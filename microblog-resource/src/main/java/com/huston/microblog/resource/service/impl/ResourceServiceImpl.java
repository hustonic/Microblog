package com.huston.microblog.resource.service.impl;

import com.huston.microblog.common.model.dto.ResourceDTO;
import com.huston.microblog.common.model.enums.ResourceTypeEnum;
import com.huston.microblog.common.model.enums.ResourceUsageEnum;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.resource.config.FTPStorageProperties;
import com.huston.microblog.resource.config.StorageProperties;
import com.huston.microblog.resource.manager.StorageManager;
import com.huston.microblog.resource.mapper.ResourceMapper;
import com.huston.microblog.resource.model.domain.Resource;
import com.huston.microblog.resource.model.enums.FileTypeEnum;
import com.huston.microblog.resource.service.ResourceService;
import com.huston.microblog.resource.util.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    //key是文件类型，value是后缀名
    private EnumMap<FileTypeEnum, String> pictureFileTypes = new EnumMap<>(FileTypeEnum.class);
    private EnumMap<FileTypeEnum, String> videoFileTypes = new EnumMap<>(FileTypeEnum.class);

    private StorageProperties storageProperties;
    private FTPStorageProperties ftpStorageProperties;

    private ResourceMapper resourceMapper;

    private StorageManager storageManager;

    public ResourceServiceImpl(StorageProperties storageProperties, FTPStorageProperties ftpStorageProperties, ResourceMapper resourceMapper,
                               @Qualifier("FTPStorageManager") StorageManager storageManager) {
        this.storageProperties = storageProperties;
        this.ftpStorageProperties = ftpStorageProperties;
        this.resourceMapper = resourceMapper;
        this.storageManager = storageManager;

        pictureFileTypes.put(FileTypeEnum.GIF, ".gif");
        pictureFileTypes.put(FileTypeEnum.JPEG, ".jpg");
        pictureFileTypes.put(FileTypeEnum.PNG, ".png");
        pictureFileTypes.put(FileTypeEnum.BMP, ".bmp");

        videoFileTypes.put(FileTypeEnum.MP4, ".mp4");
    }

    @Override
    public ResourceDTO getResource(Long resId) {
        Resource resource = resourceMapper.selectByPrimaryKey(resId).orElse(null);
        if (resource == null) {
            return null;
        }
        ResourceDTO resourceDTO = new ResourceDTO();
        BeanUtils.copyProperties(resource, resourceDTO);
        resourceDTO.setResUrl(ftpStorageProperties.getUrlPrefix() + resourceDTO.getResUrl());
        return resourceDTO;
    }

    @Override
    public String getResURL(Long resId) {
        ResourceDTO resourceDTO = getResource(resId);
        return resourceDTO != null ? resourceDTO.getResUrl() : "";
    }

    @Override
    public List<ResourceDTO> listResource(List<Long> resIds) {
        List<ResourceDTO> resourceDTOS = new ArrayList<>();
        for (Long resId : resIds) {
            resourceDTOS.add(getResource(resId));
        }
        return resourceDTOS;
    }

    /**
     * 返回资源信息
     */
    @Override
    public ResourceDTO insertResource(MultipartFile file, int resUsage, long userId) {
        //限制文件大小
        long fileSize = file.getSize();  //bytes
        //根据文件头判断文件类型是否合法，并判断文件的资源类型：图片/视频
        int resType;
        String folder;
        String suffix; //文件后缀名
        try (InputStream inputStream = file.getInputStream()) {
            FileTypeEnum fileType = FileUtils.getFileType(inputStream);
            if (pictureFileTypes.containsKey(fileType)) {
                if (fileSize > (2 << 20)) {   //2MB
                    throw new BadRequestException("图片大小不得超过2MB");
                }
                resType = ResourceTypeEnum.PICTURE.getCode();
                folder = "image";
                suffix = pictureFileTypes.get(fileType);
            } else if (videoFileTypes.containsKey(fileType)) {
                if (fileSize > (500 << 20)) {   //500MB
                    throw new BadRequestException("视频大小不得超过500MB");
                }
                resType = ResourceTypeEnum.VIDEO.getCode();
                folder = "video";
                suffix = videoFileTypes.get(fileType);
            } else {
                throw new BadRequestException("不支持的文件类型");
            }
        } catch (IOException e) {
            throw new InternalServerException("获取文件数据失败", e);
        }
        if (ResourceUsageEnum.valueOf(resUsage) == null) {
            throw new BadRequestException("resUsage参数不合法");
        }
        //通过用户ID、当前时间、资源用途、资源类型、随机数，通过Base64编码生成随机的文件名
        Date current = new Date();
        String basedName = "" + userId + current.getTime() + resUsage + resType + new Random().nextInt();
        String filename = folder + "/" + Base64Utils.encodeToUrlSafeString(basedName.getBytes()) + suffix;

        //在数据库插入图片基本信息
        Resource resource = new Resource();
        resource.setResUrl(filename);
        resource.setResType((byte) resType);
        resource.setResUsage((byte) resUsage);
        resource.setResCreTime(current);
        resource.setUserId(userId);
        if (resourceMapper.insertSelective(resource) <= 0) {
            throw new InternalServerException("插入资源信息失败");
        }

        storageManager.store(file, filename);
        //返回资源ID
        ResourceDTO resourceDTO = new ResourceDTO();
        BeanUtils.copyProperties(resource, resourceDTO);
        return resourceDTO;
    }
}

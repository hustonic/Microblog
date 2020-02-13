package com.huston.microblog.mblog.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huston.microblog.common.model.dto.ResourceDTO;
import com.huston.microblog.common.model.enums.ResourceTypeEnum;
import com.huston.microblog.common.model.enums.ResourceUsageEnum;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.mblog.manager.MicroblogTimelineManager;
import com.huston.microblog.mblog.mapper.AgreeMicroblogMapper;
import com.huston.microblog.mblog.mapper.CollectMapper;
import com.huston.microblog.mblog.mapper.MicroblogMapper;
import com.huston.microblog.mblog.mapper.MicroblogResourceMapper;
import com.huston.microblog.mblog.model.constant.BaseConst;
import com.huston.microblog.mblog.model.domain.Microblog;
import com.huston.microblog.mblog.model.domain.MicroblogResource;
import com.huston.microblog.mblog.model.dto.InsertMicroblogDTO;
import com.huston.microblog.common.model.dto.MicroblogDTO;
import com.huston.microblog.mblog.model.dto.UpdateMicroblogDTO;
import com.huston.microblog.mblog.model.enums.MicroblogTypeEnum;
import com.huston.microblog.mblog.model.enums.TimelineTypeEnum;
import com.huston.microblog.mblog.service.MicroblogService;
import com.huston.microblog.mblog.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
@Transactional
public class MicroblogServiceImpl implements MicroblogService {

    private MicroblogMapper microblogMapper;
    private MicroblogResourceMapper microblogResourceMapper;
    private CollectMapper collectMapper;
    private AgreeMicroblogMapper agreeMapper;

    private ResourceService resourceService;
    private MicroblogTimelineManager microblogTimelineManager;
    private ObjectMapper objectMapper;

    public MicroblogServiceImpl(MicroblogMapper microblogMapper, MicroblogResourceMapper microblogResourceMapper, CollectMapper collectMapper, AgreeMicroblogMapper agreeMapper, ResourceService resourceService, MicroblogTimelineManager microblogTimelineManager, ObjectMapper objectMapper) {
        this.microblogMapper = microblogMapper;
        this.microblogResourceMapper = microblogResourceMapper;
        this.collectMapper = collectMapper;
        this.agreeMapper = agreeMapper;
        this.resourceService = resourceService;
        this.microblogTimelineManager = microblogTimelineManager;
        this.objectMapper = objectMapper;
    }

    @Override
    public void insertMicroblog(InsertMicroblogDTO insertMicroblogDTO) throws CustomException {
        Microblog microblog = new Microblog();
        BeanUtils.copyProperties(insertMicroblogDTO, microblog);
        microblog.setMblogPubTime(new Date());

        List<ResourceDTO> resourceDTOS = null;
        List<Long> resIds = insertMicroblogDTO.getResIds();
        if (microblog.getMblogType() == MicroblogTypeEnum.FORWARD.getCode()) {
            if (microblog.getMblogIdForward() == null) {
                throw new BadRequestException("微博的类型为转发，转发的微博ID不能为空");
            }
            //检查转发的微博是否存在
            Microblog microblogForward = microblogMapper.selectByPrimaryKey(microblog.getMblogIdForward()).orElseThrow(() -> new BadRequestException("转发的微博不存在"));
            //检查转发的微博是否是原创微博，即转发的微博类型不能是"转发"
            if(microblogForward.getMblogType()==MicroblogTypeEnum.FORWARD.getCode()){
                throw new BadRequestException("转发的微博类型不能是'转发'，必须是'原创'微博");
            }
        } else if (microblog.getMblogType() == MicroblogTypeEnum.VIDEO.getCode() ||
                microblog.getMblogType() == MicroblogTypeEnum.PICTURE.getCode()) {
            int resType = 0;

            if (microblog.getMblogType() == MicroblogTypeEnum.VIDEO.getCode()) {
                resType = ResourceTypeEnum.VIDEO.getCode();
                if (resIds.size() > BaseConst.MAX_VIDEO_COUNT) {
                    throw new BadRequestException("视频数量不能大于" + BaseConst.MAX_VIDEO_COUNT);
                }
            } else if (microblog.getMblogType() == MicroblogTypeEnum.PICTURE.getCode()) {
                resType = ResourceTypeEnum.PICTURE.getCode();
                if (resIds.size() > BaseConst.MAX_PICTURE_COUNT) {
                    throw new BadRequestException("图片数量不能大于" + BaseConst.MAX_PICTURE_COUNT);
                }
            }
            //获取资源信息
            Result<List<ResourceDTO>> result = resourceService.listResource(resIds);
            if (!result.isSuccess()) {
                throw new InternalServerException("获取资源信息失败;" + result.getMessage());
            }
            Object resourceMaps = result.getData();
            resourceDTOS = objectMapper.convertValue(resourceMaps, new TypeReference<List<ResourceDTO>>() {});
            //验证资源创建者、资源用途、资源类型
            for (ResourceDTO resourceDTO : resourceDTOS) {
                if (resourceDTO == null) throw new BadRequestException("找不到资源");
                if (!resourceDTO.getUserId().equals(microblog.getUserId())) throw new BadRequestException("资源不属于该用户");
                if (resourceDTO.getResUsage() != ResourceUsageEnum.MICROBLOG.getCode())
                    throw new BadRequestException("资源用途不正确");
                if (resourceDTO.getResType() != resType)
                    throw new BadRequestException("资源类型不正确");
            }
        }

        //发布微博
        if (microblogMapper.insertSelective(microblog) <= 0)
            throw new InternalServerException("发布微博失败");

        if (microblog.getMblogType() == MicroblogTypeEnum.VIDEO.getCode() ||
                microblog.getMblogType() == MicroblogTypeEnum.PICTURE.getCode()) {

            //建立微博资源关系
            assert resourceDTOS != null;
            for (ResourceDTO resourceDTO : resourceDTOS) {
                MicroblogResource microblogResource = new MicroblogResource();
                microblogResource.setMblogId(microblog.getMblogId());
                microblogResource.setResId(resourceDTO.getResId());
                if (microblogResourceMapper.insertSelective(microblogResource) <= 0) {
                    throw new InternalServerException("建立微博资源关系失败");
                }
            }
        }

        //异步推送到Timeline
        microblogTimelineManager.pushAsync(microblog.getUserId(), microblog.getMblogId(), microblog.getMblogPubTime().getTime());
    }

    /**
     * 获取自己发布的微博列表
     */
    @Override
    public List<MicroblogDTO> listUserMicroblog(Long userId, long offset, long limit) {
        return listMicroblog(TimelineTypeEnum.MICROBLOG_ME.getCode(), userId, offset, limit);
    }

    /**
     * 获取关注的人的微博列表
     */
    @Override
    public List<MicroblogDTO> listFollowMicroblog(Long userId, long offset, long limit) {
        return listMicroblog(TimelineTypeEnum.MICROBLOG_FOLLOW.getCode(), userId, offset, limit);
    }

    private List<MicroblogDTO> listMicroblog(int timelineType, Long userId, long offset, long limit) {
        List<MicroblogDTO> microblogDTOs = new ArrayList<>();

        List<Long> mblogIds;
        do {
            //如果结果集数量不够并且feed流还有元素，下面两个变量做相应改变
            offset += microblogDTOs.size();
            limit -= microblogDTOs.size();

            mblogIds = microblogTimelineManager.get(timelineType, userId, offset, limit);
            for (Long mblogId : mblogIds) {
                MicroblogDTO microblogDTO = getMicroblog(mblogId);
                if (microblogDTO != null)
                    microblogDTOs.add(microblogDTO);
                else
                    microblogTimelineManager.delete(timelineType, userId, mblogId);//删除微博信息不存在的feed
                    //如果删除失败，则忽略，问题不大
            }
            //由于查询微博信息可能为空，如果结果集数量不够并且feed流还有元素，则继续获取微博信息
        } while(mblogIds.size()==limit && microblogDTOs.size()<limit);

        return microblogDTOs;
    }

    @Override
    public MicroblogDTO getMicroblog(Long mblogId) {
        return getMicroblog(mblogId, false);
    }

    /**
     *
     * @param mblogId 微博iD
     * @param isForwarded 预计获取的微博是否作为被转发的微博
     */
    public MicroblogDTO getMicroblog(Long mblogId, boolean isForwarded){
        Microblog microblog = microblogMapper.selectByPrimaryKey(mblogId).orElse(null);
        if (microblog == null) {
            return null;
        }
        MicroblogDTO microblogDTO = new MicroblogDTO();
        BeanUtils.copyProperties(microblog, microblogDTO);

        if(microblog.getMblogType()==MicroblogTypeEnum.PICTURE.getCode()||
                microblog.getMblogType()==MicroblogTypeEnum.VIDEO.getCode()) {
            //获取资源信息
            List<MicroblogResource> microblogResources = microblogResourceMapper.selectByMblogId(mblogId);
            for (MicroblogResource microblogResource : microblogResources) {
                Result<String> result = resourceService.getResUrl(microblogResource.getResId());
                if (!result.isSuccess()) {
                    continue;
                }
                String resUrl = result.getData();
                microblogDTO.getResUrls().add(resUrl);
            }
        } else if(!isForwarded && microblog.getMblogType()==MicroblogTypeEnum.FORWARD.getCode()) {
            //转发的微博类型不能是"转发"，否则会无限递归。需要在添加微博时做限制。这里为了安全考虑也加了一层判断（通过isForwarded）。
            MicroblogDTO microblogForward = getMicroblog(microblog.getMblogIdForward(), true);
            microblogDTO.setMicroblogForward(microblogForward);
        }

        return microblogDTO;
    }

    @Override
    public void updateMicroblog(UpdateMicroblogDTO updateMicroblogDTO) throws CustomException {
        Microblog microblog = microblogMapper.selectByPrimaryKey(updateMicroblogDTO.getMblogId())
                .orElseThrow(() -> new BadRequestException("微博不存在"));
        if (!updateMicroblogDTO.getUserId().equals(microblog.getUserId())) {
            throw new BadRequestException("用户只能修改自己的微博");
        }

        Microblog update = new Microblog();
        BeanUtils.copyProperties(updateMicroblogDTO, update);
        if (microblogMapper.updateByPrimaryKeySelective(update) <= 0) {
            throw new InternalServerException("修改微博失败");
        }
    }

    @Override
    public void deleteMicroblog(Long userId, Long mblogId) throws CustomException {
        Microblog microblog = microblogMapper.selectByPrimaryKey(mblogId).orElseThrow(() -> new BadRequestException("微博不存在"));
        if(!microblog.getUserId().equals(userId)){
            throw new BadRequestException("只能删除自己的微博");
        }
        if(microblogMapper.deleteByPrimaryKey(mblogId)<=0){
            throw new InternalServerException("删除微博失败");
        }
        //删除个人主页Timeline
        microblogTimelineManager.delete(TimelineTypeEnum.MICROBLOG_ME.getCode(), userId, mblogId);
    }

    //获取微博的转发数
    @Override
    public Long countForward(Long mblogId) {
        return microblogMapper.countByMblogIdForward(mblogId);
    }
}

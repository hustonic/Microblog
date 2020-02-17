package com.huston.microblog.verification.service.impl;

import com.huston.microblog.common.model.dto.ResourceDTO;
import com.huston.microblog.common.model.enums.ResourceTypeEnum;
import com.huston.microblog.common.model.enums.ResourceUsageEnum;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.verification.mapper.VerificationMapper;
import com.huston.microblog.verification.mapper.VerificationPictureMapper;
import com.huston.microblog.verification.model.domain.Verification;
import com.huston.microblog.verification.model.domain.VerificationPicture;
import com.huston.microblog.verification.model.dto.AddVerificationDTO;
import com.huston.microblog.verification.model.dto.VerificationDTO;
import com.huston.microblog.verification.model.dto.VerifyDTO;
import com.huston.microblog.verification.model.enums.VerificationStateEnum;
import com.huston.microblog.verification.service.ResourceService;
import com.huston.microblog.verification.service.VerificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
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
public class VerificationServiceImpl implements VerificationService {

    private VerificationMapper verificationMapper;
    private VerificationPictureMapper verificationPictureMapper;
    private ResourceService resourceService;

    public VerificationServiceImpl(VerificationMapper verificationMapper, VerificationPictureMapper verificationPictureMapper, ResourceService resourceService) {
        this.verificationMapper = verificationMapper;
        this.verificationPictureMapper = verificationPictureMapper;
        this.resourceService = resourceService;
    }

    @Override
    public VerificationDTO addVerification(AddVerificationDTO addVerificationDTO) throws CustomException {
        //验证resIds
        List<Long> resIds = addVerificationDTO.getResIds();
        Result<List<ResourceDTO>> result = resourceService.listResource(resIds);
        if(!result.isSuccess())
            throw new InternalServerException("获取资源信息失败");
        List<ResourceDTO> resourceDTOS = result.getData();
        for (ResourceDTO resource : resourceDTOS) {
            if (resource == null)
                throw new BadRequestException("资源不存在");
            if (resource.getResType() != ResourceTypeEnum.PICTURE.getCode()) {
                throw new BadRequestException("资源类型只能是图片");
            }
            if (resource.getResUsage() != ResourceUsageEnum.VERIFICATION.getCode()) {
                throw new BadRequestException("资源用途不正确");
            }
            if (!resource.getUserId().equals(addVerificationDTO.getUserId())) {
                throw new BadRequestException("资源不属于该用户");
            }
        }
        //插入记录，userId唯一
        Verification verification=new Verification();
        BeanUtils.copyProperties(addVerificationDTO, verification);
        verification.setVerState(VerificationStateEnum.VERIFYING.getCode());
        verification.setVerTime(new Date());
        try{
            if(verificationMapper.insertSelective(verification)<=0){
                throw new InternalServerException("添加认证信息失败");
            }
        }catch(DuplicateKeyException e){
            throw new BadRequestException("该用户的认证信息已存在，请删除后重试");
        }
        //添加认证图片记录
        for (Long resId : resIds) {
            if(resId==null||verification.getVerId()==null){
                throw new BadRequestException("resId或verId为null");
            }
            VerificationPicture verificationPicture =new VerificationPicture();
            verificationPicture.setResId(resId);
            verificationPicture.setVerId(verification.getVerId());
            if(verificationPictureMapper.insertSelective(verificationPicture)<=0){
                throw new InternalServerException("添加认证图片信息失败");
            }
        }
        VerificationDTO verificationDTO =new VerificationDTO();
        BeanUtils.copyProperties(verification, verificationDTO);
        verificationDTO.setResIds(resIds);
        return verificationDTO;
    }

    public List<Long> getResIds(Long verId){
        List<VerificationPicture> verificationPictures = verificationPictureMapper.selectByVerId(verId);
        List<Long> resIds = new ArrayList<>();
        verificationPictures.forEach(verificationPicture -> resIds.add(verificationPicture.getResId()));
        return resIds;
    }

    @Override
    public VerificationDTO getVerification(Long userId) {
        Verification verification = verificationMapper.selectByUserId(userId).orElse(null);
        if(verification==null) return null;
        VerificationDTO verificationDTO = new VerificationDTO();
        BeanUtils.copyProperties(verification, verificationDTO);
        verificationDTO.setResIds(getResIds(verification.getVerId()));
        return verificationDTO;
    }

    //管理员获取待审核的认证信息
    public List<VerificationDTO> listVerifyingVerification(Long offset, Long limit){
        List<Verification> verifications = verificationMapper.selectByVerState(VerificationStateEnum.VERIFYING.getCode(), offset, limit);
        List<VerificationDTO> verificationDTOS = new ArrayList<>();

        for (Verification verification : verifications) {
            VerificationDTO verificationDTO = new VerificationDTO();
            BeanUtils.copyProperties(verification, verificationDTO);
            verificationDTO.setResIds(getResIds(verificationDTO.getVerId()));
            verificationDTOS.add(verificationDTO);
        }
        return verificationDTOS;
    }

    //管理员审核：待审核 -> 认证失败/待确认
    @Override
    public void verify(VerifyDTO verifyDTO) throws CustomException {
        int verStateCode=verifyDTO.getVerState();
        VerificationStateEnum verState=VerificationStateEnum.valueOf(verStateCode);
        if(verState!=VerificationStateEnum.FAILED&&verState!=VerificationStateEnum.CONFIRMING)
            throw new BadRequestException("verState不合法");

        Verification update=new Verification();
        BeanUtils.copyProperties(verifyDTO, update);
        update.setVerTime(new Date());
        if(verificationMapper.updateByPrimaryKeyWithConditionSelective(update, VerificationStateEnum.VERIFYING.getCode(), null)<=0){
            throw new BadRequestException("审核认证信息失败");
        }
    }

    //用户确认认证结果：待确认 -> 认证成功
    @Override
    public void confirm(Long verId, Long userId) throws CustomException {
        Verification update=new Verification();
        update.setVerId(verId);
        update.setVerState(VerificationStateEnum.FINISHED.getCode());
        update.setVerTime(new Date());
        if(verificationMapper.updateByPrimaryKeyWithConditionSelective(update, VerificationStateEnum.CONFIRMING.getCode(), userId)<=0){
            throw new BadRequestException("确认认证信息失败");
        }
    }

    @Override
    public void deleteVerification(Long verId, Long userId) throws CustomException {
        if(verificationMapper.deleteByPrimaryWithCondition(verId, userId)<=0){
            throw new BadRequestException("删除认证信息失败");
        }
    }
}

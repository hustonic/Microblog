package com.huston.microblog.relation.service.impl;

import com.huston.microblog.common.model.enums.ServiceExceptionErrorCodeEnum;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.common.model.exception.ServiceException;
import com.huston.microblog.relation.mapper.RelationGroupMapper;
import com.huston.microblog.relation.mapper.RelationMapper;
import com.huston.microblog.relation.model.domain.Relation;
import com.huston.microblog.relation.model.dto.RelationDTO;
import com.huston.microblog.relation.service.RelationService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
@Transactional
public class RelationServiceImpl implements RelationService {

    private RelationMapper relationMapper;
    private RelationGroupMapper relationGroupMapper;

    public RelationServiceImpl(RelationMapper relationMapper, RelationGroupMapper relationGroupMapper) {
        this.relationMapper = relationMapper;
        this.relationGroupMapper = relationGroupMapper;
    }

    /**
     * 关注用户，不能重复关注
     * @param userIdSub 关注者
     * @param userIdPub 被关注者
     */
    @Override
    public void insertRelation(Long userIdSub, Long userIdPub) throws ServiceException {
        Relation relation=new Relation();
        relation.setUserIdSub(userIdSub);
        relation.setUserIdPub(userIdPub);
        relation.setRelaCreTime(new Date());
        try {
            if (relationMapper.insertSelective(relation) <= 0) {
                throw new ServiceException(ServiceExceptionErrorCodeEnum.INSERT_RELATION_FAILED.getErrorCode(), "关注用户失败");
            }
        } catch(DuplicateKeyException e){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.INSERT_RELATION_FAILED.getErrorCode(), "不能重复关注");
        }
    }

    /**
     * 取消关注，并删除分组关系
     */
    @Override
    public void deleteRelation(Long userId, Long relaId)  throws ServiceException {
        Relation relation=relationMapper.selectByPrimaryKey(relaId)
                .orElseThrow(()->new ServiceException(ServiceExceptionErrorCodeEnum.DELETE_RELATION_FAILED.getErrorCode(), "relaId不存在"));
        if(!relation.getUserIdSub().equals(userId)){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.DELETE_RELATION_FAILED.getErrorCode(), "relaId不属于当前用户");
        }

        if(relationMapper.deleteByPrimaryKey(relation.getRelaId())<=0){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.DELETE_RELATION_FAILED.getErrorCode(), "取消关注失败");
        }
        relationGroupMapper.deleteByRelaId(relaId);
    }

    @Override
    public void updateRelation(Long userId, Long relaId, String relaRemark) throws CustomException {
        Relation relation = relationMapper.selectByPrimaryKey(relaId).orElseThrow(() -> new BadRequestException("relaId不存在"));
        if(!userId.equals(relation.getUserIdSub())){
            throw new BadRequestException("修改失败，当前用户不是关注者");
        }
        Relation update = new Relation();
        update.setRelaId(relaId);
        update.setRelaRemark(relaRemark);
        if(relationMapper.updateByPrimaryKeySelective(update)<=0){
            throw new InternalServerException("修改失败");
        }
    }

    /**
     * 获取关注列表
     */
    @Override
    public List<RelationDTO> listFollowRelation(Long userId, Long offset, Long limit) {
        List<Relation> relations = relationMapper.selectByUserIdSub(userId, offset, limit);

        List<RelationDTO> relationDTOS =new ArrayList<>();
        for (Relation relation : relations) {
            RelationDTO relationDTO = new RelationDTO();
            BeanUtils.copyProperties(relation, relationDTO);
            relationDTOS.add(relationDTO);
        }
        return relationDTOS;
    }

    /**
     * 获取粉丝列表
     */
    @Override
    public List<RelationDTO> listFansRelation(Long userId, Long offset, Long limit) {
        List<Relation> relations = relationMapper.selectByUserIdPub(userId, offset, limit);

        List<RelationDTO> relationDTOS=new ArrayList<>();
        for (Relation relation : relations) {
            RelationDTO relationDTO = new RelationDTO();
            BeanUtils.copyProperties(relation, relationDTO);
            relationDTOS.add(relationDTO);
        }
        return relationDTOS;
    }

    @Override
    public Long countRelation(Long userIdSub, Long userIdPub){
        return relationMapper.countRelation(userIdSub, userIdPub);
    }

    @Override
    public List<Long> listFansId(Long userId) {
        List<Relation> relations = relationMapper.selectUserIdSubByUserIdPub(userId);
        List<Long> fansIds=new ArrayList<>();
        for (Relation relation : relations) {
            fansIds.add(relation.getUserIdSub());
        }
        return fansIds;
    }
}

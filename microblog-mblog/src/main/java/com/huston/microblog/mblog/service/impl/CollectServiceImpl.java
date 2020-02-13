package com.huston.microblog.mblog.service.impl;

import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.mblog.mapper.CollectMapper;
import com.huston.microblog.mblog.model.domain.Collect;
import com.huston.microblog.mblog.model.dto.ListCollectDTO;
import com.huston.microblog.mblog.service.CollectService;
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
public class CollectServiceImpl implements CollectService {

    private CollectMapper collectMapper;

    public CollectServiceImpl(CollectMapper collectMapper) {
        this.collectMapper = collectMapper;
    }

    @Override
    public void insertCollect(Long userId, Long mblogId) throws CustomException {
        try {
            if (collectMapper.insertSelective(new Collect(userId, mblogId, new Date())) <= 0) {
                throw new InternalServerException("收藏微博失败");
            }
        }catch(DuplicateKeyException e){
            throw new BadRequestException("不能重复收藏");
        }
    }

    @Override
    public void deleteCollect(Long userId, Long collectId) throws CustomException {
        Collect collect = collectMapper.selectByPrimaryKey(collectId).orElseThrow(()->new BadRequestException("collectId不存在"));
        if(!userId.equals(collect.getUserId())){
            throw new BadRequestException("只能删除自己的收藏记录");
        }
        if(collectMapper.deleteByPrimaryKey(collectId)<=0){
            throw new InternalServerException("取消收藏失败");
        }
    }

    @Override
    public List<Collect> listCollect(ListCollectDTO listCollectDTO){
        Long userId = listCollectDTO.getUserId();
        Long offset = listCollectDTO.getOffset();
        Long limit = listCollectDTO.getLimit();
        if(userId!=null){
            return collectMapper.selectByUserId(userId, offset, limit);
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public Collect getCollect(Long userId, Long mblogId) {
        return collectMapper.selectByUserIdAndMblogId(userId, mblogId).orElse(null);
    }
}

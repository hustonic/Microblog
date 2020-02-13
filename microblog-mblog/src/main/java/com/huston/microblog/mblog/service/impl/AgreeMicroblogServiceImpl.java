package com.huston.microblog.mblog.service.impl;

import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.mblog.mapper.AgreeMicroblogMapper;
import com.huston.microblog.mblog.model.domain.AgreeMicroblog;
import com.huston.microblog.mblog.model.dto.ListAgreeMicroblogDTO;
import com.huston.microblog.mblog.service.AgreeMicroblogService;
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
public class AgreeMicroblogServiceImpl implements AgreeMicroblogService {
    private AgreeMicroblogMapper agreeMicroblogMapper;

    public AgreeMicroblogServiceImpl(AgreeMicroblogMapper agreeMicroblogMapper) {
        this.agreeMicroblogMapper = agreeMicroblogMapper;
    }

    @Override
    public void insertAgreeMicroblog(Long userId, Long mblogId) throws CustomException {
        try {
            if (agreeMicroblogMapper.insertSelective(new AgreeMicroblog(userId, mblogId, new Date())) <= 0) {
                throw new InternalServerException("点赞失败");
            }
        }catch(DuplicateKeyException e){
            throw new BadRequestException("不能重复点赞");
        }
    }

    @Override
    public void deleteAgreeMicroblog(Long userId, Long agreeId) throws CustomException {
        AgreeMicroblog agreeMicroblog = agreeMicroblogMapper.selectByPrimaryKey(agreeId).orElseThrow(()->
                new BadRequestException("agreeId不存在"));
        if(!agreeMicroblog.getUserId().equals(userId)){
            throw new BadRequestException("只能删除自己的点赞记录");
        }
        if(agreeMicroblogMapper.deleteByPrimaryKey(agreeId)<=0){
            throw new InternalServerException("取消点赞失败");
        }
    }

    @Override
    public List<AgreeMicroblog> listAgreeMicroblog(ListAgreeMicroblogDTO listAgreeMicroblogDTO){
        Long userId= listAgreeMicroblogDTO.getUserId();
        Long mblogId = listAgreeMicroblogDTO.getMblogId();
        Long offset = listAgreeMicroblogDTO.getOffset();
        Long limit= listAgreeMicroblogDTO.getLimit();
        if(userId!=null && mblogId!=null){
            return agreeMicroblogMapper.selectByUserIdMblogId(userId, mblogId);
        }else if(userId!=null){
            return agreeMicroblogMapper.selectByUserId(userId, offset, limit);
        }else if(mblogId!=null){
            return agreeMicroblogMapper.selectByMblogId(mblogId, offset, limit);
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public Long count(Long mblogId) {
        return agreeMicroblogMapper.countByMblogId(mblogId);
    }
}

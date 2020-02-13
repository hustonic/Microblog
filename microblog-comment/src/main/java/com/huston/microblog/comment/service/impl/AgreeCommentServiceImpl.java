package com.huston.microblog.comment.service.impl;

import com.huston.microblog.comment.mapper.AgreeCommentMapper;
import com.huston.microblog.comment.mapper.CommentMapper;
import com.huston.microblog.comment.model.domain.AgreeComment;
import com.huston.microblog.common.model.dto.AgreeCommentDTO;
import com.huston.microblog.comment.service.AgreeCommentService;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.common.model.vo.ListAgreeCommentDTO;
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
public class AgreeCommentServiceImpl implements AgreeCommentService {

    private AgreeCommentMapper agreeCommentMapper;
    private CommentMapper commentMapper;

    public AgreeCommentServiceImpl(AgreeCommentMapper agreeCommentMapper, CommentMapper commentMapper) {
        this.agreeCommentMapper = agreeCommentMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public AgreeCommentDTO insertAgreeComment(Long userId, Long commId) throws CustomException {
        commentMapper.selectByPrimaryKey(commId).orElseThrow(()->new BadRequestException("评论不存在"));

        AgreeComment agreeComment = new AgreeComment();
        agreeComment.setUserId(userId);
        agreeComment.setCommId(commId);
        agreeComment.setAgreeTime(new Date());
        try {
            if (agreeCommentMapper.insertSelective(agreeComment) <= 0) {
                throw new InternalServerException("点赞失败");
            }
        }catch(DuplicateKeyException e){
            throw new BadRequestException("不能重复点赞");
        }

        AgreeCommentDTO agreeCommentDTO = new AgreeCommentDTO();
        BeanUtils.copyProperties(agreeComment, agreeCommentDTO);
        return agreeCommentDTO;
    }

    @Override
    public void deleteAgreeComment(Long agreeId, Long userId) throws CustomException {
        if(agreeCommentMapper.deleteByAgreeIdAndUserId(agreeId, userId)<=0){
            throw new BadRequestException("agreeId不存在或当前用户无权操作");
        }
    }

    @Override
    public List<AgreeCommentDTO> listAgreeComment(ListAgreeCommentDTO listAgreeCommentDTO) {
        Long userId = listAgreeCommentDTO.getUserId();
        Long commId = listAgreeCommentDTO.getCommId();
        Long offset = listAgreeCommentDTO.getOffset();
        Long limit = listAgreeCommentDTO.getLimit();
        if(userId==null && commId==null){
            return new ArrayList<>();
        }
        List<AgreeComment> agreeComments = agreeCommentMapper.selectByUserIdAndCommIdWhenPresent(userId, commId, offset, limit);
        List<AgreeCommentDTO> agreeCommentDTOS = new ArrayList<>();
        for (AgreeComment agreeComment : agreeComments) {
            AgreeCommentDTO agreeCommentDTO = new AgreeCommentDTO();
            BeanUtils.copyProperties(agreeComment, agreeCommentDTO);
            agreeCommentDTOS.add(agreeCommentDTO);
        }
        return agreeCommentDTOS;
    }

    @Override
    public Long count(Long commId) {
        return agreeCommentMapper.countByCommId(commId);
    }
}

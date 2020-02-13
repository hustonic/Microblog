package com.huston.microblog.comment.service.impl;

import com.huston.microblog.comment.mapper.CommentMapper;
import com.huston.microblog.comment.model.domain.Comment;
import com.huston.microblog.common.model.dto.CommentDTO;
import com.huston.microblog.comment.model.dto.InsertCommentDTO;
import com.huston.microblog.common.model.dto.ListCommentDTO;
import com.huston.microblog.comment.service.CommentService;
import com.huston.microblog.comment.service.MicroblogService;
import com.huston.microblog.comment.service.ResourceService;
import com.huston.microblog.common.model.dto.MicroblogDTO;
import com.huston.microblog.common.model.dto.ResourceDTO;
import com.huston.microblog.common.model.enums.ResourceTypeEnum;
import com.huston.microblog.common.model.enums.ResourceUsageEnum;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.common.model.vo.Result;
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
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;
    private ResourceService resourceService;
    private MicroblogService microblogService;

    public CommentServiceImpl(CommentMapper commentMapper, ResourceService resourceService, MicroblogService microblogService) {
        this.commentMapper = commentMapper;
        this.resourceService = resourceService;
        this.microblogService = microblogService;
    }

    @Override
    public CommentDTO insertComment(InsertCommentDTO insertCommentDTO) throws CustomException {
        //验证资源类型、用途、用户
        Long resId = insertCommentDTO.getResId();
        if(resId!=null){
            Result<ResourceDTO> resResult = resourceService.getResource(resId);
            if(!resResult.isSuccess())
                throw new InternalServerException("获取资源信息失败");
            ResourceDTO resource = resResult.getData();
            if(resource==null )
                throw new BadRequestException("资源不存在");
            if(resource.getResType()!= ResourceTypeEnum.PICTURE.getCode()){
                throw new BadRequestException("资源类型只能是图片");
            }
            if(resource.getResUsage()!= ResourceUsageEnum.COMMENT.getCode()){
                throw new BadRequestException("资源用途不正确");
            }
            if(!resource.getUserId().equals(insertCommentDTO.getUserId())){
                throw new BadRequestException("资源不属于该用户");
            }
        }

        Long mblogId = insertCommentDTO.getMblogId();
        if(mblogId == null){
            throw new BadRequestException("mblogId不能为空");
        }
        //验证评论的微博是否存在，mblogId不能为空
        Result<MicroblogDTO> mblogResult = microblogService.getMicroblog(mblogId);
        if(!mblogResult.isSuccess()){
            throw new InternalServerException("获取微博信息失败");
        }
        MicroblogDTO microblog = mblogResult.getData();
        if(microblog==null)
            throw new BadRequestException("微博不存在");

        //验证父评论
        Long commIdParent = insertCommentDTO.getCommIdParent();
        if(commIdParent!=null){
            Comment parentComment = commentMapper.selectByPrimaryKey(commIdParent)
                    .orElseThrow(()->new BadRequestException("父评论不存在"));
            //验证父评论的所属微博是否一致
            if(!parentComment.getMblogId().equals(mblogId)){
                throw new BadRequestException("父评论和当前评论的所属微博不一致");
            }
            //如果父评论还有父评论ID，则用父评论的父评论ID作为当前评论的父评论ID
            if(parentComment.getCommIdParent()!=null){
                insertCommentDTO.setCommIdParent(parentComment.getCommIdParent());
            }
        }

        Comment comment = new Comment();
        BeanUtils.copyProperties(insertCommentDTO, comment);
        comment.setCommCreTime(new Date());
        if(commentMapper.insertSelective(comment)<=0){
            throw new InternalServerException("插入评论失败");
        }
        CommentDTO commentDTO = new CommentDTO();
        BeanUtils.copyProperties(comment, commentDTO);
        return commentDTO;
    }

    @Override
    public void deleteComment(Long commId, Long userId) throws CustomException {
        if(commentMapper.deleteByCommIdAndUserId(commId, userId)<=0){
            throw new BadRequestException("删除评论失败，评论不存在或者该评论不属于该用户");
        }
    }

    @Override
    public List<CommentDTO> listComment(ListCommentDTO listCommentDTO) {
        Long mblogId = listCommentDTO.getMblogId();
        Long commIdParent = listCommentDTO.getCommIdParent();
        Long offset = listCommentDTO.getOffset();
        Long limit = listCommentDTO.getLimit();
        List<Comment> comments;
        if(commIdParent==null){
            comments = commentMapper.selectByMblogIdAndCommIdParentIsNull(mblogId, offset, limit);
        }else {
            comments = commentMapper.selectByMblogIdAndCommIdParent(mblogId, commIdParent, offset, limit);
        }

        List<CommentDTO> commentDTOS = new ArrayList<>();
        comments.forEach(comment->{
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTOS.add(commentDTO);
        });
        return commentDTOS;
    }

    @Override
    public Long countComment(Long mblogId, Long commId, Boolean commIdShouldNull) {
        if(commIdShouldNull!=null && commIdShouldNull){
            return commentMapper.countCommentWhenCommIdParentIsNull(mblogId);
        }else{
            return commentMapper.countComment(mblogId, commId);
        }
    }
}

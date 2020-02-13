package com.huston.microblog.comment.web;

import com.huston.microblog.comment.model.dto.InsertCommentDTO;
import com.huston.microblog.comment.service.CommentService;
import com.huston.microblog.common.model.constant.CommonConstant;
import com.huston.microblog.common.model.dto.CommentDTO;
import com.huston.microblog.common.model.dto.ListCommentDTO;
import com.huston.microblog.common.model.vo.InsertCommentVO;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.common.service.FeignCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
public class CommentController implements FeignCommentService {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public Result<CommentDTO> addComment(InsertCommentVO insertCommentVO, Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        InsertCommentDTO insertCommentDTO = new InsertCommentDTO();
        BeanUtils.copyProperties(insertCommentVO, insertCommentDTO);
        insertCommentDTO.setUserId(userId);
        CommentDTO commentDTO = commentService.insertComment(insertCommentDTO);
        return Result.success(commentDTO);
    }

    @Override
    public Result deleteComment(Long commId, Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        commentService.deleteComment(commId, userId);
        return Result.success();
    }

    @Override
    public Result<List<CommentDTO>> listComment(ListCommentDTO listCommentDTO) {
        List<CommentDTO> commentDTOS = commentService.listComment(listCommentDTO);
        return Result.success(commentDTOS);
    }

    @Override
    public Result<Long> countComment(Long mblogId, Long commId, Boolean commIdShouldNull) {
        Long count = commentService.countComment(mblogId, commId, commIdShouldNull);
        return Result.success(count);
    }
}

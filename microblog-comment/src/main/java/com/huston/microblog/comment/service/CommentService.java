package com.huston.microblog.comment.service;

import com.huston.microblog.common.model.dto.CommentDTO;
import com.huston.microblog.comment.model.dto.InsertCommentDTO;
import com.huston.microblog.common.model.dto.ListCommentDTO;
import com.huston.microblog.common.model.exception.CustomException;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface CommentService {

    CommentDTO insertComment(InsertCommentDTO insertCommentDTO) throws CustomException;

    void deleteComment(Long commId, Long userId) throws CustomException;

    List<CommentDTO> listComment(ListCommentDTO listCommentDTO);

    Long countComment(Long mblogId, Long commId, Boolean commIdShouldNull);
}

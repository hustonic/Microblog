package com.huston.microblog.comment.service;

import com.huston.microblog.common.model.dto.AgreeCommentDTO;
import com.huston.microblog.common.model.exception.CustomException;
import com.huston.microblog.common.model.vo.ListAgreeCommentDTO;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface AgreeCommentService {

    AgreeCommentDTO insertAgreeComment(Long userId, Long commId) throws CustomException;

    void deleteAgreeComment(Long agreeId, Long userId) throws CustomException;

    List<AgreeCommentDTO> listAgreeComment(ListAgreeCommentDTO listAgreeCommentDTO);

    Long count(Long commId);
}

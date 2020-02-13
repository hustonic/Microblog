package com.huston.microblog.comment.web;

import com.huston.microblog.comment.service.AgreeCommentService;
import com.huston.microblog.common.model.constant.CommonConstant;
import com.huston.microblog.common.model.dto.AgreeCommentDTO;
import com.huston.microblog.common.model.vo.ListAgreeCommentDTO;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.common.service.FeignAgreeCommentService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
public class AgreeCommentController implements FeignAgreeCommentService {

    private AgreeCommentService agreeCommentService;

    public AgreeCommentController(AgreeCommentService agreeCommentService) {
        this.agreeCommentService = agreeCommentService;
    }

    @Override
    public Result<AgreeCommentDTO> addAgreeComment(Long commId, Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        AgreeCommentDTO agreeCommentDTO = agreeCommentService.insertAgreeComment(userId, commId);
        return Result.success(agreeCommentDTO);
    }

    @Override
    public Result deleteAgreeComment(Long agreeId, Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        agreeCommentService.deleteAgreeComment(agreeId, userId);
        return Result.success();
    }

    @Override
    public Result<List<AgreeCommentDTO>> listAgreeComment(ListAgreeCommentDTO listAgreeCommentDTO) {
        List<AgreeCommentDTO> agreeCommentDTOS = agreeCommentService.listAgreeComment(listAgreeCommentDTO);
        return Result.success(agreeCommentDTOS);
    }

    @Override
    public Result<Long> countAgree(Long commId) {
        return Result.success(agreeCommentService.count(commId));
    }
}

package com.huston.microblog.common.service;

import com.huston.microblog.common.model.dto.AgreeCommentDTO;
import com.huston.microblog.common.model.vo.ListAgreeCommentDTO;
import com.huston.microblog.common.model.vo.Result;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface FeignAgreeCommentService {

    @PostMapping("/agreements")
    Result<AgreeCommentDTO> addAgreeComment(@RequestBody Long commId,
                                            @AuthenticationPrincipal Jwt jwt);

    @DeleteMapping("/agreements/{agreeId}")
    Result deleteAgreeComment(@PathVariable("agreeId") Long agreeId,
                              @AuthenticationPrincipal Jwt jwt);

    @GetMapping("/agreements")
    Result<List<AgreeCommentDTO>> listAgreeComment(@Validated ListAgreeCommentDTO listAgreeCommentDTO);

    @GetMapping("/agree-counts/{commId}")
    Result<Long> countAgree(@PathVariable("commId") Long commId);

}

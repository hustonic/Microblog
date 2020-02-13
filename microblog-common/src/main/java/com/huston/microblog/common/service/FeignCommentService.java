package com.huston.microblog.common.service;

import com.huston.microblog.common.model.dto.CommentDTO;
import com.huston.microblog.common.model.dto.ListCommentDTO;
import com.huston.microblog.common.model.vo.InsertCommentVO;
import com.huston.microblog.common.model.vo.Result;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface FeignCommentService {

    @PostMapping("/comments")
    Result<CommentDTO> addComment(@RequestBody @Validated InsertCommentVO insertCommentVO,
                      @AuthenticationPrincipal Jwt jwt);

    @DeleteMapping("/comments/{commId}")
    Result deleteComment(@PathVariable("commId") Long commId,
                         @AuthenticationPrincipal Jwt jwt);

    @GetMapping("/comments")
    Result<List<CommentDTO>> listComment(@Validated ListCommentDTO listCommentDTO);

    @GetMapping("/comment-counts")
    Result<Long> countComment(@RequestParam(value = "mblogId") Long mblogId,
                              @RequestParam(value = "commId", required = false) Long commId,
                              @RequestParam(value = "commIdShouldNull", required = false) Boolean commIdShouldNull);
}

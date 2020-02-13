package com.huston.microblog.mblog.web;

import com.huston.microblog.common.model.constant.CommonConstant;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.mblog.model.domain.Collect;
import com.huston.microblog.mblog.model.dto.ListCollectDTO;
import com.huston.microblog.mblog.service.CollectService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
@Validated
public class CollectController {
    private CollectService collectService;

    public CollectController(CollectService collectService) {
        this.collectService = collectService;
    }

    @PostMapping("/collections")
    public Result addCollect(@RequestBody Long mblogId,
                             @AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        collectService.insertCollect(userId, mblogId);
        return Result.success();
    }

    @DeleteMapping("/collections/{collectId}")
    public Result deleteCollect(@PathVariable("collectId") Long collectId,
                                @AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        collectService.deleteCollect(userId, collectId);
        return Result.success();
    }

    @GetMapping("/collections")
    public Result<List<Collect>> listCollect(@RequestParam("offset") @Min(value = 0, message = "offset>=0") Long offset,
                                             @RequestParam("limit") @Min(value = 1, message = "limit>=1") Long limit,
                                             @AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        ListCollectDTO listCollectDTO = new ListCollectDTO(userId, offset, limit);
        List<Collect> collects = collectService.listCollect(listCollectDTO);
        return Result.success(collects);
    }

    @GetMapping("/collections/{mblogId}")
    public Result<Collect> getCollect(@PathVariable("mblogId") Long mblogId,
                                      @AuthenticationPrincipal Jwt jwt){
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        Collect collect = collectService.getCollect(userId, mblogId);
        return Result.success(collect);
    }
}

package com.huston.microblog.mblog.web;

import com.huston.microblog.common.model.constant.CommonConstant;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.mblog.model.domain.AgreeMicroblog;
import com.huston.microblog.mblog.model.dto.ListAgreeMicroblogDTO;
import com.huston.microblog.mblog.service.AgreeMicroblogService;
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
public class AgreeMicroblogController {
    private AgreeMicroblogService agreeMicroblogService;

    public AgreeMicroblogController(AgreeMicroblogService agreeMicroblogService) {
        this.agreeMicroblogService = agreeMicroblogService;
    }

    @PostMapping("/agreements")
    public Result insertAgree(@RequestBody Long mblogId,
                              @AuthenticationPrincipal Jwt jwt){
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        agreeMicroblogService.insertAgreeMicroblog(userId, mblogId);
        return Result.success();
    }

    @DeleteMapping("/agreements/{agreeId}")
    public Result deleteAgree(@PathVariable("agreeId") Long agreeId,
                              @AuthenticationPrincipal Jwt jwt){
        Long userId = Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        agreeMicroblogService.deleteAgreeMicroblog(userId, agreeId);
        return Result.success();
    }

    //可根据提供的userId和mblogId来作为条件查询列表，如果为null则不会作为条件
    @GetMapping("/agreements")
    public Result<List<AgreeMicroblog>> listAgree(@Validated ListAgreeMicroblogDTO listAgreeMicroblogDTO){
        return Result.success(agreeMicroblogService.listAgreeMicroblog(listAgreeMicroblogDTO));
    }

    @GetMapping("/agree-counts/{mblogId}")
    public Result<Long> countAgree(@PathVariable("mblogId") Long mblogId){
        Long count = agreeMicroblogService.count(mblogId);
        return Result.success(count);
    }
}

package com.huston.microblog.verification.web;

import com.huston.microblog.common.model.constant.CommonConstant;
import com.huston.microblog.common.model.vo.Result;
import com.huston.microblog.verification.model.dto.AddVerificationDTO;
import com.huston.microblog.verification.model.dto.VerificationDTO;
import com.huston.microblog.verification.model.dto.VerifyDTO;
import com.huston.microblog.verification.model.enums.VerificationStateEnum;
import com.huston.microblog.verification.model.vo.AddVerificationVO;
import com.huston.microblog.verification.service.VerificationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
@Validated
public class VerificationController {

    private VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/verifications")
    @PreAuthorize("hasRole('user')")
    public Result<VerificationDTO> addVerification(@RequestBody @Validated AddVerificationVO addVerificationVO,
                                                   @AuthenticationPrincipal Jwt jwt){
        long userId=Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        AddVerificationDTO addVerificationDTO=new AddVerificationDTO();
        BeanUtils.copyProperties(addVerificationVO, addVerificationDTO);
        addVerificationDTO.setUserId(userId);
        VerificationDTO verificationDTO = verificationService.addVerification(addVerificationDTO);
        return Result.success(verificationDTO);
    }

    @GetMapping("/verifications/{userId}")
    public Result<VerificationDTO> getVerification(@PathVariable("userId") Long userId,
                                                   @AuthenticationPrincipal Jwt jwt){
        long currentUserId=Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        VerificationDTO verification = verificationService.getVerification(userId);
        if(verification==null){
            return Result.success(null);
        }
        if(currentUserId!=userId){
            if(!verification.getVerState().equals(VerificationStateEnum.FINISHED.getCode())){
                verification=null;
            }else{
                verification.setVerRealName(null);
                verification.setVerIdentityCard(null);
                verification.setVerState(null);
                verification.setVerResDesc(null);
                verification.setResIds(null);
            }
        }
        return Result.success(verification);
    }

    @GetMapping("/verifications")
    @PreAuthorize("hasRole('admin')")
    public Result<List<VerificationDTO>> listVerifyingVerification(@RequestParam("offset") Long offset,
                                                                   @RequestParam("limit") Long limit){
        List<VerificationDTO> verificationDTOS = verificationService.listVerifyingVerification(offset, limit);
        return Result.success(verificationDTOS);
    }

    @PatchMapping("/verifications")
    @PreAuthorize("hasRole('admin')")
    public Result verify(@RequestBody @Validated VerifyDTO verifyDTO){
        verificationService.verify(verifyDTO);
        return Result.success();
    }

    @PatchMapping("/verifications/{verId}")
    public Result confirm(@PathVariable("verId") Long verId,
                          @AuthenticationPrincipal Jwt jwt){
        long userId=Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        verificationService.confirm(verId, userId);
        return Result.success();
    }

    @DeleteMapping("/verifications/{verId}")
    public Result deleteVerification(@PathVariable("verId") Long verId,
                                     @AuthenticationPrincipal Jwt jwt){
        long userId=Long.parseLong(jwt.getClaim(CommonConstant.JWT_CLAIMS_USER_ID_NAME));
        verificationService.deleteVerification(verId, userId);
        return Result.success();
    }
}

package com.huston.microblog.auth.web;

import com.huston.microblog.auth.aspect.validation.annotation.Email;
import com.huston.microblog.auth.aspect.validation.annotation.Phone;
import com.huston.microblog.auth.manager.ValidationCodeManager;
import com.huston.microblog.auth.model.dto.*;
import com.huston.microblog.auth.model.enums.ValidationTypeEnum;
import com.huston.microblog.auth.model.vo.*;
import com.huston.microblog.auth.service.UserService;
import com.huston.microblog.common.model.dto.UserDTO;
import com.huston.microblog.common.model.exception.ControllerException;
import com.huston.microblog.common.model.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.huston.microblog.common.model.constant.CommonConstant.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
@RestController
@Validated
public class UserController{

    private UserService userService;
    private ValidationCodeManager validationCodeManager;

    public UserController(UserService userService, ValidationCodeManager validationCodeManager) {
        this.userService = userService;
        this.validationCodeManager = validationCodeManager;
    }

    //发送验证码
    @PostMapping("/validation-codes")
    public Result sendValidationCode(@RequestParam(value = "email", required = false) @Email String email,
                                     @RequestParam(value = "phone", required = false) @Phone String phone,
                                     @RequestParam("validationType") Integer validationType) {
        ValidationTypeEnum validationTypeEnum=ValidationTypeEnum.valueOf(validationType);
        if(validationTypeEnum==null){
            throw new ControllerException("validationType不存在");
        }
        if(email!=null){
            validationCodeManager.sendValidationCodeToEmailAndSave(email, validationTypeEnum);
        }else if(phone!=null){
            validationCodeManager.sendValidationCodeToPhoneAndSave(phone, validationTypeEnum);
        }else{
            throw new ControllerException("缺少参数email或phone");
        }
        return Result.success();
    }

    //注册用户
    @PostMapping("/users")
    public Result insertUser(@RequestBody @Validated InsertUserVO insertUserVO){
        ValidationTypeEnum validationTypeEnum;
        String receiver;
        if(insertUserVO.getUserEmail()!=null){
            validationTypeEnum = ValidationTypeEnum.USER_REGISTRATION_VALIDATE_EMAIL;
            receiver = insertUserVO.getUserEmail();
            insertUserVO.setUserPhone(null);
        }else if(insertUserVO.getUserPhone()!=null){
            validationTypeEnum = ValidationTypeEnum.USER_REGISTRATION_VALIDATE_PHONE;
            receiver = insertUserVO.getUserPhone();
            insertUserVO.setUserEmail(null);
        }else{
            throw new ControllerException("缺少参数userEmail或userPhone");
        }
        //验证验证码
        boolean success = validationCodeManager.validate(receiver , insertUserVO.getValidationCode(), validationTypeEnum);
        if (!success)
            throw new ControllerException("验证码错误，请重试");

        InsertUserDTO userDTO = new InsertUserDTO();
        BeanUtils.copyProperties(insertUserVO, userDTO);
        userService.insertUser(userDTO);
        //操作成功删除对应的验证码
        validationCodeManager.deleteCode(receiver, validationTypeEnum);
        return Result.success();
    }

    //通过邮箱或手机号找回密码
    @PutMapping("/passwords")
    public Result findPassword(@RequestBody @Validated FindPasswordDTO findPasswordDTO){
        userService.findPassword(findPasswordDTO);
        return Result.success();
    }

    @GetMapping("/users/{userId}")
    @PreAuthorize("isAuthenticated()")
    public Result<UserVO> getUser(@PathVariable("userId") Long userId,
                                  @AuthenticationPrincipal Jwt jwt) {
        Long myUserId = Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        UserDTO userDTO = userService.getUser(userId);
        if(userDTO==null)
            return Result.success(null);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDTO, userVO);
        if(!myUserId.equals(userId)){
            userVO.setUserEmail(null);
            userVO.setUserPhone(null);
            userVO.setUserNameSetTime(null);
            userVO.setUserNameUpdateTimes(null);
        }
        return Result.success(userVO);
    }

    @GetMapping("/user")
    public Result<UserVO> getUser(@AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        return getUser(userId, jwt);
    }

    @PatchMapping("/user")
    public Result updateUser(@RequestBody @Validated UpdateUserVO updateUserVO,
                             @AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        UpdateUserDTO updateUserDTO = new UpdateUserDTO();
        BeanUtils.copyProperties(updateUserVO, updateUserDTO);
        updateUserDTO.setUserId(userId);
        userService.updateUser(updateUserDTO);
        return Result.success();
    }

    @PostMapping("/user/phone/validation-code")
    public Result sendValidationCodeToUserPhoneForUpdate(@AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        userService.sendValidationCodeToUserPhoneForUpdate(userId);
        return Result.success();
    }

    @PutMapping("/user/phone")
    public Result updateUserPhone(@RequestBody @Validated UpdateUserPhoneVO updateUserPhoneVO,
                                  @AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        UpdateUserPhoneDTO updateUserPhoneDTO = new UpdateUserPhoneDTO();
        BeanUtils.copyProperties(updateUserPhoneVO, updateUserPhoneDTO);
        updateUserPhoneDTO.setUserId(userId);
        userService.updateUserPhone(updateUserPhoneDTO);
        return Result.success();
    }

    @PostMapping("/user/email/validation-code")
    public Result sendValidationCodeToUserEmailForUpdate(@AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        userService.sendValidationCodeToUserEmailForUpdate(userId);
        return Result.success();
    }

    @PutMapping("/user/email")
    public Result updateUserEmail(@RequestBody @Validated UpdateUserEmailVO updateUserEmailVO,
                                  @AuthenticationPrincipal Jwt jwt) {
        Long userId = Long.parseLong(jwt.getClaim(JWT_CLAIMS_USER_ID_NAME));
        UpdateUserEmailDTO updateUserEmailDTO = new UpdateUserEmailDTO();
        BeanUtils.copyProperties(updateUserEmailVO, updateUserEmailDTO);
        updateUserEmailDTO.setUserId(userId);
        userService.updateUserEmail(updateUserEmailDTO);
        return Result.success();
    }

}

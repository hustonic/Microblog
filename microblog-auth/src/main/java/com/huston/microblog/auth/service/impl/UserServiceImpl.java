package com.huston.microblog.auth.service.impl;

import com.huston.microblog.auth.manager.ValidationCodeManager;
import com.huston.microblog.auth.mapper.UserMapper;
import com.huston.microblog.auth.model.constant.UserServiceConstant;
import com.huston.microblog.auth.model.domain.Role;
import com.huston.microblog.auth.model.domain.User;
import com.huston.microblog.auth.model.dto.*;
import com.huston.microblog.auth.model.enums.ValidationTypeEnum;
import com.huston.microblog.auth.model.vo.UpdateUserVO;
import com.huston.microblog.auth.service.ResourceService;
import com.huston.microblog.auth.service.RoleService;
import com.huston.microblog.auth.service.UserRoleService;
import com.huston.microblog.auth.service.UserService;
import com.huston.microblog.common.model.dto.ResourceDTO;
import com.huston.microblog.common.model.dto.UserDTO;
import com.huston.microblog.common.model.enums.ResourceTypeEnum;
import com.huston.microblog.common.model.enums.ResourceUsageEnum;
import com.huston.microblog.common.model.enums.ServiceExceptionErrorCodeEnum;
import com.huston.microblog.common.model.exception.BadRequestException;
import com.huston.microblog.common.model.exception.InternalServerException;
import com.huston.microblog.common.model.exception.ServiceException;
import com.huston.microblog.common.model.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRoleService userRoleService;
    private final RoleService roleService;
    private final ResourceService resourceService;
    private final PasswordEncoder passwordEncoder;
    private ValidationCodeManager validationCodeManager;

    public UserServiceImpl(UserMapper userMapper, UserRoleService userRoleService, RoleService roleService, ResourceService resourceService, PasswordEncoder passwordEncoder, ValidationCodeManager validationCodeManager) {
        this.userMapper = userMapper;
        this.userRoleService = userRoleService;
        this.roleService = roleService;
        this.resourceService = resourceService;
        this.passwordEncoder = passwordEncoder;
        this.validationCodeManager = validationCodeManager;
    }

    @Override
    public void insertUser(InsertUserDTO insertUserDTO) throws ServiceException {
        //通过唯一索引确保userName、userPhone、userEmail各自的唯一性（单个字段唯一，而不是组合唯一）
        User user = new User();
        BeanUtils.copyProperties(insertUserDTO, user);
        Date current = new Date();
        user.setUserAvailTime(current);
        user.setUserCreTime(current);
        user.setUserNameSetTime(current);
        user.setUserNameUpdateTimes((byte) 0);
        //对userPassword加密
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        //添加用户
        try {
            if (userMapper.insertSelective(user) <= 0) {
                throw new ServiceException(ServiceExceptionErrorCodeEnum.CREATE_USER_FAILED.getErrorCode(), "创建用户失败");
            }
        } catch(DuplicateKeyException e){
            String errorMessage="某字段值已存在，不能重复";
            if(Objects.requireNonNull(e.getMessage()).contains("idx_user_name")){
                errorMessage="用户名已存在，不能重复";
            } else if(Objects.requireNonNull(e.getMessage()).contains("idx_user_email")){
                errorMessage="邮箱已存在，不能重复";
            } else if(Objects.requireNonNull(e.getMessage()).contains("idx_user_phone")){
                errorMessage="手机号已存在，不能重复";
            }
            throw new ServiceException(ServiceExceptionErrorCodeEnum.CREATE_USER_FAILED.getErrorCode(), errorMessage);
        }
        //关联用户角色信息。
        Role role = roleService.getRole(UserServiceConstant.USER_ROLE_NAME);
        userRoleService.insertUserRole(user.getUserId(), role.getRoleId());
    }

    @Override
    public UserDTO getUser(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId).orElse(null);
        if(user == null){
            return null;
        } else {
            UserDTO userDTO =new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTO.setUserPhone(encryptPhone(userDTO.getUserPhone()));
            userDTO.setUserEmail(encryptEmail(userDTO.getUserEmail()));
            if(user.getResId()!=null){
                Result<String> result = resourceService.getResUrl(user.getResId());
                if(result.isSuccess()) {
                    String resUrl = result.getData();
                    userDTO.setResUrl(resUrl);
                }
            }
            return userDTO;
        }
    }

    /**
     * @return 加密后的手机号字符串，例如 123***456
     */
    private String encryptPhone(String phone) {
        if(phone==null) return null;
        return phone.substring(0,3)+"***"+phone.substring(phone.length()-3);
    }

    /**
     * @return 加密后的邮箱字符串，例如 123***@qq.com
     */
    private String encryptEmail(String email) {
        if(email==null) return null;
        int length= email.indexOf('@');
        if(length>4) return email.substring(0,3)+"***"+email.substring(length);
        else return email.substring(0,1)+"***"+email.substring(length);
    }

    @Override
    public void updateUser(UpdateUserDTO updateUserDTO) throws ServiceException{
        if(updateUserDTO.getUserName()!=null){  //修改用户名
            this.updateUserName(updateUserDTO.getUserId(), updateUserDTO.getUserName());
        }

        if(updateUserDTO.getUserPassword()!=null){  //修改密码
            UpdateUserPasswordDTO updateUserPasswordDTO = new UpdateUserPasswordDTO();
            BeanUtils.copyProperties(updateUserDTO, updateUserPasswordDTO);
            updateUserPasswordDTO.setUserId(updateUserDTO.getUserId());
            this.updateUserPassword(updateUserPasswordDTO);
        }


        UpdateUserBasicDTO updateUserBasicDTO = new UpdateUserBasicDTO();
        BeanUtils.copyProperties(updateUserDTO, updateUserBasicDTO);
        updateUserBasicDTO.setUserId(updateUserDTO.getUserId());
        if(updateUserBasicDTO.getResId()==null&&updateUserBasicDTO.getUserBirthday()==null&&
                updateUserBasicDTO.getUserIntro()==null&&updateUserBasicDTO.getUserSex()==null){
            return;
        }
        this.updateUserBasic(updateUserBasicDTO);
    }

    /**
     * 更新用户基本信息，不包含用户名、手机号、邮箱、密码等需要验证的信息。
     */
    @Override
    public void updateUserBasic(UpdateUserBasicDTO updateUserBasicDTO) throws ServiceException {
        //验证资源类型、用途、用户
        if(updateUserBasicDTO.getResId()!=null) {
            Result<ResourceDTO> result = resourceService.getResource(updateUserBasicDTO.getResId());
            if (!result.isSuccess()) {
                throw new InternalServerException("获取资源信息失败");
            }
            ResourceDTO resource = result.getData();
            if (resource == null)
                throw new BadRequestException("资源不存在");
            if (resource.getResType() != ResourceTypeEnum.PICTURE.getCode()) {
                throw new BadRequestException("资源类型只能是图片");
            }
            if (resource.getResUsage() != ResourceUsageEnum.HEAD_PICTURE.getCode()) {
                throw new BadRequestException("资源用途不正确");
            }
            if (!resource.getUserId().equals(updateUserBasicDTO.getUserId())) {
                throw new BadRequestException("资源不属于该用户");
            }
        }

        User user=new User();
        BeanUtils.copyProperties(updateUserBasicDTO,user);
        if (userMapper.updateByPrimaryKeySelective(user) <= 0) {
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_FAILED.getErrorCode(), "更新用户基本信息失败");
        }
    }

    /**
     * 修改用户名，用户名不可重复（唯一索引），需要限制一年内的用户名修改次数
     */
    @Override
    public void updateUserName(Long userId, String userName) throws ServiceException {
        Optional<User> optionalUser = userMapper.selectByPrimaryKey(userId);
        if (!optionalUser.isPresent()){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.USER_ID_NOT_FOUND.getErrorCode(), "用户不存在");
        }
        User user = optionalUser.get();
        if(user.getUserName().equals(userName)){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_NAME_FAILED.getErrorCode(), "新用户名不能与原用户名相同");
        }

        Calendar userNameSetTime = Calendar.getInstance();
        userNameSetTime.setTime(user.getUserNameSetTime());
        Byte userNameUpdateTimes = user.getUserNameUpdateTimes();

        //如果当前用户名的设置时间user_name_set_time不是今年，且user_name_update_times不为0，
        // 则先把user_name_update_times清零。
        User update = new User();
        update.setUserId(userId);
        Calendar current = Calendar.getInstance();

        int userNameSetYear = userNameSetTime.get(Calendar.YEAR);
        int currentYear = current.get(Calendar.YEAR);
        if (userNameSetYear < currentYear&& userNameUpdateTimes!=0 ) {
            userNameUpdateTimes = 0;
            update.setUserNameUpdateTimes(userNameUpdateTimes);
        }
        //根据角色判断可更名次数
        List<Role> roles=roleService.listRoles(userId);
        int max=0;  //计算当前的最大可更名次数
        for(Role role:roles){
            if (UserServiceConstant.USER_ROLE_NAME.equalsIgnoreCase(role.getRoleName())) {
                max += UserServiceConstant.USER_UPDATE_NAME_TIMES;
            } else if (UserServiceConstant.VERIFIED_USER_ROLE_NAME.equalsIgnoreCase(role.getRoleName())) {
                max += UserServiceConstant.VERIFIED_USER_UPDATE_NAME_TIMES;
            } else if (UserServiceConstant.ADMIN_ROLE_NAME.equalsIgnoreCase(role.getRoleName())) {
                max += UserServiceConstant.ADMIN_UPDATE_NAME_TIMES;
            }
        }
        if(userNameUpdateTimes<max){
            update.setUserName(userName);
            update.setUserNameSetTime(new Date());
            update.setUserNameUpdateTimes(++userNameUpdateTimes);
        }else{
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_NAME_FAILED.getErrorCode(),
                    "用户今年的更名次数已达到限制");
        }
        try {
            if (userMapper.updateByPrimaryKeySelective(update) <= 0) {
                throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_NAME_FAILED.getErrorCode(), "修改用户名失败");
            }
        } catch (DuplicateKeyException e){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_NAME_FAILED.getErrorCode(), "用户名已存在，不能重复");
        }
    }

    /**
     * 修改用户手机号，需要验证原手机号和新手机号的验证码。
     */
    @Override
    public void updateUserPhone(UpdateUserPhoneDTO updateUserPhoneDTO) throws ServiceException {
        boolean success=true;
        User user = userMapper.selectUserPhoneByUserId(updateUserPhoneDTO.getUserId()).orElse(null);
        if(user==null){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.USER_ID_NOT_FOUND.getErrorCode(), "用户不存在。");
        }
        if(user.getUserPhone().equals(updateUserPhoneDTO.getUserPhone())){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_PHONE_FAILED.getErrorCode(), "新手机号不能与原手机号相同");
        }
        if(user.getUserPhone()!=null && !user.getUserPhone().equals("")){
            success = validationCodeManager.validate(user.getUserPhone(), updateUserPhoneDTO.getOldPhoneCode(),
                    ValidationTypeEnum.UPDATE_USER_PHONE);
        }
        if(!success){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.VALIDATION_CODE_ERROR.getErrorCode(), "验证码错误");
        }

        success = validationCodeManager.validate(updateUserPhoneDTO.getUserPhone(), updateUserPhoneDTO.getNewPhoneCode(),
                ValidationTypeEnum.UPDATE_USER_PHONE);
        if(!success){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.VALIDATION_CODE_ERROR.getErrorCode(), "验证码错误");
        }

        User update=new User();
        BeanUtils.copyProperties(updateUserPhoneDTO,update);
        try {
            if (userMapper.updateByPrimaryKeySelective(update) <= 0) {
                throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_PHONE_FAILED.getErrorCode(), "修改手机号失败");
            }
        } catch (DuplicateKeyException e){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_PHONE_FAILED.getErrorCode(), "手机号已存在，不能重复");
        }

        validationCodeManager.deleteCode(user.getUserPhone(), ValidationTypeEnum.UPDATE_USER_PHONE);
        validationCodeManager.deleteCode(updateUserPhoneDTO.getUserPhone(), ValidationTypeEnum.UPDATE_USER_PHONE);
    }

    @Override
    public void sendValidationCodeToUserPhoneForUpdate(Long userId) throws ServiceException {
        User user = userMapper.selectUserPhoneByUserId(userId).orElse(null);
        if(user==null)
            throw new ServiceException(ServiceExceptionErrorCodeEnum.USER_ID_NOT_FOUND.getErrorCode(), "用户不存在。");
        String phone=user.getUserPhone();

        if(phone==null){
            throw new BadRequestException("用户没有绑定手机号，发送验证码失败");
        }
        validationCodeManager.sendValidationCodeToPhoneAndSave(phone, ValidationTypeEnum.UPDATE_USER_PHONE);
    }

    @Override
    public void sendValidationCodeToUserEmailForUpdate(Long userId) throws ServiceException {
        User user = userMapper.selectUserEmailByUserId(userId).orElse(null);
        if(user==null)
            throw new ServiceException(ServiceExceptionErrorCodeEnum.USER_ID_NOT_FOUND.getErrorCode(), "用户不存在。");
        String email=user.getUserEmail();

        if(email==null){
            throw new BadRequestException("用户没有绑定邮箱，发送验证码失败");
        }
        validationCodeManager.sendValidationCodeToEmailAndSave(email, ValidationTypeEnum.UPDATE_USER_EMAIL);
    }

    @Override
    public void updateUserEmail(UpdateUserEmailDTO updateUserEmailDTO) throws ServiceException {
        boolean success=true;
        User user = userMapper.selectUserEmailByUserId(updateUserEmailDTO.getUserId()).orElse(null);
        if(user==null){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.USER_ID_NOT_FOUND.getErrorCode(), "用户不存在。");
        }
        if(user.getUserEmail().equals(updateUserEmailDTO.getUserEmail())){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_EMAIL_FAILED.getErrorCode(), "新邮箱不能与原邮箱相同");
        }
        if(user.getUserEmail()!=null && !user.getUserEmail().equals("")){
            success = validationCodeManager.validate(user.getUserEmail(), updateUserEmailDTO.getOldEmailCode(),
                    ValidationTypeEnum.UPDATE_USER_EMAIL);
        }
        if(!success){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.VALIDATION_CODE_ERROR.getErrorCode(), "验证码错误");
        }

        success = validationCodeManager.validate(updateUserEmailDTO.getUserEmail(), updateUserEmailDTO.getNewEmailCode(),
                ValidationTypeEnum.UPDATE_USER_EMAIL);
        if(!success){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.VALIDATION_CODE_ERROR.getErrorCode(), "验证码错误");
        }

        User update=new User();
        BeanUtils.copyProperties(updateUserEmailDTO,update);
        try {
            if (userMapper.updateByPrimaryKeySelective(update) <= 0) {
                throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_EMAIL_FAILED.getErrorCode(), "修改邮箱失败");
            }
        } catch (DuplicateKeyException e){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_EMAIL_FAILED.getErrorCode(), "邮箱已存在，不能重复");
        }

        validationCodeManager.deleteCode(user.getUserEmail(), ValidationTypeEnum.UPDATE_USER_EMAIL);
        validationCodeManager.deleteCode(updateUserEmailDTO.getUserEmail(), ValidationTypeEnum.UPDATE_USER_EMAIL);
    }

    @Override
    public void updateUserPassword(UpdateUserPasswordDTO updateUserPasswordDTO) throws ServiceException {
        User user = userMapper.selectUserPasswordByUserId(updateUserPasswordDTO.getUserId())
                .orElseThrow(()->new ServiceException(ServiceExceptionErrorCodeEnum.USER_ID_NOT_FOUND.getErrorCode(), "用户不存在"));
        if(passwordEncoder.matches(updateUserPasswordDTO.getUserPassword(),user.getUserPassword())){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_PASSWORD_FAILED.getErrorCode(), "新密码不能与原密码一样");
        }
        if(!passwordEncoder.matches(updateUserPasswordDTO.getOldPassword(),user.getUserPassword())){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_PASSWORD_FAILED.getErrorCode(), "原密码不一致");
        }

        User update=new User();
        BeanUtils.copyProperties(updateUserPasswordDTO, update);
        update.setUserPassword(passwordEncoder.encode(update.getUserPassword()));
        int affected=userMapper.updateByPrimaryKeySelective(update);
        if(affected<=0){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.UPDATE_USER_PASSWORD_FAILED.getErrorCode(), "修改密码失败");
        }
    }

    @Override
    public void findPassword(FindPasswordDTO findPasswordDTO) {
        ValidationTypeEnum validationTypeEnum;
        if(findPasswordDTO.getValidationType()==ValidationTypeEnum.FIND_PASSWORD_BY_EMAIL.getType()){
            validationTypeEnum=ValidationTypeEnum.FIND_PASSWORD_BY_EMAIL;
        }else if(findPasswordDTO.getValidationType()==ValidationTypeEnum.FIND_PASSWORD_BY_PHONE.getType()){
            validationTypeEnum=ValidationTypeEnum.FIND_PASSWORD_BY_PHONE;
        }else{
            throw new BadRequestException("validationType不合法");
        }
        boolean valid = validationCodeManager.validate(findPasswordDTO.getEmailOrPhone(), findPasswordDTO.getValidationCode(), validationTypeEnum);
        if(!valid){
            throw new BadRequestException("验证码错误");
        }

        String password= passwordEncoder.encode(findPasswordDTO.getNewPassword());
        if(validationTypeEnum==ValidationTypeEnum.FIND_PASSWORD_BY_EMAIL){
            if(userMapper.updateUserPasswordByUserEmail(findPasswordDTO.getEmailOrPhone(), password)<=0){
                throw new ServiceException("修改密码失败");
            }
        }else {
            if(userMapper.updateUserPasswordByUserPhone(findPasswordDTO.getEmailOrPhone(), password)<=0){
                throw new ServiceException("修改密码失败");
            }
        }
        validationCodeManager.deleteCode(findPasswordDTO.getEmailOrPhone(), validationTypeEnum);
    }
}

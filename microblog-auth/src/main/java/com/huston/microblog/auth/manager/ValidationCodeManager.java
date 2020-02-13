package com.huston.microblog.auth.manager;

import com.huston.microblog.auth.model.enums.ValidationTypeEnum;
import com.huston.microblog.common.model.exception.ManagerException;

/**
 * 提供验证码发送和校验服务
 * @author huxiantao-cn@foxmail.com
 */
public interface ValidationCodeManager {

    void sendValidationCodeToPhoneAndSave(String phone, ValidationTypeEnum validationType) throws ManagerException ;

    void sendValidationCodeToEmailAndSave(String email, ValidationTypeEnum validationType) throws ManagerException ;

    boolean validate(String receiver, String code, ValidationTypeEnum validationType);

    void deleteCode(String receiver, ValidationTypeEnum validationType);
}

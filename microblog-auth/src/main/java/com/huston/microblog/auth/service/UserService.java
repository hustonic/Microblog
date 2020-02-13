package com.huston.microblog.auth.service;

import com.huston.microblog.auth.model.dto.*;
import com.huston.microblog.auth.model.vo.UpdateUserVO;
import com.huston.microblog.common.model.dto.UserDTO;
import com.huston.microblog.common.model.exception.ServiceException;

/**
 *
 * @author huxiantao-cn@foxmail.com
 */
public interface UserService {

    void insertUser(InsertUserDTO insertUserDTO) throws ServiceException;

    UserDTO getUser(Long userId);

    void findPassword(FindPasswordDTO findPasswordDTO);

    void updateUser(UpdateUserDTO updateUserDTO) throws ServiceException ;

    /**
     * 更新用户基本信息，不包含用户名、手机号、邮箱、密码等需要验证的信息。
     */
    void updateUserBasic(UpdateUserBasicDTO updateUserBasicDTO) throws ServiceException ;

    /**
     * 修改用户名，用户名不可重复（唯一索引），需要限制一年内的用户名修改次数
     */
    void updateUserName(Long userId, String userName) throws ServiceException;

    void sendValidationCodeToUserPhoneForUpdate(Long userId) throws ServiceException;

    void updateUserPhone(UpdateUserPhoneDTO updateUserPhoneDTO) throws ServiceException;

    void sendValidationCodeToUserEmailForUpdate(Long userId) throws ServiceException;

    void updateUserEmail(UpdateUserEmailDTO updateUserEmailDTO) throws ServiceException;

    void updateUserPassword(UpdateUserPasswordDTO updateUserPasswordDTO) throws ServiceException;

}

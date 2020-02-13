package com.huston.microblog.auth.service;

import com.huston.microblog.auth.model.domain.UserRole;
import com.huston.microblog.common.model.exception.ServiceException;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface UserRoleService {

    List<UserRole> listUserRoles(Long userId);

    void insertUserRole(Long userId,Long roleId)  throws ServiceException;
}

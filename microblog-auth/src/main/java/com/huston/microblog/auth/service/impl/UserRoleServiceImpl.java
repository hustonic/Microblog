package com.huston.microblog.auth.service.impl;

import com.huston.microblog.auth.mapper.UserRoleMapper;
import com.huston.microblog.auth.model.domain.UserRole;
import com.huston.microblog.common.model.enums.ServiceExceptionErrorCodeEnum;
import com.huston.microblog.common.model.exception.ServiceException;
import com.huston.microblog.auth.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleMapper userRoleMapper;

    public UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public List<UserRole> listUserRoles(Long userId) {
        return userRoleMapper.selectByUserId(userId);
    }

    @Override
    public void insertUserRole(Long userId, Long roleId) throws ServiceException {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        int affectedRows = userRoleMapper.insertSelective(userRole);
        if(affectedRows<=0){
            throw new ServiceException(ServiceExceptionErrorCodeEnum.INSERT_USER_ROLE_FAILED.getErrorCode(),
                    "插入用户角色关系失败");
        }
    }
}

package com.huston.microblog.auth.service.impl;

import com.huston.microblog.auth.mapper.RoleMapper;
import com.huston.microblog.auth.model.domain.Role;
import com.huston.microblog.auth.model.domain.UserRole;
import com.huston.microblog.auth.service.RoleService;
import com.huston.microblog.auth.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author huxiantao-cn@foxmail.com
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    private UserRoleService userRoleService;

    public RoleServiceImpl(RoleMapper roleMapper, UserRoleService userRoleService) {
        this.roleMapper = roleMapper;
        this.userRoleService = userRoleService;
    }

    @Override
    public List<Role> listRoles(Long userId) {
        //先根据userId查UserRole关系，然后根据结果的roleId查Roles
        List<UserRole> userRoles = userRoleService.listUserRoles(userId);

        List<Role> roles=new ArrayList<>();
        userRoles.forEach(userRole -> {
            Optional<Role> role = roleMapper.selectByPrimaryKey(userRole.getRoleId());
            role.ifPresent(roles::add);
        });
        return roles;
    }

    @Override
    public Role getRole(String roleName) {
        return roleMapper.selectByRoleName(roleName.toLowerCase())  //不区分大小写
                .orElse(roleMapper.selectByRoleName(roleName.toUpperCase())
                        .orElse(null));
    }
}

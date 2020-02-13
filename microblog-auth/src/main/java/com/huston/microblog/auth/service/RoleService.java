package com.huston.microblog.auth.service;

import com.huston.microblog.auth.model.domain.Role;

import java.util.List;

/**
 * @author huxiantao-cn@foxmail.com
 */
public interface RoleService {

    List<Role> listRoles(Long userId);

    Role getRole(String roleName);
}

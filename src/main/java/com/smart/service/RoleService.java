package com.smart.service;

import com.smart.core.Service;
import com.smart.model.Role;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/11/20.
 */
public interface RoleService extends Service<Role> {

    List<Role> findRolesByUserId(Long userId);

    List<Role> pageList();

    Role findRoleById(Long id);

    void add(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

}

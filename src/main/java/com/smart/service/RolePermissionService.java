package com.smart.service;
import com.smart.model.RolePermission;
import com.smart.core.Service;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
public interface RolePermissionService extends Service<RolePermission> {

    void deleteByRoleId(Long id);

}

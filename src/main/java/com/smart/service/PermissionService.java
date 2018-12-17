package com.smart.service;
import com.smart.model.Permission;
import com.smart.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
public interface PermissionService extends Service<Permission> {

    List<Permission> findByUserId(Long id);

    List<Permission> pageList();

    void add(Permission permission);

    Permission findPermissionById(Long id);

    void deletePermission(Long id);

    void updatePermission(Permission permission);

    List<Permission> findByMenuId(List<Long> menuIdList);
}

package com.smart.service;
import com.smart.model.ResourcePermission;
import com.smart.core.Service;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
public interface ResourcePermissionService extends Service<ResourcePermission> {

    void deleteByPermissionId(Long id);
}

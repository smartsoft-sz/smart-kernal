package com.smart.service.impl;

import com.smart.dao.RolePermissionMapper;
import com.smart.model.RolePermission;
import com.smart.service.RolePermissionService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
@Service
@Transactional
public class RolePermissionServiceImpl extends AbstractService<RolePermission> implements RolePermissionService {
    @Resource
    private RolePermissionMapper tblRolePermissionMapper;

    @Override
    public void deleteByRoleId(Long id) {
        tblRolePermissionMapper.deleteByRoleId(id);
    }
}

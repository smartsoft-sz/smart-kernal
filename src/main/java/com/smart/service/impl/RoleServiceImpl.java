package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.dao.RoleMapper;
import com.smart.model.Permission;
import com.smart.model.Role;
import com.smart.model.RolePermission;
import com.smart.service.RolePermissionService;
import com.smart.service.RoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by CodeGenerator on 2017/11/20.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionService rolePermissionService;

    @Override
    public List<Role> findRolesByUserId(Long userId){
        return roleMapper.findRolesByUserId(userId);
    }

    @Override
    public List<Role> pageList() {
        return roleMapper.pageList();
    }

    @Override
    public Role findRoleById(Long id) {
        Role role =  roleMapper.findRoleById(id);
        if (CollectionUtils.isNotEmpty(role.getPermissionList())){
            List<Long> list = role.getPermissionList().stream().map(Permission::getId).collect(Collectors.toList());
            role.setPermissionIds(list);
        }
        return role;
    }

    @Override
    public void add(Role role) {
        Long id = save(role);
        if (CollectionUtils.isNotEmpty(role.getPermissionIds())){
            role.getPermissionIds().stream().forEach(item ->{
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(id);
                rolePermission.setPermissionId(item);
                rolePermissionService.save(rolePermission);
            });

        }
    }

    @Override
    public void updateRole(Role role) {
        rolePermissionService.deleteByRoleId(role.getId());
        updateByPK(role);
        if (CollectionUtils.isNotEmpty(role.getPermissionIds())){
            role.getPermissionIds().stream().forEach(item ->{
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(role.getId());
                rolePermission.setPermissionId(item);
                rolePermissionService.save(rolePermission);
            });
        }

    }

    @Override
    public void deleteRole(Long id) {
        rolePermissionService.deleteByRoleId(id);
        deleteByPK(id);
    }


}

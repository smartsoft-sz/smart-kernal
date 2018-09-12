package com.smart.service.impl;

import com.smart.core.ResultCode;
import com.smart.core.ServiceException;
import com.smart.dao.PermissionMapper;
import com.smart.model.Permission;
import com.smart.model.ResourcePermission;
import com.smart.service.PermissionService;
import com.smart.core.AbstractService;
import com.smart.service.ResourcePermissionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {
    @Resource
    private PermissionMapper tblPermissionMapper;
    @Resource
    private ResourcePermissionService resourcePermissionService;

    @Override
    public List<Permission> findByUserId(Long id) {
        return tblPermissionMapper.findByUserId(id);
    }

    @Override
    public List<Permission> pageList() {
        return tblPermissionMapper.pageList();
    }

    @Override
    public void add(Permission permission) {
        permission.setType("System");
        Long permissionId = super.save(permission);
        if (CollectionUtils.isNotEmpty(permission.getResourceIds())){
            permission.getResourceIds().stream().forEach(item ->{
                ResourcePermission resourcePermission = new ResourcePermission();
                resourcePermission.setResourceId(item);
                resourcePermission.setPermissionId(permissionId);
                resourcePermission.setPermissionType(permission.getType());
                resourcePermissionService.save(resourcePermission);
            });
        }else {
            throw new ServiceException(ResultCode.FAIL);
        }
    }

    @Override
    public Permission findPermissionById(Long id) {
        Permission permission = tblPermissionMapper.findPermissionById(id);
        List<Long> list = permission.getResourceList().stream().map(com.smart.model.Resource::getId).distinct().collect(Collectors.toList());
        permission.setResourceIds(list);
        return permission;
    }

    @Override
    public void deletePermission(Long id) {
        resourcePermissionService.deleteByPermissionId(id);
        deleteByPK(id);
    }

    @Override
    public void updatePermission(Permission permission) {
        resourcePermissionService.deleteByPermissionId(permission.getId());
        updateByPK(permission);
        if (CollectionUtils.isNotEmpty(permission.getResourceIds())){
            permission.getResourceIds().stream().forEach(item ->{
                ResourcePermission resourcePermission = new ResourcePermission();
                resourcePermission.setResourceId(item);
                resourcePermission.setPermissionId(permission.getId());
                resourcePermission.setPermissionType(permission.getType());
                resourcePermissionService.save(resourcePermission);
            });
        }else {
            throw new ServiceException(ResultCode.FAIL);
        }
    }


}

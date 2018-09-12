package com.smart.service.impl;

import com.smart.dao.ResourcePermissionMapper;
import com.smart.model.ResourcePermission;
import com.smart.service.ResourcePermissionService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
@Service
@Transactional
public class ResourcePermissionServiceImpl extends AbstractService<ResourcePermission> implements ResourcePermissionService {
    @Resource
    private ResourcePermissionMapper tblResourcePermissionMapper;

    @Override
    public void deleteByPermissionId(Long id) {
        tblResourcePermissionMapper.deleteByPermissionId(id);
    }
}

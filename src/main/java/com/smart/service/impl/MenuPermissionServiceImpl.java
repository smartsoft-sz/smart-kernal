package com.smart.service.impl;

import com.smart.dao.MenuPermissionMapper;
import com.smart.model.MenuPermission;
import com.smart.service.MenuPermissionService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class MenuPermissionServiceImpl extends AbstractService<MenuPermission> implements MenuPermissionService {
    @Resource
    private MenuPermissionMapper tblMenuPermissionMapper;

    @Override
    public void deleteByMenuId(Long menuId) {
        tblMenuPermissionMapper.deleteByMenuId(menuId);
    }
}

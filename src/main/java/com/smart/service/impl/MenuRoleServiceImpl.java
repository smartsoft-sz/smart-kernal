package com.smart.service.impl;

import com.smart.dao.MenuRoleMapper;
import com.smart.model.MenuRole;
import com.smart.service.MenuRoleService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class MenuRoleServiceImpl extends AbstractService<MenuRole> implements MenuRoleService {
    @Resource
    private MenuRoleMapper tblMenuRoleMapper;

}

package com.smart.service.impl;

import com.smart.core.Result;
import com.smart.dao.MenuMapper;
import com.smart.model.Menu;
import com.smart.service.MenuService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/09/03.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Resource
    private MenuMapper tblMenuMapper;

    @Override
    public List<Menu> findAllMenusWithRoles() {
        List<Menu> menuList = tblMenuMapper.findAllMenusWithRoles();
        return menuList;
    }
}

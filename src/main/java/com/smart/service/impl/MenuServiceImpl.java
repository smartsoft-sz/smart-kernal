package com.smart.service.impl;

import com.smart.bo.MenuBO;
import com.smart.core.Result;
import com.smart.dao.MenuMapper;
import com.smart.model.Menu;
import com.smart.model.MenuPermission;
import com.smart.service.MenuPermissionService;
import com.smart.service.MenuService;
import com.smart.core.AbstractService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by CodeGenerator on 2018/09/03.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Resource
    private MenuMapper tblMenuMapper;
    @Resource
    private MenuPermissionService menuPermissionService;

    @Override
    public List<Menu> findAllMenusWithPermissions() {
        List<Menu> menuList = tblMenuMapper.findAllMenusWithPermissions();
        return menuList;
    }

    @Override
    public void addMenu(Menu menu) {
            if (null == menu.getParentId()){
                menu.setParentId(0L);
            }
            save(menu);
            if (null != menu.getPermissionId()){
            MenuPermission menuPermission = new MenuPermission();
            menuPermission.setMenuId(menu.getId());
            menuPermission.setPermissionId(menu.getPermissionId());
            menuPermissionService.save(menuPermission);
        }
    }

    @Override
    public void deleteMenu(Long id) {
        menuPermissionService.deleteByMenuId(id);
        deleteByPK(id);
    }

    @Override
    public void updateMenu(Menu menu) {
            menuPermissionService.deleteByMenuId(menu.getId());
            updateByPK(menu);
            if (null != menu.getPermissionId()){
            MenuPermission menuPermission = new MenuPermission();
            menuPermission.setMenuId(menu.getId());
            menuPermission.setPermissionId(menu.getPermissionId());
            menuPermissionService.save(menuPermission);
        }
    }

    @Override
    public Menu findMenuDetial(Long id) {
        Menu menu = tblMenuMapper.findMenuDetial(id);
        if (CollectionUtils.isNotEmpty(menu.getPermissionList())){
            menu.setPermissionId(menu.getPermissionList().get(0).getId());
        }
        return menu;
    }

    @Override
    public Map<Long,List<MenuBO>> listMenuBO() {
        List<MenuBO> menuBOS = tblMenuMapper.listMenuBO();
        Map<Long,List<MenuBO>> mapList = menuBOS.stream().collect(Collectors.groupingBy(MenuBO::getParentId));
        return mapList;
    }


}

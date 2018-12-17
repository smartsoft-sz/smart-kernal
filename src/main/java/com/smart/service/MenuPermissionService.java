package com.smart.service;
import com.smart.model.MenuPermission;
import com.smart.core.Service;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
public interface MenuPermissionService extends Service<MenuPermission> {

    void deleteByMenuId(Long menuId);
}

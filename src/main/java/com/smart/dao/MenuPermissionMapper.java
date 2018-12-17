package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.MenuPermission;
import org.apache.ibatis.annotations.Param;

public interface MenuPermissionMapper extends Mapper<MenuPermission> {

    void deleteByMenuId(@Param("menuId") Long menuId);

}
package com.smart.dao;

import com.smart.bo.MenuBO;
import com.smart.core.Mapper;
import com.smart.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {

    List<Menu> findAllMenusWithPermissions();

    Menu findMenuDetial(@Param("id") Long id);

    List<MenuBO> listMenuBO();

    List<Menu> findByRoleId(@Param("roleId") Long roleId);
}
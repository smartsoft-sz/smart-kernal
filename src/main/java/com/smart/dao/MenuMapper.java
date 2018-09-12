package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.Menu;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    List<Menu> findAllMenusWithRoles();
}
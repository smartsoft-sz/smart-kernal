package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<Permission> findByUserId(@Param("userId") Long id);

    List<Permission> pageList();

    Permission findPermissionById(@Param("permissionId") Long id);
}
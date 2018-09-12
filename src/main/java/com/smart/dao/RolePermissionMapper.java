package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.RolePermission;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper extends Mapper<RolePermission> {

    void deleteByRoleId(@Param("roleId") Long roleId);
}
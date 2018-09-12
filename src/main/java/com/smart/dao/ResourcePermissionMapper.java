package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.ResourcePermission;
import org.apache.ibatis.annotations.Param;

public interface ResourcePermissionMapper extends Mapper<ResourcePermission> {

    void deleteByPermissionId(@Param("permissionId") Long id);
}
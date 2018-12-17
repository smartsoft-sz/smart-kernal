package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper extends Mapper<Resource> {

    List<Resource> getResourcesByPermissionId(@Param("permissionId") Long id);

    List<Resource> filter(@Param("keyword") String keyword);
}
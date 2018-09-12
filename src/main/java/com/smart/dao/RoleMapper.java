package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {
    List<Role> findRolesByUserId(Long userId);

    List<Role> pageList();

    Role findRoleById(@Param("id") Long id);
}
package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {

    void save(@Param("userId") Long userId,@Param("roleIds") List<Long> roleIds);
}
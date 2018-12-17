package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<User> listUserPage(@Param("keyword") String keyword);
}
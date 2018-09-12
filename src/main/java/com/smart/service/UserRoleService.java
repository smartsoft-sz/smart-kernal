package com.smart.service;
import com.smart.model.UserRole;
import com.smart.core.Service;


/**
 * Created by CodeGenerator on 2018/06/23.
 */
public interface UserRoleService extends Service<UserRole> {

    int deleteByUserId(Long userId);
}

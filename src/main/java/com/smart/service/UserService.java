package com.smart.service;
import com.smart.model.User;
import com.smart.core.Service;


/**
 * Created by CodeGenerator on 2018/06/22.
 */
public interface UserService extends Service<User> {

    User findByLoginName(String loginName);

    Long saveUser(User user);

    User getUserIdentity(Long userId);

    int updateAdmin(User user);
}

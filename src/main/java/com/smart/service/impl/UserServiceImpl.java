package com.smart.service.impl;

import com.smart.core.ResultCode;
import com.smart.core.ServiceException;
import com.smart.dao.UserMapper;
import com.smart.model.Role;
import com.smart.model.User;
import com.smart.model.UserRole;
import com.smart.service.RoleService;
import com.smart.service.UserRoleService;
import com.smart.service.UserService;
import com.smart.core.AbstractService;
import com.smart.service.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/22.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper tblUserMapper;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleService roleService;

    @Override
    public User findByLoginName(String loginName){
        User user = new User();
        user.setLoginName(loginName);
        return findOne(user);
    }

    @Override
    public Long saveUser(User user) {
        User checkUser = this.findByLoginName(user.getLoginName());
        if (checkUser != null) {
            throw new ServiceException(ResultCode.USER_EXIST);
        }
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if (StringUtils.isEmpty(user.getType())) {
            user.setType(Constants.UserType.ADMIN);
        }
        Long result = super.save(user);
        if (user.getRoles() != null && user.getRoles().size() > 0) {
            for (Role role : user.getRoles()) {
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(role.getId());
                userRoleService.save(userRole);
            }
        }
        return result;
    }

    @Override
    public User getUserIdentity(Long userId){
        User user = findById(userId);
        if(user != null){
            user.setRoles(roleService.findRolesByUserId(userId));
        }
        return user;
    }

    @Override
    public int updateAdmin(User user) {
        int result = 0;
        User u = findById(user.getId());
        if(StringUtils.isNotBlank(user.getLoginName())){
            u.setLoginName(user.getLoginName());
        }
        if(StringUtils.isNotBlank(user.getName())){
            u.setName(user.getName());
        }
        if(StringUtils.isNotBlank(user.getMobile())){
            u.setMobile(user.getMobile());
        }
        if(StringUtils.isNotBlank(user.getEmail())){
            u.setEmail(user.getEmail());
        }
        userRoleService.deleteByUserId(user.getId());
        result = super.updateByPK(u);
        if (user.getRoles() != null && user.getRoles().size()>0) {
            for (Role role : user.getRoles()) {
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(role.getId());
                userRoleService.save(userRole);
            }
        }
        return result;
    }
}

package com.smart.service.impl;

import com.smart.core.ResultCode;
import com.smart.core.ServiceException;
import com.smart.dao.UserMapper;
import com.smart.model.Role;
import com.smart.model.User;
import com.smart.model.UserRole;
import com.smart.service.PermissionService;
import com.smart.service.RoleService;
import com.smart.service.UserRoleService;
import com.smart.service.UserService;
import com.smart.core.AbstractService;
import com.smart.service.util.Constants;
import com.smart.service.util.QueryUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


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
    @Resource
    private PermissionService permissionService;

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
        if (user.getRoleIds() != null && user.getRoleIds().size() > 0) {
            userRoleService.saveUserRole(result,user.getRoleIds());
        }
        return result;
    }

    @Override
    public User getUserIdentity(Long userId){
        User user = findById(userId);
        if(user != null){
            List<Role> roles = roleService.findRolesByUserId(userId);
            user.setRoles(roles);
            user.setPermissionList(permissionService.findByUserId(userId));
            user.setRoleIds(roles.stream().map(role -> role.getId()).collect(Collectors.toList()));
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
        if (user.getRoleIds() != null && user.getRoleIds().size() > 0) {
            userRoleService.saveUserRole(user.getId(),user.getRoleIds());
        }
        return result;
    }

    @Override
    public List<User> listUserPage(String keyword) {
        keyword = QueryUtil.replaceSpecialCharactorsForLikeParam(keyword);
        return tblUserMapper.listUserPage(keyword);
    }

    @Override
    public void deleteUser(Long userId) {
        userRoleService.deleteByUserId(userId);
        deleteByPK(userId);
    }
}

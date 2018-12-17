package com.smart.service.impl;

import com.smart.dao.UserRoleMapper;
import com.smart.model.UserRole;
import com.smart.service.UserRoleService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/23.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper tblUserRoleMapper;

    @Override
    public int deleteByUserId(Long userId) {
        Condition condition = new Condition(UserRole.class);
        Condition.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId",userId);
        return tblUserRoleMapper.deleteByCondition(condition);
    }

    @Override
    public void saveUserRole(Long userId, List<Long> roleIds) {
        tblUserRoleMapper.save(userId,roleIds);
    }
}

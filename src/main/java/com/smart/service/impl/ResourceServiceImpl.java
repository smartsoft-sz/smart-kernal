package com.smart.service.impl;

import com.smart.dao.ResourceMapper;
import com.smart.model.Resource;
import com.smart.service.ResourceService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/25.
 */
@Service
@Transactional
public class ResourceServiceImpl extends AbstractService<com.smart.model.Resource> implements ResourceService {
    @javax.annotation.Resource
    private ResourceMapper tblResourceMapper;

    @Override
    public List<Resource> getResourcesByPermissionId(Long id) {
        return tblResourceMapper.getResourcesByPermissionId(id);
    }
}

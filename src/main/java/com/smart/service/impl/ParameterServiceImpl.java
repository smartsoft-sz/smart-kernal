package com.smart.service.impl;

import com.smart.dao.ParameterMapper;
import com.smart.model.Parameter;
import com.smart.service.ParameterService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/13.
 */
@Service
@Transactional
public class ParameterServiceImpl extends AbstractService<Parameter> implements ParameterService {
    @Resource
    private ParameterMapper tblParameterMapper;

}

package com.smart.service.impl;

import com.smart.dao.CodeGroupMapper;
import com.smart.model.CodeGroup;
import com.smart.service.CodeGroupService;
import com.smart.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by smartsoft on 2018/09/07.
 */
@Service
@Transactional
public class CodeGroupServiceImpl extends AbstractService<CodeGroup> implements CodeGroupService {
    @Resource
    private CodeGroupMapper tblCodeGroupMapper;

}

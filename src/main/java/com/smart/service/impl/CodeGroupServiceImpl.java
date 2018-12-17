package com.smart.service.impl;

import com.smart.dao.CodeGroupMapper;
import com.smart.model.CodeGroup;
import com.smart.service.CodeGroupService;
import com.smart.core.AbstractService;
import com.smart.service.util.QueryUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by smartsoft on 2018/09/07.
 */
@Service
@Transactional
public class CodeGroupServiceImpl extends AbstractService<CodeGroup> implements CodeGroupService {
    @Resource
    private CodeGroupMapper tblCodeGroupMapper;

    @Override
    public List<CodeGroup> filter(String keyword) {
        keyword = QueryUtil.replaceSpecialCharactorsForLikeParam(keyword);
        return tblCodeGroupMapper.filter(keyword);
    }
}

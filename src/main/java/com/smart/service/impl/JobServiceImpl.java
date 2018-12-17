package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.dao.JobMapper;
import com.smart.model.Job;
import com.smart.service.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/03/27.
 */
@Service
@Transactional
public class JobServiceImpl extends AbstractService<Job> implements JobService {
    @Resource
    private JobMapper tblJobMapper;

    @Override
    public Job findByCode(String code) {
        Job job = new Job();
        job.setCode(code);
        return this.findOne(job);
    }
}

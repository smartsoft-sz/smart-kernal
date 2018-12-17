package com.smart.service;


import com.smart.core.Service;
import com.smart.model.Job;

/**
 * Created by CodeGenerator on 2018/03/27.
 */
public interface JobService extends Service<Job> {

    Job findByCode(String code);
}

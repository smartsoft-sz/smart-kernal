package com.smart.service;

import com.smart.core.Service;
import com.smart.model.JobRerunResult;

import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/27.
 */
public interface JobRerunResultService extends Service<JobRerunResult> {

    List<JobRerunResult> findAllJobRerunResult();

    List<JobRerunResult> findByStatus(String status, String jobItemStatus);

    void rerunJob(Long jobId, Date startTime, Date endTime);
}

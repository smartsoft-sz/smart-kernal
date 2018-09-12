package com.smart.service;

import com.smart.core.Service;
import com.smart.model.JobRunResult;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/27.
 */
public interface JobRunResultService extends Service<JobRunResult> {

    List<JobRunResult> findAllJobRerunResult();

    List<JobRunResult> findByStatus(String status);

    List<JobRunResult> listInprogressResultByJobId(Long jobId);

    List<JobRunResult> listByJobIdAndStatus(Long jobId, String status);
}

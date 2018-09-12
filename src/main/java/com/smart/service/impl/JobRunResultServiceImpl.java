package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.core.JobConstant;
import com.smart.dao.JobRunResultMapper;
import com.smart.model.JobRunResult;
import com.smart.service.JobRunResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/27.
 */
@Service
@Transactional
public class JobRunResultServiceImpl extends AbstractService<JobRunResult> implements JobRunResultService {
    @Resource
    private JobRunResultMapper tblJobRunResultMapper;


    @Override
    public List<JobRunResult> findAllJobRerunResult() {
        return tblJobRunResultMapper.findAllJobRunResult();
    }

    @Override
    public List<JobRunResult> findByStatus(String status) {
        return tblJobRunResultMapper.findByStatus(status);
    }

    @Override
    public List<JobRunResult> listInprogressResultByJobId(Long jobId) {
        return this.listByJobIdAndStatus(jobId, JobConstant.JOB_RUN_RESULT_STATUS_INPROGRESS);
    }

    @Override
    public List<JobRunResult> listByJobIdAndStatus(Long jobId, String status) {
        JobRunResult jobRunResult = new JobRunResult();
        jobRunResult.setJobId(jobId);
        jobRunResult.setStatus(status);
        return this.find(jobRunResult);
    }
}

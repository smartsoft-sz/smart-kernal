package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.JobRunResult;

import java.util.List;

public interface JobRunResultMapper extends Mapper<JobRunResult> {
    List<JobRunResult> findByStatus(String status);

    List<JobRunResult> findAllJobRunResult();
}
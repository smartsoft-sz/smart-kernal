package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.JobRerunResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobRerunResultMapper extends Mapper<JobRerunResult> {

    List<JobRerunResult> findByStatus(String status);

    List<JobRerunResult> findByJobItemStatus(@Param("status") String status, @Param("jobItemStatus") String jobItemStatus);

    List<JobRerunResult> findAllJobRerunResult();
}
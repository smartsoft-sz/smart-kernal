package com.smart.service.job;


import com.smart.bo.JobParam;

public interface JobRerunService {

    void process(JobParam jobParam) throws Exception;

    void delete(JobParam jobParam);

    JobRerunService getBean();
}

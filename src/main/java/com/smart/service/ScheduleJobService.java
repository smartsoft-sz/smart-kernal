package com.smart.service;
import com.smart.bo.ScheduleJobReturnBO;
import com.smart.model.ScheduleJob;
import com.smart.core.Service;
import org.quartz.SchedulerException;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
public interface ScheduleJobService extends Service<ScheduleJob> {

    boolean isScheduleJobExist(String jobName, String jobGroup);

    ScheduleJob findByMethodName(String name);

    void changeStatus(Long jobId, String action) throws SchedulerException;

    void addJobToQuartz(ScheduleJob job) throws SchedulerException;

    void deleteJobInQuartz(ScheduleJob scheduleJob) throws SchedulerException;

    void pauseJobInQuartz(ScheduleJob scheduleJob) throws SchedulerException;

    void resumeJobInQuartz(ScheduleJob scheduleJob) throws SchedulerException;

    void updateJobInQuartz(ScheduleJob scheduleJob) throws SchedulerException;

    List<ScheduleJobReturnBO> getAllScheduleJobBOs() throws SchedulerException;

    void createScheduleJob(ScheduleJob scheduleJob) throws SchedulerException;

    void updateScheduleJob(ScheduleJob scheduleJob) throws SchedulerException;

    void deleteScheduleJob(Long id) throws SchedulerException;

    void pauseScheduleJob(Long id) throws SchedulerException;

    void resumeScheduleJob(Long id) throws SchedulerException;

    void runOnce(Long id) throws SchedulerException;
}

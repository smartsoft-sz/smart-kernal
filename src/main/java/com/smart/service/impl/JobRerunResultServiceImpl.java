package com.smart.service.impl;

import com.alibaba.fastjson.JSON;
import com.smart.bo.JobParam;
import com.smart.core.AbstractService;
import com.smart.dao.JobRerunResultMapper;
import com.smart.model.Job;
import com.smart.model.JobRerunResult;
import com.smart.service.JobRerunResultService;
import com.smart.service.JobService;
import com.smart.service.job.JobRerunService;
import com.smart.service.util.Constants;
import com.smart.service.util.DateUtil;
import com.smart.service.util.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/27.
 */
@Service
@Transactional
public class JobRerunResultServiceImpl extends AbstractService<JobRerunResult> implements JobRerunResultService {

    private static final Logger logger = LoggerFactory.getLogger(JobRerunResultServiceImpl.class);

    @Resource
    private JobRerunResultMapper tblJobRerunResultMapper;
    @Resource
    private JobService jobService;

    @Override
    public List<JobRerunResult> findAllJobRerunResult() {
        return tblJobRerunResultMapper.findAllJobRerunResult();
    }

    @Override
    public List<JobRerunResult> findByStatus(String status, String jobItemStatus) {
        List<JobRerunResult> list;
        if (Constants.JOB_RERUN_RESULT_STATUS_COMPLETED.equals(status)) {
            list = tblJobRerunResultMapper.findByJobItemStatus(status, jobItemStatus);
        }else {
            list = tblJobRerunResultMapper.findByStatus(status);
        }
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Async
    public void rerunJob(Long jobId, Date start, Date end) {
        LocalDateTime startTime = DateUtil.dateToLocalDateTime(start);
        LocalDateTime endTime = DateUtil.dateToLocalDateTime(end);
        Job job = jobService.findById(jobId);
        if (job != null) {
            Long interval = 0L;
            //根据选择的重跑时间类型不同，重新格式化时间
            switch (job.getUnit()) {
                case "d": {
                    //将当前用户选择的时间格式化成最近的整点时间
                    startTime = DateUtil.getDayStart(startTime);
                    endTime = DateUtil.getDayStart(endTime).plusDays(1).minusSeconds(1);
                    interval = job.getIntervalValue() * 86400;
                    break;
                }
                case "h": {
                    //将当前用户选择的时间格式化成最近的整点时间
                    int startTimeHour = startTime.getHour();
                    Long startTimeDiff = startTimeHour % job.getIntervalValue();
                    startTime = startTime.minusHours(startTimeDiff).withMinute(0).withSecond(0).withNano(0);
                    int endTimeHour = endTime.getHour();
                    Long endTimeDiff = endTimeHour % job.getIntervalValue();
                    endTime = endTime.minusHours(endTimeDiff).withMinute(0).withSecond(0).withNano(0);
                    interval = job.getIntervalValue() * 3600;
                    break;
                }
                case "m": {
                    //将当前用户选择的时间格式化成最近的整点时间
                    int startTimeMinute = startTime.getMinute();
                    Long startTimeDiff = startTimeMinute % job.getIntervalValue();
                    startTime = startTime.minusMinutes(startTimeDiff).withSecond(0).withNano(0);
                    int endTimeMinute = endTime.getMinute();
                    Long endTimeDiff = endTimeMinute % job.getIntervalValue();
                    endTime = endTime.minusMinutes(endTimeDiff).withSecond(0).withNano(0);
                    interval = job.getIntervalValue() * 60;
                    break;
                }
                case "s": {
                    //将当前用户选择的时间格式化成最近的整点时间
                    int startTimeSecond = startTime.getSecond();
                    Long startTimeDiff = startTimeSecond % job.getIntervalValue();
                    startTime = startTime.minusSeconds(startTimeDiff).withNano(0);
                    int endTimeSecond = endTime.getSecond();
                    Long endTimeDiff = endTimeSecond % job.getIntervalValue();
                    endTime = endTime.minusSeconds(endTimeDiff).withNano(0);
                    interval = job.getIntervalValue();
                    break;
                }
                default:
            }

            //重跑之前删除原有数据
            JobRerunService jobRerunService = (JobRerunService) SpringUtils.getBean(job.getBeanName());
            JobParam deleteJobParam = new JobParam();
            deleteJobParam.setStartTime(startTime);
            deleteJobParam.setEndTime(endTime);
            deleteJobParam.setInterval(interval);
            jobRerunService.delete(deleteJobParam);
            //重跑
            try {
                if (interval != 0) {
                    //Job重跑前准备信息
                    JobRerunResult jobRerunResult = new JobRerunResult();
                    jobRerunResult.setJobId(jobId);
                    jobRerunResult.setStartTime(DateUtil.fromLocalDateTime(startTime));
                    jobRerunResult.setEndTime(DateUtil.fromLocalDateTime(endTime));
                    jobRerunResult.setStatus(Constants.JOB_RERUN_RESULT_STATUS_INPROGRESS);
                    save(jobRerunResult);
                    //收集错误信息的集合
                    List<JobParam> jobErrorItemList = new ArrayList<>();
                    do {
                        List<JobRerunResult> jobRerunResults = listInProgressJobByJobId(jobId);
                        JobRerunResult jobRerunResultItem = jobRerunResults.get(jobRerunResults.size() - 1);
                        //重跑每一项的错误记录
                        JobParam jobParam = new JobParam();
                        jobParam.setStartTime(startTime);
                        jobParam.setInterval(interval);
                        try {
                            jobRerunService.process(jobParam);
                            jobRerunResultItem.setJobItemStatus(Constants.JOB_RERUN_RESULT_ITEM_STATUS_SUCCESS);
                            jobRerunResultItem.setRunTime(new Date());
                            updateByPK(jobRerunResultItem);
                        } catch (Exception e) {
                            jobRerunResultItem.setJobItemStatus(Constants.JOB_RERUN_RESULT_ITEM_STATUS_ERROR);
                            //有错误抛出后记录
                            jobErrorItemList.add(jobParam);
                            updateByPK(jobRerunResultItem);
                        }
                        startTime = startTime.plusSeconds(interval);
                    } while (startTime.isBefore(endTime) || startTime.isEqual(endTime));
                    //全部重跑完之后取出最终的一条记录
                    List<JobRerunResult> jobRerunResults = listInProgressJobByJobId(jobId);
                    JobRerunResult jobRerunResult2 = jobRerunResults.get(jobRerunResults.size() - 1);
                    //全部跑完后将状态更新为完成并记录重跑项的错误信息
                    jobRerunResult2.setStatus(Constants.JOB_RERUN_RESULT_STATUS_COMPLETED);
                    if (Constants.JOB_RERUN_RESULT_ITEM_STATUS_ERROR.equals(jobRerunResult2.getJobItemStatus())) {
                        jobRerunResult2.setJobError(JSON.toJSONString(jobErrorItemList));
                    }
                    updateByPK(jobRerunResult2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("some errors occured in job rerun service",e);
            }
        } else {
            logger.error("job is null,jobId : " + jobId);
        }
    }

    private List<JobRerunResult> listInProgressJobByJobId(Long jobId) {
        return this.listByJobIdAndStatus(jobId, Constants.JOB_RUN_RESULT_STATUS_INPROGRESS);
    }

    private List<JobRerunResult> listByJobIdAndStatus(Long jobId, String status) {
        JobRerunResult jobRerunResult = new JobRerunResult();
        jobRerunResult.setJobId(jobId);
        jobRerunResult.setStatus(status);
        return this.find(jobRerunResult);
    }
}

package com.smart.aop;

import com.smart.model.Job;
import com.smart.model.JobRunResult;
import com.smart.service.JobRunResultService;
import com.smart.service.JobService;
import com.smart.service.util.Constants;
import com.smart.service.util.DateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: Jinmeng Tang
 * @Date: Created in 2018/2/8 上午9:34
 */
@Component // 注册到Spring容器，必须加入这个注解
@Aspect // 该注解标示该类为切面类，切面是由通知和切点组成的。
public class JobAspect {

    private static final Logger logger = LoggerFactory.getLogger(JobAspect.class);

    @Resource
    private JobService jobService;
    @Resource
    private JobRunResultService jobRunResultService;

    private Long jobId = 0L;

    /**
     * 定义切点表达式
     */
    @Pointcut("execution(* com.smart.job.*.*.*(..))")
    public void jobPoint() {}

    /**
     * 定义前置通知
     */
    @Before("jobPoint()")
    public void before(JoinPoint joinPoint) {
        logger.info("Job方法执行前通知");
        //通过job的方法名从admin获取当前job的id
        Job job = jobService.findByCode(joinPoint.getSignature().getName());
        if (job != null) {
            jobId = job.getId();
            JobRunResult jobRunResult = new JobRunResult();
            jobRunResult.setJobId(jobId);
            jobRunResult.setStartTime(LocalDateTime.now());
            jobRunResult.setStatus(Constants.JOB_RUN_RESULT_STATUS_INPROGRESS);
            jobRunResultService.save(jobRunResult);
            logger.info("保存成功");
        }else {
            logger.info("error occurred when job before");
        }
    }

    @AfterReturning("jobPoint()")
    public void afterReturning(JoinPoint joinPoint) {
        logger.info("Job方法执行后通知");
        List<JobRunResult> jobRunResultList = jobRunResultService.listInprogressResultByJobId(jobId);
        if (jobRunResultList != null && jobRunResultList.size() != 0) {
            JobRunResult jobRunResult = jobRunResultList.get(jobRunResultList.size() - 1);
            if (jobRunResult != null) {
                jobRunResult.setEndTime(LocalDateTime.now());
                LocalDateTime startTime = jobRunResult.getStartTime();
                LocalDateTime endTime = jobRunResult.getEndTime();
                jobRunResult.setRunTime(Math.abs(Double.valueOf(Double.valueOf(Duration.between(startTime, endTime).toMillis()) / 1000)));
                jobRunResult.setStatus(Constants.JOB_RUN_RESULT_STATUS_SUCCESS);
                jobRunResultService.updateByPK(jobRunResult);
                logger.info("更新成功");
            }else {
                logger.info("error occurred when job after returning");
            }
        }else {
            logger.info("error occurred when job after returning");
        }
    }

    @AfterThrowing(throwing="e",pointcut="jobPoint()")
    public void afterThrowing(Throwable e) {
        logger.info("Job方法出错后通知");
        List<JobRunResult> jobRunResultList = jobRunResultService.listInprogressResultByJobId(jobId);
        if (jobRunResultList != null && jobRunResultList.size() != 0) {
            JobRunResult jobRunResult = jobRunResultList.get(jobRunResultList.size() - 1);
            if (jobRunResult != null) {
                jobRunResult.setEndTime(LocalDateTime.now());
                LocalDateTime startTime = jobRunResult.getStartTime();
                LocalDateTime endTime = jobRunResult.getEndTime();
                jobRunResult.setRunTime(Math.abs(Double.valueOf(Double.valueOf(Duration.between(startTime, endTime).toMillis()) / 1000)));
                jobRunResult.setJobError(e.toString());
                jobRunResult.setStatus(Constants.JOB_RUN_RESULT_STATUS_FAILED);
                jobRunResultService.updateByPK(jobRunResult);
            }else {
                logger.info("error occurred when job after throwing");
            }
        }else {
            logger.info("error occurred when job after throwing");
        }
    }
}

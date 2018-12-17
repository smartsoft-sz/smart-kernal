package com.smart.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tbl_job_rerun_result")
public class JobRerunResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_id")
    private Long jobId;

    /**
     * job的开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * job的结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 记录目前跑完的那条记录的结束时间
     */
    @Column(name = "run_time")
    private Date runTime;

    /**
     * 两种状态INPROGRESS, COMPLETED
     */
    private String status;

    /**
     * 两种状态SUCCESS，ERROR
     */
    @Column(name = "job_item_status")
    private String jobItemStatus;

    /**
     * 每个Item的Exception记录
     */
    @Column(name = "job_error")
    private String jobError;

    @Transient
    private Job job;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return job_id
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * @param jobId
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 获取job的开始时间
     *
     * @return start_time - job的开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置job的开始时间
     *
     * @param startTime job的开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取job的结束时间
     *
     * @return end_time - job的结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置job的结束时间
     *
     * @param endTime job的结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取记录目前跑完的那条记录的结束时间
     *
     * @return run_time - 记录目前跑完的那条记录的结束时间
     */
    public Date getRunTime() {
        return runTime;
    }

    /**
     * 设置记录目前跑完的那条记录的结束时间
     *
     * @param runTime 记录目前跑完的那条记录的结束时间
     */
    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }

    /**
     * 获取两种状态INPROGRESS, COMPLETED
     *
     * @return status - 两种状态INPROGRESS, COMPLETED
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置两种状态INPROGRESS, COMPLETED
     *
     * @param status 两种状态INPROGRESS, COMPLETED
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取两种状态SUCCESS，ERROR
     *
     * @return job_item_status - 两种状态SUCCESS，ERROR
     */
    public String getJobItemStatus() {
        return jobItemStatus;
    }

    /**
     * 设置两种状态SUCCESS，ERROR
     *
     * @param jobItemStatus 两种状态SUCCESS，ERROR
     */
    public void setJobItemStatus(String jobItemStatus) {
        this.jobItemStatus = jobItemStatus;
    }

    /**
     * 获取每个Item的Exception记录
     *
     * @return job_error - 每个Item的Exception记录
     */
    public String getJobError() {
        return jobError;
    }

    /**
     * 设置每个Item的Exception记录
     *
     * @param jobError 每个Item的Exception记录
     */
    public void setJobError(String jobError) {
        this.jobError = jobError;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
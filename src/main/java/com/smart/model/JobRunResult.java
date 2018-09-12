package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tbl_job_run_result")
public class JobRunResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_id")
    private Long jobId;

    /**
     * job的开始时间
     */
    @Column(name = "start_time")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime startTime;

    /**
     * job的结束时间
     */
    @Column(name = "end_time")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime endTime;

    /**
     * 本次job运行的总时间(单位：s)
     */
    @Column(name = "run_time")
    private Double runTime;

    /**
     * 三种状态INPROGRESS, SUCCESS, FAILED
     */
    private String status;

    /**
     * Exception记录
     */
    @Column(name = "job_error")
    private String jobError;

    @Transient
    private ScheduleJob scheduleJob;

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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取本次job运行的总时间(单位：s)
     *
     * @return run_time - 本次job运行的总时间(单位：s)
     */
    public Double getRunTime() {
        return runTime;
    }

    /**
     * 设置本次job运行的总时间(单位：s)
     *
     * @param runTime 本次job运行的总时间(单位：s)
     */
    public void setRunTime(Double runTime) {
        this.runTime = runTime;
    }

    /**
     * 获取三种状态INPROGRESS, SUCCESS, FAILED
     *
     * @return status - 三种状态INPROGRESS, SUCCESS, FAILED
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置三种状态INPROGRESS, SUCCESS, FAILED
     *
     * @param status 三种状态INPROGRESS, SUCCESS, FAILED
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取Exception记录
     *
     * @return job_error - Exception记录
     */
    public String getJobError() {
        return jobError;
    }

    /**
     * 设置Exception记录
     *
     * @param jobError Exception记录
     */
    public void setJobError(String jobError) {
        this.jobError = jobError;
    }

    public ScheduleJob getScheduleJob() {
        return scheduleJob;
    }

    public void setScheduleJob(ScheduleJob scheduleJob) {
        this.scheduleJob = scheduleJob;
    }
}
package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_schedule_job")
public class ScheduleJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_group")
    private String jobGroup;

    @Column(name = "cron_expression")
    private String cronExpression;

    @Column(name = "start_time")
    private Date startTime;

    private String description;

    @Column(name = "bean_class")
    private String beanClass;

    @Column(name = "is_concurrent")
    private Boolean isConcurrent;

    @Column(name = "spring_id")
    private String springId;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "manual_fire_time")
    private Date manualFireTime;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime createdDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime lastModifiedDate;

    private Integer version;

    @Transient
    private String jobStatus;

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

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
     * @return job_name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return job_group
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * @param jobGroup
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * @return cron_expression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * @param cronExpression
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return bean_class
     */
    public String getBeanClass() {
        return beanClass;
    }

    /**
     * @param beanClass
     */
    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * @return is_concurrent
     */
    public Boolean getIsConcurrent() {
        return isConcurrent;
    }

    /**
     * @param isConcurrent
     */
    public void setIsConcurrent(Boolean isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * @return spring_id
     */
    public String getSpringId() {
        return springId;
    }

    /**
     * @param springId
     */
    public void setSpringId(String springId) {
        this.springId = springId;
    }

    /**
     * @return method_name
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * @return manual_fire_time
     */
    public Date getManualFireTime() {
        return manualFireTime;
    }

    /**
     * @param manualFireTime
     */
    public void setManualFireTime(Date manualFireTime) {
        this.manualFireTime = manualFireTime;
    }

    /**
     * @return created_by
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return last_modified_by
     */
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Boolean getConcurrent() {
        return isConcurrent;
    }

    public void setConcurrent(Boolean concurrent) {
        isConcurrent = concurrent;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
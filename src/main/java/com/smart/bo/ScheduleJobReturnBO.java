package com.smart.bo;

import java.util.Date;

public class ScheduleJobReturnBO {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5492729408304257068L;

	private Long id;

    private String jobName;

    private String jobGroup;

    private String jobStatus;
    
    private String jobStatusDesc;

    private String cronExpression;

    private String description;

    private String beanClass;

    private Boolean isConcurrent;
    
    private Boolean isRequestsRecovery;
    private Boolean isDurable;
    private Boolean isUpdateData;

    private String springId;

    private String methodName;

    private String createdBy;

    private Date createdDt;

    private String lastUpdatedBy;

    private Date lastUpdatedDt;

    private Integer version;
    
    private Date nextFireTime;
    
    private Date startTime;
    
    private Date previousFireTime;
    
    private String previousFireType;
    
    public String getPreviousFireType() {
		return previousFireType;
	}

	public void setPreviousFireType(String previousFireType) {
		this.previousFireType = previousFireType;
	}

	public String getJobStatusDesc() {
		return jobStatusDesc;
	}

	public void setJobStatusDesc(String jobStatusDesc) {
		this.jobStatusDesc = jobStatusDesc;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getNextFireTime() {
		return nextFireTime;
	}

	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public Date getPreviousFireTime() {
		return previousFireTime;
	}

	public void setPreviousFireTime(Date previousFireTime) {
		this.previousFireTime = previousFireTime;
	}
	
	public Boolean getIsRequestsRecovery() {
		return isRequestsRecovery;
	}

	public void setIsRequestsRecovery(Boolean isRequestsRecovery) {
		this.isRequestsRecovery = isRequestsRecovery;
	}
	
	public Boolean getIsDurable() {
		return isDurable;
	}

	public void setIsDurable(Boolean isDurable) {
		this.isDurable = isDurable;
	}

	public Boolean getIsUpdateData() {
		return isUpdateData;
	}

	public void setIsUpdateData(Boolean isUpdateData) {
		this.isUpdateData = isUpdateData;
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
     * @return job_status
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * @param jobStatus
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
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
     * @return created_by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return created_dt
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * @param createdDt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * @return last_updated_by
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return last_updated_dt
     */
    public Date getLastUpdatedDt() {
        return lastUpdatedDt;
    }

    /**
     * @param lastUpdatedDt
     */
    public void setLastUpdatedDt(Date lastUpdatedDt) {
        this.lastUpdatedDt = lastUpdatedDt;
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
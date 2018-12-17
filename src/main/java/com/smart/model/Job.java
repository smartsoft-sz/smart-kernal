package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "tbl_job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * job名称
     */
    private String name;

    /**
     * job名称代码（方法名）
     */
    private String code;

    /**
     * job描述
     */
    private String description;

    /**
     * job执行间隔值
     */
    @Column(name = "interval_value")
    private Long intervalValue;

    /**
     * 单位
     */
    private String unit;

    /**
     * 该job所对应的Service
     */
    @Column(name = "bean_name")
    private String beanName;

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
     * 获取job名称
     *
     * @return name - job名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置job名称
     *
     * @param name job名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取job名称代码（方法名）
     *
     * @return code - job名称代码（方法名）
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置job名称代码（方法名）
     *
     * @param code job名称代码（方法名）
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取job描述
     *
     * @return description - job描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置job描述
     *
     * @param description job描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取job执行间隔值
     *
     * @return interval_value - job执行间隔值
     */
    public Long getIntervalValue() {
        return intervalValue;
    }

    /**
     * 设置job执行间隔值
     *
     * @param intervalValue job执行间隔值
     */
    public void setIntervalValue(Long intervalValue) {
        this.intervalValue = intervalValue;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取该job所对应的Service
     *
     * @return bean_name - 该job所对应的Service
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * 设置该job所对应的Service
     *
     * @param beanName 该job所对应的Service
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;
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
     * @return created_date
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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

    /**
     * @return last_modified_date
     */
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
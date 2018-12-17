package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "tbl_sms_verify")
public class SmsVerify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "last_modified_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime lastModifiedDate;

    private Integer version;

    private String mobile;

    @Column(name = "verify_code")
    private String verifyCode;

    @Column(name = "verify_time")
    private Date verifyTime;

    @Column(name = "expiry_time")
    private Date expiryTime;

    @Column(name = "verify_count")
    private Integer verifyCount;

    private Integer status;

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

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return verify_code
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * @param verifyCode
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    /**
     * @return verify_time
     */
    public Date getVerifyTime() {
        return verifyTime;
    }

    /**
     * @param verifyTime
     */
    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    /**
     * @return expery_time
     */
    public Date getExpiryTime() {
        return expiryTime;
    }

    /**
     * @param expiryTime
     */
    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    /**
     * @return max_verify_times
     */
    public Integer getVerifyCount() {
        return verifyCount;
    }

    /**
     * @param verifyCount
     */
    public void setVerifyCount(Integer verifyCount) {
        this.verifyCount = verifyCount;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
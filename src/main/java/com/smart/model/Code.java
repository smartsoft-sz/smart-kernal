package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import java.time.LocalDateTime;
import javax.persistence.*;

@Table(name = "tbl_code")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private Long createdBy;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    private Integer version;

    private String code;

    private String name;

    @Column(name = "seq_num")
    private Integer seqNum;

    private String description;

    @Column(name = "code_group_code")
    private String codeGroupCode;

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

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return seq_num
     */
    public Integer getSeqNum() {
        return seqNum;
    }

    /**
     * @param seqNum
     */
    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
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
     * @return code_group_code
     */
    public String getCodeGroupCode() {
        return codeGroupCode;
    }

    /**
     * @param codeGroupCode
     */
    public void setCodeGroupCode(String codeGroupCode) {
        this.codeGroupCode = codeGroupCode;
    }
}
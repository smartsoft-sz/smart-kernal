package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "tbl_email_template")
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_id")
    private String templateId;

    private String description;

    private String parameter;

    @Column(name = "template_subject")
    private String templateSubject;

    @Column(name = "template_from")
    private String templateFrom;

    @Column(name = "template_from_name")
    private String templateFromName;

    @Column(name = "template_to")
    private String templateTo;

    @Column(name = "template_cc")
    private String templateCc;

    @Column(name = "template_bcc")
    private String templateBcc;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private Long createdBy;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    private Integer version;

    private String content;

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
     * @return template_id
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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
     * @return parameter
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * @param parameter
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    /**
     * @return template_subject
     */
    public String getTemplateSubject() {
        return templateSubject;
    }

    /**
     * @param templateSubject
     */
    public void setTemplateSubject(String templateSubject) {
        this.templateSubject = templateSubject;
    }

    /**
     * @return template_from
     */
    public String getTemplateFrom() {
        return templateFrom;
    }

    /**
     * @param templateFrom
     */
    public void setTemplateFrom(String templateFrom) {
        this.templateFrom = templateFrom;
    }

    /**
     * @return template_from_name
     */
    public String getTemplateFromName() {
        return templateFromName;
    }

    /**
     * @param templateFromName
     */
    public void setTemplateFromName(String templateFromName) {
        this.templateFromName = templateFromName;
    }

    /**
     * @return template_to
     */
    public String getTemplateTo() {
        return templateTo;
    }

    /**
     * @param templateTo
     */
    public void setTemplateTo(String templateTo) {
        this.templateTo = templateTo;
    }

    /**
     * @return template_cc
     */
    public String getTemplateCc() {
        return templateCc;
    }

    /**
     * @param templateCc
     */
    public void setTemplateCc(String templateCc) {
        this.templateCc = templateCc;
    }

    /**
     * @return template_bcc
     */
    public String getTemplateBcc() {
        return templateBcc;
    }

    /**
     * @param templateBcc
     */
    public void setTemplateBcc(String templateBcc) {
        this.templateBcc = templateBcc;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tbl_email_config")
public class EmailConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String host;

    private String port;

    private String protocol;

    private String parameter;

    private String username;

    private String password;

    private String encoding;

    @Column(name = "email_from")
    private String emailFrom;

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
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @param protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @param encoding
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * @return email_from
     */
    public String getEmailFrom() {
        return emailFrom;
    }

    /**
     * @param emailFrom
     */
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
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
}
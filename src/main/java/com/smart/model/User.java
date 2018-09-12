package com.smart.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smart.util.JsonDateDeserializer;
import com.smart.util.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mobile;

    /**
     * 默认为员工的工号
     */
    @Column(name = "login_name")
    private String loginName;

    private String name;

    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    private String status;

    private String password;

    /**
     * 0: 平台用户，1:公司用户
     */
    private String type;

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

    @Transient
    private List<Role> roles;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Transient
    private Role role;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Transient
    private UserRole userRole;


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
     * 获取默认为员工的工号
     *
     * @return login_name - 默认为员工的工号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置默认为员工的工号
     *
     * @param loginName 默认为员工的工号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return image_url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
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
     * 获取0: 平台用户，1:公司用户
     *
     * @return type - 0: 平台用户，1:公司用户
     */
    public String getType() {
        return type;
    }

    /**
     * 设置0: 平台用户，1:公司用户
     *
     * @param type 0: 平台用户，1:公司用户
     */
    public void setType(String type) {
        this.type = type;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", loginName='" + loginName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", version=" + version +
                '}';
    }
}
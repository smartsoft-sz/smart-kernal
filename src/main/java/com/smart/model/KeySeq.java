package com.smart.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tbl_key_seq")
public class KeySeq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 需要维护的key名称
     */
    @Column(name = "key_name")
    private String keyName;

    /**
     * 当前编号
     */
    @Column(name = "cur_key")
    private Long curKey;

    /**
     * 记录创建时间
     */
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    /**
     * 数据编号更新时间
     */
    @Column(name = "last_modified_date")
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
     * 获取需要维护的key名称
     *
     * @return key_name - 需要维护的key名称
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * 设置需要维护的key名称
     *
     * @param keyName 需要维护的key名称
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * 获取当前编号
     *
     * @return cur_key - 当前编号
     */
    public Long getCurKey() {
        return curKey;
    }

    /**
     * 设置当前编号
     *
     * @param curKey 当前编号
     */
    public void setCurKey(Long curKey) {
        this.curKey = curKey;
    }

    /**
     * 获取记录创建时间
     *
     * @return created_date - 记录创建时间
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置记录创建时间
     *
     * @param createdDate 记录创建时间
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取数据编号更新时间
     *
     * @return last_modified_date - 数据编号更新时间
     */
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * 设置数据编号更新时间
     *
     * @param lastModifiedDate 数据编号更新时间
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
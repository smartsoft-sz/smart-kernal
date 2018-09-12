package com.smart.core;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface  Service<T> {
    Long save(T model);//持久化
    int save(List<T> models);//批量持久化
    void deleteByPK(Long id);//通过主鍵刪除
    int updateByPK(T model);//更新
    int updateByPKSelective(T model);
    T findById(Long id);//通过ID查找
    List<T> findAll();//获取所有
    int count(T entity);
    T findOne(T entity);
    List<T> find(T entity);
}

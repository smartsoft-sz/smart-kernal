package com.smart.service;

import com.smart.model.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

//暂时集中放缓存方法，千万注意别嵌套调用
public interface CacheService {

    // 读取所有code数据，来自tbl_code
    HashMap<String, LinkedHashMap<String, Code>> getAllCodes();

    void refreshCache(String key);

}
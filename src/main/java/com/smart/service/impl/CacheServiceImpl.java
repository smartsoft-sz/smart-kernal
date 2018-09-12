package com.smart.service.impl;

import com.smart.model.*;
import com.smart.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

//开放的API来自codeservice, 而cacheservice只是为了集中存放以及让AOP生效，切记不可内部调用该类所有方法
//如果缓存不存在， cacheservice还是会从codeservice里读取数据，
//所以千万注意别嵌套调用,
@Service
@EnableCaching
public class CacheServiceImpl implements CacheService {

    @Resource
    private CodeService codeService;

    @Resource
    CacheManager cacheManager;

    private final Logger log = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Override
    @Cacheable(value="generalCache", key = "#root.methodName")
    public HashMap<String, LinkedHashMap<String, Code>> getAllCodes() {
        List<Code> codes = codeService.findAll();
        codes = codes.stream().sorted(Comparator.comparing(Code::getSeqNum)).collect(Collectors.toList());

        HashMap<String, LinkedHashMap<String, Code>> codeMap = new HashMap<>();
        LinkedHashMap<String, Code> codeSubMap = new LinkedHashMap<>();
        for (Code code : codes) {
            if (codeMap.containsKey(code.getCodeGroupCode())) {
                continue;
            } else {
                codeSubMap = new LinkedHashMap<>();
                codeMap.put(code.getCodeGroupCode(), codeSubMap);
            }

            for (Code codei : codes) {
                if (code.getCodeGroupCode().equals(codei.getCodeGroupCode())) {
                    codeSubMap.put(codei.getCode(), codei);
                }
            }
        }
        return codeMap;
    }


    @Override
    public void refreshCache(String key) {
        cacheManager.getCache("generalCache").evict(key);
        log.info("Cache key [" + key + "] cleared");
    }

}
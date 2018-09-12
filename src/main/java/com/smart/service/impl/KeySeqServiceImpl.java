package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.dao.KeySeqMapper;
import com.smart.model.KeySeq;
import com.smart.service.KeySeqService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/01/27.
 */
@Service
@Transactional
public class KeySeqServiceImpl extends AbstractService<KeySeq> implements KeySeqService {
    @Resource
    private KeySeqMapper tblKeySeqMapper;

    @Override
    public void resetSeq() {
        this.tblKeySeqMapper.resetSeq();
    }

    @Override
    public KeySeq findByKeyName(String keyName) {
        KeySeq keySeq = new KeySeq();
        keySeq.setKeyName(keyName);
        return this.findOne(keySeq);
    }
}

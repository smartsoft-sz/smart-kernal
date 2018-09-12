package com.smart.service;

import com.smart.core.Service;
import com.smart.model.KeySeq;

/**
 * Created by CodeGenerator on 2018/01/27.
 */
public interface KeySeqService extends Service<KeySeq> {

    void resetSeq();

    KeySeq findByKeyName(String keyName);

}

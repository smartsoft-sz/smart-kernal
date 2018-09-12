package com.smart.service.util;

import com.smart.core.AbstractKeySeq;
import com.smart.model.KeySeq;
import com.smart.service.KeySeqService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class KeySequenceManager extends AbstractKeySeq {


    private final KeySeqService keySeqService;

    public KeySequenceManager(KeySeqService keySeqService){
        this.keySeqService = keySeqService;
    }

    public String generateBatchNum(){
        long currentKey = super.generateKey(Constants.KEY_SEQ_NAME_BATCH);
        String currentDateStr = DateFormatUtils.format(new Date(), "yyyyMMdd");

        return currentDateStr + StringUtils.leftPad(currentKey+"", 10, '0');
    }

    @Override
    public Long initStartNum(String keyName) {
        KeySeq keySeq = this.keySeqService.findByKeyName(keyName);
        return keySeq.getCurKey();
    }

    @Override
    public void updateStartNum(String keyName, long intervalMax) {
        KeySeq keySeq = this.keySeqService.findByKeyName(keyName);
        keySeq.setCurKey(intervalMax);
        this.keySeqService.updateByPK(keySeq);
    }
}

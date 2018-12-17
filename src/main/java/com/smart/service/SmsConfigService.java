package com.smart.service;


import com.smart.core.Service;
import com.smart.model.SmsConfig;

/**
 * Created by CodeGenerator on 2018/03/29.
 */
public interface SmsConfigService extends Service<SmsConfig> {
    SmsConfig getSmsConfig()throws Exception;

    void sendSMS(Integer smsType, String content, String mobile) throws Exception;

}

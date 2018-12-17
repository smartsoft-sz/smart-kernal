package com.smart.service;


import com.smart.core.Service;
import com.smart.model.SmsVerify;

/**
 * Created by CodeGenerator on 2017/12/14.
 */
public interface SmsVerifyService extends Service<SmsVerify> {

    SmsVerify findByMobile(String mobile);

    SmsVerify findByMobileAndVerifyCode(String mobile, String verifyCode);

    void checkVerifyCode(String mobile, String verifyCode);
}

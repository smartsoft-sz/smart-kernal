package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.core.ResultCode;
import com.smart.core.ServiceException;
import com.smart.dao.SmsVerifyMapper;
import com.smart.model.SmsVerify;
import com.smart.service.SmsVerifyService;
import com.smart.service.util.Constants;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by CodeGenerator on 2017/12/14.
 */
@Service
@Transactional
public class SmsVerifyServiceImpl extends AbstractService<SmsVerify> implements SmsVerifyService {

    private final Logger log = LoggerFactory.getLogger(SmsVerifyServiceImpl.class);

    @Resource
    private SmsVerifyMapper tblSmsVerifyMapper;

    @Override
    public SmsVerify findByMobile(String mobile) {
        SmsVerify smsVerify = new SmsVerify();
        smsVerify.setMobile(mobile);
        return this.findOne(smsVerify);
    }

    @Override
    public SmsVerify findByMobileAndVerifyCode(String mobile, String verifyCode) {
        SmsVerify smsVerify = new SmsVerify();
        smsVerify.setMobile(mobile);
        smsVerify.setVerifyCode(verifyCode);
        return this.findOne(smsVerify);
    }


    /**
     * 1. 检查mobile是否存在， 不存在返回 -1， 验证码不存在
     * 2. check status == 0, 验证码已被使用
     * 3. expiryTime before current time , 验证码已过期
     *
     * @param mobile
     * @param verifyCode
     * @return
     */
    @Override
    public void checkVerifyCode(String mobile, String verifyCode) {
        SmsVerify smsVerify = this.findByMobileAndVerifyCode(mobile, verifyCode);
        if (smsVerify == null) {
            // 手机号或者验证码不存在
            throw new ServiceException(ResultCode.VERIFY_CODE_ERROR);
        } else {
            if (smsVerify.getStatus() == Constants.NormalStatusInt.INACTIVE) {
                 // 验证码已被使用
                throw new ServiceException(ResultCode.VERIFY_CODE_USED);
            }
            if (smsVerify.getExpiryTime().before(new Date())) {
                // 验证码已过期
                throw new ServiceException(ResultCode.VERIFY_CODE_EXPIRED);
            }
        }
        smsVerify.setVerifyTime(new Date());
        smsVerify.setStatus(Constants.NormalStatusInt.INACTIVE);
        super.updateByPK(smsVerify);
    }



}

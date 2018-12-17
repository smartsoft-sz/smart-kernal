package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.dao.SmsConfigMapper;
import com.smart.model.SmsConfig;
import com.smart.service.SmsConfigService;
import com.smart.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;


/**
 * Created by CodeGenerator on 2018/03/29.
 */
@Service
@Transactional
public class SmsConfigServiceImpl extends AbstractService<SmsConfig> implements SmsConfigService {
    @Resource
    private SmsConfigMapper tblSmsConfigMapper;
    @Resource
    private UserService userService;

    @Value("${account.smspaas.useraccount:}")
    private String account;

    @Value("${account.smspaas.userpassword:}")
    private String password;

    @Value("${account.smspaas.signName:}")
    private String signName;

    @Override
    public SmsConfig getSmsConfig()throws Exception{
        SmsConfig smsConfig = this.findOne(new SmsConfig());
        return smsConfig;
    }

    @Override
    public void sendSMS(Integer smsType, String content, String mobile) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://api.ucpaas.com/sms-partner/access/" + account + "/sendsms";
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Accept", "application/json");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        String encrypt = new BigInteger(1, md.digest()).toString(16);
        LocalDateTime curTime = LocalDateTime.now();
        String body = "{\"clientid\":\"" +account+ "\",\"password\":\""+ encrypt +"\",\"mobile\":\""+ mobile +"\",\"smstype\":\""+ smsType +"\",\"content\":\"【" + signName + "】" + content + "\",\"sendtime\":\"" + curTime + "\",\"extend\":\"00\",\"uid\":\"00\"}";
        httpPost.setEntity(new StringEntity(body, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String responseContent = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseContent);
        response.close();
        httpClient.close();
    }



}

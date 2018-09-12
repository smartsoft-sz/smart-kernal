package com.smart.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsSendUtil {
    private static final Logger log = LoggerFactory.getLogger(SmsSendUtil.class);

    public static void sendRegisterSms(String code, String mobile) {

        try {
//            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "xxx_LTAI27oR6zqe4Taz", "MjoJxoq4X13qFXSs6yMWKZoaNfRCQh");
//            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms",  "sms.aliyuncs.com");
//            IAcsClient client = new DefaultAcsClient(profile);
//            SingleSendSmsRequest request = new SingleSendSmsRequest();
//            request.setSignName("黑洞网络xxx");//控制台创建的签名名称
//            request.setTemplateCode("SMS_54280007_xxx");//控制台创建的模板CODE
//            request.setParamString("{\"code\":\""+ code +"\",\"product\":\"智软科创\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
//            //request.setParamString("{}");
//            request.setRecNum(mobile);//接收号码
//            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        } catch (Exception e) {
            log.error("sms send faild to " + mobile, e);
        }
    }


    public static void sendMessage(String code, String mobile) {

        try {
//            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "xxx_LTAI27oR6zqe4Taz", "MjoJxoq4X13qFXSs6yMWKZoaNfRCQh");
//            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms",  "sms.aliyuncs.com");
//            IAcsClient client = new DefaultAcsClient(profile);
//            SingleSendSmsRequest request = new SingleSendSmsRequest();
//            request.setSignName("黑洞网络xxx");//控制台创建的签名名称
//            request.setTemplateCode("SMS_54280007_xxx");//控制台创建的模板CODE
//            request.setParamString("{\"code\":\""+ code +"\",\"product\":\"智软科创\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
//            //request.setParamString("{}");
//            request.setRecNum(mobile);//接收号码
//            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        } catch (Exception e) {
            log.error("sms send faild to " + mobile, e);
        }
    }


    public static void main(String[] args) {
        sendRegisterSms("1234", "18551178731");
    }
}

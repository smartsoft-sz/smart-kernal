package com.smart.service;

import com.smart.model.Email;
import com.smart.model.EmailConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

@Component("mailService")
public class MailService {
    @Resource
    private EmailConfigService emailConfigService;

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    public void sendMail(Email email) throws MessagingException {

        //从tbl_mail_config里拿配置
        List<EmailConfig> emailConfigList = emailConfigService.findAll();
        EmailConfig emailConfig = emailConfigList.get(0);
        //mail from address must be same as authorization user
        email.setFrom(emailConfig.getUsername());
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());
        //加认证机制
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.transport.protocol", emailConfig.getProtocol());// 连接协议
        javaMailProperties.put("mail.smtp.host", emailConfig.getHost());// 主机名
        javaMailProperties.put("mail.smtp.port", Integer.parseInt(emailConfig.getPort()));// 端口号
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.timeout", 5000);
        javaMailProperties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用
        javaMailProperties.put("mail.debug", "false");//设置是否显示debug信息  true 会在控制台显示相关信息
        mailSender.setJavaMailProperties(javaMailProperties);
        mailSender.setSession(Session.getInstance(javaMailProperties));

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, email.getEmailEncoding());
        String ss[] = email.getTo().toArray(new String[email.getTo().size()]);
        message.setTo(email.getTo().toArray(new String[email.getTo().size()]));
        if (email.getCc()!=null) {
            message.setCc((String[])email.getCc().toArray(new String[email.getCc().size()]));
        }
        if (email.getBcc()!=null) {
            message.setBcc((String[])email.getBcc().toArray(new String[email.getBcc().size()]));
        }
        String mailFrom = email.getFrom();
        if (StringUtils.isNotEmpty(email.getFromName())) {
            try {
                mailFrom = javax.mail.internet.MimeUtility.encodeText(email.getFromName())+" <"+email.getFrom()+">";
            } catch (UnsupportedEncodingException e) {
                log.error("error occured when send mail",e);
            }
        }
        message.setFrom(new InternetAddress(mailFrom));
        message.setSubject(email.getSubject());
        message.setText(email.getContent(), true);
        mailSender.send(mimeMessage);
    }
}

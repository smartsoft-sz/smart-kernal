package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.dao.EmailConfigMapper;
import com.smart.model.Email;
import com.smart.model.EmailConfig;
import com.smart.model.EmailTemplate;
import com.smart.service.EmailConfigService;
import com.smart.service.EmailTemplateService;
import com.smart.service.MailService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/05/18.
 */
@Service
@Transactional
public class EmailConfigServiceImpl extends AbstractService<EmailConfig> implements EmailConfigService {
    @Resource
    private EmailConfigMapper tblEmailConfigMapper;
    @Resource
    private EmailTemplateService emailTemplateService;
    @Resource
    private MailService mailService;

    //templateId
    private final String TEMPLATE_TEST_EMAIL = "TEMPLATE_TEST_EMAIL";
    private final String TEMPLATE_CUBALERT_LONGTIMEUNLOCK = "TEMPLATE_CUBALERT_LONGTIMEUNLOCK";
    private final String TEMPLATE_CUBALERT_USELIMIT = "TEMPLATE_CUBALERT_USELIMIT";
    private final String TEMPLATE_CUBALERT_NETSTATUS = "TEMPLATE_CUBALERT_NETSTATUS";

    @Override
    public EmailTemplate findByTemplateId(String templateId){
        EmailTemplate emailTemplate = emailTemplateService.findByTemplateId(templateId);
        return  emailTemplate;
    }
    @Override
    public void sendEmailNotification(String templateId, Map<String, String> parameters, List<String> toList, List<String> ccList, List<String> bccList){
        if(toList == null){
            toList = new ArrayList<>();
        }
        ccList = new ArrayList<>();
        bccList = new ArrayList<>();
        Email emails = new Email();
        Configuration cfg = new Configuration();
        cfg.setNumberFormat("0.##");
        cfg.setClassicCompatible(true);
        EmailTemplate emailTemplate = emailTemplateService.findByTemplateId(templateId);
        if(emailTemplate.getTemplateTo() !=null && emailTemplate.getTemplateTo() != ""){
            String[] tos = emailTemplate.getTemplateTo().trim().split(";");
            for(int i=0; i< tos.length; i++ ){
                String s = tos[i];
                toList.add(tos[i]);
            }
        }
        emails.setTo(toList);
        if(emailTemplate.getTemplateCc() != null && emailTemplate.getTemplateCc() != ""){
            String[] ccs = emailTemplate.getTemplateCc().trim().split(";");
            for(int i=0; i< ccs.length; i++ ){
                ccList.add(ccs[i]);
            }
        }
        emails.setCc(ccList);
        if(emailTemplate.getTemplateBcc() != null && emailTemplate.getTemplateBcc() != ""){
            String[] bccs = emailTemplate.getTemplateBcc().trim().split(";");
            for(int i=0; i< bccs.length; i++ ){
                bccList.add(bccs[i]);
            }
        }
        emails.setBcc(bccList);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        String stringContent = new String(emailTemplate.getContent());
        stringLoader.putTemplate("emailTemplate",stringContent);
        cfg.setTemplateLoader(stringLoader);
        String content = "";
        try{
            Template template = cfg.getTemplate("emailTemplate");
            content = FreeMarkerTemplateUtils.processTemplateIntoString(template, parameters);
            emails.setContent(content);
            emails.setFromName(emailTemplate.getTemplateFromName());
            emails.setSubject(emailTemplate.getTemplateSubject());
            mailService.sendMail(emails);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void sendTestEmail(String emailAdd, String parameter){
        try{
            Map<String , String> parameters = new HashMap<>();
            parameters.put("username",parameter);
            List<String> toList = new ArrayList<>();
            toList.add(emailAdd);
            this.sendEmailNotification(TEMPLATE_TEST_EMAIL, parameters, toList, null, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

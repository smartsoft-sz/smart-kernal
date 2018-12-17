package com.smart.service;


import com.smart.core.Service;
import com.smart.model.EmailConfig;
import com.smart.model.EmailTemplate;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/05/18.
 */
public interface EmailConfigService extends Service<EmailConfig> {
    EmailTemplate findByTemplateId(String templateId);

    void sendEmailNotification(String templateId, Map<String, String> parameters, List<String> toList, List<String> ccList, List<String> bccList);

    void sendTestEmail(String emailAdd, String parameter);

}

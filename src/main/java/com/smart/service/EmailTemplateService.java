package com.smart.service;


import com.smart.core.Service;
import com.smart.model.EmailTemplate;

/**
 * Created by CodeGenerator on 2018/05/18.
 */
public interface EmailTemplateService extends Service<EmailTemplate> {

    EmailTemplate findByTemplateId(String templateId);
}

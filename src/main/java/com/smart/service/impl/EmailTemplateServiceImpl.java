package com.smart.service.impl;

import com.smart.core.AbstractService;
import com.smart.dao.EmailTemplateMapper;
import com.smart.model.EmailTemplate;
import com.smart.service.EmailTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/05/18.
 */
@Service
@Transactional
public class EmailTemplateServiceImpl extends AbstractService<EmailTemplate> implements EmailTemplateService {
    @Resource
    private EmailTemplateMapper tblEmailTemplateMapper;

    @Override
    public EmailTemplate findByTemplateId(String templateId){
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setTemplateId(templateId);
        return tblEmailTemplateMapper.selectOne(emailTemplate);
    }

}

package com.smart.dao;

import com.smart.core.Mapper;
import com.smart.model.EmailTemplate;
import org.apache.ibatis.annotations.Param;

public interface EmailTemplateMapper extends Mapper<EmailTemplate> {

    EmailTemplate findByTemplateId(@Param("templateId") String templateId);
}
package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.EmailTemplate;
import com.smart.service.EmailTemplateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/05/18.
*/
@RestController
@RequestMapping("/emailTemplate")
public class EmailTemplateController {
    @Resource
    private EmailTemplateService emailTemplateService;

    @PostMapping
    public Result add(@Validated @RequestBody EmailTemplate emailTemplate) {
        emailTemplateService.save(emailTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        emailTemplateService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody EmailTemplate emailTemplate) {
        emailTemplateService.updateByPK(emailTemplate);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        EmailTemplate emailTemplate = emailTemplateService.findById(id);
        return ResultGenerator.genSuccessResult(emailTemplate);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<EmailTemplate> list = emailTemplateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

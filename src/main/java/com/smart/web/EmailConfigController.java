package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.core.Reflections;
import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.EmailConfig;
import com.smart.service.EmailConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/05/18.
*/
@RestController
@RequestMapping("/email/config")
public class EmailConfigController {
    @Resource
    private EmailConfigService emailConfigService;

    private static final Logger logger = LoggerFactory.getLogger(Reflections.class);

    @PostMapping
    public Result add(@Validated @RequestBody EmailConfig emailConfig) {
        emailConfigService.save(emailConfig);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        emailConfigService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody EmailConfig emailConfig) {
        emailConfigService.updateByPK(emailConfig);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        EmailConfig emailConfig = emailConfigService.findById(id);
        return ResultGenerator.genSuccessResult(emailConfig);
    }

    @GetMapping("/setInfo")
    public Result search(){
        List<EmailConfig> list = emailConfigService.findAll();
        EmailConfig emailConfig = null;
        if(list != null && list.size() > 0){
            emailConfig = list.get(0);
        }
        return ResultGenerator.genSuccessResult(emailConfig);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<EmailConfig> list = emailConfigService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/sendMail")
    public Result sendMail(@RequestParam String emailAdd, @RequestParam String testParameter){
        try {
            emailConfigService.sendTestEmail(emailAdd, testParameter);
        }catch(Exception e){
            logger.error("error: "+e);
        }
        return ResultGenerator.genSuccessResult();
    }
}

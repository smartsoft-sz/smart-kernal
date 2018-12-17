package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.SmsConfig;
import com.smart.service.SmsConfigService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/03/29.
*/
@RestController
@RequestMapping("/sms/config")
public class SmsConfigController {
    @Resource
    private SmsConfigService smsConfigService;

    @PostMapping
    public Result add(@Validated @RequestBody SmsConfig smsConfig) {
        smsConfigService.save(smsConfig);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        smsConfigService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody SmsConfig smsConfig) {
        smsConfigService.updateByPK(smsConfig);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        SmsConfig smsConfig = smsConfigService.findById(id);
        return ResultGenerator.genSuccessResult(smsConfig);
    }

    @GetMapping
    public Result list() {
        List<SmsConfig> list = smsConfigService.findAll();
        SmsConfig smsConfig = list.get(0);
        return ResultGenerator.genSuccessResult(smsConfig);
    }

}

package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.SmsVerify;
import com.smart.service.SmsVerifyService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2017/12/14.
*/
@RestController
@RequestMapping("/smsVerify")
public class SmsVerifyController {
    @Resource
    private SmsVerifyService smsVerifyService;

    @PostMapping
    public Result add(@Validated @RequestBody SmsVerify smsVerify) {
        smsVerifyService.save(smsVerify);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        smsVerifyService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody SmsVerify smsVerify) {
        smsVerifyService.updateByPK(smsVerify);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        SmsVerify smsVerify = smsVerifyService.findById(id);
        return ResultGenerator.genSuccessResult(smsVerify);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SmsVerify> list = smsVerifyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


}

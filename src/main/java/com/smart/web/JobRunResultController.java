package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.JobRunResult;
import com.smart.service.JobRunResultService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/03/27.
*/
@RestController
@RequestMapping("/job/run/result")
public class JobRunResultController {
    @Resource
    private JobRunResultService jobRunResultService;

    @PostMapping
    public Result add(@Validated @RequestBody JobRunResult jobRunResult) {
        jobRunResultService.save(jobRunResult);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        jobRunResultService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody JobRunResult jobRunResult) {
        jobRunResultService.updateByPK(jobRunResult);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        JobRunResult jobRunResult = jobRunResultService.findById(id);
        return ResultGenerator.genSuccessResult(jobRunResult);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<JobRunResult> list = jobRunResultService.findAllJobRerunResult();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/status")
    public Result getJobRunResultByStatus(@RequestParam() String status,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<JobRunResult> list;
        if (StringUtils.equals(status,"ALL")) {
            list = jobRunResultService.findAllJobRerunResult();
        }else {
            list = jobRunResultService.findByStatus(status);
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

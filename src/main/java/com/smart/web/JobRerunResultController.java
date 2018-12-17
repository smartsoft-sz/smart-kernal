package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.JobRerunResult;
import com.smart.service.JobRerunResultService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/03/27.
*/
@RestController
@RequestMapping("/job/rerun/result")
public class JobRerunResultController {
    @Resource
    private JobRerunResultService jobRerunResultService;

    @PostMapping
    public Result add(@Validated @RequestBody JobRerunResult jobRerunResult) {
        jobRerunResultService.save(jobRerunResult);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        jobRerunResultService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody JobRerunResult jobRerunResult) {
        jobRerunResultService.updateByPK(jobRerunResult);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        JobRerunResult jobRerunResult = jobRerunResultService.findById(id);
        return ResultGenerator.genSuccessResult(jobRerunResult);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<JobRerunResult> list = jobRerunResultService.findAllJobRerunResult();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/status")
    public Result getJobRerunResultByStatus(@RequestParam() String status,@RequestParam(defaultValue = "") String jobItemStatus,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<JobRerunResult> list;
        if (StringUtils.equals(status,"ALL")) {
            list = jobRerunResultService.findAllJobRerunResult();
        }else {
            list = jobRerunResultService.findByStatus(status,jobItemStatus);
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/rerun")
    public Result rerunJob(@RequestParam("jobId") Long jobId,
                           @RequestParam("startTime")
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                           @RequestParam("endTime")
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        jobRerunResultService.rerunJob(jobId,startTime,endTime);
        return ResultGenerator.genSuccessResult();
    }
}

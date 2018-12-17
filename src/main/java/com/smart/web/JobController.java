package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.Job;
import com.smart.service.JobService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/03/27.
*/
@RestController
@RequestMapping("/job")
public class JobController {
    @Resource
    private JobService jobService;

    @PostMapping
    public Result add(@Validated @RequestBody Job job) {
        jobService.save(job);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        jobService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Job job) {
        jobService.updateByPK(job);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Job job = jobService.findById(id);
        return ResultGenerator.genSuccessResult(job);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Job> list = jobService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

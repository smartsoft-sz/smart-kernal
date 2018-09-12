package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
* Created by CodeGenerator on 2018/06/25.
*/
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @javax.annotation.Resource
    private ResourceService resourceService;

    @PostMapping
    public Result add(@Validated @RequestBody com.smart.model.Resource resource) {
        resourceService.save(resource);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        resourceService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody com.smart.model.Resource resource) {
        resourceService.updateByPK(resource);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        com.smart.model.Resource resource = resourceService.findById(id);
        return ResultGenerator.genSuccessResult(resource);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<com.smart.model.Resource> list = resourceService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

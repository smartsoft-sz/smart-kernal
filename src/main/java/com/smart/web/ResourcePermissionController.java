package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.ResourcePermission;
import com.smart.service.ResourcePermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/25.
*/
@RestController
@RequestMapping("/resource/permission")
public class ResourcePermissionController {
    @Resource
    private ResourcePermissionService resourcePermissionService;

    @PostMapping
    public Result add(@Validated @RequestBody ResourcePermission resourcePermission) {
        resourcePermissionService.save(resourcePermission);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        resourcePermissionService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody ResourcePermission resourcePermission) {
        resourcePermissionService.updateByPK(resourcePermission);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        ResourcePermission resourcePermission = resourcePermissionService.findById(id);
        return ResultGenerator.genSuccessResult(resourcePermission);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ResourcePermission> list = resourcePermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

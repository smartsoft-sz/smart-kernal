package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.RolePermission;
import com.smart.service.RolePermissionService;
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
@RequestMapping("/role/permission")
public class RolePermissionController {
    @Resource
    private RolePermissionService rolePermissionService;

    @PostMapping
    public Result add(@Validated @RequestBody RolePermission rolePermission) {
        rolePermissionService.save(rolePermission);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        rolePermissionService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody RolePermission rolePermission) {
        rolePermissionService.updateByPK(rolePermission);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        RolePermission rolePermission = rolePermissionService.findById(id);
        return ResultGenerator.genSuccessResult(rolePermission);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RolePermission> list = rolePermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

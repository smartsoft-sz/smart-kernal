package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.Permission;
import com.smart.service.PermissionService;
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
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @PostMapping
    public Result add(@Validated @RequestBody Permission permission) {
        permissionService.save(permission);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/addPermission")
    public Result addPermission(@Validated @RequestBody Permission permission) {
        permissionService.add(permission);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/deletePermission/{id}")
    public Result deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        permissionService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Permission permission) {
        permissionService.updateByPK(permission);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/updatePermission")
    public Result updatePermission(@Validated @RequestBody Permission permission) {
        permissionService.updatePermission(permission);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Permission permission = permissionService.findById(id);
        return ResultGenerator.genSuccessResult(permission);
    }

    @GetMapping("/detailInfo/{id}")
    public Result detailInfo(@PathVariable Long id) {
        Permission permission = permissionService.findPermissionById(id);
        return ResultGenerator.genSuccessResult(permission);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Permission> list = permissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/pageList")
    public Result pageList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Permission> list = permissionService.pageList();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

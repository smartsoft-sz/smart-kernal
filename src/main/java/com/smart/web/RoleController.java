package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.Role;
import com.smart.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2017/11/20.
*/
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping
    public Result add(@Validated @RequestBody Role role) {
        roleService.save(role);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/addRole")
    public Result addRole(@Validated @RequestBody Role role) {
        roleService.add(role);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/deleteRole/{id}")
    public Result deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        roleService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Role role) {
        roleService.updateByPK(role);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/updateRole")
    public Result updateRole(@Validated @RequestBody Role role) {
        roleService.updateRole(role);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Role role = roleService.findById(id);
        return ResultGenerator.genSuccessResult(role);
    }

    @GetMapping("/detailInfo/{id}")
    public Result detailInfo(@PathVariable Long id) {
        Role role = roleService.findRoleById(id);
        return ResultGenerator.genSuccessResult(role);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Role> list = roleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/pageList")
    public Result pageList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Role> list = roleService.pageList();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

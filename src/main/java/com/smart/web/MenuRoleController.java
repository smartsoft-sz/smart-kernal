package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.MenuRole;
import com.smart.service.MenuRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/08/30.
*/
@RestController
@RequestMapping("/menu/role")
public class MenuRoleController {
    @Resource
    private MenuRoleService menuRoleService;

    @PostMapping
    public Result add(@Validated @RequestBody MenuRole menuRole) {
        menuRoleService.save(menuRole);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        menuRoleService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody MenuRole menuRole) {
        menuRoleService.updateByPK(menuRole);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        MenuRole menuRole = menuRoleService.findById(id);
        return ResultGenerator.genSuccessResult(menuRole);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MenuRole> list = menuRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

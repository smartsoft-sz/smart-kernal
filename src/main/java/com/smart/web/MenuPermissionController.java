package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.MenuPermission;
import com.smart.service.MenuPermissionService;
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
@RequestMapping("/menu/permission")
public class MenuPermissionController {
    @Resource
    private MenuPermissionService menuPermissionService;

    @PostMapping
    public Result add(@Validated @RequestBody MenuPermission menuPermission) {
        menuPermissionService.save(menuPermission);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        menuPermissionService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody MenuPermission menuPermission) {
        menuPermissionService.updateByPK(menuPermission);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        MenuPermission menuPermission = menuPermissionService.findById(id);
        return ResultGenerator.genSuccessResult(menuPermission);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MenuPermission> list = menuPermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

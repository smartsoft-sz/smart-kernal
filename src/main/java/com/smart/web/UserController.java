package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultCode;
import com.smart.core.ResultGenerator;
import com.smart.model.User;
import com.smart.security.SecurityUtils;
import com.smart.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/22.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping
    public Result add(@Validated @RequestBody User user) {
        userService.saveUser(user);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody User user) {
        userService.updateByPK(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping("/withRoles/{id}")
    public Result withRoles(@PathVariable Long id) {
        User user = userService.getUserIdentity(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping("/identity")
    public Result getUserIdentity() {
        User user = userService.getUserIdentity(SecurityUtils.getCurrentUserId());
        if(user==null)
            ResultGenerator.genFailResult(ResultCode.USER_NOT_EXIST);
        return ResultGenerator.genSuccessResult(user);
    }

    @PutMapping("/updateAdmin")
    public Result updateAdmin(@Validated @RequestBody User user) {
        userService.updateAdmin(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

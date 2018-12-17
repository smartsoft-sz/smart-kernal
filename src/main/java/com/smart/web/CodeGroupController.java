package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.CodeGroup;
import com.smart.service.CodeGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by smartsoft on 2018/09/07.
*/
@RestController
@RequestMapping("/codeGroup")
public class CodeGroupController {
    @Resource
    private CodeGroupService codeGroupService;

    @PostMapping
    public Result add(@Validated @RequestBody CodeGroup codeGroup) {
        codeGroupService.save(codeGroup);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        codeGroupService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody CodeGroup codeGroup) {
        codeGroupService.updateByPK(codeGroup);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        CodeGroup codeGroup = codeGroupService.findById(id);
        return ResultGenerator.genSuccessResult(codeGroup);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CodeGroup> list = codeGroupService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/filter")
    public Result filter(@RequestParam(defaultValue = "0") Integer page,
                         @RequestParam(defaultValue = "0") Integer size,
                         @RequestParam(required = false) String keyword) {
        PageHelper.startPage(page, size);
        List<CodeGroup> list = codeGroupService.filter(keyword);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

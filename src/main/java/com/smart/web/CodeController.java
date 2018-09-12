package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.Code;
import com.smart.service.CodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/21.
*/
@RestController
@RequestMapping("/code")
public class CodeController {
    @Resource
    private CodeService codeService;

    @PostMapping
    public Result add(@Validated @RequestBody Code code) {
        codeService.saveCode(code);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        codeService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Code code) {
        codeService.updateCode(code);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Code code = codeService.findById(id);
        return ResultGenerator.genSuccessResult(code);
    }

    @GetMapping("/type")
    public Result listByGroup(@RequestParam String type) {
        List<Code> codeList = codeService.listCodeByCond(null,type);
        return ResultGenerator.genSuccessResult(codeList);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page,
                        @RequestParam(defaultValue = "0") Integer size,
                        @RequestParam(required = false) String keyword,
                        @RequestParam(required = false) String codeGroupCode
                       ) {
        PageHelper.startPage(page, size);
        List<Code> list = codeService.listCodeByCond(keyword,codeGroupCode);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Code> list = codeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

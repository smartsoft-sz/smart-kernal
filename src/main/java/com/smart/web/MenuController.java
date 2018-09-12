package com.smart.web;

import com.smart.core.Result;
import com.smart.core.ResultGenerator;
import com.smart.model.Menu;
import com.smart.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/03.
*/
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @PostMapping
    public Result add(@Validated @RequestBody Menu menu) {
        menuService.save(menu);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        menuService.deleteByPK(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@Validated @RequestBody Menu menu) {
        menuService.updateByPK(menu);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        Menu menu = menuService.findById(id);
        return ResultGenerator.genSuccessResult(menu);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Menu> list = menuService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 获取所有菜单
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll() {
        return ResultGenerator.genSuccessResult(menuService.findAllMenusWithRoles());
    }
}

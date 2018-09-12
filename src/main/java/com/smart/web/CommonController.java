package com.smart.web;

import com.smart.service.CodeService;
import com.smart.service.ParameterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    private CodeService codeService;
    @Resource
    private ParameterService parameterService;

}

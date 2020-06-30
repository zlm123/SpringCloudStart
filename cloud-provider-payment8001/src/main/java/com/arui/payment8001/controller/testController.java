package com.arui.payment8001.controller;

import com.arui.common.model.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ARui
 * @Date: 2020/5/27 0:33
 */
@RestController
public class testController {
//    @Autowired
//    ResponseResultInterceptor responseResultInterceptor;

    @PostMapping(value = "test")
    public CommonResult<String> test() {
//        responseResultInterceptor.test();
        return CommonResult.success();
    }
}

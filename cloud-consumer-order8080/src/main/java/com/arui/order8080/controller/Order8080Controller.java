package com.arui.order8080.controller;

import com.arui.common.bean.Payment;
import com.arui.common.model.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ARui
 * @Date: 2020/6/5 17:04
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@ResponseBody
public class Order8080Controller {

    public static final String PAYMENT_URL = "http://127.0.0.1:8192/";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<String> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @RequestMapping(value = "/throwException")
    public Payment throwException(Payment payment) {
        throw new IllegalArgumentException("aaa");
    }

//    @ExceptionHandler({RuntimeException.class})
//    public CommonResult<String> fix(Exception ex) {
//        System.out.println("do This");
//        return CommonResult.error(ex.getMessage());
//    }
}

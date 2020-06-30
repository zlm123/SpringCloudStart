package com.arui.payment8001.controller;

import com.arui.common.exception.BusinessException;
import com.arui.payment8001.ResponseResult;
import com.arui.payment8001.service.PaymentService;
import com.arui.payment8001.bean.Payment;
import com.arui.common.model.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: ARui
 * @Date: 2020/5/22 1:02
 */
@RestController
@Slf4j
@ResponseResult
@RequestMapping("/provider")
public class payment8001Controller {
    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<String> insertPay(@Valid Payment payment) {
        int re = paymentService.add(payment);
        if (re == 1)
            return CommonResult.success("付款成功");
        else
            return CommonResult.error(111, "付款失败");
    }

    @ResponseResult
    @PostMapping(value = "/payment/search")
    public List<Payment> search() {
        return paymentService.search();
    }

    @ResponseResult
    @PostMapping(value = "throwException")
    public Payment throwException(Payment payment) {
        throw new RuntimeException("未处理异常");
    }

    @ResponseResult
    @PostMapping(value = "throwBusinessException")
    public Payment throwBusinessException(Payment payment) {
        throw new BusinessException(null, "业务异常");
    }
}

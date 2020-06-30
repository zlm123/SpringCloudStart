package com.arui.payment8001.service;

import com.arui.payment8001.bean.Payment;

import java.util.List;

/**
 * @Author: ARui
 * @Date: 2020/5/22 17:39
 */
public interface PaymentService {
    public int add(Payment payment);

    public List<Payment> search();
}

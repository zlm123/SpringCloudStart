package com.arui.payment8001.service.impl;

import com.arui.payment8001.bean.Payment;
import com.arui.payment8001.dao.PaymentMapper;
import com.arui.payment8001.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ARui
 * @Date: 2020/5/22 17:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public int add(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public List<Payment> search() {
        return paymentMapper.selectByExample(null);
    }
}

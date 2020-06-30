package com.arui.payment8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @Author: ARui
 * @Date: 2020/5/22 0:07
 */
@MapperScan("com.arui.payment8001.dao")
//@MapperScan("com.arui.springcloud.bean")
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class);
    }
}

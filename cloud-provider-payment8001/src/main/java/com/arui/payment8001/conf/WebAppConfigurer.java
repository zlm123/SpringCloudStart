package com.arui.payment8001.conf;

import com.arui.payment8001.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: ARui
 * @Date: 2020/5/27 0:42
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
    }
}

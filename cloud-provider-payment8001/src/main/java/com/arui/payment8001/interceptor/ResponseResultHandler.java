package com.arui.payment8001.interceptor;

import com.arui.common.exception.BaseException;
import com.arui.common.exception.BusinessException;
import com.arui.common.model.CommonResult;
import com.arui.payment8001.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ARui
 * @Date: 2020/5/26 23:43
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        ResponseResult responseResult = (ResponseResult) httpServletRequest.getAttribute(RESPONSE_RESULT_ANN);
        return responseResult == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("进入 返回格式 重写格式处理。。。");
        if (o instanceof CommonResult)
            return o;
        else if (o instanceof Exception) {
            return o;
        } else
            return CommonResult.success(o);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult handleBaseException(Exception e) {
        log.error(e.getMessage(), e);

        return CommonResult.error(1001, e.getMessage());
    }

    /**
     * 业务异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResult handleBusinessException(BaseException e) {
        log.error(e.getMessage(), e);

        return CommonResult.error(1002, e.getMessage());
    }
}

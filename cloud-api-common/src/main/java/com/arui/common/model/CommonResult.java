package com.arui.common.model;

import com.alibaba.fastjson.JSON;
import com.arui.common.emuns.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ARui
 * @Date: 2020/5/22 11:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public boolean successed() {
        return code == 200;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static <T> CommonResult success() {
        return new CommonResult();
    }

    public static <T> CommonResult success(String msg, T data) {
        CommonResult response = new CommonResult();
        response.setMsg(msg);
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> CommonResult success(T data) {
        CommonResult response = new CommonResult();
        response.setMsg(ResultCode.SUCCESS.getMsg());
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> CommonResult error(int code, String msg) {
        CommonResult response = new CommonResult();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> CommonResult build(int code, String msg, T data) {
        CommonResult response = new CommonResult(code, msg, data);
        return response;
    }
}

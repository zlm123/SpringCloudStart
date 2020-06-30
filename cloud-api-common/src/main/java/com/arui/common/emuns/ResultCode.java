package com.arui.common.emuns;

import lombok.AllArgsConstructor;

/**
 * @Author: ARui
 * @Date: 2020/5/27 11:34
 */
@AllArgsConstructor

public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(500, "失败");
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}

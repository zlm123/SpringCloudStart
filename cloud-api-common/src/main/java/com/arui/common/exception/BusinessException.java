package com.arui.common.exception;

import com.arui.common.emuns.IResponseEnum;

/**
 * @Author: ARui
 * @Date: 2020/6/30 19:57
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 1L;

    public BusinessException(IResponseEnum responseEnum, String message) {
        super(responseEnum, message);
    }

    public BusinessException(IResponseEnum responseEnum, String message, Throwable cause) {
        super(responseEnum, message, cause);
    }
}

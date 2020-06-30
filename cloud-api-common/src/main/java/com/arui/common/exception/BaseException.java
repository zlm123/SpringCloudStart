package com.arui.common.exception;

import com.arui.common.emuns.IResponseEnum;

/**
 * @Author: ARui
 * @Date: 2020/6/30 20:02
 */
public class BaseException extends RuntimeException {
    public BaseException(IResponseEnum iResponseEnum, String message) {
        super(message);
    }

    public BaseException(IResponseEnum iResponseEnum, String message, Throwable cause) {
        super(message, cause);
    }
}

package com.yijixin.fromzerotoexpert.exception;

/**
 * @Classname FzteException
 * @Description 自定义异常类
 * @Version 1.0.0
 * @Date 2022/10/14 20:59
 * @Created by 忆霁昕
 */
public class FzteException extends Exception {
    private Integer code;
    private String msg;

    public FzteException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public FzteException(FzteExceptionEnum ex) {
        this(ex.getCode(), ex.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

package com.yijixin.fromzerotoexpert.exception;

/**
 * @Classname FzteEnum
 * @Description 自定义异常枚举类
 * @Version 1.0.0
 * @Date 2022/10/14 20:54
 * @Created by 忆霁昕
 */
public enum FzteExceptionEnum {
    NEED_USERNAME(10001, "用户名不能空"),
    NEED_PASSWORD(10002, "密码不能空"),
    INSERT_FAILED(10003, "插入失败"),
    SYSTEM_ERROR(20000, "系统故障")
    ;
    private Integer code;
    private String msg;

    FzteExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

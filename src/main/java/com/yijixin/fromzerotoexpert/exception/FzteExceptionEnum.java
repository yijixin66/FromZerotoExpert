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
    USERNAME_TOO_LONG(10004, "用户名不能超过15个字符"),
    WRONG_PASSWORD_LENGTH(10005, "密码的长度必须6~16位"),
    NAME_EXISTED(10006, "用户名已存在"),
    WRONG_PASSWORD(10007, "密码只能包含数字和大小写字母，必须包含两种以上字符"),
    SENSITIVE_NAME(10008, "用户名含敏感词"),
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

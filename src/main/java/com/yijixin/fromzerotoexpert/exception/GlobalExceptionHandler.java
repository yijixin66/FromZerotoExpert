package com.yijixin.fromzerotoexpert.exception;

import com.yijixin.fromzerotoexpert.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname GlobalExceptionHandler
 * @Description 统一异常处理 返回统一的结果
 * @Version 1.0.0
 * @Date 2022/10/14 21:01
 * @Created by 忆霁昕
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /***
     * todo
     * #Description 处理系统异常
     * @param ex
     * @return com.yijixin.fromzerotoexpert.common.ApiRestResponse
     * @author 忆霁昕
     * #Date 2022/10/14
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiRestResponse handlerException(Exception ex) {
        log.error("系统异常", ex);
        return ApiRestResponse.error(FzteExceptionEnum.SYSTEM_ERROR);
    }
    /***
     * todo
     * #Description 处理自定义异常
     * @param ex
     * @return com.yijixin.fromzerotoexpert.common.ApiRestResponse
     * @author 忆霁昕
     * #Date 2022/10/14
     */
    @ExceptionHandler(FzteException.class)
    @ResponseBody
    public ApiRestResponse handlerFzteException(FzteException ex) {
        log.error(ex.getMsg(), ex);
        return ApiRestResponse.error(ex.getCode(), ex.getMsg());
    }
}

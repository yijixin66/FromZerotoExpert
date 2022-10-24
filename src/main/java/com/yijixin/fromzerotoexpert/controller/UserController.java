package com.yijixin.fromzerotoexpert.controller;

import com.yijixin.fromzerotoexpert.common.ApiRestResponse;
import com.yijixin.fromzerotoexpert.exception.FzteException;
import com.yijixin.fromzerotoexpert.service.UserService;
import com.yijixin.fromzerotoexpert.util.CheckUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname UserController
 * @Description 用户控制器
 * @Version 1.0.0
 * @Date 2022/10/11 21:54
 * @Created by 忆霁昕
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    /***
     * todo
     * #Description 利用cookie实现网站短暂的记忆
     * @param request
     * @param response
     * @return java.lang.String
     * @author 忆霁昕
     * #Date 2022/10/14
     */
    @GetMapping("/FromZerotoExpert")
    @ResponseBody
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        //注意判空
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("has_accessed")
                        && cookie.getValue().equals("hafzte")) {
                    return "嗨，欢迎您再次到 from zero to expert.";
                }
            }
        }
        Cookie cookie = new Cookie("has_accessed", "hafzte");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        return "嗨，欢迎您来到 from zero to expert.";
    }

    /***
     * todo
     * #Description 登录模块
     * @param username
     * @param password
     * @return com.yijixin.fromzerotoexpert.common.ApiRestResponse
     * @author 忆霁昕
     * #Date 2022/10/14
     */
    @PostMapping("/Register")
    @ResponseBody
    public ApiRestResponse register(
            @RequestParam("username") String username,
            @RequestParam("password") String password) throws FzteException {
        CheckUtils.checkUsername(username);
        CheckUtils.checkPassword(password);
        userService.register(username, password);
        return ApiRestResponse.success();
    }
}

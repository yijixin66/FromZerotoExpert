package com.yijixin.fromzerotoexpert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname UserController
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/10/11 21:54
 * @Created by 忆霁昕
 */
@Controller
public class UserController {
    @GetMapping("/FromZerotoExpert")
    @ResponseBody
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("has_accessed")
                    && cookie.getValue().equals("hafzte")) {
                return "嗨，欢迎您再次到 from zero to expert.";
            }
        }
        Cookie cookie = new Cookie("has_accessed", "hafzte");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        return "嗨，欢迎您来到 from zero to expert.";
    }
}

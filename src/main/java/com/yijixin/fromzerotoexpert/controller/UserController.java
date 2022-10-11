package com.yijixin.fromzerotoexpert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String hello() {
        return "嗨，欢迎您来到 from zero to expert.";
    }
}

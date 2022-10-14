package com.yijixin.fromzerotoexpert.service;

import com.yijixin.fromzerotoexpert.exception.FzteException;

/**
 * @Classname UserService
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/10/14 20:39
 * @Created by 忆霁昕
 */
public interface UserService {
    void register(String username, String password) throws FzteException;
}

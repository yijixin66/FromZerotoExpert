package com.yijixin.fromzerotoexpert.model.dao;

import com.yijixin.fromzerotoexpert.model.pojo.User;

import javax.annotation.Resource;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/10/14 20:10
 * @Created by 忆霁昕
 */
@Resource
public interface UserMapper {
    int insert(User user);

    User selectByName(String username);
}

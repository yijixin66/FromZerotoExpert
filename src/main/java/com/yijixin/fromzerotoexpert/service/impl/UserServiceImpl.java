package com.yijixin.fromzerotoexpert.service.impl;

import com.yijixin.fromzerotoexpert.exception.FzteException;
import com.yijixin.fromzerotoexpert.exception.FzteExceptionEnum;
import com.yijixin.fromzerotoexpert.model.dao.UserMapper;
import com.yijixin.fromzerotoexpert.model.pojo.User;
import com.yijixin.fromzerotoexpert.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/10/14 21:11
 * @Created by 忆霁昕
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void register(String username, String password) throws FzteException {
        //判空
        if (StringUtils.isEmpty(username)) {
            throw new FzteException(FzteExceptionEnum.NEED_USERNAME);
        }
        if (StringUtils.isEmpty(password)) {
            throw new FzteException(FzteExceptionEnum.NEED_USERNAME);
        }
        //密码限制
//        if (password)

        //检测用户名是否重复

        //插入
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int count = userMapper.insert(user);
        if (count == 0) {
            throw new FzteException(FzteExceptionEnum.INSERT_FAILED);
        }
    }
}

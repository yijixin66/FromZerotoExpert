package com.yijixin.fromzerotoexpert.model.dao;

import com.yijixin.fromzerotoexpert.FromzerotoexpertApplicationTests;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Classname DisallowWordMapperTest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/10/25 11:57
 * @Created by 忆霁昕
 */
public class DisallowWordMapperTest extends FromzerotoexpertApplicationTests {

    private static DisallowWordMapper disallowWordMapper;
    @Resource
    public void setDisallowWordMapper(DisallowWordMapper disallowWordMapper) {
        DisallowWordMapperTest.disallowWordMapper = disallowWordMapper;
    }

    @Test
    public void selectAllValue() {
        System.out.println(disallowWordMapper.selectAllValue());
    }

}
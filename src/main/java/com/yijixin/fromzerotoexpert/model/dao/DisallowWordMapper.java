package com.yijixin.fromzerotoexpert.model.dao;

import com.yijixin.fromzerotoexpert.model.pojo.DisallowWord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname DisallowWordMapper
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/10/25 11:46
 * @Created by 忆霁昕
 */
@Repository
public interface DisallowWordMapper {
    List<String> selectAllValue();
}

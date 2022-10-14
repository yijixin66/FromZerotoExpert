package com.yijixin.fromzerotoexpert;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yijixin.fromzerotoexpert.model.dao")
public class FromzerotoexpertApplication {

    public static void main(String[] args) {
        SpringApplication.run(FromzerotoexpertApplication.class, args);
    }

}

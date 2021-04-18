package com.dfy.heart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan(value = "com.dfy.heart", annotationClass = Resource.class)
public class DfyheartApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfyheartApplication.class, args);
    }

}

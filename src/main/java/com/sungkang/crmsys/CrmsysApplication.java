package com.sungkang.crmsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sungkang.crmsys.mapper")
public class CrmsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmsysApplication.class, args);
    }

}

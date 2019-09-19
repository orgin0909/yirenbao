package com.top.yirenbaotop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.top.yirenbaotop.mapper")
@EnableCaching
@SpringBootApplication
public class YirenbaotopApplication {

    public static void main(String[] args) {
        SpringApplication.run(YirenbaotopApplication.class, args);
    }

}

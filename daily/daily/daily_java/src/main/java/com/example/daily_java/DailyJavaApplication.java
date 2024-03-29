package com.example.daily_java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("com.example.daily_java.mapper")
@SpringBootApplication
// @ServletComponentScan(basePackages = {"com.example.daily_java.filter"})
public class DailyJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyJavaApplication.class, args);
    }

}

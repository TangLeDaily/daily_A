package com.example.daily_java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.daily_java.mapper")
@SpringBootApplication
public class DailyJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyJavaApplication.class, args);
    }

}

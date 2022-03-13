package com.example.multiple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.multiple.mapper")
public class MultipleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleApplication.class, args);
    }

}

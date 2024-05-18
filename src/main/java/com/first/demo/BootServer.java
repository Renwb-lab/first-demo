package com.first.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.first.demo.mapper")
@SpringBootApplication
public class BootServer {
    public static void main(String[] args) {
        //启动
        SpringApplication.run(BootServer.class);
    }
}

package com.anzaiyun.servie;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.anzaiyun.servie")
public class Springboot02WebDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02WebDubboServiceApplication.class, args);
    }

}

package com.anzaiyun.servie;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Springboot02WebDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02WebDubboServiceApplication.class, args);
    }

}

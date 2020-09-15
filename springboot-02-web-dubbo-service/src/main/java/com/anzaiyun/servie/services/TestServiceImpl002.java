package com.anzaiyun.servie.services;

import com.anzaiyun.api.services.TestService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(timeout = 3000,version = "1.0.2")
public class TestServiceImpl002 implements TestService {

    @Override
    public String TestOne() {
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "this is TestOne version=1.0.2";
    }

    @Override
    public String TestTwo() {
        return "this is TestTwo";
    }

    @Override
    public String TestThree() {
        return "this is TestThree";
    }
}

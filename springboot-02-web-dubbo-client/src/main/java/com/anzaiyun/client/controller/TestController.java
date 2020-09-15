package com.anzaiyun.client.controller;

import com.anzaiyun.api.services.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @DubboReference(version = "1.0.2")
    private TestService testService;

    @RequestMapping("/1")
    @ResponseBody
    public String TestOne(){
        return testService.TestOne();
    }
}

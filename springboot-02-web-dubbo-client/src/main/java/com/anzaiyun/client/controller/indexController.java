package com.anzaiyun.client.controller;

import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class indexController {

    @DubboReference
    UserService userService;

    @ResponseBody
    @RequestMapping("/1")
    public String testcontro1(){
        Users user = userService.FindById(1);

        return "12312313"+user.getVc_name();
    }

    @ResponseBody
    @RequestMapping("/2")
    public String testcontro2(){
        Users[] user = userService.FindUser();

        return user.toString();
    }
}

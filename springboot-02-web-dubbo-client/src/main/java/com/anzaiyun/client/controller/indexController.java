package com.anzaiyun.client.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class indexController {

    @Reference
    UserService userService;

    @ResponseBody
    @RequestMapping("")
    public String testcontro(){
        Users user = userService.FindById(1);

        return "12312313"+user.getVc_name();
    }
}

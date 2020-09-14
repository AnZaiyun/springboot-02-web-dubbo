package com.anzaiyun.client.controller.Login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/login"})
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping("")
    public String login(Model model){
        return "login.html";
    }
}

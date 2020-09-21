package com.anzaiyun.client.controller.MainPage;

import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Main")
public class MemberShowController {

    private Logger logger = Logger.getLogger(MemberShowController.class);

    @DubboReference
    private UserService userService;

    @RequestMapping("/MemberShow")
    public String memberShow(@RequestParam("uid") Integer uid, Model model, HttpSession session){
        Users user = userService.FindById(uid);
        model.addAttribute("user",user);

        return "member-show.html";
    }
}

package com.anzaiyun.client.controller.MainPage;

import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Main")
public class MemberListController {

    private Logger logger = Logger.getLogger(MemberListController.class);

    @DubboReference
    private UserService userService;

    @RequestMapping("/MemberList")
    public String memberList(Model model, HttpSession session){

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        logger.debug("会员列表页面  用户：["+username+"] 密码：["+password+"]");

        logger.debug("获取所有用户信息");
        Users[] users = userService.FindUser();
        model.addAttribute("users",users);

        return "member-list.html";
    }
}

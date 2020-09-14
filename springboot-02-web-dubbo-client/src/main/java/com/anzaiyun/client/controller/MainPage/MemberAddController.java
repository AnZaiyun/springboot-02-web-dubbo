package com.anzaiyun.client.controller.MainPage;

import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Main")
public class MemberAddController {

    private Logger logger = Logger.getLogger(MemberAddController.class);

    @DubboReference
    private UserService userService;

    @RequestMapping("/MemberAdd")
    public String MemberAdd(Authentication auth, Model model, HttpSession session){

//        User user = null;
        String username = "无";
        String userauth = "无";
        if (auth.getPrincipal()!=null){
            User user  = (User) auth.getPrincipal();
            username = user.getUsername() ;
            userauth = user.getAuthorities().toString();

        }

        logger.debug("增加会员页面  用户：["+username+"]"+"  权限：["+userauth+"]");
        return "member-add.html";
    }

    @RequestMapping("/Add")
    public String Add(@RequestParam("email") String email,
                      @RequestParam("username") String username,
                      @RequestParam("tel") String tel,
                      Model model,  HttpSession session){
        Users user = new Users(username,tel,email);
        boolean result = userService.InsertUser(user);
        if (result){
            model.addAttribute("msg","用户["+username+"]添加成功");
        }else {
            model.addAttribute("msg","用户["+username+"]添加失败");
        }


        return "member-add.html";
    }
}

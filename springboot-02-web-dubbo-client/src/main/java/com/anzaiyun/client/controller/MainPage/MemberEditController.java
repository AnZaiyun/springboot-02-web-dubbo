package com.anzaiyun.client.controller.MainPage;

import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Main")
public class MemberEditController {

    //使用spring boot自带的日志
    private Logger logger = LoggerFactory.getLogger(MemberEditController.class);

    @DubboReference
    private UserService userService;

    @RequestMapping("/MemberEdit")
    public String memberEdit(@RequestParam("uid") Integer uid, Model model){
        Users user = userService.FindById(uid);
        model.addAttribute("user",user);

        logger.info("用户编辑页面");

        return "member-edit.html";
    }

    @RequestMapping("/Edit")
    public String Edit(@RequestParam("email") String email,@RequestParam("username") String username,
                       @RequestParam("vc_address") String vc_address,@RequestParam("l_id") Integer l_id,
                       Model model){

        Users user = new Users();
        user.setL_id(l_id);
        user.setVc_mail(email);
        user.setVc_name(username);
        user.setVc_address(vc_address);
        System.out.println(user.toString());
        userService.UpdateUser(user);

        user = userService.FindById(l_id);
        model.addAttribute("user",user);

        return "member-edit.html";
    }
}

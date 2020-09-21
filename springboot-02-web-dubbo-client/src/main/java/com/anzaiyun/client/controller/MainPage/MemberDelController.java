package com.anzaiyun.client.controller.MainPage;

import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Main")
public class MemberDelController {

    private Logger logger = Logger.getLogger(MemberDelController.class);

    @DubboReference
    private UserService userService;

    @RequestMapping(value = "/MemberDel",method = RequestMethod.GET)
    @ResponseBody //只有加上该注解，前台ajax才能找到该模板转换，原因未知
    public String MemberDel(@RequestParam("uid") Integer uid, Model model){

        System.out.println("uid is "+uid);
        boolean result = userService.UpdateUserState(uid);

//        Users[] users = userService.FindUser();
//        model.addAttribute("users",users);

        //需要返回一个值，有值代表执行成功，没值代表执行失败
        if(result)
            return "true";
        else
            return null;
    }
}

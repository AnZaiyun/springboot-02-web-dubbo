package com.anzaiyun.client.controller.LevelPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Main")
public class LevelController {

    @RequestMapping("/Level")
    public String Level(){
        return "member-level.html";
    }
}

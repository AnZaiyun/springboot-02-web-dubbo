package com.anzaiyun.client.controller.LevelPage;

import com.anzaiyun.api.dao.Level;
import com.anzaiyun.api.services.LevelService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Main")
public class LevelController {

    @DubboReference
    private LevelService levelService;

    @RequestMapping("/Level")
    public String Level(Model model){
        Level[] level = levelService.FindLevels();

        model.addAttribute("levels",level);
        return "member-level.html";
    }
}

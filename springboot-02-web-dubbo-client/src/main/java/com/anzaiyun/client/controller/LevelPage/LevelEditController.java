package com.anzaiyun.client.controller.LevelPage;

import com.anzaiyun.api.dao.Level;
import com.anzaiyun.api.services.LevelService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Main")
public class LevelEditController {
    @DubboReference
    private LevelService levelService;

    @RequestMapping("/LevelEdit")
    public String LevelEdit(@RequestParam("l_id") Integer l_id, Model model){
        Level level = levelService.FindLevelById(l_id);

        model.addAttribute("level",level);
        return "level-edit.html";
    }

    @RequestMapping("/Level/Edit")
    public String Edit(@RequestParam("l_id") int l_id, @RequestParam("vc_name") String vc_name,
                       @RequestParam("l_jfxx") int l_jfxx, @RequestParam("l_jfsx") int l_jfsx,
                       Model model){
        Level level = new Level(l_id,vc_name,l_jfsx,l_jfxx);
        levelService.UpdateLevel(level);
        model.addAttribute("level",level);
        model.addAttribute("vc_msg","更新成功");
        return "level-edit.html";
    }
}

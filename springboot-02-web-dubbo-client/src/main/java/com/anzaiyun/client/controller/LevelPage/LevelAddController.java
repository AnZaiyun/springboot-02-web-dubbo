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
public class LevelAddController {

    @DubboReference
    private LevelService levelService;

    @RequestMapping("/LevelAdd")
    public String LevelAdd(){
        return "level-add.html";
    }

    @RequestMapping("/Level/Add")
    public String Add(@RequestParam("vc_name") String vc_name, @RequestParam("l_jfxx") int l_jfxx, @RequestParam("l_jfsx") int l_jfsx,
                      Model model){
        Level level = new Level(vc_name,l_jfsx,l_jfxx);
        if (levelService.FindLevelByName(vc_name) != null){
            model.addAttribute("vc_msg","当前积分等级名称已存在！");
        }else{
            model.addAttribute("vc_msg","积分等级新建成功。。。");
            levelService.AddLevel(level);
        }

        return "level-add.html";
    }
}

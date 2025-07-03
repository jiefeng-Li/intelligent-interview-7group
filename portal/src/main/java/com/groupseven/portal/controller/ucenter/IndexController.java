package com.groupseven.portal.controller.ucenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("ucenterIndexController")
@RequestMapping("ucenter")
public class IndexController {
    @GetMapping
    public String index(){
        return "ucenter/index";
    }

    @GetMapping("avatar")
    public String avatar(){
        return "ucenter/upload_avatar";
    }
    @GetMapping("resume")
    public String resume(){
        return "ucenter/resume";
    }
}


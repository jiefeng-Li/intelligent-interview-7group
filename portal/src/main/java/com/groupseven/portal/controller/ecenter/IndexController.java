package com.groupseven.portal.controller.ecenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("ecenterIndexController")
@RequestMapping("ecenter")
public class IndexController {
    @GetMapping
    public String index(){
        return "ecenter/index";
    }
}

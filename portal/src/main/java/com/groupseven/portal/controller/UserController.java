package com.groupseven.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("reg")
    public String reg(){
        return "reg";
    }

    @GetMapping("ident")
    public String ident(){
        return "ident";
    }

    @GetMapping("uploadavatar")
    public String uploadAvatar(){
        return "ucenter/upload_avatar";
    }
}

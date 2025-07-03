package com.groupseven.portal.controller.Resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("resume")
public class ResumeController {
    @GetMapping("/add1")
    public String resume1(){
        return "resume_1";
    }
    @GetMapping("/add2")
    public String resume2(){
        return "resume_2";
    }
    @GetMapping("/add3")
    public String resume3() {
        return "resume_3";
    }
    @GetMapping("addsuc")
    public String resume(){
        return "resume_suc";
    }
    @GetMapping("/view")
    public String view(){
        return "resume_view";
    }
}

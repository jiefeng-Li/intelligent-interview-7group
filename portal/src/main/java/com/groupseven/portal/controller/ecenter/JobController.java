package com.groupseven.portal.controller.ecenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("ecenterResumeController")
@RequestMapping("ecenter/job")
public class JobController {
    @GetMapping
    public String index() {
        return "ecenter/job";
    }
}

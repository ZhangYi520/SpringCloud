package com.zy.zy_sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class ToSystemViewController {

    @GetMapping("/toUser")
    public String toUser(){
        return "/system/user";
    }

    @GetMapping("/toRole")
    public String toRole(){
        return "/system/roleList";
    }
}

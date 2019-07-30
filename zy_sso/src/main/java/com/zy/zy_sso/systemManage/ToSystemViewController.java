package com.zy.zy_sso.systemManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class ToSystemViewController {

    @GetMapping("/toUser")
    public String toUser(){
        return "/system/user/user";
    }
}

package com.zy.socket.controller.blogs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogsIndexController {

    @GetMapping("/toBlogsIndex")
    public String  toBlogsIndex(){
        return "blogs/blogsIndex";
    }

}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 控制器

public class HelloController {
    @RequestMapping("/") // 映射URL

    public String hello() { // 方法
        return "hello.html"; // 返回网页
    }
}

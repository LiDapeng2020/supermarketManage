package com.supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {
    //页面顶部布局
    @RequestMapping("/top")
    public String top() {
        return "layout/top";
    }
    //页面左边布局
    @RequestMapping("/nav")
    public String nav() {
        return "layout/nav";
    }
    //页面中间首页标签页
    @RequestMapping("/head")
    public String head() {
        return "layout/head";
    }
    //页面右部布局
    @RequestMapping("/east")
    public String east() {
        return "layout/east";
    }
    //页面底部布局
    @RequestMapping("/south")
    public String south() {
        return "layout/south";
    }
}

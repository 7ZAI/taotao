package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author binblink
 * @Create Time　2018/4/11 23:20
 * @Description:页面跳转
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){

        return page;
    }
}

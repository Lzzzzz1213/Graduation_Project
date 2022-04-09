package com.glasssellmanagersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    @RequestMapping("/homepage")
    public String homePage(){
        return "index";
    }
}

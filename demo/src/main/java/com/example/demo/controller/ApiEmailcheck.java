package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ApiEmailcheck {
    
    @RequestMapping("/")
    public String root_test() throws Exception{
        return "EmailCheck";
    }
 
    @RequestMapping("/demo")
    public String demo_test() throws Exception{
        return "Hello demo(/demo)";
    }
    
}
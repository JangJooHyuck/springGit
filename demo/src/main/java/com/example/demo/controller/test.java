package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
@Controller
public class test {
    @RequestMapping("/2")
   
    public String root_test() throws Exception{
        return "index";
    }
 
    @RequestMapping("/demo")
    
    public String demo_test() throws Exception{
        return "Hello demo(/demo)";
    }
    
}
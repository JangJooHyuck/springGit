package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class HtmlController {

    @RequestMapping("/")
    public String email_check() throws Exception {
        
        //main.html 불러옴
        return "main";
    }

}

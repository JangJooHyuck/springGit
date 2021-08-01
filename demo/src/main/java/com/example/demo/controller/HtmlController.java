package com.example.demo.controller;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class HtmlController {

    @RequestMapping("/")
    public String email_check() throws Exception {
        //index.html 불러옴
        return "index";
    }
    
    //main.html
    @ModelAttribute
    @RequestMapping("/main")
    public String main(Model model) throws Exception{
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String mailString = req.getHeader("X-FORWARDED-FOR");
        if(mailString == null){
            mailString = req.getRemoteAddr();
        }
        model.addAttribute("value", mailString);
        return "main";
    }
    //printLog.html
    @RequestMapping("/printLog")
    public String printLog() throws Exception{
        return "printLog";
    }

}

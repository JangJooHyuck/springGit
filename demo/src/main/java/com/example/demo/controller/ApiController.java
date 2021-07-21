package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.EmailcheckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api")

public class ApiController {
    @Autowired
    EmailcheckService emailcheckservice;

    @RequestMapping("/check")
    @ResponseBody
    public String checkEmail(@RequestParam(value = "check") String userEmail)  
}

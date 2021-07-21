package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.EmailcheckService;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api")1
public class ApiController {

    @Autowired
    EmailcheckService emailcheckservice;

    @GetMapping("/check")
    @ResponseBody
    public User result(@RequestParam(value = "check") String userEmail) {

        User user = new User();
        user.setEmail(userEmail);
        user.setResult(emailcheckservice.isValidEmail(userEmail));

        return user;
    }
}

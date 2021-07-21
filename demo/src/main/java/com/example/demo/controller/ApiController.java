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
//  /api로 들어오는것들은 밑에 클래스에서 받아올수있다.
@RequestMapping("/api")
public class ApiController {

    //객체 자동생성 Autowired
    @Autowired

    //EmailcheckService 를 가져온다
    EmailcheckService emailcheckservice;

    //get으로 호출을 받으면
    @GetMapping("/get")
    @ResponseBody

    public User result(@RequestParam(value = "check") String userEmail) {

        // User 객체생성
        User user = new User();

        //email 에다가 userEmail 값을 넣고
        user.setEmail(userEmail);
        //Result 에다가 isValidEmail 에서 나온 값을 넣어준다.
        user.setResult(emailcheckservice.isValidEmail(userEmail));

        // user 값을 반환한다
        return user;
    }
}

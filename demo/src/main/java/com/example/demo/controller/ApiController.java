package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.example.demo.service.EmailcheckService;
import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
//  /api로 들어오는것들은 밑에 클래스에서 받아올수있다.
@RequestMapping("/api")
public class ApiController {

    //객체 자동생성 Autowired
    @Autowired
    EmailcheckService emailcheckservice;

    //get방식 
    @GetMapping("/get")
    @ResponseBody
    // 값이 check 인것을 파라미터로 받아온다.
    public User GETresult(@RequestParam(value = "check") String userEmail) {

        // User 객체생성
        User user = new User();

        user.setEmail(userEmail);
        user.setResult(emailcheckservice.isValidEmail(userEmail));
        
       

        // user 값을 반환한다
        return user;
    }

    //post 방식
    @PostMapping("/post")
    @ResponseBody
    public User POSTresult(@RequestParam User user) throws Exception {
        String isValid = emailcheckservice.isValidEmail(user.getEmail());
        User user2 = new User();
        user2.setEmail(user.getEmail());
        user2.setResult(isValid);

        return user2;
    }
    
    
  
}
    

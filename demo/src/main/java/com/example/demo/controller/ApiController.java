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
import org.springframework.web.bind.annotation.RequestBody;



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
    public User GETresult(@RequestParam(value = "check") String userEmail)throws Exception {

        //3초 지연
        Thread.sleep(3000);

        // User 객체생성
        User userResult = new User();

        userResult.setEmail(userEmail);
        userResult.setResult(emailcheckservice.isValidEmail(userEmail));
        
       

        // user 값을 반환한다
        return userResult;
    }

    //post 방식
    @PostMapping("/post")
    @ResponseBody
    public User POSTresult(@RequestBody User user) throws Exception {

        //3초 지연
        Thread.sleep(3000);

        String isValid = emailcheckservice.isValidEmail(user.getEmail());
        User userResult = new User();
        userResult.setEmail(user.getEmail());
        userResult.setResult(isValid);

        return userResult;
    }
    
    
  
}
    

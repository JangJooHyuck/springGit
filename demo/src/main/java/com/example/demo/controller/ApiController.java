package com.example.demo.controller;

import com.example.demo.service.dbService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import com.example.demo.model.Userlog;
import com.example.demo.service.EmailcheckService;

import java.util.List;




@Controller
//  /api로 들어오는것들은 밑에 클래스에서 받아올수있다.
@RequestMapping("/api")
public class ApiController {

    //객체 자동생성 Autowired
    @Autowired
    EmailcheckService emailcheckservice;

    @Autowired
    dbService dbservice;

    Userlog userlog = new Userlog();

    //get방식
    @GetMapping("/get")
    @ResponseBody
    // 값이 check 인것을 파라미터로 받아온다.
    public Userlog getResult(@RequestParam(value = "check") String userEmail, @RequestParam(value="userIP") String UserIP ) throws Exception {

        //3초 지연
        Thread.sleep(3000);
        Boolean usermailboolean = emailcheckservice.isValidEmail(userEmail);
        userlog.setDate(dbservice.findNow());
        userlog.setIdx(dbservice.findIdx()+1);
        userlog.setResult(dbservice.logBoolean(usermailboolean));
        userlog.setMail(userEmail);
        userlog.setUserIP(UserIP);
        //db에 로그 저장
        dbservice.insertLog(userlog);
        return userlog;
    }

    //post 방식
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Userlog POSTresult(@RequestBody Userlog userlog) throws Exception {

        //3초 지연
        Thread.sleep(3000);

        Boolean usermailboolean = emailcheckservice.isValidEmail(userlog.getResult());
        userlog.setDate(dbservice.findNow());
        userlog.setIdx(dbservice.findIdx()+1);
        userlog.setMail(dbservice.logBoolean(usermailboolean));

        //db에 로그 저장
        dbservice.insertLog(userlog);
        return userlog;

    }
     // select * from log order by idx desc limit start , 10
     @GetMapping("/ajax")
     @ResponseBody
     public List<Userlog> getLog(@RequestParam(value = "pageNumber" , defaultValue = "1") int pageNumber) throws Exception{
         return dbservice.getAllLog((pageNumber-1) * 10, 10);
     }

     // total page 찾아주는 api 현재 databse count 에서 보여줄 목록(10)을 나누고 나머지가 > 0 +1 or 10 나눈그대로 리턴
     @GetMapping("/findIdxCount")
     @ResponseBody
     public int getCount(){
         return dbservice.findIdx()%10 > 0 ? dbservice.findIdx()/10 + 1 : dbservice.findIdx()/10;
     }
}


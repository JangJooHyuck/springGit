package com.example.demo.service;

import java.util.List;

import com.example.demo.mapper.UserLogMp;
import com.example.demo.model.Userlog;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class dbService {

    private UserLogMp userlogmp;

    public List<Userlog> getAllLog(int start, int end){
        return userlogmp.findAll(start, end);
    }
    public void insertLog(Userlog userLog){
        userlogmp.Insert(userLog);
    }

    public int findIdx(){
        return userlogmp.findIdx();
    }

    public String findNow(){
        return userlogmp.findNow();
    }

    public String logBoolean(Boolean checkResult){
        return checkResult ? "success" : "fail";
    }

}

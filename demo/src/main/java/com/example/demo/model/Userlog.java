package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// userlog DTO
@Getter
@Setter
// 생성자  annotation
@AllArgsConstructor
@NoArgsConstructor
public class Userlog {

    int idx;
    String Date;
    String UserIP;
    String Mail;
    String Result;
    String Word;

}

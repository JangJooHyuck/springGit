package com.example.demo.service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.stereotype.Service;

@Service
public class EmailcheckSV {

    // email 정규식 정의
    static String Emailpattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    public boolean isValidEmail(String userEmail) {

        Pattern pattern = Pattern.compile(Emailpattern);
        Matcher matcher = pattern.matcher(userEmail);

        return matcher.find();
    }
}

package com.example.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter

// 생성자  annotation
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String result;
    
}

package com.example.demo.service;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Paging {

    int currentPage; // 현재페이지
    int totalPage; // 총페이지
}

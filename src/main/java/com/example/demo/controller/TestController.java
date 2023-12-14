package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yhd")
public class TestController {
    @RequestMapping("/aaa")
    public void methodA(){
        System.out.println("TestController 클래스의 메소드 A가 실행되었다.");
    }
}

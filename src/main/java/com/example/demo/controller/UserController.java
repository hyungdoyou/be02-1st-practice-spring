package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(){
        System.out.println("로그인 기능 실행");
        return "login";
    }

    @RequestMapping("/signin")
    public String signin(){
        System.out.println("회원가입 기능 실행");
        return "signin";
    }
}

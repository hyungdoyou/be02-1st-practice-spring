package com.example.demo.service;

import com.example.demo.model.UserLoginDto;
import com.example.demo.model.UserSignUpDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // 서비스 아키텍처

    // 로그인
    public boolean login(UserLoginDto userLoginDto) {
        if(userLoginDto.getId().equals("test01")
                && userLoginDto.getPw().equals("qwer1234")) {
            return true;
        } else {
            return false;
        }
    }
    // 회원가입
    public boolean signUp(UserSignUpDto userSignUpDto) {
        if(!userSignUpDto.getId().isEmpty() && !userSignUpDto.getPw().isEmpty()
        && !userSignUpDto.getName().isEmpty() && !userSignUpDto.getEmail().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.model.UserLoginDto;
import com.example.demo.model.UserSignUpDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 로그인
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Object> login(UserLoginDto userLoginDto) {

        if(userService.login(userLoginDto)) {
            return ResponseEntity.ok().body(userLoginDto);
        } else {
            return ResponseEntity.badRequest().body(userLoginDto);
        }
    }

    // 회원가입
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<Object> signUp(UserSignUpDto userSignUpDto) {

        if(userService.signUp(userSignUpDto)) {
            return ResponseEntity.ok().body(userSignUpDto);
        }
        return ResponseEntity.badRequest().body(userSignUpDto);
    }

}

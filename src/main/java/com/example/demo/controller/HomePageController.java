package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    @RequestMapping("homepage")
    public String homepage() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }
    @RequestMapping("/homepage/product")
    public String product() {
        return "product";
    }
}

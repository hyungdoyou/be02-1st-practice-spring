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

    //@Autowired
    //UserService userService;

    // private final 을 쓰면 의존성 주입이 안되어있다는거 자체를 알기도 편하고 바꿀수도 없다.
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    @RequestMapping("homepage")
    public String homepage() {
        return "main/index";
    }
     */
    /* 이제 로그인 페이지를 띄워주는것은 필요하지 않다. 로그인을 처리만 해주면 된다. (백엔드기 때문)
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        System.out.println("로그인 페이지");
        return "user/login";
        //return "redirect:user/login";
    }
     */

    /*
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    // 이렇게 해주는 이유 : 변수를 받을 값이 많아질 수 있기때문에 별도의 클래스를 만들어서 관리
    public String login(UserLoginDto userLoginDto) {

        if(userService.login(userLoginDto)) {
            return "로그인 성공";
        } else {
            return "로그인 실패";
        }
    }
     */



    @RequestMapping(method = RequestMethod.POST, value = "/login")
    // 이렇게 해주는 이유 : 변수를 받을 값이 많아질 수 있기때문에 별도의 클래스를 만들어서 관리
    public ResponseEntity<Object> login(UserLoginDto userLoginDto) {

        if(userService.login(userLoginDto)) {
            //return ResponseEntity.ok().body("로그인 성공");
            return ResponseEntity.ok().body(userLoginDto);
        } else {
            //return ResponseEntity.badRequest().body("로그인 실패");
            return ResponseEntity.badRequest().body(userLoginDto);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<Object> signUp(UserSignUpDto userSignUpDto) {

        if(userService.signUp(userSignUpDto)) {
            //return ResponseEntity.ok().body("회원가입 성공");
            // 이렇게 객체 자체를 넣어주면 응답할때 자동으로 JSON 형태로 반환해줌
            return ResponseEntity.ok().body(userSignUpDto);
        }
        return ResponseEntity.badRequest().body(userSignUpDto);
    }

}

package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor // 생성자 생성 어노테이션
@Builder
public class UserLoginDto {
    private String id;
    private String pw;

}

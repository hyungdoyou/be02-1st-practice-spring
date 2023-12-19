package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserLoginDto {
    private String id;
    private String pw;

}

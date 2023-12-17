package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetReviewRes {
    private Integer review_idx;
    private Integer product_idx;
    private Integer user_idx;
    private String review_content;
    private String review_photo;
    private Integer evaluation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    private Integer status;
}

package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

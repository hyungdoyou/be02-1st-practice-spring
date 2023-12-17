package com.example.demo.controller;

import com.example.demo.model.GetReviewRes;
import com.example.demo.model.PostReviewReq;
import com.example.demo.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Object> create(PostReviewReq postReviewReq) {
        int result = reviewService.create(postReviewReq);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity<Object> list() {
        List<GetReviewRes> getReviewResList = reviewService.list();
        return ResponseEntity.ok().body(getReviewResList);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity<Object> update(PostReviewReq postReviewReq) {
        int result = reviewService.update(postReviewReq);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public ResponseEntity<Object> delete(GetReviewRes getReviewRes) {
        int result = reviewService.delete(getReviewRes);
        return ResponseEntity.ok().body(result);
    }
}

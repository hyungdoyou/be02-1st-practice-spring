package com.example.demo.service;

import com.example.demo.dao.ReviewDao;
import com.example.demo.model.GetReviewRes;
import com.example.demo.model.PostReviewReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    ReviewDao reviewDao;

    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public int create(PostReviewReq postReviewReq) {
        return reviewDao.Create(postReviewReq);
    }

    public List<GetReviewRes> list() {
        return reviewDao.list();
    }

    public int update(PostReviewReq postReviewReq) {
        return reviewDao.Update(postReviewReq);
    }

    public int delete(GetReviewRes getReviewRes) {
        return reviewDao.Delete(getReviewRes);
    }
}

package com.example.demo.dao;

import com.example.demo.model.GetReviewRes;
import com.example.demo.model.PostReviewReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ReviewDao {
    private final JdbcTemplate jdbcTemplate;

    public ReviewDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // CREATE
    public int Create(PostReviewReq postReviewReq) {
        String sql = "INSERT INTO Review(product_idx, user_idx, review_content, review_photo, evaluation, createdAt, updatedAt, status)  VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] sqlParams = new Object[]{
                postReviewReq.getProduct_idx(),
                postReviewReq.getUser_idx(),
                postReviewReq.getReview_content(),
                postReviewReq.getReview_photo(),
                postReviewReq.getEvaluation(),
                postReviewReq.getCreatedAt(),
                postReviewReq.getUpdatedAt(),
                postReviewReq.getStatus()
        };
        return jdbcTemplate.update(sql, sqlParams);
    }

    public List<GetReviewRes> list() {
        String sql = "SELECT * FROM Review";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> GetReviewRes.builder()
                        .review_idx(rs.getInt("review_idx"))
                        .product_idx(rs.getInt("product_idx"))
                        .user_idx(rs.getInt("user_idx"))
                        .review_content(rs.getString("review_content"))
                        .review_photo(rs.getString("review_photo"))
                        .evaluation(rs.getInt("evaluation"))
                        .createdAt(rs.getDate("createdAt"))
                        .updatedAt(rs.getDate("updatedAt"))
                        .status(rs.getInt("status"))
                        .build()
                );
    }

    public int Update(PostReviewReq postReviewReq) {
        String sql = "UPDATE Review SET product_idx = ? WHERE user_idx = ?";
        Object[] sqlParams = new Object[]{
                postReviewReq.getProduct_idx(),
                postReviewReq.getUser_idx()
        };
        return jdbcTemplate.update(sql, sqlParams);
    }

    public int Delete(GetReviewRes getReviewRes) {
        String sql = "DELETE FROM Review WHERE user_idx = ?";
        Object[] sqlParams = new Object[]{
                getReviewRes.getUser_idx()
        };
        return jdbcTemplate.update(sql, sqlParams);
    }
}

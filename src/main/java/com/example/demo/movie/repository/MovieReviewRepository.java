package com.example.demo.movie.repository;

import com.example.demo.movie.model.entity.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {
}

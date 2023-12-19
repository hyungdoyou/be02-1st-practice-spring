package com.example.demo.movie.model;

import com.example.demo.movie.model.entity.MovieReview;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class MovieDto {
    private Integer id;
    private String name;
    private Integer price;

    private List<MovieReviewDto> movieReviewDtoList = new ArrayList<>();
}

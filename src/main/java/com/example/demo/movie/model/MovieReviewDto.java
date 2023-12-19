package com.example.demo.movie.model;

import com.example.demo.movie.model.entity.Movie;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieReviewDto {
    private Integer id;
    private Integer star;
    private String text;

    private MovieDto movieDto;
}

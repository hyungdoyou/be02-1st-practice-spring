package com.example.demo.movie.service;


import com.example.demo.movie.model.MovieDto;
import com.example.demo.movie.model.MovieReviewDto;
import com.example.demo.movie.model.entity.Movie;
import com.example.demo.movie.model.entity.MovieReview;
import com.example.demo.movie.repository.MovieRepository;
import com.example.demo.movie.repository.MovieReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieReviewService {


    MovieReviewRepository movieReviewRepository;

    public MovieReviewService(MovieReviewRepository movieReviewRepository) {
        this.movieReviewRepository = movieReviewRepository;
    }

    // CREATE
    public void create(Integer movieid, MovieReviewDto movieReviewDto) {
        movieReviewRepository.save(MovieReview.builder()
                        .movie(Movie.builder().id(movieid).build())
                        .star(movieReviewDto.getStar())
                        .text(movieReviewDto.getText())
                        .build());
    }

    // LIST 조회
    public List<MovieReviewDto> list() {
        List<MovieReview> result = movieReviewRepository.findAll();

        List<MovieReviewDto> movieReviewDtos = new ArrayList<>();

        for (MovieReview movieReview:result) {
            Movie movie = movieReview.getMovie();
            MovieDto movieDto = MovieDto.builder()
                    .id(movie.getId())
                    .name(movie.getName())
                    .price(movie.getPrice())
                    .build();

            MovieReviewDto movieReviewDto = MovieReviewDto.builder()
                    .id(movieReview.getId())
                    .star(movieReview.getStar())
                    .text(movieReview.getText())
                    .movieDto(movieDto)
                    .build();
            movieReviewDtos.add(movieReviewDto);
        }

        return movieReviewDtos;
    }

    // READ
    public MovieReviewDto read(Integer id) {
        Optional<MovieReview> result = movieReviewRepository.findById(id);
        if(result.isPresent()) {
            MovieReview movieReview = result.get();

            return MovieReviewDto.builder()
                    .id(movieReview.getId())
                    .star(movieReview.getStar())
                    .text(movieReview.getText())
                    .movieDto(MovieDto.builder()
                            .id(movieReview.getMovie().getId())
                            .name(movieReview.getMovie().getName())
                            .price(movieReview.getMovie().getPrice())
                            .build())
                    .build();
        } else {
            return null;
        }
    }

    // UPDATE
    public void update(MovieReviewDto movieReviewDto) {
        Optional<MovieReview> result = movieReviewRepository.findById(movieReviewDto.getId());

        if(result.isPresent()) {
            MovieReview movieReview = result.get();
            movieReview.setStar(movieReviewDto.getStar());
            movieReview.setText(movieReviewDto.getText());
            movieReviewRepository.save(movieReview);
        }
    }

    // DELETE
    public void delete(Integer id) {
        movieReviewRepository.delete(MovieReview.builder().id(id).build());
    }
}

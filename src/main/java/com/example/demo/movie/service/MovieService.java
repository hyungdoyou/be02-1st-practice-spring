package com.example.demo.movie.service;

import com.example.demo.movie.model.MovieDto;
import com.example.demo.movie.model.MovieReviewDto;
import com.example.demo.movie.model.entity.Movie;
import com.example.demo.movie.model.entity.MovieReview;
import com.example.demo.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void create(MovieDto movieDto) {

        movieRepository.save(Movie.builder()
                .name(movieDto.getName())
                .price(movieDto.getPrice())
                .build());
    }

    public List<MovieDto> list() {
        List<Movie> result = movieRepository.findAll();

        List<MovieDto> movieDtos = new ArrayList<>();
        for(Movie movie : result) {
            List<MovieReviewDto> movieReviewDtos = new ArrayList<>();
            List<MovieReview> movieReviewList = movie.getMovieReviewList();

            for(MovieReview movieReview : movieReviewList) {
                MovieReviewDto movieReviewDto = MovieReviewDto.builder()
                        .id(movieReview.getId())
                        .star(movieReview.getStar())
                        .text(movieReview.getText())
                        .build();

                movieReviewDtos.add(movieReviewDto);
            }

            MovieDto movieDto = MovieDto.builder()
                    .id(movie.getId())
                    .name(movie.getName())
                    .price(movie.getPrice())
                    .movieReviewDtoList(movieReviewDtos)
                    .build();
            movieDtos.add(movieDto);
        }

        return movieDtos;
    }


    public MovieDto read(Integer id) {
        Optional<Movie> result = movieRepository.findById(id);
        if (result.isPresent()) {
            Movie movie = result.get();

            List<MovieReviewDto> movieReviewDtos = new ArrayList<>();

            for(MovieReview movieReview : movie.getMovieReviewList()) {
                movieReviewDtos.add(MovieReviewDto.builder()
                        .id(movieReview.getId())
                        .star(movieReview.getStar())
                        .text(movieReview.getText())
                        .build()
                );
            }

            return MovieDto.builder()
                    .id(movie.getId())
                    .price(movie.getPrice())
                    .name(movie.getName())
                    .movieReviewDtoList(movieReviewDtos)
                    .build();
        } else {
            return null;
        }
    }

    public void update(MovieDto movieDto) {
        movieRepository.save(Movie.builder()
                .id(movieDto.getId())
                .name(movieDto.getName())
                .price(movieDto.getPrice())
                .build());
    }

    public void delete(Integer id) {
        movieRepository.delete(Movie.builder().id(id).build());
    }
}

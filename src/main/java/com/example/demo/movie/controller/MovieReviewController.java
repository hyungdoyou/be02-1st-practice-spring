package com.example.demo.movie.controller;


import com.example.demo.movie.model.MovieReviewDto;
import com.example.demo.movie.service.MovieReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie_review")
public class MovieReviewController {

    MovieReviewService movieReviewService;

    public MovieReviewController(MovieReviewService movieReviewService) {
        this.movieReviewService = movieReviewService;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(Integer movieid, MovieReviewDto movieReviewDto) {
        movieReviewService.create(movieid, movieReviewDto);

        return ResponseEntity.ok().body("리뷰 작성 성공");
    }

    // LIST 조회
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(movieReviewService.list());
    }

    // READ 조회
    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(Integer id) {
        return ResponseEntity.ok().body(movieReviewService.read(id));
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(MovieReviewDto movieReviewDto) {
        movieReviewService.update(movieReviewDto);

        return ResponseEntity.ok().body("리뷰 수정 성공");
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity delete(Integer id) {
        movieReviewService.delete(id);
        return ResponseEntity.ok().body("리뷰 삭제 성공");
    }
}

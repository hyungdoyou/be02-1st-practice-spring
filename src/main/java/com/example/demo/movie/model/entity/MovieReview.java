package com.example.demo.movie.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer star;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Movie_id")
    private Movie movie;

}

package com.movieinfoservice.movieinfo.controller;

import com.movieinfoservice.movieinfo.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieinfo")
public class MovieInfo {
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {
        return new Movie(movieId, "batman");
    }
}

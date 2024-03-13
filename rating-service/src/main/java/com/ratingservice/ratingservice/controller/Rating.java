package com.ratingservice.ratingservice.controller;

import com.ratingservice.ratingservice.model.RatingItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class Rating {

    @GetMapping("/allmovies")
    public RatingItem[] getAllRatings() {
        return new RatingItem[]{
                new RatingItem("111", 4),
                new RatingItem("2222", 3)
        };
    }
//    @GetMapping("/{movieId}")
//    public RatingItem getRating(@PathVariable String movieId) {
//        return new RatingItem(movieId, 4);
//    }

}

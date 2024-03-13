package com.catalogservice.catalogservice.controller;

import com.catalogservice.catalogservice.model.CatalogItem;
import com.catalogservice.catalogservice.model.Movie;
import com.catalogservice.catalogservice.model.RatingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@RequestMapping("/catalog")
@RestController
public class Catalog {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public Catalog(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    private List<RatingItem> getListOfRatings() {
        try {
            return webClientBuilder.build()
                    .get()
                    .uri("http://rating-service/rating/allmovies")
                    .retrieve()
                    .bodyToFlux(RatingItem.class)
                    .collectList()
                    .block();
        } catch (Exception e) {


            return Collections.emptyList();
        }
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable int userId) {
        List<RatingItem> ratings = getListOfRatings();
        return ratings.stream().map(rating -> {
            try {
                Movie movie = webClientBuilder.build()
                        .get()
                        .uri("http://movie-info/movieinfo/" + rating.getMovieId())
                        .retrieve()
                        .bodyToMono(Movie.class)
                        .block();
                if (movie != null) {
                    return new CatalogItem(movie.getName(), "desc", rating.getRateNumber());
                } else {
                    return new CatalogItem("No Movie", "No Desc", 0);
                }
            } catch (Exception e) {
              

                return new CatalogItem("No Movie", "No Desc", 0);
            }
        }).toList();
    }
}

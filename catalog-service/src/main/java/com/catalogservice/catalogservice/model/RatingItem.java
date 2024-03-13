package com.catalogservice.catalogservice.model;

public class RatingItem {

        private String movieId ;
        private int rateNumber ;

        public RatingItem(String movieId, int rateNumber) {
            this.movieId = movieId;
            this.rateNumber = rateNumber;
        }

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public int getRateNumber() {
            return rateNumber;
        }

        public void setRateNumber(int rateNumber) {
            this.rateNumber = rateNumber;
        }
    }


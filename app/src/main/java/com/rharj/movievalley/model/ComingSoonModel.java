package com.rharj.movievalley.model;

public class ComingSoonModel {

    private int movieImage;
    private String movieName;
    private String movieCategory;

    public int getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(int movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public ComingSoonModel() {
    }

    public ComingSoonModel(int movieImage, String movieName, String movieCategory) {
        this.movieImage = movieImage;
        this.movieName = movieName;
        this.movieCategory = movieCategory;

    }
}

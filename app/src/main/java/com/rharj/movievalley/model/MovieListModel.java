package com.rharj.movievalley.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MovieListModel implements Serializable {

    private String title;
    private String category;
    private String rating;
    private String language;
    private String details;
    private String viewType;
    private String duration;
    private String releaseDate;
    private int imageUrl;

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MovieListModel(){}
    public MovieListModel(String title, String category, String rating, String language, String
            details, String viewType, String duration, String releaseDate, int imageUrl) {
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.language = language;
        this.details = details;
        this.viewType = viewType;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}

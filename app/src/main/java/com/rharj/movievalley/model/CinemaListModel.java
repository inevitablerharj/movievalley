package com.rharj.movievalley.model;

public class CinemaListModel {

    private String cinemaName;
    private String cinemaAddress;

    public CinemaListModel() {
    }

    public CinemaListModel(String cinemaName, String cinemaAddress) {
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
    }

    public String getCinemaName() {

        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }
}

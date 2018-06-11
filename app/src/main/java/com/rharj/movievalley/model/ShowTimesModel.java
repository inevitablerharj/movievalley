package com.rharj.movievalley.model;

public class ShowTimesModel {

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getShow_times() {
        return show_times;
    }

    public void setShow_times(String show_times) {
        this.show_times = show_times;
    }

    public String getGeo_location() {
        return geo_location;
    }

    public void setGeo_location(String geo_location) {
        this.geo_location = geo_location;
    }

    private String cinema_name;
    private String show_times;
    private String geo_location;

    public ShowTimesModel(String cinema_name, String show_times, String geo_location) {
        this.cinema_name = cinema_name;
        this.show_times = show_times;
        this.geo_location = geo_location;
    }

    public ShowTimesModel() {

    }
}

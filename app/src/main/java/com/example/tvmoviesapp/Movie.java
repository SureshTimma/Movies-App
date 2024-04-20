package com.example.tvmoviesapp;

public class Movie {
    private String title;
    private String thumbnailUrl;
    private String videoUrl;

    // Required empty constructor for Firebase
    public Movie() {}

    // Constructor with parameters (If you'd like one)
    public Movie(String title, String videoUrl) {
        this.title = title;
        this.videoUrl = videoUrl;
        // You might have a thumbnailUrl property as well. If so, add the following line:
        // this.thumbnailUrl = ""; // Initialize to an empty string for now
    }


    // Getters
    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    // Setters (If you need them)
    // ...
}

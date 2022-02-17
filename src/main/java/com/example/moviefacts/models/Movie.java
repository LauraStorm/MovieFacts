package com.example.moviefacts.models;

public class Movie implements Comparable<Movie> {
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean hasWonAwards;

    //Constructor
    public Movie (int year, int length, String title,String subject, int popularity, boolean hasWonAwards){
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.hasWonAwards = hasWonAwards;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isHasWonAwards() {
        return hasWonAwards;
    }

    public void setHasWonAwards(boolean hasWonAwards) {
        this.hasWonAwards = hasWonAwards;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Movie aMovie) {                     //compareTo så højeste popularity er øverst
        if (this.popularity < aMovie.getPopularity()){
            return 1;
        } else if (this.popularity > aMovie.getPopularity()){
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Movie: year =" + year +
                ", length =" + length +
                ", title =" + title  +
                ", subject =" + subject  +
                ", popularity =" + popularity +
                ", awards = " + hasWonAwards;
    }


}

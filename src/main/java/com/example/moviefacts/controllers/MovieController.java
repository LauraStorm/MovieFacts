package com.example.moviefacts.controllers;

import com.example.moviefacts.models.Movie;
import com.example.moviefacts.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
//The controller is responsible to receive request and return responses to the client//
@RestController  //
public class MovieController {
    private MovieService movieService = new MovieService();

    //Controller methods
    //3.1
    @GetMapping("/")
    public String index(){
        return "Hello World - welcome to my movie analysis application";
    }

    //3.2 /getFirst
    @GetMapping("/getFirst")
    public String getFirstMovieTitle(){
        String firstMovieTitle = movieService.getFirstMovieFromFile();
        return firstMovieTitle;
    }

    //3.3 /getRandom
    @GetMapping("/getRandom")
    public String getRandomMovieTitle(){
        String randomMovieTitle = movieService.getRandomMovieTitle();
        return randomMovieTitle;
    }

    //3.4 /getTenSortByPopularity
    @GetMapping("/getTenSortByPopularity")
    public ArrayList<Movie> top10ByPopularity(){
        ArrayList<Movie> sortedList = movieService.getTenMoviesSortedByPopularity();
        return sortedList;
    }

    //3.5 /howManyWonAnAward
    @GetMapping("/howManyWonAnAward")
    public String getHowManyWonAnAward(){
        String totalAwards = movieService.getHowManyWonAwards();
        return totalAwards;
    }
}

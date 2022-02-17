package com.example.moviefacts.services;

import com.example.moviefacts.models.Movie;
import com.example.moviefacts.repositories.MovieDataRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MovieService {
    private MovieDataRepository movieDataRepository = new MovieDataRepository();
    private Random random = new Random();

    //Constructor
    public MovieService(){
        movieDataRepository.readCSVFile();      //readFile er i constructoren, så den bliver læst når der bliver oprettet en instans a MovieService
                                                //Det gør at filen bliver læst, og der kan 'arbejdes' med listen i de forskellige metoder i MovieService
    }

    //3.2
    public String getFirstMovieFromFile(){
        Movie firstMovie = movieDataRepository.movies.get(0);
        String firstMovieTitle = firstMovie.getTitle();
        return "First movie is: " + firstMovieTitle;
    }

    //3.3
    public String getRandomMovieTitle(){
        ArrayList<Movie> movies = movieDataRepository.movies;
        int randomNumber = random.nextInt(movies.size());
        String movieTitle = "";

        for (int i = 0; i < movies.size(); i++) {
            Movie randomIndexMovie = movies.get(randomNumber);
            movieTitle = randomIndexMovie.getTitle();
        }
        return "A random movie title: " + movieTitle;
    }

    //3.4
    public ArrayList<Movie> getTenMoviesSortedByPopularity(){
        ArrayList<Movie> movies = movieDataRepository.movies;       //all movies from list
        ArrayList<Movie> randomMovies = new ArrayList<Movie>();     //random 10 movies

        int moviesToAdd = 10;                                        //Der skal addes 10 random movies

        for (int i = 1; i <= moviesToAdd; i++) {
            int randomNumber = random.nextInt(movies.size());       //Random number
            Movie movie = movies.get(randomNumber);
            randomMovies.add(movie);                                //adder random movie til ny liste
        }
        Collections.sort(randomMovies);                             //Sortere - Se compareTo Metode i Movie class
        return randomMovies;
    }

    //3.5
    public String getHowManyWonAwards(){
        ArrayList<Movie> movies = movieDataRepository.movies;

        int countAmountOfAwards = 0;        //counts movies who has won an award

        for (int i = 0; i <movies.size() ; i++) {
            Boolean currentMovie = movies.get(i).isHasWonAwards();
            if (currentMovie.equals(true)){
                countAmountOfAwards++;
            }
        }
        return "Total Won Awards: " + countAmountOfAwards;
    }








}

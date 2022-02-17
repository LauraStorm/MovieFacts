package com.example.moviefacts.repositories;

import com.example.moviefacts.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDataRepository {
    //Method to get data from file
   public ArrayList<Movie> movies = new ArrayList<Movie>();

    public void readCSVFile (){
        File moveFile = new File("src/main/resources/imdb-data.csv");

        try {
            Scanner sc = new Scanner(moveFile);
            sc.nextLine();                                       //springer første linje over, da det ikke er en film

            while (sc.hasNextLine()){                            //Læser hver linje, så længe der er en linje
                String line = sc.nextLine();                    //Læser første linje, så næste og så næste, og videre og videre

                String [] stringAsArray = line.split(";");  //Deler linjen op i et array.

                int year = Integer.parseInt(stringAsArray[0]);     //Placere de forskellige oplysninger ved hjælp af index placringen
                int length = Integer.parseInt(stringAsArray[1]);
                String title = stringAsArray[2];
                String subject = stringAsArray[3];
                int popularity = Integer.parseInt(stringAsArray[4]);
                boolean hasAward = stringAsArray[5].equals("Yes");      //hvis der står 'Yes' i filen, laves det om til en boolean 'true'

                Movie currentMovie = new Movie(year,length,title,subject,popularity,hasAward);
                movies.add(currentMovie);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Movie File not found!");
            e.printStackTrace();
        }

    }

}

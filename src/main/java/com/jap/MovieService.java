package com.jap;

import java.util.*;

public class MovieService {

    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        Map<Movie, Integer> map = movieService.getMovieWithRating();
        Set<String> set = movieService.getMovieNameWithRating4(map, 4);
        System.out.println("Rating 4" + set);
        Map<String, String> map1 = movieService.getAllMoviesWithComedy(map);
        System.out.println("Comedy Movie " + map1);
        List<String> list = movieService.getMovieWithHighestRating(map);
        System.out.println("--------------");
        System.out.println("Highest Rating " + list);
    }

    // This function is creating a Map object and adding the movie name as key and rating as value.
    public Map<Movie, Integer> getMovieWithRating() {

        //create five movie object by calling Movie class parameterized constructor
        Movie movie1 = new Movie(1, "Avatar", "science", "23/05/2007");
        Movie movie2 = new Movie(2, "Goodbye", "comedy", "13/05/2017");
        Movie movie3 = new Movie(3, "Thor", "action", "23/05/1907");
        Movie movie4 = new Movie(4, "IronMan", "action", "23/05/2010");
        Movie movie5 = new Movie(5, "Lord Of The Rings", "history", "13/05/2012");


        //create HashMap object and add all the Movie object inside it
        Map<Movie, Integer> movieDetails = new HashMap<>();
        //Key will be movie object and value will be rating ranging from 1 to 5
        movieDetails.put(movie1, 4);
        movieDetails.put(movie2, 3);
        movieDetails.put(movie3, 2);
        movieDetails.put(movie4, 5);
        movieDetails.put(movie5, 3);

        //return the HashMap object
        return movieDetails;
    }

    /**
     * We iterate through the map object using entrySet() method and retrieve all the movies name having rating as 4 and
     * store the movie name in TreeSet object
     *
     * @param map    The map object that contains the movie name and its rating.
     * @param rating The rating of the movie.
     * @return A TreeSet object containing all the movie names having rating as 4.
     */
    public Set<String> getMovieNameWithRating4(Map<Movie, Integer> map, int rating) {
        //Create a TreeSet object
        TreeSet<String> movieWithSpecificRatings = new TreeSet<>();

        //Use entrySet() method to iterate through the map object
        for (Map.Entry<Movie, Integer> movieList : map.entrySet()) {
            Movie key = movieList.getKey();
            //retrieve all the movies name having rating as 4
            if (movieList.getValue() == rating) {
                //Store the movie name in TreeSet object
                movieWithSpecificRatings.add(key.getMovieName());
            }
        }
        //return the TreeSet object
        return movieWithSpecificRatings;
    }

    /**
     * The above function returns the name of the movie with the highest rating.
     *
     * @param map A Map object that contains the movie name and its rating
     * @return A list of movies with the highest rating
     */
    public List<String> getMovieWithHighestRating(Map<Movie, Integer> map) {
        //Create a ArrayList object of type String
        ArrayList<String> movieWithHighestRating = new ArrayList<>();
        Movie movie = new Movie();
        //get the first value from the map and store it in the variable max
        Object[] ratings = map.values().toArray();
        // Use entrySet().iterator().next() method to retrieve the first value of Map object
        for (Map.Entry<Movie, Integer> movies : map.entrySet()) {
            Integer max = (Integer) ratings[0];
            if ((max < movies.getValue())) {
                max = movies.getValue();
                //get the name of the movie with the highest rating and add it in the List created
                movieWithHighestRating.add(movie.getMovieName());
            }
        }
        //return the List object

        return movieWithHighestRating;
    }

    /**
     * This function takes a Map object as an argument and returns a Map object
     *
     * @param map A Map object that contains the movie name as key and the release date as value.
     * @return A Map object with movie name as key and release date as value.
     */
    public Map<String, String> getAllMoviesWithComedy(Map<Movie, Integer> map) {
        //Create a Map object
        Map<String, String> comedyMovies = new HashMap<>();
        //use entrySet to iterate through the Map object
        for (Map.Entry<Movie, Integer> entries : map.entrySet()) {

            //get all the movies name and their released date for the movie of genre "comedy"
            if (entries.getKey().getGenre().equals("comedy")) {

                //store movie name with release date in the above created Map object and return the Map object
                comedyMovies.put(entries.getKey().getMovieName(), entries.getKey().getReleaseDate());
            }
        }

        return comedyMovies;

    }
}

package Homework.Homework3;

import java.util.*;

/**
 * Models a Hash Set of movies
 */
public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {

    /**
     * Sorts movies using HashSet and then puts the HashSet into an ArrayList
     *
     * @return ArrayList of movies
     */
    public ArrayList<Movie> getSorted() {
        HashSet<Movie> hashSetMovies = new HashSet<>(this);
        ArrayList<Movie> arrayListMovies = new ArrayList<>(hashSetMovies);
        return arrayListMovies;
    }

    //Tests the HashFilmArchive class
    public static void main(String[] args) {
        HashFilmArchive archive = new HashFilmArchive();
        for (Movie m : Movie.getTestMovies()) archive.add(m);
        for (Movie m : archive) System.out.println(m);
        System.out.println("**************");
        for (Movie m : archive.getSorted()) System.out.println(m);
    }
}

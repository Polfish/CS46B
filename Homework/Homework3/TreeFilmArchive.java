package Homework.Homework3;

import java.util.*;

/**
 * Models a Tree Set of movies
 */
public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive {

    /**
     * Puts this TreeSet into an Array List
     *
     * @return ArrayList of movies
     */
    public ArrayList<Movie> getSorted() {
        ArrayList<Movie> arrayListMovies = new ArrayList<>(this);
        return arrayListMovies;
    }

    //Tests the TreeFilmArchive class
    public static void main(String[] args) {
        TreeFilmArchive archive = new TreeFilmArchive();
        for (Movie m : Movie.getTestMovies()) archive.add(m);
        for (Movie m : archive) System.out.println(m);
        System.out.println("**************");
        for (Movie m : archive.getSorted()) System.out.println(m);
    }
}

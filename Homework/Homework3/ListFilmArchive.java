package Homework.Homework3;

import java.util.*;

/**
 * Models an Array List of movies
 */
public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {

    /**
     * Sorts movies using a TreeSet and then puts the TreeSet into an ArrayList
     *
     * @return ArrayList of movies
     */
    public ArrayList<Movie> getSorted() {
        TreeSet<Movie> treeSetMovies = new TreeSet<>(this);
        ArrayList<Movie> arrayListMovies = new ArrayList<>(treeSetMovies);
        return arrayListMovies;
    }

    /**
     * Checks to see whether or not the movie is already added into the list, if it isn't then it is
     * added to the Array List.
     *
     * @param movie movie object
     * @return true if not added and false if already added
     */
    public boolean add(Movie movie) {
    	boolean added = false;
    	if (!this.contains(movie)) {
    		super.add(movie);
    		return true;
    	}
    	return added;
    }

    //Tests the ListFilmArchive class
    public static void main(String[] args) {
        ListFilmArchive archive = new ListFilmArchive();
        for (Movie m : Movie.getTestMovies()) archive.add(m);
        for (Movie m : archive) System.out.println(m);
        System.out.println("**************");
        for (Movie m : archive.getSorted()) System.out.println(m);
    }
}
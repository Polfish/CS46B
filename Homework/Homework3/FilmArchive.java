package Homework.Homework3;

import java.util.*;

/**
 * An interface for movies with two methods: getSorted and add.
 */
public interface FilmArchive {
    ArrayList<Movie> getSorted();

    boolean add(Movie movie);
}

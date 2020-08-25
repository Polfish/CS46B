package Homework.Homework3;

/**
 * Models a movie by name and year.
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private int year;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    /**
     * Compares two movies by title, then year.
     *
     * @param o Movie object
     * @return an integer comparing movies by title, then year
     */
    public int compareTo(Movie o) {
        if (!o.equals(this)) {
        	if (!o.title.equals(title))
				return title.compareTo(o.title);
				else
					return Double.compare(year, o.year);
        }
        else
        	return 0;
    }

    /**
     * Gets the title of the movie.
     *
     * @return title of movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the year of the movie
     *
     * @return year of movie
     */
    public int getYear() {
        return year;
    }

    /**
     * Overrides the equals method.
     *
     * @param o Any object, but in this case, preferably a Movie object
     * @return true if movie titles do not match and false if they do match
     */
    public boolean equals(Object o) {
        Movie movie = (Movie) o;
        if (movie.title.compareTo(title) == 0 && Double.compare(movie.year, year) == 0)
            return true;
        else
            return false;
    }

    /**
     * Overrides the toString method.
     *
     * @return Movie title and year
     */
    public String toString() {
        return "Movie " + title + " " + "(" + year + ")";
    }

    /**
     * An array of 10 movies.
     * Counting from 0, 0 and 1 in this array have the same title, but different years.
     * 2 and 3 have different titles, but the same years.
     * 4 and 5 are the same titles and the same years.
     * 6 through 10 are all personally chosen movies.
     *
     * @return array of 10 movies
     */
    public static Movie[] getTestMovies() {
        Movie aladdin1 = new Movie("Aladdin", 1992);
        Movie aladdin2 = new Movie("Aladdin", 2019);
        Movie sameYear1 = new Movie("Forrest Gump", 1994);
        Movie sameYear2 = new Movie("Shawshank Redemption", 1994);
        Movie sameMovie1 = new Movie("Schindler's list", 1993);
        Movie sameMovie2 = new Movie("Schindler's list", 1993);
        Movie theGreenMile = new Movie("The Green Mile", 1999);
        Movie batmanBegins = new Movie("Batman Begins", 2005);
        Movie thePianist = new Movie("The Pianist", 2002);
        Movie thePrincessBride = new Movie("The Princess Bride", 1984);
        Movie[] movies = {aladdin1, aladdin2, sameYear1, sameYear2, sameMovie1, sameMovie2, theGreenMile
                , batmanBegins, thePianist, thePrincessBride};
        return movies;
    }

    public int hashCode() {
        return title.hashCode() + year;
    }
}

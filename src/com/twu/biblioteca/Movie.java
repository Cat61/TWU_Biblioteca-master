package com.twu.biblioteca;

public class Movie extends LibraryItem
{
    private final String director;
    private final String rating;

    public Movie(String titleArg, String yearArg, String directorArg, String ratingArg)
    {
        super(titleArg, yearArg);
        director = directorArg;
        rating = ratingArg;
    }

    public static String getHeader()
    {
        return  "Movie List:\n"
                + String.format("   %-30s %-10s %-20s %s", "Title", "Year", "Director", "Rating") + "\n"
                + "------------------------------------------------------------------------\n";
    }

    @Override
    public String toString()
    {
        return super.toString() + String.format("%-20s %s", director, rating);
    }
}

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

    @Override
    public String toString()
    {
        return super.toString() + String.format("%-20s %s", director, rating);
    }
}

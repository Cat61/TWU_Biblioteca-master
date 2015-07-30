package com.twu.biblioteca;

public class Movie
{
    private final String title;
    private final String year;
    private final String director;
    private final String rating;
    private boolean available;

    public Movie(String titleArg, String yearArg, String directorArg, String ratingArg)
    {
        title = titleArg;
        year = yearArg;
        director = directorArg;
        rating = ratingArg;
        available = true;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailability(boolean newAvailability)
    {
        available = newAvailability;
    }

    @Override
    public String toString()
    {
        return String.format("%-19s %-19s %-19s %s", title, year, director, rating);
    }
}

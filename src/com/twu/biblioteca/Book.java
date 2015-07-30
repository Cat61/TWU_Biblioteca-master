package com.twu.biblioteca;

public class Book
{
    private final String title;
    private final String author;
    private final String year;
    private boolean available;

    public Book(String titleArg, String authorArg, String yearArg)
    {
        title = titleArg;
        author = authorArg;
        year = yearArg;
        available = true;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public boolean equalsTitle(String t)
    {
        return title.equals(t);
    }

    public void setAvailability(boolean newAvailability)
    {
        available = newAvailability;
    }

    @Override
    public String toString()
    {
        return String.format("%-35s %-35s %s", title, author, year);
    }
}

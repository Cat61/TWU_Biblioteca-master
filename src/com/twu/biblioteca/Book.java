package com.twu.biblioteca;

/**
 * Created by Catherine on 21/07/2015.
 */
public class Book
{
    private String title;
    private String author;
    private String year;

    public Book(String titleArg, String authorArg, String yearArg)
    {
        title = titleArg;
        author = authorArg;
        year = yearArg;
    }

    @Override
    public String toString()
    {
        return String.format("%-35s %-35s %s", title, author, year);
    }
}

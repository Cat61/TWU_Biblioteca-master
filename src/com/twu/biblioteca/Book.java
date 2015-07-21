package com.twu.biblioteca;

/**
 * Created by Catherine on 21/07/2015.
 */
public class Book
{
    private String title;
    private String author;

    public Book(String titleArg, String authorArg)
    {
        title = titleArg;
        author = authorArg;
    }

    @Override
    public String toString()
    {
        return "\"" + title + "\" by " + author;
    }
}

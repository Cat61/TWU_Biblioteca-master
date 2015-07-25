package com.twu.biblioteca;

/**
 * Created by Catherine on 21/07/2015.
 */
public class Book
{
    private String title;
    private String author;
    private String year;
    private boolean available;

    public Book(String titleArg, String authorArg, String yearArg)
    {
        title = titleArg;
        author = authorArg;
        year = yearArg;
        available = true;
    }

    public boolean checkout()
    {
        if(available)
        {
            available = false;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isAvailable()
    {
        return available;
    }

    public boolean equalsTitle(String t)
    {
        return title.equals(t);
    }

    public boolean returnBook()
    {
        if(available)
        {
            return false;
        }
        else
        {
            available = true;
            return true;
        }
    }

    @Override
    public String toString()
    {
        return String.format("%-35s %-35s %s", title, author, year);
    }
}

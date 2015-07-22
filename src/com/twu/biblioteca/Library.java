package com.twu.biblioteca;

import java.util.List;

/**
 * Created by Catherine on 21/07/2015.
 */
public class Library
{
    private List<Book> books;

    public Library()
    {
        books = Generate.listOfBooks();
    }

    public boolean checkout(int index)
    {
        if(isInvalidIndex(index))
        {
            return false;
        }

        return books.get(index).checkout();
    }

    public boolean isAvailable(int index)
    {
        if(isInvalidIndex(index))
        {
            return false;
        }

        return books.get(index).isAvailable();
    }

    private boolean isInvalidIndex(int index)
    {
        return index < 0 || index >= books.size();
    }

    public String printBooks()
    {
        String str = "Book List:\n"
                + String.format("%-35s %-35s %s", "Title", "Author", "Year") + "\n"
                + "----------------------------------------------------------------------------\n";

        for (Book b : books)
        {
            str += b.toString() + "\n";
        }

        return str;
    }
}

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

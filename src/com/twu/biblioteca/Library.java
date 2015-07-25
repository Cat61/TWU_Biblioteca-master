package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Catherine on 21/07/2015.
 */
public class Library
{
    private List<Book> books;
    private List<Book> availableBooks;

    public Library()
    {
        books = Generate.listOfBooks();
        availableBooks = new ArrayList<Book>(books);
    }

    public boolean checkout(int index)
    {
        if(isInvalidIndex(index))
        {
            return false;
        }

        boolean success = availableBooks.get(index).checkout();

        if(success)
        {
            availableBooks.remove(index);
        }

        return success;
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
        return index < 0 || index >= availableBooks.size();
    }

    public String printAllBooks()
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

    public String printAvailableBooks()
    {
        String str = "Book List:\n"
                + String.format("   %-35s %-35s %s", "Title", "Author", "Year") + "\n"
                + "-------------------------------------------------------------------------------\n";

        for (int i = 0; i < availableBooks.size(); i++)
        {
            Book b = availableBooks.get(i);
            str += "(" + (i+1) + ")" + b.toString() + "\n";
        }

        return str;
    }
}

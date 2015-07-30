package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library
{
    private List<Book> books;
    private List<Book> availableBooks;

    private List<Movie> availableMovies;

    public Library()
    {
        books = Generate.listOfBooks();
        availableBooks = new ArrayList<Book>(books);

        availableMovies = Generate.listOfMovies();
    }

    public boolean checkout(int index)
    {
        if(isInvalidIndex(index))
        {
            return false;
        }

        Book b = availableBooks.get(index);

        if (!b.isAvailable())
        {
            return false;
        }

        b.setAvailability(false);
        availableBooks.remove(index);
        return true;

    }

    public boolean isAvailable(int index)
    {
        return !isInvalidIndex(index) && books.get(index).isAvailable();
    }

    private boolean isInvalidIndex(int index)
    {
        return index < 0 || index >= availableBooks.size();
    }

    public boolean returnBook(String title)
    {
        for (Book b : books)
        {
            if(!b.isAvailable() && b.equalsTitle(title))
            {
                b.setAvailability(true);
                availableBooks.add(b);
                return true;
            }
        }
        return false;
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

    public String printAvailableMovies()
    {
        String str = "Movie List:\n"
                + String.format("   %-19s %-19s %-19s %s", "Title", "Year", "Director", "Rating") + "\n"
                + "---------------------------------------------------------------------\n";

        for (int i = 0; i < availableMovies.size(); i++)
        {
            Movie m = availableMovies.get(i);
            str += "(" + (i+1) + ")" + m.toString() + "\n";
        }

        return str;
    }
}

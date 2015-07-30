package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library
{
    private List<Book> books;
    private List<Book> availableBooks;

    private List<Movie> movies;
    private List<Movie> availableMovies;

    public Library()
    {
        books = Generate.listOfBooks();
        availableBooks = new ArrayList<Book>(books);

        movies = Generate.listOfMovies();
        availableMovies = new ArrayList<Movie>(movies);
    }

    public boolean checkoutBook(int index)
    {
        return checkout(availableBooks, index);
    }

    private boolean isInvalidIndex(int index, List list)
    {
        return index < 0 || index >= list.size();
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

    public boolean checkoutMovie(int index)
    {
        return checkout(availableMovies, index);
    }

    public boolean isBookAvailable(int index)
    {
        return books.get(index).isAvailable();
    }

    public String printAvailableBooks()
    {
        String str = "Book List:\n"
                + String.format("   %-30s %-10s %s", "Title", "Year", "Author") + "\n"
                + "-------------------------------------------------------------------------------\n";

        return str + printList(availableBooks);
    }

    public String printAvailableMovies()
    {
        String str = "Movie List:\n"
                + String.format("   %-30s %-10s %-20s %s", "Title", "Year", "Director", "Rating") + "\n"
                + "------------------------------------------------------------------------\n";

        return str + printList(availableMovies);
    }

    private String printList(List list)
    {
        String str = "";

        for (int i = 0; i < list.size(); i++)
        {
            str += "(" + (i+1) + ")" + list.get(i).toString() + "\n";
        }

        return str;
    }

    private boolean checkout(List<? extends LibraryItem> list, int index)
    {
        if(isInvalidIndex(index, list))
        {
            return false;
        }

        LibraryItem item = list.get(index);

        if (!item.isAvailable())
        {
            return false;
        }

        item.setAvailability(false);
        list.remove(index);
        return true;
    }
}

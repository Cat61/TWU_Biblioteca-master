package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Library
{
    private List<Book> books;
    private List<Book> availableBooks;

    private List<Movie> movies;
    private List<Movie> availableMovies;

    public final Map<String, String> users;

    public Library()
    {
        books = Generate.listOfBooks();
        availableBooks = new ArrayList<Book>(books);

        movies = Generate.listOfMovies();
        availableMovies = new ArrayList<Movie>(movies);

        users = Generate.users();
    }

    public enum Item {book, movie}

    public boolean checkout(Item type, int index)
    {
        switch (type)
        {
            case book:
                return checkout(availableBooks, index);
            case movie:
                return checkout(availableMovies, index);
            default:
                return false;
        }
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

    public boolean isBookAvailable(int index)
    {
        return books.get(index).isAvailable();
    }

    public String printTypeList(Item type)
    {
        switch (type)
        {
            case book:
                return printBooksHeader() + printList(availableBooks);
            case movie:
                return printMovieHeader() + printList(availableMovies);
            default:
                return null;
        }
    }

    private boolean isInvalidIndex(int index, List list)
    {
        return index < 0 || index >= list.size();
    }

    private String printBooksHeader()
    {
        return "Book List:\n"
                + String.format("   %-30s %-10s %s", "Title", "Year", "Author") + "\n"
                + "-------------------------------------------------------------------------------\n";
    }

    private String printMovieHeader()
    {
        return  "Movie List:\n"
                + String.format("   %-30s %-10s %-20s %s", "Title", "Year", "Director", "Rating") + "\n"
                + "------------------------------------------------------------------------\n";
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

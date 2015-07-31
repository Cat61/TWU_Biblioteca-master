package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Generate
{
    public static List<Book> listOfBooks()
    {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Kathy Sierra, Bert Bates", "2005"));
        books.add(new Book("Hadoop: The Definitive Guide", "Tom White", "2009"));
        books.add(new Book("Java: A Beginner's Guide", "Herbert Schildt", "2011"));
        books.add(new Book("Effective Java", "Joshua Bloch", "2001"));
        books.add(new Book("Java All-in-One For Dummies", "Doug Lowe", "2014"));
        books.add(new Book("Learning Java", "Patrick Niemeyer, Daniel Leuck", "2013"));
        return books;
    }

    public static List<Movie> listOfMovies()
    {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Casablanca", "1942", "Michael Curtiz", "9"));
        movies.add(new Movie("The Godfather", "1972", "Francis Coppola", "9"));
        movies.add(new Movie("Date Movie", "2006", "Aaron Seltzer", "2"));
        movies.add(new Movie("Avatar", "2009", "James Cameron", "8"));
        movies.add(new Movie("Iron Man", "2008", "Jon Favreau", "7"));
        return movies;
    }

    public static String user1LibraryNumber()
    {
        return "123-4567";
    }

    public static String user1Password()
    {
        return "qwerty";
    }

    public static String user2LibraryNumber()
    {
        return "141-6211";
    }

    public static String user2Password()
    {
        return "P@ssword";
    }
}

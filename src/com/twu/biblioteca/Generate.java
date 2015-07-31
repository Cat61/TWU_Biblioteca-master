package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<String, User> users()
    {
        Map<String, User> users = new HashMap<String, User>();
        users.put("123-4567", new User("123-4567", "qwerty", "John Smith", "john.smith@gmail.com", "0207 123 4567"));
        users.put("141-6211", new User("141-6211", "P@ssword", "Susan Parker", "susan.parker@gmail.com", "0712 318 2399"));
        return users;
    }
}


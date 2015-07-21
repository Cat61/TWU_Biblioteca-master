package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Catherine on 21/07/2015.
 */
public class Generate
{
    public static List<Book> listOfBooks()
    {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Kathy Sierra, Bert Bates"));
        books.add(new Book("Hadoop: The Definitive Guide", "Tom White"));
        books.add(new Book("Java: A Beginner's Guide", "Herbert Schildt"));
        books.add(new Book("Effective Java", "Joshua Bloch"));
        books.add(new Book("Java All-in-One For Dummies", "Doug Lowe"));
        books.add(new Book("Learning Java", "Patrick Niemeyer, Daniel Leuck"));
        return books;
    }
}

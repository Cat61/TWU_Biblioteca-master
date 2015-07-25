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
}

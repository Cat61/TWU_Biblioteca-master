package com.twu.biblioteca;

public class Book extends LibraryItem
{
    private final String author;

    public Book(String titleArg, String authorArg, String yearArg)
    {
        super(titleArg, yearArg);
        author = authorArg;
    }

    @Override
    public String toString()
    {
        return super.toString() + author;
    }
}

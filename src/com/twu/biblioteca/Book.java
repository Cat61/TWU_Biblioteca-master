package com.twu.biblioteca;

public class Book extends LibraryItem
{
    private final String author;

    public Book(String titleArg, String authorArg, String yearArg)
    {
        super(titleArg, yearArg);
        author = authorArg;
    }

    public static String getHeader()
    {
        return "Book List:\n"
                + String.format("   %-30s %-10s %s", "Title", "Year", "Author") + "\n"
                + "-------------------------------------------------------------------------------\n";
    }

    @Override
    public String toString()
    {
        return super.toString() + author;
    }
}

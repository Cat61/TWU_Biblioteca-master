package com.twu.biblioteca;

public abstract class LibraryItem
{
    private final String title;
    private final String year;
    private boolean available;

    public LibraryItem(String titleArg, String yearArg)
    {
        title = titleArg;
        year = yearArg;
        available = true;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailability(boolean newAvailability)
    {
        available = newAvailability;
    }

    public boolean equalsTitle(String t)
    {
        return title.equals(t);
    }

    @Override
    public String toString()
    {
        return String.format("%-30s %-10s ", title, year);
    }
}

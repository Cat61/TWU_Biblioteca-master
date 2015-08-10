package com.twu.biblioteca;

import java.util.List;
import java.util.Map;

public class Library
{
    private List<LibraryItem> media;

    public final Map<String, User> users;

    public Library()
    {
        media = Generate.listOfBooks();
        media.addAll(Generate.listOfMovies());

        users = Generate.users();
    }

    public boolean checkoutItem(String name, Class<?> type)
    {
        LibraryItem item = getLibraryItem(media, type, name);

        if (item == null || !item.isAvailable())
        {
            return false;
        }

        item.setAvailability(false);
        return true;
    }

    public boolean returnItem(String title, Class<?> type)
    {
        LibraryItem item = getLibraryItem(media, type, title);
        if (item == null || item.isAvailable())
        {
            return false;
        }

        item.setAvailability(true);
        return true;
    }

    public boolean isItemAvailable(String title, Class<?> type)
    {
        LibraryItem item = getLibraryItem(media, type, title);
        return item == null || item.isAvailable();
    }

    public String printList(Class<?> type)
    {
        String str = "";

        if(type == Book.class)
        {
            str = Book.getHeader();
        }
        else if(type == Movie.class)
        {
            str = Movie.getHeader();
        }

        int count = 1;
        for (LibraryItem item : media)
        {
            if(type.isInstance(item) && item.isAvailable())
            {
                str += "(" + count + ")" + item.toString() + "\n";
                count++;
            }
        }

        return str;
    }

    private static LibraryItem getLibraryItem(List<LibraryItem> list, Class<?> type, String name)
    {
        for (LibraryItem item : list)
        {
            if(type.isInstance(item) && item.equalsTitle(name))
            {
                return item;
            }
        }

        return null;
    }
}

package com.twu.biblioteca;

import java.util.List;
import java.util.Map;

public class Library
{
    private List<LibraryItem> media;

    public final Map<String, User> users;

    public Library()
    {
        media = Data.getListOfBooks();
        media.addAll(Data.getListOfMovies());

        users = Data.getUsers();
    }

    public boolean checkoutItem(String name, Class<? extends LibraryItem> type)
    {
        LibraryItem item = getLibraryItem(media, type, name);

        if (item == null || !item.isAvailable())
        {
            return false;
        }

        item.setAvailability(false);
        return true;
    }

    public boolean returnItem(String title, Class<? extends LibraryItem> type)
    {
        LibraryItem item = getLibraryItem(media, type, title);
        if (item == null || item.isAvailable())
        {
            return false;
        }

        item.setAvailability(true);
        return true;
    }

    public boolean isItemAvailable(String title, Class<? extends LibraryItem> type)
    {
        LibraryItem item = getLibraryItem(media, type, title);
        return item == null || item.isAvailable();
    }

    public String printList(Class<? extends LibraryItem> type)
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

    private static LibraryItem getLibraryItem(List<LibraryItem> list, Class<? extends LibraryItem> type, String name)
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

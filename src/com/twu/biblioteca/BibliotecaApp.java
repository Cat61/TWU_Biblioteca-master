package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp
{
    private static Library library;

    private static BufferedReader in;
    private static PrintStream out;

    private static User user;
    
    public static void main(String[] args)
    {
        program(System.in, System.out);
    }
    
    static void program(InputStream inStream, PrintStream outStream)
    {
        setStreams(inStream, outStream);

        library = new Library();

        boolean success = login();
        if(!success)
        {
            return;
        }

        out.println();

        out.println("Welcome!");

        mainLoop();

    }

    private static boolean login()
    {
        while (true)
        {
            out.println("Enter library number:");
            String username = getInput();

            if(username.equals("q"))
            {
                out.println();
                quit();
                return false;
            }

            if(!library.users.containsKey(username))
            {
                out.println("Unrecognisable library number.\n");
                continue;
            }

            user = library.users.get(username);

            out.println("Enter password:");
            String password = getInput();

            if(!user.getPassword().equals(password))
            {
                out.println("Invalid password.\n");
                continue;
            }

            return true;
        }
    }

    private static void setStreams(InputStream inStream, PrintStream outStream)
    {
        in = new BufferedReader(new InputStreamReader(inStream));
        out = outStream;
    }

    private static void mainLoop()
    {
        boolean cont = true;

        while (cont)
        {
            printMenuOptions();

            String input = getInput();

            cont = selectMenuOption(input);
        }
    }

    private static String getInput()
    {
        try
        {
            return in.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static void printMenuOptions()
    {
        out.println("Menu Options:\n" +
                "\tList Books: enter \"b\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tList Movies: enter \"m\"\n" +
                "\tCheckout Movie: enter \"k\"\n" +
                "\tUser details: enter \"u\"\n" +
                "\tQuit: enter \"q\"");
    }

    private static boolean selectMenuOption(String input)
    {
        out.println();

        if(input == null || input.length() != 1)
        {
            out.println("Select a valid option!");
            return true;
        }

        char c = input.charAt(0);

        switch (c)
        {
            case 'b':
                out.println(library.printTypeList(Library.Item.book));
                break;
            case 'c':
                checkoutOption(Library.Item.book);
                break;
            case 'r':
                returnBookOption();
                break;
            case 'm':
                out.println(library.printTypeList(Library.Item.movie));
                break;
            case 'k':
                checkoutOption(Library.Item.movie);
                break;
            case 'u':
                out.println("User details:\n" + user.details());
                break;
            case 'q':
                quit();
                return false;
            default:
                out.println("Select a valid option!");
        }

        return true;
    }

    private static void checkoutOption(Library.Item type)
    {
        out.println(library.printTypeList(type));

        out.println("Select " + type + " to checkout: enter index");

        String input = getInput();

        out.println();

        int index;

        try
        {
            index = Integer.parseInt(input);
        }
        catch (NumberFormatException ex)
        {
            out.println("Not a valid index of a " + type + "!\n");
            return;
        }

        boolean success = library.checkout(type, index - 1);

        if (success)
        {
            out.println("Thank you! Enjoy the " + type + ".\n");
        }
        else
        {
            out.println("That " + type + " is not available!\n");
        }
    }

    private static void returnBookOption()
    {
        out.println("Enter title of the book you are returning:");

        String input = getInput();

        out.println();

        boolean success = library.returnBook(input);

        if(success)
        {
            out.println("Thank you for returning the book.\n");
        }
        else
        {
            out.println("That is not a valid book to return.\n");
        }
    }

    private static void quit()
    {
        out.println("Quit!");
    }
}

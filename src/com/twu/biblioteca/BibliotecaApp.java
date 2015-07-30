package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp
{
    private static Library library;

    private static BufferedReader in;
    private static PrintStream out;
    
    public static void main(String[] args)
    {
        program(System.in, System.out);
    }
    
    static void program(InputStream inStream, PrintStream outStream)
    {
        setStreams(inStream, outStream);

        out.println("Welcome!");

        library = new Library();

        mainLoop();
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
                out.println(library.printAvailableBooks());
                break;
            case 'c':
                checkoutBookOption();
                break;
            case 'r':
                returnOption();
                break;
            case 'm':
                out.println(library.printAvailableMovies());
                break;
            case 'k':
                checkoutMovieOption();
                break;
            case 'q':
                out.println("Quit!");
                return false;
            default:
                out.println("Select a valid option!");
        }

        return true;
    }

    private static void checkoutBookOption()
    {
        out.println(library.printAvailableBooks());

        out.println("Select book to checkout: enter index");

        String input = getInput();

        checkoutBook(input);
    }

    private static void checkoutBook(String input)
    {
        out.println();

        int index;

        try
        {
            index = Integer.parseInt(input);
        }
        catch (NumberFormatException ex)
        {
            out.println("Not a valid index of a book!\n");
            return;
        }

        boolean success = library.checkoutBook(index - 1);

        if (success)
        {
            out.println("Thank you! Enjoy the book.\n");
        }
        else
        {
            out.println("That book is not available!\n");
        }
    }

    private static void returnOption()
    {
        out.println("Enter title of the book you are returning:");

        String input = getInput();

        returnBook(input);
    }

    private static void returnBook(String input)
    {
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

    private static void checkoutMovieOption()
    {
        out.println(library.printAvailableMovies());

        out.println("Select movie to checkout: enter index");

        String input = getInput();

        checkoutMovie(input);
    }

    private static void checkoutMovie(String input)
    {
        out.println();

        int index;

        try
        {
            index = Integer.parseInt(input);
        }
        catch (NumberFormatException ex)
        {
            out.println("Not a valid index of a movie!\n");
            return;
        }

        boolean success = library.checkoutMovie(index - 1);

        if (success)
        {
            out.println("Thank you! Enjoy the movie.\n");
        }
        else
        {
            out.println("That movie is not available!\n");
        }
    }

}

package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.PrintStream;

public class BibliotecaApp
{
    private static Library library;

    public static void main(String[] args)
    {
        welcome();

        initialiseOrResetLibrary();

        mainLoop();

    }

    static void welcome()
    {
        System.out.println("Welcome!");
    }

    static void initialiseOrResetLibrary()
    {
        library = new Library();
    }

    private static void mainLoop()
    {
        boolean cont = true;

        while (cont)
        {
            printMenuOptions();

            Console console = System.console();
            String input = console.readLine();

            cont = selectMenuOption(input);
        }
    }

    static void printMenuOptions()
    {
        System.out.println("Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tQuit: enter \"q\"");
    }

    static boolean selectMenuOption(String input)
    {
        System.out.println();

        if(input.length() != 1)
        {
            System.out.println("Select a valid option!");
            return true;
        }

        char c = input.charAt(0);

        switch (c)
        {
            case 'l':
                System.out.println(library.printAvailableBooks());
                break;
            case 'c':
                checkout();
                break;
            case 'q':
                System.out.println("Quit!");
                return false;
            default:
                System.out.println("Select a valid option!");
        }

        return true;
    }

    private static void checkout()
    {
        System.out.println(library.printAvailableBooks());

        System.out.println("Select book to checkout: enter index");

        Console console = System.console();
        String input = console.readLine();

        checkoutBook(input);
    }

    static void checkoutBook(String input)
    {
        System.out.println();

        int index;

        try
        {
            index = Integer.parseInt(input);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Not a valid index of a book!\n");
            return;
        }

        boolean success = library.checkout(index - 1);

        if (success)
        {
            System.out.println("Thank you! Enjoy the book.\n");
        }
        else
        {
            System.out.println("That book is not available!\n");
        }
    }

    public static void returnBook(String input)
    {
        library.returnBook("Head First Java");
    }
}

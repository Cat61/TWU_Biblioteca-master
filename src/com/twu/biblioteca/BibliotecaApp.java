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

        initialiseLibrary();

        mainLoop();

    }

    protected static void initialiseLibrary()
    {
        if(library == null)
        {
            library = new Library();
        }
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

    protected static boolean selectMenuOption(String input)
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
                System.out.println(library.printBooks());
                break;
            case 'q':
                System.out.println("Quit!");
                return false;
            default:
                System.out.println("Select a valid option!");
        }

        return true;
    }

    protected static void printMenuOptions()
    {
        System.out.println("Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tQuit: enter \"q\"");
    }

    protected static void welcome()
    {
        System.out.println("Welcome!");
    }
}

package com.twu.biblioteca;

import java.io.Console;

public class BibliotecaApp
{
    private static Library library;

    public static void main(String[] args)
    {
        System.out.println(welcome());

        library = new Library();

        mainLoop();

    }

    private static void mainLoop()
    {
        boolean cont = true;

        while (cont)
        {
            System.out.println(printMenuOptions());

            Console console = System.console();
            String input = console.readLine();

            cont = selectMenuOption(input);
        }
    }

    private static boolean selectMenuOption(String input)
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

    private static String printMenuOptions()
    {
        return "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tQuit: enter \"q\"";
    }

    protected static String welcome()
    {
        return "Welcome!";
    }
}

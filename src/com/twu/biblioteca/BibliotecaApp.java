package com.twu.biblioteca;

public class BibliotecaApp
{
    public static void main(String[] args)
    {
        System.out.println(welcome());

        Library library = new Library();

        System.out.println("Available Books:");
        System.out.println(library.printBooks());
    }

    protected static String welcome()
    {
        return "Welcome!";
    }
}

package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testListBooksAndQuit()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutBookAndQuit()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "1\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutAndListBooks()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Book List:\n" +
                "   Title                          Year       Author\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                2005       Kathy Sierra, Bert Bates\n" +
                "(2)Hadoop: The Definitive Guide   2009       Tom White\n" +
                "(3)Effective Java                 2001       Joshua Bloch\n" +
                "(4)Java All-in-One For Dummies    2014       Doug Lowe\n" +
                "(5)Learning Java                  2013       Patrick Niemeyer, Daniel Leuck\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "3\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testFailedCheckoutAndListBooks()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "That book is not available!\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "8\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidSelectMenuOptionWithChar()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                "Select a valid option!\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "p\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidSelectMenuOptionWithCorrectCharButMore()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                "Select a valid option!\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "l hh\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidSelectMenuOptionWithWord()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                "Select a valid option!\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "line\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnFirstBookAndListBooks()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "Thank you for returning the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Book List:\n" +
                "   Title                          Year       Author\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Hadoop: The Definitive Guide   2009       Tom White\n" +
                "(2)Java: A Beginner's Guide       2011       Herbert Schildt\n" +
                "(3)Effective Java                 2001       Joshua Bloch\n" +
                "(4)Java All-in-One For Dummies    2014       Doug Lowe\n" +
                "(5)Learning Java                  2013       Patrick Niemeyer, Daniel Leuck\n" +
                "(6)Head First Java                2005       Kathy Sierra, Bert Bates\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "1\n" +
                "r\n" +
                "Head First Java\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnAvailableBookAndListBooks()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "Thank you for returning the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Book List:\n" +
                "   Title                          Year       Author\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                2005       Kathy Sierra, Bert Bates\n" +
                "(2)Hadoop: The Definitive Guide   2009       Tom White\n" +
                "(3)Java: A Beginner's Guide       2011       Herbert Schildt\n" +
                "(4)Effective Java                 2001       Joshua Bloch\n" +
                "(5)Learning Java                  2013       Patrick Niemeyer, Daniel Leuck\n" +
                "(6)Java All-in-One For Dummies    2014       Doug Lowe\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "5\n" +
                "r\n" +
                "Java All-in-One For Dummies\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMisspeltReturnAndListBooks()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "That is not a valid book to return.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Book List:\n" +
                "   Title                          Year       Author\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                2005       Kathy Sierra, Bert Bates\n" +
                "(2)Hadoop: The Definitive Guide   2009       Tom White\n" +
                "(3)Java: A Beginner's Guide       2011       Herbert Schildt\n" +
                "(4)Effective Java                 2001       Joshua Bloch\n" +
                "(5)Learning Java                  2013       Patrick Niemeyer, Daniel Leuck\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "5\n" +
                "r\n" +
                "Java All-in-One For Dummie\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidReturnAndListBooks()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getBookList() +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "That is not a valid book to return.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Book List:\n" +
                "   Title                          Year       Author\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                2005       Kathy Sierra, Bert Bates\n" +
                "(2)Hadoop: The Definitive Guide   2009       Tom White\n" +
                "(3)Java: A Beginner's Guide       2011       Herbert Schildt\n" +
                "(4)Effective Java                 2001       Joshua Bloch\n" +
                "(5)Learning Java                  2013       Patrick Niemeyer, Daniel Leuck\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "5\n" +
                "r\n" +
                "&\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testListMovies()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getMovieList() +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "m\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutMovieAndQuit()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getMovieList() +
                "\n" +
                "Select movie to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the movie.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "k\n1\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutMovieAndListMovies()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getMovieList() +
                "\n" +
                "Select movie to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the movie.\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Movie List:\n" +
                "   Title                          Year       Director             Rating\n" +
                "------------------------------------------------------------------------\n" +
                "(1)Casablanca                     1942       Michael Curtiz       9\n" +
                "(2)Date Movie                     2006       Aaron Seltzer        2\n" +
                "(3)Avatar                         2009       James Cameron        8\n" +
                "(4)Iron Man                       2008       Jon Favreau          7\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "k\n" +
                "2\n" +
                "m\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testFailedCheckoutMovie()
    {
        String expected = getLoginAndWelcome() +
                getMenuOptionsString() +
                "\n" +
                getMovieList() +
                "\n" +
                "Select movie to checkout: enter index\n" +
                "\n" +
                "That movie is not available!\n" +
                "\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login()+"k\n8\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    private String getTerminalOutput()
    {
        String text = outContent.toString();
        text = text.replaceAll("\r\n", "\n");
        return text;
    }

    private String getMenuOptionsString()
    {
        return "Menu Options:\n" +
                "\tList Books: enter \"b\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tList Movies: enter \"m\"\n" +
                "\tCheckout Movie: enter \"k\"\n" +
                "\tUser details: enter \"u\"\n" +
                "\tQuit: enter \"q\"\n";
    }

    private String getBookList()
    {
        return "Book List:\n" +
                "   Title                          Year       Author\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                2005       Kathy Sierra, Bert Bates\n" +
                "(2)Hadoop: The Definitive Guide   2009       Tom White\n" +
                "(3)Java: A Beginner's Guide       2011       Herbert Schildt\n" +
                "(4)Effective Java                 2001       Joshua Bloch\n" +
                "(5)Java All-in-One For Dummies    2014       Doug Lowe\n" +
                "(6)Learning Java                  2013       Patrick Niemeyer, Daniel Leuck\n";
    }

    private String getMovieList()
    {
        return "Movie List:\n" +
                "   Title                          Year       Director             Rating\n" +
                "------------------------------------------------------------------------\n" +
                "(1)Casablanca                     1942       Michael Curtiz       9\n" +
                "(2)The Godfather                  1972       Francis Coppola      9\n" +
                "(3)Date Movie                     2006       Aaron Seltzer        2\n" +
                "(4)Avatar                         2009       James Cameron        8\n" +
                "(5)Iron Man                       2008       Jon Favreau          7\n";
    }

    private String login()
    {
        return "123-4567\nqwerty\n";
    }

    private String quit()
    {
        return "q\n";
    }

    private String getLoginAndWelcome()
    {
        return "Enter library number:\n" +
                "Enter password:\n" +
                "\n" +
                "Welcome!\n";
    }
}

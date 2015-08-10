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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" + 
                bookList() +
                "\n" +
                menuOptionsString() +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                "Select Book to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Book.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() +
                "c\n" +
                "Head First Java\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutAndListBooks()
    {
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                "Select Book to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Book.\n" +
                "\n" +
                menuOptionsString() +
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
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "Java: A Beginner's Guide\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testFailedCheckoutAndListBooks()
    {
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                "Select Book to checkout: enter title\n" +
                "\n" +
                "That Book is not available!\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "Big Java: Early Objects\n" +
                "b\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidSelectMenuOptionWithChar()
    {
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                "Select a valid option!\n" +
                menuOptionsString() +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                "Select a valid option!\n" +
                menuOptionsString() +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                "Select a valid option!\n" +
                menuOptionsString() +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                "Select Book to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Book.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Enter title of the Book you are returning:\n" +
                "\n" +
                "Thank you for returning the Book.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "Head First Java\n" +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                "Select Book to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Book.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Enter title of the Book you are returning:\n" +
                "\n" +
                "Thank you for returning the Book.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "Java All-in-One For Dummies\n" +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                "Select Book to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Book.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Enter title of the Book you are returning:\n" +
                "\n" +
                "That is not a valid Book to return.\n" +
                "\n" +
                menuOptionsString() +
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
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "Java All-in-One For Dummies\n" +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                bookList() +
                "\n" +
                "Select Book to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Book.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Enter title of the Book you are returning:\n" +
                "\n" +
                "That is not a valid Book to return.\n" +
                "\n" +
                menuOptionsString() +
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
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "c\n" +
                "Java All-in-One For Dummies\n" +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                movieList() +
                "\n" +
                menuOptionsString() +
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
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                movieList() +
                "\n" +
                "Select Movie to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Movie.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "k\nCasablanca\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutMovieAndListMovies()
    {
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                movieList() +
                "\n" +
                "Select Movie to checkout: enter title\n" +
                "\n" +
                "Thank you! Enjoy the Movie.\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Movie List:\n" +
                "   Title                          Year       Director             Rating\n" +
                "------------------------------------------------------------------------\n" +
                "(1)Casablanca                     1942       Michael Curtiz       9\n" +
                "(2)Date Movie                     2006       Aaron Seltzer        2\n" +
                "(3)Avatar                         2009       James Cameron        8\n" +
                "(4)Iron Man                       2008       Jon Favreau          7\n" +
                "\n" +
                menuOptionsString() +
                "\n" +
                "Quit!\n";

        String input = login() + "k\n" +
                "The Godfather\n" +
                "m\n" + quit();
        BibliotecaApp.program(new ByteArrayInputStream(input.getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testFailedCheckoutMovie()
    {
        String expected = loginAndWelcome() +
                menuOptionsString() +
                "\n" +
                movieList() +
                "\n" +
                "Select Movie to checkout: enter title\n" +
                "\n" +
                "That Movie is not available!\n" +
                "\n" +
                menuOptionsString() +
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

    private String menuOptionsString()
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

    private String movieList()
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

    private String loginAndWelcome()
    {
        return "Enter library number:\n" +
                "Enter password:\n" +
                "\n" +
                "Welcome!\n";
    }

    private String bookList()
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
}

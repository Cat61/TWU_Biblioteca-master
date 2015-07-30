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
    public void testListAndQuit()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("l\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutAndQuit()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("c\n1\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutAndListBooks()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Effective Java                      Joshua Bloch                        2001\n" +
                "(4)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(5)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("c\n3\nl\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testFailedCheckoutAndListBooks()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "That book is not available!\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("c\n8\nl\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidSelectMenuOptionWithChar()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Select a valid option!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("p\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidSelectMenuOptionWithCorrectCharButMore()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Select a valid option!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("l hh\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidSelectMenuOptionWithWord()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Select a valid option!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("line\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnFirstBookAndListBooks()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "Thank you for returning the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(2)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(3)Effective Java                      Joshua Bloch                        2001\n" +
                "(4)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(5)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "(6)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("c\n1\nr\nHead First Java\nl\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnAvailableBookAndListBooks()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "Thank you for returning the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "(6)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("c\n5\nr\nJava All-in-One For Dummies\nl\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMisspeltReturnAndListBooks()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "That is not a valid book to return.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("c\n5\nr\nJava All-in-One For Dummie\nl\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidReturnAndListBooks()
    {
        String expected = "Welcome!\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Select book to checkout: enter index\n" +
                "\n" +
                "Thank you! Enjoy the book.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Enter title of the book you are returning:\n" +
                "\n" +
                "That is not a valid book to return.\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n" +
                "\n" +
                "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tReturn Book: enter \"r\"\n" +
                "\tQuit: enter \"q\"\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("c\n5\nr\n&\nl\nq\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    private String getTerminalOutput()
    {
        String text = outContent.toString();
        text = text.replaceAll("\r\n", "\n");
        return text;
    }
}

package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaAppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUp()
    {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testWelcome()
    {
        String expected = "Welcome!\n";
        BibliotecaApp.welcome();
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionL()
    {
        BibliotecaApp.initialiseOrResetLibrary();

        String expected = "\nBook List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n\n";
        BibliotecaApp.selectMenuOption("l");
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionCL()
    {
        BibliotecaApp.initialiseOrResetLibrary();

        BibliotecaApp.checkoutBook("3");

        String expected = "\n\nBook List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Effective Java                      Joshua Bloch                        2001\n" +
                "(4)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(5)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n\n";
        BibliotecaApp.selectMenuOption("l");
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionCLInvalid()
    {
        BibliotecaApp.initialiseOrResetLibrary();

        BibliotecaApp.checkoutBook("8");

        String expected = "\nUnsuccessful checkout!\n\n" +
                "Book List:\n" +
                "   Title                               Author                              Year\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "(4)Effective Java                      Joshua Bloch                        2001\n" +
                "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n\n";
        BibliotecaApp.selectMenuOption("l");
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionQ()
    {
        String expected = "\nQuit!\n";
        BibliotecaApp.selectMenuOption("q");
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionInvalid1()
    {
        String expected = "\nSelect a valid option!\n";
        BibliotecaApp.selectMenuOption("p");
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionInvalid2()
    {
        String expected = "\nSelect a valid option!\n";
        BibliotecaApp.selectMenuOption("l hh");
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionInvalid3()
    {
        String expected = "\nSelect a valid option!\n";
        BibliotecaApp.selectMenuOption("line");
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintMenuOptions()
    {
        String expected = "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tCheckout Book: enter \"c\"\n" +
                "\tQuit: enter \"q\"\n";
        BibliotecaApp.printMenuOptions();
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionC()
    {
        BibliotecaApp.initialiseOrResetLibrary();

        BibliotecaApp.checkoutBook("4");

        String expected = "\nThank you! Enjoy the book.\n\n";
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

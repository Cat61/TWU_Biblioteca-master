package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
        String expected = "Welcome!";
        BibliotecaApp.welcome();
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionL()
    {
        BibliotecaApp.initialiseLibrary();

        String expected = "Book List:\n" +
                "Title                               Author                              Year\n" +
                "----------------------------------------------------------------------------\n" +
                "Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "Effective Java                      Joshua Bloch                        2001\n" +
                "Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "Learning Java                       Patrick Niemeyer, Daniel Leuck      2013";
        BibliotecaApp.selectMenuOption("l");
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionQ()
    {
        String expected = "Quit!";
        BibliotecaApp.selectMenuOption("q");
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionInvalid1()
    {
        String expected = "Select a valid option!";
        BibliotecaApp.selectMenuOption("p");
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionInvalid2()
    {
        String expected = "Select a valid option!";
        BibliotecaApp.selectMenuOption("l hh");
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectMenuOptionInvalid3()
    {
        String expected = "Select a valid option!";
        BibliotecaApp.selectMenuOption("line");
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintMenuOptions()
    {
        String expected = "Menu Options:\n" +
                "\tList Books: enter \"l\"\n" +
                "\tQuit: enter \"q\"";
        BibliotecaApp.printMenuOptions();
        String actual = outContent.toString().trim();
        assertEquals(expected, actual);
    }
}

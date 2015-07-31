package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LoginTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testLoginAndQuit()
    {
        String expected = "Enter library number:\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream("q\n".getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSuccessfulLogin()
    {
        String expected = "Enter library number:\n" +
                "Enter password:\n" +
                "\n" +
                "Welcome!\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream(("123-4567\nqwerty\nq\n").getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginInvalidLibraryNumber()
    {
        String expected = "Enter library number:\n" +
                "Unrecognisable library number.\n" +
                "\n" +
                "Enter library number:\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream(("123-4568\nq\n").getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginInvalidPassword()
    {
        String expected = "Enter library number:\n" +
                "Enter password:\n" +
                "Invalid password.\n" +
                "\n" +
                "Enter library number:\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream(("123-4567\nqwert\nq\n").getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginInvalidPasswordTwice()
    {
        String expected = "Enter library number:\n" +
                "Enter password:\n" +
                "Invalid password.\n" +
                "\n" +
                "Enter library number:\n" +
                "Enter password:\n" +
                "Invalid password.\n" +
                "\n" +
                "Enter library number:\n" +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream(("123-4567\nqwert\n123-4567\nqwery\nq\n").getBytes()), new PrintStream(outContent));
        String actual = getTerminalOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testSuccessfulLoginWithSecondUser()
    {
        String expected = "Enter library number:\n" +
                "Enter password:\n" +
                "\n" +
                "Welcome!\n" +
                getMenuOptionsString() +
                "\n" +
                "Quit!\n";

        BibliotecaApp.program(new ByteArrayInputStream(("141-6211\nP@ssword\nq\n").getBytes()), new PrintStream(outContent));
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
                "\tQuit: enter \"q\"\n";
    }
}

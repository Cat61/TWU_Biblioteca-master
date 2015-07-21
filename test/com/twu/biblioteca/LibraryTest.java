package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest
{
    @Test
    public void testPrintBooks()
    {
        String expected = "\"Head First Java\" by Kathy Sierra, Bert Bates\n" +
                "\"Hadoop: The Definitive Guide\" by Tom White\n" +
                "\"Java: A Beginner's Guide\" by Herbert Schildt\n" +
                "\"Effective Java\" by Joshua Bloch\n" +
                "\"Java All-in-One For Dummies\" by Doug Lowe\n" +
                "\"Learning Java\" by Patrick Niemeyer, Daniel Leuck\n";

        Library library = new Library();
        String actual = library.printBooks();
        assertEquals(expected, actual);
    }
}
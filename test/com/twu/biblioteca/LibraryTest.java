package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest
{
    @Test
    public void testPrintBooks()
    {
        String expected =
                "Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "Effective Java                      Joshua Bloch                        2001\n" +
                "Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n";

        Library library = new Library();
        String actual = library.printBooks();
        assertEquals(expected, actual);

    }
}
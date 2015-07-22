package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest
{
    private Library library;

    @Before
    public void setUp()
    {
        library = new Library();
    }

    @Test
    public void testPrintBooks()
    {
        String expected =
                "Book List:\n" +
                "Title                               Author                              Year\n" +
                "----------------------------------------------------------------------------\n" +
                "Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                "Hadoop: The Definitive Guide        Tom White                           2009\n" +
                "Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                "Effective Java                      Joshua Bloch                        2001\n" +
                "Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                "Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n";

        String actual = library.printBooks();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckout()
    {
        boolean success = library.checkout(3);
        assertTrue(success);

        boolean available = library.isAvailable(3);
        assertFalse(available);
    }

    @Test
    public void testCheckoutInvalid1()
    {
        boolean success = library.checkout(-1);
        assertFalse(success);
    }

    @Test
    public void testCheckoutInvalid2()
    {
        boolean success = library.checkout(8);
        assertFalse(success);
    }

    @Test
    public void testCheckoutInvalid3()
    {
        boolean success = library.checkout(2);
        assertTrue(success);

        success = library.checkout(2);
        assertFalse(success);

        boolean available = library.isAvailable(2);
        assertFalse(available);
    }

}
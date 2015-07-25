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
    public void testPrintAllBooks()
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

        String actual = library.printAllBooks();
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintAvailableBooks()
    {
        String expected =
                "Book List:\n" +
                        "   Title                               Author                              Year\n" +
                        "-------------------------------------------------------------------------------\n" +
                        "(1)Head First Java                     Kathy Sierra, Bert Bates            2005\n" +
                        "(2)Hadoop: The Definitive Guide        Tom White                           2009\n" +
                        "(3)Java: A Beginner's Guide            Herbert Schildt                     2011\n" +
                        "(4)Effective Java                      Joshua Bloch                        2001\n" +
                        "(5)Java All-in-One For Dummies         Doug Lowe                           2014\n" +
                        "(6)Learning Java                       Patrick Niemeyer, Daniel Leuck      2013\n";

        String actual = library.printAvailableBooks();
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
    public void testUnsuccessfulCheckoutWithMinus()
    {
        boolean success = library.checkout(-1);
        assertFalse(success);
    }

    @Test
    public void testUnsuccessfulCheckoutWithOutOfIndex()
    {
        boolean success = library.checkout(8);
        assertFalse(success);
    }

    @Test
    public void testReturnBook()
    {
        boolean success = library.checkout(3);
        assertTrue(success);

        success = library.returnBook("Effective Java");
        assertTrue(success);

        boolean available = library.isAvailable(3);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnBookWithUncheckedOutBook()
    {
        boolean success = library.returnBook("Effective Java");
        assertFalse(success);

        boolean available = library.isAvailable(3);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnBookWithMisspeltBook()
    {
        boolean success = library.checkout(3);
        assertTrue(success);

        success = library.returnBook("Effectiv Java");
        assertFalse(success);

        boolean available = library.isAvailable(3);
        assertFalse(available);
    }
}
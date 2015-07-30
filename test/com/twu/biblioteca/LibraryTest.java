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
    public void testPrintAvailableBooks()
    {
        String expected =
                "Book List:\n" +
                "   Title                          Year       Author\n" +
                "-------------------------------------------------------------------------------\n" +
                "(1)Head First Java                2005       Kathy Sierra, Bert Bates\n" +
                "(2)Hadoop: The Definitive Guide   2009       Tom White\n" +
                "(3)Java: A Beginner's Guide       2011       Herbert Schildt\n" +
                "(4)Effective Java                 2001       Joshua Bloch\n" +
                "(5)Java All-in-One For Dummies    2014       Doug Lowe\n" +
                "(6)Learning Java                  2013       Patrick Niemeyer, Daniel Leuck\n";

        String actual = library.printTypeList(Library.Item.book);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckout()
    {
        boolean success = library.checkout(Library.Item.book, 3);
        assertTrue(success);

        boolean available = library.isBookAvailable(3);
        assertFalse(available);
    }

    @Test
    public void testUnsuccessfulCheckoutWithMinus()
    {
        boolean success = library.checkout(Library.Item.book, -1);
        assertFalse(success);
    }

    @Test
    public void testUnsuccessfulCheckoutWithOutOfIndex()
    {
        boolean success = library.checkout(Library.Item.book, 8);
        assertFalse(success);
    }

    @Test
    public void testReturnBook()
    {
        boolean success = library.checkout(Library.Item.book, 3);
        assertTrue(success);

        success = library.returnBook("Effective Java");
        assertTrue(success);

        boolean available = library.isBookAvailable(3);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnBookWithUncheckedOutBook()
    {
        boolean success = library.returnBook("Effective Java");
        assertFalse(success);

        boolean available = library.isBookAvailable(3);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnBookWithMisspeltBook()
    {
        boolean success = library.checkout(Library.Item.book, 3);
        assertTrue(success);

        success = library.returnBook("Effectiv Java");
        assertFalse(success);

        boolean available = library.isBookAvailable(3);
        assertFalse(available);
    }
}
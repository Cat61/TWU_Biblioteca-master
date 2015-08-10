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

        String actual = library.printList(Book.class);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutBook()
    {
        boolean success = library.checkoutItem("Effective Java", Book.class);
        assertTrue(success);

        boolean available = library.isItemAvailable("Effective Java", Book.class);
        assertFalse(available);
    }

    @Test
    public void testUnsuccessfulCheckoutWithMisspeltBook()
    {
        boolean success = library.checkoutItem("Effectiv Java", Book.class);
        assertFalse(success);
    }

    @Test
    public void testUnsuccessfulCheckoutWithUnavailableBook()
    {
        boolean success = library.checkoutItem("Effective Java", Book.class);
        assertTrue(success);

        success = library.checkoutItem("Effective Java", Book.class);
        assertFalse(success);
    }

    @Test
    public void testReturnBook()
    {
        boolean success = library.checkoutItem("Effective Java", Book.class);
        assertTrue(success);

        success = library.returnItem("Effective Java", Book.class);
        assertTrue(success);

        boolean available = library.isItemAvailable("Effective Java", Book.class);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnWithUncheckedOutBook()
    {
        boolean success = library.returnItem("Effective Java", Book.class);
        assertFalse(success);

        boolean available = library.isItemAvailable("Effective Java", Book.class);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnWithMisspeltBook()
    {
        boolean success = library.checkoutItem("Effective Java", Book.class);
        assertTrue(success);

        success = library.returnItem("Effectiv Java", Book.class);
        assertFalse(success);

        boolean available = library.isItemAvailable("Effective Java", Book.class);
        assertFalse(available);
    }

    @Test
    public void testPrintAvailableMovies()
    {
        String expected =
                "Movie List:\n" +
                        "   Title                          Year       Director             Rating\n" +
                        "------------------------------------------------------------------------\n" +
                        "(1)Casablanca                     1942       Michael Curtiz       9\n" +
                        "(2)The Godfather                  1972       Francis Coppola      9\n" +
                        "(3)Date Movie                     2006       Aaron Seltzer        2\n" +
                        "(4)Avatar                         2009       James Cameron        8\n" +
                        "(5)Iron Man                       2008       Jon Favreau          7\n";

        String actual = library.printList(Movie.class);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckoutMovie()
    {
        boolean success = library.checkoutItem("Avatar", Movie.class);
        assertTrue(success);

        boolean available = library.isItemAvailable("Avatar", Movie.class);
        assertFalse(available);
    }

    @Test
    public void testUnsuccessfulCheckoutWithMisspeltMovie()
    {
        boolean success = library.checkoutItem("Avetar", Movie.class);
        assertFalse(success);
    }

    @Test
    public void testUnsuccessfulCheckoutWithUnavailableMovie()
    {
        boolean success = library.checkoutItem("Avatar", Movie.class);
        assertTrue(success);

        success = library.checkoutItem("Avatar", Movie.class);
        assertFalse(success);
    }

    @Test
    public void testReturnMovie()
    {
        boolean success = library.checkoutItem("Avatar", Movie.class);
        assertTrue(success);

        success = library.returnItem("Avatar", Movie.class);
        assertTrue(success);

        boolean available = library.isItemAvailable("Avatar", Movie.class);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnWithUncheckedOutMovie()
    {
        boolean success = library.returnItem("Avatar", Movie.class);
        assertFalse(success);

        boolean available = library.isItemAvailable("Avatar", Movie.class);
        assertTrue(available);
    }

    @Test
    public void testUnsuccessfulReturnWithMisspeltMovie()
    {
        boolean success = library.checkoutItem("Avatar", Movie.class);
        assertTrue(success);

        success = library.returnItem("Avalar", Movie.class);
        assertFalse(success);

        boolean available = library.isItemAvailable("Avatar", Movie.class);
        assertFalse(available);
    }
}
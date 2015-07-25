package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest
{
    private Book book;

    @Before
    public void setUp()
    {
        book = new Book("Effective Java", "Joshua Bloch", "2001");
    }

    @Test
    public void testCheckoutAvailable()
    {
        boolean success = book.checkout();
        assertTrue(success);

        assertFalse(book.isAvailable());
    }

    @Test
    public void testCheckoutNotAvailable()
    {
        boolean success = book.checkout();
        assertTrue(success);
        assertFalse(book.isAvailable());

        success = book.checkout();
        assertFalse(success);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testToString()
    {
        String expected = "Effective Java                      Joshua Bloch                        2001";
        String actual = book.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsTitle()
    {
        assertTrue(book.equalsTitle("Effective Java"));

        assertFalse(book.equalsTitle("liwug"));

        assertFalse(book.equalsTitle("effective Java"));
    }

    @Test
    public void testSuccessfulReturnBook()
    {
        boolean success = book.checkout();
        assertTrue(success);

        success = book.returnBook();
        assertTrue(success);

        assertTrue(book.isAvailable());
    }

    @Test
    public void testUnsuccessfulReturnBookAvailable()
    {
        boolean success = book.returnBook();
        assertFalse(success);

        assertTrue(book.isAvailable());
    }
}
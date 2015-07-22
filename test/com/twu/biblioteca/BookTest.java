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
    public void testCheckoutAv()
    {
        boolean success = book.checkout();
        assertTrue(success);

        assertFalse(book.isAvailable());
    }

    @Test
    public void testCheckoutNotAv()
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
}
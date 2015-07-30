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
    public void testSetAvailability()
    {
        assertTrue(book.isAvailable());

        book.setAvailability(false);

        assertFalse(book.isAvailable());
    }

    @Test
    public void testSetAvailabilityFalseTrue()
    {
        assertTrue(book.isAvailable());

        book.setAvailability(false);

        assertFalse(book.isAvailable());

        book.setAvailability(true);

        assertTrue(book.isAvailable());
    }

    @Test
    public void testToString()
    {
        String expected = "Effective Java                 2001       Joshua Bloch";
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
}
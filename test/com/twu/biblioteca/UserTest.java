package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest
{

    private User user;

    @Before
    public void setup()
    {
        user = new User("123-4568", "qwerty123", "Jane Smith", "jane.smith@gmail.com", "0774 123 4051");
    }

    @Test
    public void testGetUsername()
    {
        String expected = "123-4568";
        String actual = user.getUsername();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetPassword()
    {
        String expected = "qwerty123";
        String actual = user.getPassword();

        assertEquals(expected, actual);
    }

    @Test
    public void testDetails()
    {
        String expected = "Jane Smith\n" +
                "email: jane.smith@gmail.com\n" +
                "tel: 0774 123 4051\n";
        String actual = user.details();

        assertEquals(expected, actual);
    }
}
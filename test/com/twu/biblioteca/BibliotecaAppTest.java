package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest
{
    @Test
    public void testWelcome()
    {
        String expected = "Welcome!";
        String actual = BibliotecaApp.welcome();
        assertEquals(expected, actual);
    }

}

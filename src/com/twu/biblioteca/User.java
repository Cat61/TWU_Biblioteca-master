package com.twu.biblioteca;

public class User
{
    private final String username;
    private final String password;

    public User(String usernameArg, String passwordArg)
    {
        username = usernameArg;
        password = passwordArg;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}

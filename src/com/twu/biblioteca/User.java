package com.twu.biblioteca;

public class User
{
    private final String username;
    private final String password;
    private final String name;
    private final String email;
    private final String telephone;

    public User(String usernameArg, String passwordArg, String nameArg, String emailArg, String telephoneArg)
    {
        username = usernameArg;
        password = passwordArg;
        name = nameArg;
        email = emailArg;
        telephone = telephoneArg;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String details()
    {
        return name + "\nemail: " + email + "\ntel: " + telephone + "\n";
    }
}

package com.parameters;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User {

    @Parameters(value = "username")
    @Test
    public void createUser(String username)
    {
        System.out.println("The user "+username+("has been created"));
    }

    @Parameters(value = "username")
    @Test
    public void modifiedUser(String username)
    {
        System.out.println("The user "+username+("has been modified"));
    }
    @Parameters(value = "username")
    @Test
    public void deleteUser(String username)
    {
        System.out.println("The user "+username+("has been deleted"));
    }

    @BeforeClass
    public void setup()
    {
        System.out.println("Launch the Browser,Navigate to URL and Login");
    }

    @AfterClass
            public void teardown()
    {
        System.out.println("logout and close the url");
        System.out.println("*************************************************************");
    }
    {

    }
}

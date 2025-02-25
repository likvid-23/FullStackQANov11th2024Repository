package com.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderDemo {

    @Test(dataProvider = "credentials")
    public void login(String username,String password)
    {
        System.out.println("Login with Username :"+username);
        System.out.println("Login with Password :"+password);
    }


    @DataProvider(name = "credentials")
    public Object[][] getdata() {
        Object[][] obj = {{"user1", "pass1"},
                {"user2", "pass2"}};
        return obj;
    }
}

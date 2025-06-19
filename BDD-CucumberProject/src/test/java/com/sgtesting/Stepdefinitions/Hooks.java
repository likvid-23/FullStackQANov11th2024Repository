package com.sgtesting.Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {
    public static WebDriver oDriver = null;
    @Before
      public void opentheBrowser()
    {
        try{
            oDriver = new ChromeDriver();
            oDriver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @After
    public void closeTheBrowser()
    {
        try{
            oDriver.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

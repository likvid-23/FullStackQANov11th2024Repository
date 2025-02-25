package com.sgtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
private static WebDriver driver=null;

    public static void main(String[] args) {
        openBrowser();
        navigateURL();
        login();
        logout();

    }

    private static void openBrowser()
    {
        try{
            driver=new ChromeDriver();
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void navigateURL()
    {
        driver.get("http://www.sgtestinginstitute.com/");

    }

    private static void login()
    {
        try{
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.id("email")).sendKeys("suviarva412@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Capamerica@412");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(3000);} catch (Exception e) {
            e.printStackTrace();
        }
    }

 private static void logout()
 {
     try{
     driver.findElement(By.xpath("//li[@class='dropdown'][5]")).click();
     driver.findElement(By.xpath("//a[@href='logout.php']")).click();

     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}

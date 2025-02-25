package com.sgtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Question5 {
    private static WebDriver driver=null;

    public static void main(String[] args) {
        openBrowser();
        navigateURL();
        divCount();
    }
    private static void openBrowser() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateURL() {
        try {
            driver.get("https://tomcat.apache.org");
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void divCount()
    {
        try {
            List<WebElement> count = driver.findElements(By.xpath("//div"));
            System.out.println("Number of divs in TomCat Website :"+count.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.sgtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Question3 {

    private static WebDriver driver=null;
    public static void main(String[] args) {
        openBrowser();
        navigateURL();
        getHTMLTutorial();
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
            driver.get("https://www.w3schools.com/");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void getHTMLTutorial()
    {
        try{
            driver.findElement(By.xpath("//a[text()='HTML']")).click();
            List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
            System.out.println("Number of Links in this website : "+links.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

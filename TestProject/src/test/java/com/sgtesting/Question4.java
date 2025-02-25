package com.sgtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Question4 {
 private static WebDriver driver=null;

    public static void main(String[] args) {
        openBrowser();
        navigateURL();
        imageCount();
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
            driver.get("https://www.amazon.in");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void imageCount()
    {
        try{
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Smart Phone");
        driver.findElement(By.id("nav-search-submit-button")).click();
            List<WebElement> images = driver.findElements(By.xpath("//img"));
            System.out.println("Number of images in this Website : "+images.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

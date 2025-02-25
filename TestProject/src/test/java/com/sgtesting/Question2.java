package com.sgtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {
    private static WebDriver driver = null;

    public static void main(String[] args) {
        openBrowser();
        navigateURL();
        applyJobonGowriSoftwareSolutions();
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
            driver.get("http://gowrisoftsolutions.com/");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void applyJobonGowriSoftwareSolutions() {
        try {
            driver.findElement(By.xpath("//a[@href='careers.html']")).click();
            driver.findElement(By.id("profName")).sendKeys("Likith Bhushan H N");
            driver.findElement(By.id("profemail")).sendKeys("likith90@gmail.com");
            driver.findElement(By.id("profphone")).sendKeys("7676759273");
            driver.findElement(By.id("profmessage")).sendKeys("This is doing for Testing purpose at SG Institute for Testing");
            WebElement fileupload = driver.findElement(By.id("resume"));
            fileupload.sendKeys("C:\\Users\\Honnesh\\Desktop\\DemoResumeForTesting.docx");
           driver.findElement(By.xpath("//button[text()='Submit']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

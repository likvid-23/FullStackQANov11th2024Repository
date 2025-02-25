package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.awt.event.KeyEvent.VK_DOWN;

public class RobotClasssDemmo {
    private static WebDriver driver = null;

    public static void main(String[] args) {
        launchbrowser();
        navigateURL();
        clickForms();
    }

    public static void launchbrowser() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public static void navigateURL()
     {
         try{
             driver.get("https://demoqa.com");
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     public static <driver> void clickForms()
     {
         try{
             WebElement forms = driver.findElement(By.xpath("//h5[text()='Forms']"));
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
             JavascriptExecutor js = (JavascriptExecutor) driver;
             js.executeScript("window.scrollBy(0,250)", "");
             wait.until(ExpectedConditions.elementToBeClickable(forms)).click();
             driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
             WebElement state = driver.findElement(By.xpath("//div[text()='Select State']"));
             WebElement text1 = driver.findElement(By.id("firstName"));
             Actions action=new Actions(driver);
             Robot rb=new Robot();
             action.click(text1).build().perform();
             text1.sendKeys("likith");
             Point location = state.getLocation();
              js.executeScript("window.scrollTo(599,1074)",state);
             action.click(state).build().perform();
             rb.keyPress(KeyEvent.VK_ENTER);
             WebElement city = driver.findElement(By.xpath("//div[text()='Select City']"));
             Point citylocation = city.getLocation();
             System.out.println(citylocation);
             js.executeScript("window.scrollTo(847,1074)",city);
             action.click(city).build().perform();
             rb.keyPress(KeyEvent.VK_ENTER);





         } catch (Exception e) {
             e.printStackTrace();
         }
     }


}

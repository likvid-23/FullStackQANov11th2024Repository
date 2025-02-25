package DEMO.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static DEMO.qa.DemoQAPage.driver;
import static DEMO.qa.DemoQAPage.oPracticePage;

public class WidgetsPage {

    @Test
    public void clickWidgets()
    {
        try{
            WebElement widgets = driver.findElement(By.xpath("//h5[text()='Widgets']"));
            System.out.println("Element is displayed ? " + widgets.isDisplayed());
            System.out.println("Element is Enabled ? " + widgets.isEnabled());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(widgets)).click();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "clickWidgets")
    public void clickSlider()
    {
              try{
                WebElement slide=oPracticePage.getSlider();
                  System.out.println(slide.toString());
                  System.out.println(slide.getLocation());
                  JavascriptExecutor js = (JavascriptExecutor) driver;
                  js.executeScript("window.scrollTo(80, 704)",slide);
                  js.executeScript("arguments[0].click();",slide);
                  Thread.sleep(3000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
    }
}

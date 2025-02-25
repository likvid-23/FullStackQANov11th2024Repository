package DEMO.qa;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DemoQAPage {
    public static WebDriver driver=null;
    public static PageElements oPracticePage=null;

    @BeforeTest
    public void setup()
    {
        try{
            driver=new ChromeDriver();
        driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        oPracticePage=new PageElements(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void navigatetoURL()
    {
        try
        {
            driver.get("https://demoqa.com");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterTest
//    public void teardown()
//    {
//        try{
//            driver.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}

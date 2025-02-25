package DEMO.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import static DEMO.qa.DemoQAPage.*;


public class PracticeFormPage {

 SoftAssert soft=new SoftAssert();
    @Test
    public void clickForms()
    {
        try {
            WebElement forms = driver.findElement(By.xpath("//h5[text()='Forms']"));
            System.out.println("Element is displayed ? " + forms.isDisplayed());
            System.out.println("Element is Enabled ? " + forms.isEnabled());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(forms)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void clickPracticeForm()
    {
        try{
            driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fillTheForm()
    {
        try{
            oPracticePage.getFirstName().sendKeys("Likith");
            oPracticePage.getLastName().sendKeys("Bhushan");
            oPracticePage.getUserEmail().sendKeys("likith@gmail.com");
            WebElement radio = oPracticePage.getMaleRadioButton();
            Point location = radio.getLocation();
            System.out.println(location);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(588, 646)",radio);
            js.executeScript("arguments[0].click();",radio);
            oPracticePage.getUserNumber().sendKeys("7676759273");
            WebElement dateField = oPracticePage.getDateOfBirthInput();
            dateField.click();
            Actions actions = new Actions(driver);
            actions.moveToElement(dateField);
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.chord("A")).keyUp(Keys.CONTROL).perform();
            dateField.sendKeys("30 Nov 1995");
            dateField.sendKeys(Keys.ENTER);
            WebElement subjectInput = oPracticePage.getSubjectsInput();
            subjectInput.sendKeys("Maths");
            subjectInput.sendKeys(Keys.ENTER);
            subjectInput.sendKeys("Physics");
            subjectInput.sendKeys(Keys.ENTER);
            subjectInput.sendKeys("Chemistry");
            subjectInput.sendKeys(Keys.ENTER);
            WebElement checkbox1 = oPracticePage.getCheckbox1();
            WebElement checkbox2 = oPracticePage.getCheckbox2();
            System.out.println(checkbox1.getLocation());
            System.out.println(checkbox2.getLocation()) ;
            js.executeScript("window.scrollTo(588, 816)",checkbox1);
            js.executeScript("arguments[0].click();",checkbox1);
            js.executeScript("window.scrollTo(673, 816)",checkbox2);
            js.executeScript("arguments[0].click();",checkbox2);
            WebElement chooseFile = oPracticePage.getUploadPicture();
            chooseFile.sendKeys("C:\\Users\\Honnesh\\Pictures\\Screenshots\\Screenshot 2024-10-23 233621.png");
            oPracticePage.getCurrentAddress().sendKeys("Kirlosker Layout, Chikkabanavara,Bangalore -560073");
            WebElement state = oPracticePage.getState();
            System.out.println(state.getLocation());
            System.out.println(state.isEnabled());
            System.out.println(state.isDisplayed());
            js.executeScript("window.scrollTo(599,1074)");
            Actions act=new Actions(driver);
            act.click(state).build().perform();
            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_ENTER);
            WebElement city = oPracticePage.getCity();
            System.out.println(city.getLocation());
            act.click(city).build().perform();
            rb.keyPress(KeyEvent.VK_ENTER);
            oPracticePage.getSubmit().click();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

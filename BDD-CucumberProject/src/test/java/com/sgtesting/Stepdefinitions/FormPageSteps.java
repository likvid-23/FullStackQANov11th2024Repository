package com.sgtesting.Stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.sgtesting.Stepdefinitions.ElementsPageSteps.oDriver;
import static com.sgtesting.Stepdefinitions.ElementsPageSteps.oPage;

public class FormPageSteps {
    @Given("I should be navigated to forms page")
    public void i_should_be_navigated_to_forms_page() {
        WebElement forms = oPage.getForms();
        JavascriptExecutor js = (JavascriptExecutor) oDriver;
        js.executeScript("window.scrollBy(0,250)", "");
        Wait<WebDriver> wait = new WebDriverWait(oDriver, Duration.ofSeconds(30));
        forms.click();
    }
    @Given("I should click Practice form")
    public void i_should_click_practice_form() {
        oPage.getPracticeform().click();
    }
    @When("i fill up the form and click submit")
    public void i_fill_up_the_form_and_click_submit() throws AWTException {
        oPage.getFirstName().sendKeys("Likith");
        oPage.getLastName().sendKeys("Bhushan");
        oPage.getUserEmail1().sendKeys("likith@gmail.com");
        WebElement radio = oPage.getMaleRadioButton();
        Point location = radio.getLocation();
        System.out.println(location);
        JavascriptExecutor js = (JavascriptExecutor) oDriver;
        js.executeScript("window.scrollTo(588, 646)",radio);
        js.executeScript("arguments[0].click();",radio);
        oPage.getUserNumber().sendKeys("7676759273");
        WebElement dateField = oPage.getDateOfBirthInput();
        dateField.click();
        Actions actions = new Actions(oDriver);
        actions.moveToElement(dateField);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.chord("A")).keyUp(Keys.CONTROL).perform();
        dateField.sendKeys("30 Nov 1995");
        dateField.sendKeys(Keys.ENTER);
        WebElement subjectInput = oPage.getSubjectsInput();
        subjectInput.sendKeys("Maths");
        subjectInput.sendKeys(Keys.ENTER);
        subjectInput.sendKeys("Physics");
        subjectInput.sendKeys(Keys.ENTER);
        subjectInput.sendKeys("Chemistry");
        subjectInput.sendKeys(Keys.ENTER);
        WebElement checkbox1 = oPage.getCheckbox1();
        WebElement checkbox2 = oPage.getCheckbox2();
        js.executeScript("window.scrollTo(588, 816)",checkbox1);
        js.executeScript("arguments[0].click();",checkbox1);
        js.executeScript("window.scrollTo(673, 816)",checkbox2);
        js.executeScript("arguments[0].click();",checkbox2);
        WebElement chooseFile = oPage.getUploadPicture();
        chooseFile.sendKeys("C:\\Users\\Honnesh\\Pictures\\Screenshots\\Screenshot 2024-10-23 233621.png");
        oPage.getCurrentAddress().sendKeys("Kirlosker Layout, Chikkabanavara,Bangalore -560073");
        WebElement state = oPage.getState();
        js.executeScript("window.scrollTo(599,1074)");
        Actions act=new Actions(oDriver);
        act.click(state).build().perform();
        Robot rb=new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        WebElement city = oPage.getCity();
        System.out.println(city.getLocation());
        act.click(city).build().perform();
        rb.keyPress(KeyEvent.VK_ENTER);
        oPage.getSubmit().click();

    }
}

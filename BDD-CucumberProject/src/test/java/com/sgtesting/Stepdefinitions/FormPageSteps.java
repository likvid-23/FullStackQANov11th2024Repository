package com.sgtesting.Stepdefinitions;

import PageFactory.FormPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;


import static com.sgtesting.Stepdefinitions.ElementsPageSteps.oElePage;
import static com.sgtesting.Stepdefinitions.Hooks.oDriver;

public class FormPageSteps {
    public static Logger log = LogManager.getLogger(FormPageSteps.class);
    public static FormPageElements oFormPage=null;

    @Given("I should be navigated to forms page")
    public void i_should_be_navigated_to_forms_page() {
        try {
            log.info("I should be navigated to forms page");
            oFormPage=new FormPageElements(oDriver);
            WebElement forms = oFormPage.getForms();
            JavascriptExecutor js = (JavascriptExecutor) oDriver;
            js.executeScript("window.scrollBy(0,250)", "");
            Wait<WebDriver> wait = new WebDriverWait(oDriver, Duration.ofSeconds(30));
            forms.click();
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @Given("I should click Practice form")
    public void i_should_click_practice_form() {
        try {
            log.info("i should click Practice form");
            oFormPage.getPracticeform().click();
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @When("i fill up the form and click submit")
    public void i_fill_up_the_form_and_click_submit() throws AWTException {
        try {
            log.info("i fill up the form and click submit");
            oFormPage.getFirstName().sendKeys("Likith");
            oFormPage.getLastName().sendKeys("Bhushan");
            oFormPage.getUserEmail1().sendKeys("likith@gmail.com");
            WebElement radio = oFormPage.getMaleRadioButton();
            Point location = radio.getLocation();
            System.out.println(location);
            JavascriptExecutor js = (JavascriptExecutor) oDriver;
            js.executeScript("window.scrollTo(588, 646)", radio);
            js.executeScript("arguments[0].click();", radio);
            oFormPage.getUserNumber().sendKeys("7676759273");
            WebElement dateField = oFormPage.getDateOfBirthInput();
            dateField.click();
            Actions actions = new Actions(oDriver);
            actions.moveToElement(dateField);
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.chord("A")).keyUp(Keys.CONTROL).perform();
            dateField.sendKeys("30 Nov 1995");
            dateField.sendKeys(Keys.ENTER);
            WebElement subjectInput = oFormPage.getSubjectsInput();
            subjectInput.sendKeys("Maths");
            subjectInput.sendKeys(Keys.ENTER);
            subjectInput.sendKeys("Physics");
            subjectInput.sendKeys(Keys.ENTER);
            subjectInput.sendKeys("Chemistry");
            subjectInput.sendKeys(Keys.ENTER);
            WebElement checkbox1 = oFormPage.getCheckbox1();
            WebElement checkbox2 = oFormPage.getCheckbox2();
            js.executeScript("window.scrollTo(588, 816)", checkbox1);
            js.executeScript("arguments[0].click();", checkbox1);
            js.executeScript("window.scrollTo(673, 816)", checkbox2);
            js.executeScript("arguments[0].click();", checkbox2);
            WebElement chooseFile = oFormPage.getUploadPicture();
            chooseFile.sendKeys("C:\\Users\\Honnesh\\Pictures\\Screenshots\\Screenshot 2024-10-23 233621.png");
            oFormPage.getCurrentAddress1().sendKeys("Kirlosker Layout, Chikkabanavara,Bangalore -560073");
            WebElement state = oFormPage.getState();
            js.executeScript("window.scrollTo(599,1074)");
            Actions act = new Actions(oDriver);
            act.click(state).build().perform();
            Robot rb = new Robot();
            rb.keyPress(KeyEvent.VK_ENTER);
            WebElement city = oFormPage.getCity();
            System.out.println(city.getLocation());
            act.click(city).build().perform();
            rb.keyPress(KeyEvent.VK_ENTER);
            oFormPage.getSubmit1().click();
        } catch (Exception e) {
            log.error("", e);
        }

    }
}

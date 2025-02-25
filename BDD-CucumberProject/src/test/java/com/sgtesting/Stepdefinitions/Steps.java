package com.sgtesting.Stepdefinitions;

import PageFactory.PageElements;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Steps {
    public static WebDriver oDriver = null;
    public static PageElements oPage = null;


    @Given("^Browser should be navigated to DemoQA page$")
    public void browser_should_be_navigated_to_demo_qa_page() {
        try {
            oDriver = new ChromeDriver();
            oDriver.manage().window().maximize();
            oDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            oDriver.get("https://demoqa.com");
            oPage = new PageElements(oDriver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @When("I click on Elements item")
    public void i_click_on_elements_item() {
        try {
            WebElement elements = oPage.getElements();
            JavascriptExecutor js = (JavascriptExecutor) oDriver;
            js.executeScript("window.scrollBy(0,250)");
            elements.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Elements Page should be displayed")
    public void elements_page_should_be_displayed() {
        try {
            String expected, actual;
            expected = "Please select an item from left to start practice.";
            actual = oPage.getElementsPageText().getText();
            Assert.assertEquals(expected, actual);
            System.out.println("Successfully landed on Elements Page");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Given("^Navigate to Text Box$")
    public void navigate_to_text_box() {
        try {
            oPage.getTextbox().click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @When("^I fill the text boxes and submit$")
    public void i_fill_the_text_boxes_and_submit() {
        try {
            oPage.getUserName().sendKeys("Likith");
            oPage.getUserEmail().sendKeys("likith@gmail.com");
            oPage.getCurrentAddress().sendKeys("Kirlosker lauout Bangalore");
            oPage.getPermanentAddress().sendKeys("Raghavendra colony madhugiri");
            Wait<WebDriver> wait = new WebDriverWait(oDriver, Duration.ofSeconds(100));
            WebElement submit = oPage.getSubmit();
            wait.until(ExpectedConditions.elementToBeClickable(submit)).click();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("^I should find text in the box below$")
    public void i_should_find_text_in_the_box_below() {
        try {
            String output = oPage.getOutput().getText();
            System.out.println(output);
            Assert.assertNotNull(output);
            System.out.println("We have successfully submitted");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
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

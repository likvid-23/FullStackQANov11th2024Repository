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

public class ElementsPageSteps {
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
            Thread.sleep(4000);
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



}

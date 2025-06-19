package com.sgtesting.Stepdefinitions;

import PageFactory.ElementsPageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.sgtesting.Stepdefinitions.Hooks.oDriver;

public class ElementsPageSteps {
 private static Logger log= LogManager.getLogger(ElementsPageSteps.class);

    public static ElementsPageElements oElePage = null;


    @Given("^Browser should be navigated to DemoQA page$")
    public void browser_should_be_navigated_to_demo_qa_page() {
        try {
            log.info("Browser should be navigated to DEMOQA page");
            oDriver.get("https://demoqa.com");

        } catch (Exception e) {
            log.error("",e);
        }
    }

    @When("I click on Elements item")
    public void i_click_on_elements_item() {
        try {
            log.info("i click on elements item");
            oElePage=new ElementsPageElements(oDriver);
            WebElement elements = oElePage.getElements();
            JavascriptExecutor js = (JavascriptExecutor) oDriver;
            js.executeScript("window.scrollBy(0,250)");
            Thread.sleep(2000);
            elements.click();
        } catch (Exception e) {
           log.error("",e);
        }
    }

    @Then("Elements Page should be displayed")
    public void elements_page_should_be_displayed() {
        try {
            log.info("elements page should be displayed");
            String expected, actual;
            expected = "Please select an item from left to start practice.";
            actual = oElePage.getElementsPageText().getText();
            Assert.assertEquals(expected, actual);
            System.out.println("Successfully landed on Elements Page");
        } catch (Exception e) {
           log.error("",e);
        }
    }

    @Given("^Navigate to Text Box$")
    public void navigate_to_text_box() {
        try {
            log.info("Navigate to text Box");
            oElePage.getTextbox().click();

        } catch (Exception e) {
            log.error("",e);
        }
    }

    @When("^I fill the text boxes and submit$")
    public void i_fill_the_text_boxes_and_submit() {
        try {
            log.info("i fill the text boxes and submit");
            oElePage.getUserName().sendKeys("Likith");
            oElePage.getUserEmail().sendKeys("likith@gmail.com");
            oElePage.getCurrentAddress().sendKeys("Kirlosker lauout Bangalore");
            oElePage.getPermanentAddress().sendKeys("Raghavendra colony madhugiri");
            Wait<WebDriver> wait = new WebDriverWait(oDriver, Duration.ofSeconds(20));
            WebElement submit = oElePage.getSubmit();
            wait.until(ExpectedConditions.elementToBeClickable(submit)).click();


        } catch (Exception e) {
            log.error("",e);
        }
    }

    @Then("^I should find text in the box below$")
    public void i_should_find_text_in_the_box_below() {
        try {
            log.info("I should find text in the box below");
            String output = oElePage.getOutput().getText();
            System.out.println(output);
            Assert.assertNotNull(output);
            System.out.println("We have successfully submitted");


        } catch (Exception e) {
            log.error("",e);
        }
    }

    @Given("Navigate to Webtables")
    public void navigate_to_webtables() {
        // Write code here that turns the phrase above into concrete action
       try{
        oElePage.getWebtables().click();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @When("I click on add button")
    public void i_click_on_add_button() {
        try{
            oElePage.getAddNewRecordButton().click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I fill the Registration form and submit")
    public void i_fill_the_registration_form_and_submit() {
        oElePage.getFirstName().sendKeys("samvid");
        oElePage.getLastName().sendKeys("honnappa");
        oElePage.getAge().sendKeys("1");
        oElePage.getUserEmail().sendKeys("samhonnappa@gmail.com");
        oElePage.getSalary().sendKeys("500000");
        oElePage.getDepartment().sendKeys("Playing");
        oElePage.getSubmit().click();
    }

    @Then("I should find the added record on table")
    public void i_should_find_the_added_record_on_table() {
        try{
            WebDriverWait wait=new WebDriverWait(oDriver,Duration.ofSeconds(10));
            WebElement searchbox = oElePage.getSearchBox();
            searchbox.sendKeys("samvid");
            wait.until(ExpectedConditions.visibilityOf(searchbox));
            WebElement record = oElePage.getRecord();
            String recordText = wait.until(ExpectedConditions.visibilityOf(record)).getText();
            System.out.println(record.isDisplayed());
            Assert.assertEquals(recordText,"samvid");
            System.out.println("Expected Record found in the table");
    } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Given("Navigate to Checkboxes page")
    public void navigate_to_checkboxes_page() {
     try{
         oElePage.getCheckboxlink().click();
     } catch (Exception e) {
         e.printStackTrace();
     }
    }

    @When("I click the expand button")
    public void i_click_the_expand_button() {
try{
    oElePage.getExpand().click();
} catch (Exception e) {
    e.printStackTrace();
}
    }

    @Then("I should find the check boxes")
    public void i_should_find_the_check_boxes() {
       try{
 oElePage.getTreehome().click();
 System.out.println(oElePage.getResult().isDisplayed());

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }


}

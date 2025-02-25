package com.sgtesting.Stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.sgtesting.Stepdefinitions.ElementsPageSteps.oPage;

public class ButtonPageSteps {
    @Given("I should be navigated to Buttons Page")
    public void i_should_be_navigated_to_buttons_page() {
oPage.getButtons().click();
    }
    @When("I click on Click Me button")
    public void i_click_on_click_me_button() {
       oPage.getClickMeButton().click();
    }
    @Then("Corresponding confirmation message should be displayed")
    public void corresponding_confirmation_message_should_be_displayed() {
        String expexted, actual;
      expexted="You have done a dynamic click";
     actual= oPage.getDynamicClickMessage().getText();
        Assert.assertEquals(expexted,actual);
        System.out.println("Succesfully clicled the CLICK ME button");
    }
}

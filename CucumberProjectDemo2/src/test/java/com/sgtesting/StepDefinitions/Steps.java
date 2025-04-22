package com.sgtesting.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Steps {
    WebDriver driver=null;
    @Given("Login page should have opened for the user")
    public void login_page_should_have_opened_for_the_user() {
        try{
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.saucedemo.com/v1/");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I fill the credentials and click submit")
    public void i_fill_the_credentials_and_click_submit() {
      try{
          driver.findElement(By.id("user-name")).sendKeys("standard_user");
          driver.findElement(By.id("password")).sendKeys("secret_sauce");
          driver.findElement(By.id("login-button")).click();
      } catch (Exception e) {
          e.printStackTrace();
      }
    }

    @Then("User should be login to homepage")
    public void user_should_be_login_to_homepage() {
       try{
           String expectedname="Products";
           WebElement products = driver.findElement(By.xpath("//div[text()='Products']"));
           String actualname=products.getText();
           Assert.assertEquals(expectedname,actualname);
           System.out.println("Name validation Successfull");

       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @When("I enter {string} in username text field")
    public void i_enter_in_username_text_field(String usrnme) {
        try{
            driver.findElement(By.id("user-name")).sendKeys(usrnme);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I enter {string} in password text field")
    public void i_enter_in_password_text_field(String pwd) {
       try{
           driver.findElement(By.id("password")).sendKeys(pwd);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @When("I click on Login Button")
    public void i_click_on_login_button() {
try{
    driver.findElement(By.id("login-button")).click();
} catch (Exception e) {
    e.printStackTrace();
}
    }
    @Then("user should close browser")
    public void user_should_close_browser() {
        try{
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

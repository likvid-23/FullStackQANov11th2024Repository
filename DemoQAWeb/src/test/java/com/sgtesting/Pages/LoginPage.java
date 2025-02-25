package com.sgtesting.Pages;

import com.sgtesting.Pagefactory.PageElements;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class LoginPage {
    public static WebDriver oBrowser = null;
    public static PageElements oPage = null;
    SoftAssert soft=new SoftAssert();

    @DataProvider(name = "credentials")
    public Object[][] getCredentials()
    {
        Object[][] obj={
                {"standard_user","secret_sauce"}
        };
        return obj;
    }

    @DataProvider(name="information")
    public Object[][] information1()
    {
       Object[][] info={{"Likith","Bhushan","572132"}};

       return info;
    }

    @BeforeSuite
    public void setup() {
        try {
            oBrowser = new ChromeDriver();
            oPage = new PageElements(oBrowser);
            oBrowser.manage().window().maximize();
            oBrowser.manage().wait(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void navigateURL() {
        try {
            oBrowser.get("https://www.saucedemo.com/v1/");
            String actualTitle = oBrowser.getTitle();
           Assert.assertEquals(actualTitle,"Swag Labs");
            System.out.println("Actual Title of the WebPage is matching with the Expected Title");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "credentials" , dependsOnMethods = "navigateURL")
    public void login(String uname,String pword) {
        try {
          oPage.getUsername().sendKeys(uname);
          oPage.getPassword().sendKeys(pword);
            oPage.getLogin().click();
            Thread.sleep(2000);
            String productspage = oPage.getProducts().getText();
            Assert.assertEquals(productspage,"Products");
            System.out.println("Successfully Landed in products Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(dependsOnMethods = "login")
    public void products()
    {
        try{
          oPage.getAddtoCart().get(0).click();
          oPage.getAddtoCart().get(2).click();
          oPage.getCartbutton().click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(dependsOnMethods = "products")
    public void clickonCheckout()
    {
        try{
            oPage.getClickCheckout().click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "information",dependsOnMethods = "clickonCheckout")
    public void infoPage(String fname,String lname,String pcode)
    {
      oPage.getFirstname().sendKeys(fname);
      oPage.getLastname().sendKeys(lname);
      oPage.getPostalcode().sendKeys(pcode);
      oPage.getContinued().click();
    }

    @Test(dependsOnMethods = "infoPage")
   public void finish()
    {
        oPage.getFinish().click();
    }


 @AfterSuite
    public void teardown() {
        try {
            oBrowser.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

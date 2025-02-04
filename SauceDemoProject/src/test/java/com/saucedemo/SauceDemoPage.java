package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public  class SauceDemoPage {
    private static WebDriver oBrowser = null;
    private static SauceElementsPage oPage = null;

    public static void main(String[] args) {
        launchBrowser();
        login();
        addTocart();
        goToCart();
        gotoCheckout();
        checkout();
        finish();

    }

    private static void launchBrowser() {
        try {
            oBrowser = new ChromeDriver();
            oPage = new SauceElementsPage(oBrowser);
            oBrowser.get("https://www.saucedemo.com/v1");
            oBrowser.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void login() {
        try {
            oPage.getUsername().sendKeys("standard_user");
            oPage.getPassword().sendKeys("secret_sauce");
            oPage.getSubmit().click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTocart() {
        List<WebElement> eles = oPage.getAdd();
        eles.get(0).click();
    }

    private static void goToCart() {
        oPage.getCart().click();
    }

    private static void gotoCheckout() {
        oPage.getCheckout().click();
    }

    private static void checkout()
    {
        oPage.getFirstname().sendKeys("Likith");
        oPage.getLastname().sendKeys("H N");
        oPage.getPostalCode().sendKeys("572132");
        oPage.getContinued().click();
    }
    private static void finish()
    {
        oPage.getFinish().click();
    }
}



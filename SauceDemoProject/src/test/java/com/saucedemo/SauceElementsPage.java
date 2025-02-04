package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public  class SauceElementsPage {
    public SauceElementsPage(WebDriver oBrowser) {
        PageFactory.initElements(oBrowser, this);
    }

    //webelement for username
    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement username;
    public WebElement getUsername() {
        return username;
    }

//webelement for password

private WebElement password;
    public WebElement getPassword()
    {
        return password;
    }

    //webelement for LoginButton
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;
    public WebElement getSubmit() {
        return submit;
    }
     @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
     List<WebElement> add;
    public List<WebElement> getAdd()
    {
        return add;
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement cart;
    public WebElement getCart()
    {
        return cart;
    }
    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkout;

    public WebElement getCheckout()
    {
        return checkout;
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstname;
    public WebElement getFirstname() {
        return firstname;
    }
    @FindBy(xpath ="//input[@id='last-name']" )
    private WebElement lastname;
    public WebElement getLastname()
    {
        return lastname;
    }
    @FindBy(xpath ="//input[@id='postal-code']" )
    private WebElement postalCode;
    public WebElement getPostalCode()
    {
        return postalCode;
    }
    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    private WebElement continued;

    public WebElement getContinued() {
        return continued;
    }

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    private WebElement finish;
    public WebElement getFinish()
    {
        return finish;
    }
}

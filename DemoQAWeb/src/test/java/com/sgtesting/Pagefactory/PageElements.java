package com.sgtesting.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageElements {
    public PageElements(WebDriver oBrowser)
    {
        PageFactory.initElements(oBrowser,this);
    }


    @FindBy(xpath = "//input[@id='user-name']") private WebElement username;
    private WebElement password;
    @FindBy(xpath = "//input[@id='login-button']") private WebElement login;

    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    private List<WebElement> addtocart;
    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement cartbutton;
   @FindBy(xpath = "//a[@class='btn_action checkout_button']") private WebElement clickCheckout;
   @FindBy(xpath = "//input[@id='first-name']") private WebElement firstname;
    @FindBy(xpath = "//input[@id='last-name']") private WebElement lastname;
    @FindBy(xpath = "//input[@id='postal-code']") private WebElement postalcode;
    @FindBy(xpath = "//input[@type='submit']") private WebElement continued;
    @FindBy(xpath = "//a[text()='FINISH']") private WebElement finish;
    @FindBy(xpath = "//div[text()='Products']")
    private WebElement products;


    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword()
    {
        return password;
    }

    public WebElement getLogin()
    {
        return login;
    }
    public List<WebElement> getAddtoCart()
    {
        return addtocart;
    }

    public WebElement getCartbutton() {
        return cartbutton;
    }
    public WebElement getClickCheckout()
    {
        return clickCheckout;
    }
     public WebElement getFirstname()
     {
         return firstname;
     }
     public WebElement getLastname()
     {
         return lastname;
     }
     public WebElement getPostalcode()
     {
         return postalcode;
     }
     public WebElement getContinued()
     {
         return continued;
     }
     public WebElement getFinish()
     {
         return finish;
     }

    public WebElement getProducts() {
        return products;
    }
}

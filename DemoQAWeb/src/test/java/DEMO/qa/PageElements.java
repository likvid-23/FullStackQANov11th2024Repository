package DEMO.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements {
    public PageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private WebElement firstName;
    private WebElement lastName;
    private WebElement userEmail;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement maleRadioButton;

    private WebElement userNumber;
    private WebElement dateOfBirthInput;
    private WebElement subjectsInput;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']")
    private WebElement checkbox1;
    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']")
    private WebElement checkbox2;
    private WebElement uploadPicture;
    private WebElement currentAddress;
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement state;
    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement city;
    private WebElement submit;
    @FindBy(xpath = "//button[@id='closeLargeModal']")
    private WebElement closeWindow;
    @FindBy(xpath = "//span[text()='Slider']")
    private WebElement slider;

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getUserEmail() {
        return userEmail;
    }

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getUserNumber() {
        return userNumber;
    }

    public WebElement getDateOfBirthInput() {
        return dateOfBirthInput;
    }

    public WebElement getSubjectsInput() {
        return subjectsInput;
    }

    public WebElement getCheckbox1() {
        return checkbox1;
    }

    public WebElement getCheckbox2() {
        return checkbox2;
    }

    public WebElement getUploadPicture() {
        return uploadPicture;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getCloseWindow() {
        return closeWindow;
    }

    public WebElement getSlider() {
        return slider;
    }
}

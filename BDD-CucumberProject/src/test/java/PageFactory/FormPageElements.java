package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPageElements {

    public FormPageElements(WebDriver oDriver)
    {
        PageFactory.initElements(oDriver,this);
    }

    private WebElement firstName;
    public WebElement getFirstName() {
        return firstName;
    }

    private WebElement lastName;
    public WebElement getLastName() {
        return lastName;
    }

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement userEmail1;
    public WebElement getUserEmail1() {
        return userEmail1;
    }

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement maleRadioButton;
    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    private WebElement userNumber;
    public WebElement getUserNumber() {
        return userNumber;
    }

    private WebElement dateOfBirthInput;
    public WebElement getDateOfBirthInput() {
        return dateOfBirthInput;
    }

    private WebElement subjectsInput;
    public WebElement getSubjectsInput() {
        return subjectsInput;
    }

    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']")
    private WebElement checkbox1;

    public WebElement getCheckbox1() {
        return checkbox1;
    }
    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']")
    private WebElement checkbox2;

    public WebElement getCheckbox2() {
        return checkbox2;
    }
    private WebElement uploadPicture;
    public WebElement getUploadPicture() {
        return uploadPicture;
    }

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddress1;
    public WebElement getCurrentAddress1(){
        return currentAddress1;
    }
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement state;
    public WebElement getState() {
        return state;
    }

    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement city;
    public WebElement getCity() {
        return city;
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit1;
    public WebElement getSubmit1() {
        return submit1;
    }

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement forms;
    public WebElement getForms() {
        return forms;
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceform;
    public WebElement getPracticeform() {
        return practiceform;
    }
}

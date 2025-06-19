package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ElementsPageElements {

    public ElementsPageElements(WebDriver oDriver) {
        PageFactory.initElements(oDriver, this);
    }


    private WebElement userName;

    public WebElement getUserName() {
        return userName;
    }


    private WebElement userEmail;

    public WebElement getUserEmail() {
        return userEmail;
    }

    private WebElement currentAddress;

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    private WebElement permanentAddress;

    public WebElement getPermanentAddress() {
        return permanentAddress;
    }


    private WebElement submit;

    public WebElement getSubmit() {
        return submit;
    }

    private WebElement output;

    public WebElement getOutput() {
        return output;
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement oElements;

    public WebElement getElements() {
        return oElements;
    }

    @FindBy(xpath = "//div[text()='Please select an item from left to start practice.']")
    private WebElement elementsPageText;

    public WebElement getElementsPageText() {
        return elementsPageText;
    }

    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textbox;

    public WebElement getTextbox() {
        return textbox;
    }

    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttons;

    public WebElement getButtons() {
        return buttons;
    }

    private WebElement dynamicClickMessage;

    public WebElement getDynamicClickMessage() {
        return dynamicClickMessage;
    }


    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeButton;

    public WebElement getClickMeButton() {
        return clickMeButton;
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webtables;

    public WebElement getWebtables() {
        return webtables;
    }

    private WebElement addNewRecordButton;

    public WebElement getAddNewRecordButton() {
        return addNewRecordButton;
    }

    private WebElement firstName;

    public WebElement getFirstName() {
        return firstName;
    }

    private WebElement lastName;

    public WebElement getLastName() {
        return lastName;
    }

    private WebElement age;

    public WebElement getAge() {
        return age;
    }

    private WebElement salary;

    public WebElement getSalary() {
        return salary;
    }

    private WebElement department;

    public WebElement getDepartment() {
        return department;
    }

    @FindBy(xpath = "//div[@class='rt-tr -odd']/div[1]")
    private WebElement record;

    public WebElement getRecord() {
        return record;
    }

    private WebElement searchBox;

    public WebElement getSearchBox()
    {
        return searchBox;
    }

    @FindBy(xpath = "//span[text()='Check Box']")
    private WebElement checkboxlink;
    public WebElement getCheckboxlink()
    {
        return checkboxlink;
    }

    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expand;
    public WebElement getExpand()
    {
        return expand;
    }

    @FindBy(xpath = "//input[@id='tree-node-home']")
    private WebElement treehome;
    public WebElement getTreehome()
    {
        return treehome;
    }

    private WebElement result;
    public WebElement getResult()
    {
        return result;
    }


}

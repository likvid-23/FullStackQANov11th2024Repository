import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {
    private static WebDriver driver=null;

    public static void main(String[] args) {
openBrowserandNavigate();
selectDropDown();
    }

    private static void openBrowserandNavigate()
    {
        try
        {
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.get("D:\\HTML\\Sample.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void selectDropDown()
    {
        try{
        WebElement ole = driver.findElement(By.id("tools"));
        Select option=new Select(ole);
       // System.out.println(obj.isMultiple());
        option.selectByIndex(1);
        Thread.sleep(2000);
        option.selectByValue("rc");
        Thread.sleep(1000);
        option.selectByContainsVisibleText("Selenium WebDriver");
        } catch (Exception e) {


        }
    }
}

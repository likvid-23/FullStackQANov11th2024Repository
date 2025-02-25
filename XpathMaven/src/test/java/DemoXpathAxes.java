import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoXpathAxes {
    private static WebDriver driver = null;

    public static void main(String[] args) {
        openbrowser();
        navigateURL();
        enterSalaryforSachin();
        selectCityforDravid();
        getThenameofPrimeMinisterofIndia();
    }

    private static void openbrowser() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateURL() {
        driver.get("D:\\HTML\\WebTableHTML.html");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void enterSalaryforSachin() {
        driver.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following-sibling::td[4]/input")).sendKeys("20000");
    }

    private static void selectCityforDravid() {
        WebElement select = driver.findElement(By.xpath("//td[text()='Rahul Dravid']/following-sibling::td[2]/select"));
        Select options = new Select(select);
        List<WebElement> option = options.getOptions();
        for (WebElement opt : option) {
            String txt = opt.getText();
            if (txt.equals("Bangalore")) {
                opt.click();
            }
        }
    }

    private static void getThenameofPrimeMinisterofIndia()
    {
        String name = driver.findElement(By.xpath("//td[text()='Prime Minister of India']/preceding-sibling::td[1]")).getText();
        driver.findElement(By.xpath("//td[text()='Prime Minister of India']/preceding-sibling::td[2]/input")).click();
        WebElement select = driver.findElement(By.xpath("//td[text()='Narendra Modi']/following-sibling::td[2]/select"));
        Select options = new Select(select);
        List<WebElement> option = options.getOptions();
        for (WebElement opt : option)
        {
            String txt = opt.getText();
            if (txt.equals("Gujarath")) {
                opt.click();
            }
        }
        driver.findElement(By.xpath("//td[text()='Narendra Modi']/following-sibling::td[4]/input")).sendKeys("100000");

        System.out.println("Name of Prime Minister of India :"+name);

    }

}

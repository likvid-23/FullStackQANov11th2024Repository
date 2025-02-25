import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class PopUpDemo {
    private static WebDriver driver=null;
    public static void main(String[] args) {
        openBrowser();
        navigateURL();
        handlepPopUps();

    }
    private static void openBrowser()
    {
        try {
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void navigateURL()
    {
        driver.get("https://www.html-code-generator.com/demo/html/popup-window");
    }
    private static void popUpbrowser()
    {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void handlepPopUps()
    {
        try{
            WebElement ole=driver.findElement(By.xpath("//input[@type='button']"));
            System.out.println("Number of Popup window before we click webelement :"+popupsCount());
            ole.click();
            Thread.sleep(2000);
            System.out.println("Number of Popup window after we click webelement :"+popupsCount());
            if(popupsCount()>0)
            {
                popUps();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int popupsCount()
    {
        int count = driver.getWindowHandles().size() - 1;
        return count;
    }
    private static void popUps()
    {
        try{
            String parentBrowser=driver.getWindowHandle();
            System.out.println("Parent : "+parentBrowser);
            Set<String> childBrowsers = driver.getWindowHandles();
            Object[] obj = childBrowsers.toArray();
            for(int i=1;i<obj.length;i++){
                String childBrowser = obj[i].toString();
                System.out.println("child browser : "+childBrowser);
                Thread.sleep(1000);
                driver.switchTo().window(childBrowser);
                Thread.sleep(2000);
                System.out.println(driver.getCurrentUrl());
                String childWindowhandler = driver.getWindowHandle();
                System.out.println(childWindowhandler);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

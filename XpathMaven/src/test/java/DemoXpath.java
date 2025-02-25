import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DemoXpath {
    private static WebDriver driver=null;
    public static void main(String[] args) {
openBrowser();
navigate();
//relativeXpath();
//multipleAtribute();
        //relativexpathusingattributename();
   //relativeXpathusingTagName_2();
   relativeXpathusingPartialmatchingofAttribute();
    }
    public static void openBrowser()
    {

        try{
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(2000);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void navigate()
    {
        driver.get("D:\\HTML\\Sample.html");
    }
    public static void relativeXpath()
    {
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Alert alrt = driver.switchTo().alert();
        String txt = alrt.getText();
        System.out.println(txt);
        alrt.accept();
    }
    public static void multipleAtribute()
    {
        driver.findElement(By.xpath("//input[@type='text' and @id='uid1user1name1']")).sendKeys("Likith");
    }
    public static void relativexpathusingattributename()
    {
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        int noLinks = links.size();
        System.out.println("Number of links :"+noLinks);
        //click on the link containing text "Tool"
        for(int i=0;i<noLinks;i++)
        {
            WebElement link = links.get(i);
            String name=link.getText();
            if(name.contains("Tool"))
            {
                link.click();
                break;
            }
        }

    }
   public static void relativeXpathusingTagName_2()
   {


       List<WebElement> links = driver.findElements(By.xpath("//a"));
       for(int i=0;i< links.size();i++)
       {
           String name = links.get(i).getText();
           System.out.println(name);
       }
   }
   public static void relativeXpathusingPartialmatchingofAttribute()
   {
       driver.findElement(By.xpath(""));
   }
}


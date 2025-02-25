import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {
  private static WebDriver driver=null;
    public static void main(String[] args) {
     openBrowser();
     navigateURL();
    frame1demo();
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
         driver.get("D:\\HTMLWorkspace\\demopages\\frames.html");
     }

     private static void frame1demo()
     {
    driver.switchTo().frame(0);
    driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("likith");
    driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("H N");
  driver.findElement(By.xpath("//input[@value='Login']")).click();
  driver.switchTo().frame(0);
         String txt = driver.findElement(By.linkText("Eclipse IDE")).getText();
         System.out.println(txt);
         driver.switchTo().defaultContent();
         driver.switchTo().defaultContent();
         driver.switchTo().frame(1);
     }


}

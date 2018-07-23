package KeywordDriven;
 
import org.openqa.selenium.chrome.ChromeDriver;

 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Actions 
{
 public static WebDriver driver;
  
 
 
 public static void openBrowser()
 { 
 System.setProperty("webdriver.chrome.driver", "E:\\Project\\SeleniumProj\\Driver\\chromedriver.exe");
 driver=new ChromeDriver();
 
 }
  
 public static void navigate(String site)
 { 
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get(site);
 }
  
 public static void type(String cmd,String cmd1)
 {
	 String input=cmd;
	 String[] xpath=input.split("=");
	// System.out.println(xpath[0]);
	// System.out.println(xpath[1]);
	 
	 //System.out.println(" "+cmd);
	 //System.out.println(" "+cmd1);
	 
	
	
	 if(xpath[0].equals("name"))
	 {
		 driver.findElement(By.name(xpath[1])).sendKeys(cmd1);
	 }else if(xpath[0].equals("id"))
	 {
		 driver.findElement(By.id(xpath[1])).sendKeys(cmd1);
	 }
 }
 
 public static void click(String clk) throws InterruptedException
 {
	
	 String input=clk;
	 String[] xpath1=input.split("=");
	 System.out.println("XPATH1" + xpath1[0]);
	 System.out.println("XPATH1" + xpath1[1]);
	 System.out.println("XPATH1" + xpath1[2]);
	 Thread.sleep(500);
	 //driver.findElement(By.className("nav-input")).click();
	 
	driver.findElement(By.xpath(xpath1[1]+"="+xpath1[2])).click();
 
 }

 public static void closeBrowser()
 {
	 driver.quit();
 }




}
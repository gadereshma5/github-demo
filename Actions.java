package HybridFramework;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Actions extends ReadExcelData
{
 public static WebDriver driver;
 
 
 public static void captureScreenshot(WebDriver driver,String screenshotName) throws IOException
 {

 TakesScreenshot ts=(TakesScreenshot)driver;
  
 File source=ts.getScreenshotAs(OutputType.FILE);
  
 FileUtils.copyFile(source, new File("E:\\framework\\"+screenshotName+".png"));
  
 System.out.println("Screenshot taken");

 }

 
 public static void openBrowser() throws IOException
 { 

	 try {
		System.setProperty("webdriver.chrome.driver", "E:\\Project\\SeleniumProj\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 Reporter.log("Browser Opened");
		 logger.info("Browser Opened");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 // Reporter.log("Browser Maximized");
          logger.info("Browser Maximized");

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		captureScreenshot(driver,"openbrowser");
	}
	
}


 public static void navigate(String site) throws IOException
 { 

	 try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(site);

	       // Reporter.log("Application started");
	        logger.info("Application started");
		 
	} catch (Exception e) {
		
		e.printStackTrace();
		captureScreenshot(driver,"openbrowser");
	}
}


 public static void type(String cmd,String cmd1) throws IOException
 {
		
			  try {
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				  String input=cmd;
				  String[] xpath=input.split("=");
				// System.out.println(xpath[0]);
				// System.out.println(xpath[1]);
				 
				 //System.out.println(" "+cmd);
				 //System.out.println(" "+cmd1);
				  //logger.info("taking input");
					if(xpath[0].equals("id"))
					 {
						 driver.findElement(By.id(xpath[1])).sendKeys(cmd1);
						 
					 }else if(xpath[0].equals("xpath"))
					 {
						 driver.findElement(By.xpath(xpath[1]+"="+xpath[2])).sendKeys(cmd1);
						 
					 }else if(xpath[0].equals("name"))
					 {
						 driver.findElement(By.name(xpath[1])).sendKeys(cmd1);
					 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				captureScreenshot(driver,"type");
			}

				

	}
	 
	
 

 public static void click(String clk) throws InterruptedException, IOException
 {
	
	 try {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		String input=clk;
		 String[] xpath1=input.split("=");
		 System.out.println("XPATH1" + xpath1[0]);
		 System.out.println("XPATH1" + xpath1[1]);
		 System.out.println("XPATH1" + xpath1[2]);
		 Thread.sleep(500);
		// logger.info("click action");
		  if(xpath1[0].equals("id"))
			 {
				 driver.findElement(By.id(xpath1[1])).click();
			 }
		  else if(xpath1[0].equals("xpath"))
		  {
		  driver.findElement(By.xpath(xpath1[1]+"="+xpath1[2])).click();
		  }
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		captureScreenshot(driver,"click");
	}
	 
 }
 
 public static void closeBrowser()
 {
	 driver.quit();
	 //Reporter.log("Application closed");
	 logger.info("Application closed");
 }




}
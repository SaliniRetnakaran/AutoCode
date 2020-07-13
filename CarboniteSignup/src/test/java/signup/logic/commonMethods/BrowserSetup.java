package signup.logic.commonMethods;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserSetup extends ExcelDataprovider
{


	public WebDriver driver;
	
	
	public WebDriver driverSetup(String browsername) throws Exception
	{
		
		if(browsername.equalsIgnoreCase("Firefox"))
				{
			 System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
				 }
		
		           if(browsername.equalsIgnoreCase("Chrome"))
		                {
		        	   System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		        	   File folder = new File(UUID.randomUUID().toString());
		        	   folder.mkdir();
		        	   HashMap<String,Object> prefs=new HashMap<String,Object>();
		      		   prefs.put("profile.default_content_settings.popups", 0);
		      		   prefs.put("download.default_directory", folder.getAbsolutePath());
		      		 
		      		     ChromeOptions options=new ChromeOptions();
		        		 options.setExperimentalOption("prefs", prefs);
		        		 driver=new ChromeDriver(options);
		      		    //driver=new ChromeDriver();
		                }
		
		                    if(browsername.equalsIgnoreCase("IE"))
		                    {
		                     System.setProperty("webdriver.ie.driver", ".\\Drivers\\IEDriverServer.exe");
		 		  			 driver=new InternetExplorerDriver();
		                    }
		       
		                    return driver;
						
	  }
	
	 public void urlSetup(WebDriver driver)
	 {
		 driver.get("https://www.carbonite.com/backup-software/safe-personal-trial/");
		 driver.manage().window().maximize();
		 
		 String SignupTitle=GetElementfromExcel(1, 1);
		 WebElement element=driver.findElement(By.xpath(SignupTitle));
		 
		 if(element.isDisplayed())
		 {
			 System.out.println("Page loaded succesfully !!!!");
		 }
		 
		 else
		 {
			 System.out.println("Error!! Please check the url given");
		 }
	 }
	 
	 public void broswerClose(WebDriver driver)
	 {
		driver.close();
	 }
	 
	 public void broswerQuit(WebDriver driver)
	 {
		driver.quit();
	 }
}

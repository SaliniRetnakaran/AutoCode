package signup.logic.commonMethods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot 
{

	WebDriver driver;
	public static void Capturescreenshot(WebDriver driver,String ScreenshotName) throws Exception
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		 FileHandler.copy(src, new File(".//Screenshot//"+ScreenshotName));
		}
		
		catch(IOException e)
		{
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
	}
	
	
}

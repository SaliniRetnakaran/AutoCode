package signup.testcase.validation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import signup.logic.commonMethods.BrowserSetup;
import signup.logic.commonMethods.Screenshot;
import signup.logic.commonMethods.SignupValidations;


public class Signup_Smoketest extends BrowserSetup
{

public WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) throws Exception
	{
	 driver=driverSetup(browser);
	 urlSetup(driver);
	 
	}
	
	@Test
	public void TC01_Signup_WithvalidData() throws Exception
	{
		SignupValidations sv=new SignupValidations(driver);
		Thread.sleep(2000);
		sv.SignupValidDetails();
		Thread.sleep(3000);
		sv.Submit();
		Thread.sleep(2000);
		sv.WelcomePage();
		
	}
	
	@Test(priority=1)
	public void TC02_Signup_EmptyData() throws Exception
	{
		SignupValidations sv=new SignupValidations(driver);
		Thread.sleep(2000);
		sv.Submit();
		Thread.sleep(2000);
		sv.SignupEmptyFields();
		
	}
	
	@Test(priority=3)
	public void TC03_Signup_ExistingAccount() throws Exception
	{
		SignupValidations sv=new SignupValidations(driver);
		Thread.sleep(2000);
		sv.SignupExistingEmailID();
		Thread.sleep(2000);
		
		
	}
	
  @AfterClass
	public void driverquite()
	{
	  broswerQuit(driver);
	}
		  
 @AfterMethod
  public void teardownMethod(ITestResult result) throws Exception
			{
			 
			 String time=new SimpleDateFormat("MM-dd-yyy_hh.mm.ss_a").format(new Date());
			 String screenshotname=result.getName()+"_"+time+".png";
			     
			 if(result.getStatus()==ITestResult.FAILURE)
			       {
				  Screenshot.Capturescreenshot(driver,screenshotname);
			       }
			 
			broswerClose(driver);
			}
}

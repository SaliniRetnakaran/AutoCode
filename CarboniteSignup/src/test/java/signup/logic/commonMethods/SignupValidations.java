package signup.logic.commonMethods;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class SignupValidations 
{
    public WebDriver driver;
	public ExcelDataprovider excel;
	WebElement element;
	String EmailElement,EmailInput,ConfirmEmailInput,ConfirmEmailElement,PasswordElement,PasswordInput;
	String CofirmPasswordElement,CofirmPasswordInput,CountryElement,CountryInput;
	String EmailEmptyElement,ConfirmEmailEmptyElement,PasswordEmptyElement,ConfirmPasswordEmptyElement;
	
	
	
	public SignupValidations(WebDriver driver)
	{
		this.driver=driver;
		 excel=new ExcelDataprovider();
		 		
	}
	 public void SignupValidDetails()
	 {
	    
		 EmailElement=excel.GetElementfromExcel(2, 1);
		 EmailInput=excel.GetDatafromExcel( 1, 1);
		 
		 ConfirmEmailElement=excel.GetElementfromExcel(3, 1);
		 ConfirmEmailInput=excel.GetDatafromExcel(2, 1);
		 
		 PasswordElement=excel.GetElementfromExcel(4, 1);
		 PasswordInput=excel.GetDatafromExcel(3, 1);
		 
		 CofirmPasswordElement=excel.GetElementfromExcel(5, 1);
		 CofirmPasswordInput=excel.GetDatafromExcel(4, 1);
		 
		  driver.findElement(By.xpath(EmailElement)).sendKeys(EmailInput);
		  driver.findElement(By.xpath(ConfirmEmailElement)).sendKeys(ConfirmEmailInput);
		  driver.findElement(By.xpath(PasswordElement)).sendKeys(PasswordInput);
		  driver.findElement(By.xpath(CofirmPasswordElement)).sendKeys(CofirmPasswordInput);
		  
		 
	 }
	 
	 public void Submit()
	 {
		 String submitbutton=excel.GetElementfromExcel(7, 1);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 element=driver.findElement(By.xpath(submitbutton));
		 js.executeScript("arguments[0].scrollIntoView();", element);
		 
		 driver.findElement(By.xpath(submitbutton)).click();
	 }
	 
	 public void WelcomePage() throws InterruptedException
	 {
		 String Welcomeimg=excel.GetElementfromExcel(16, 1);
		 element=driver.findElement(By.xpath(Welcomeimg));
		
		 if(element.isDisplayed())
		 {
			 System.out.println("Successfully signed up!!!!");
		 }
		 
		 else
		 {
			 System.out.println("Error!! Please give valid information for signup");
		 }
		 
		 
		 Thread.sleep(20000);
		 		 
	 }
	 
	 public void SignupEmptyFields()
	 {
		 
		 EmailEmptyElement=excel.GetElementfromExcel(12, 1);
		 ConfirmEmailEmptyElement=excel.GetElementfromExcel(13, 1);
		 PasswordEmptyElement=excel.GetElementfromExcel(14, 1);
		 ConfirmPasswordEmptyElement=excel.GetElementfromExcel(15, 1);
		 
		 
		  String EmptyEmailmsg=driver.findElement(By.xpath(EmailEmptyElement)).getText();
		  String EmptyCnfrmEmailmsg=driver.findElement(By.xpath(ConfirmEmailEmptyElement)).getText();
		  String EmptyPsswrdEmailmsg=driver.findElement(By.xpath(PasswordEmptyElement)).getText();
		  String EmptyCnfrmPwdEmailmsg=driver.findElement(By.xpath(ConfirmPasswordEmptyElement)).getText();
		  
		    
		  Assert.assertEquals(EmptyEmailmsg, "The email field is required.");
		  Assert.assertEquals(EmptyCnfrmEmailmsg, "Must be valid email");
		  Assert.assertEquals(EmptyPsswrdEmailmsg, "The password field is required.");
		  Assert.assertEquals(EmptyCnfrmPwdEmailmsg, "The confirm password field is required.");
	 }
	 
	 
	 public void SignupExistingEmailID() throws InterruptedException
	 {
	    
		 EmailElement=excel.GetElementfromExcel(2, 1);
		 EmailInput=excel.GetDatafromExcel( 1, 1);
		 
		 ConfirmEmailElement=excel.GetElementfromExcel(3, 1);
		 ConfirmEmailInput=excel.GetDatafromExcel(2, 1);
		 
		 PasswordElement=excel.GetElementfromExcel(4, 1);
		 PasswordInput=excel.GetDatafromExcel(3, 1);
		 
		 CofirmPasswordElement=excel.GetElementfromExcel(5, 1);
		 CofirmPasswordInput=excel.GetDatafromExcel(4, 1);
		 
		  driver.findElement(By.xpath(EmailElement)).sendKeys(EmailInput);
		  driver.findElement(By.xpath(ConfirmEmailElement)).sendKeys(ConfirmEmailInput);
		  driver.findElement(By.xpath(PasswordElement)).sendKeys(PasswordInput);
		  driver.findElement(By.xpath(CofirmPasswordElement)).sendKeys(CofirmPasswordInput);
		  
		  Submit();
		  Thread.sleep(2000);
		 
		  String EmailExistingElement=excel.GetElementfromExcel(12, 1);
		  String ExistingEmailmsg=driver.findElement(By.xpath(EmailExistingElement)).getText();
		  Assert.assertEquals(ExistingEmailmsg, "Email is already in use.");
	 }
	 
}

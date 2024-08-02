package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ActionEngine;



public class LandingPage extends ActionEngine {
	
	

WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}


	@FindBy(xpath="(//li/a)[1]")
	WebElement signIn;
	
	@FindBy(xpath="((//li/a)[2]")
	WebElement createAccount;
	
	
	
	
	public void clkOnSignInBtn()
	{
		click_custom(signIn);
		
	}
	
	public void clkOnCreateAccountBtn()
	{
		click_custom(createAccount);
		
	}
	
	
	
}

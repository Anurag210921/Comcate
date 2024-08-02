package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ActionEngine;


public class CreateAccountPage extends ActionEngine{

	
	
WebDriver driver;
	
	public CreateAccountPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}

	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement confirmPwd;
	
	@FindBy(xpath="//button[@class='action submit primary']")
	WebElement CreateAccountBtn;
	

}

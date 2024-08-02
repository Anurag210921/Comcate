package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ActionEngine;

public class SignInPage extends ActionEngine {
	
	WebDriver driver;
	public SignInPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}

	
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(xpath="//input[@name='login[password]']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement signInBtn;
	
	
	public void signIn()
	{
	 
		send_keys(email, "ranaanurag760@gmail.com");	
		send_keys(password, "Anurag@210921");
		click_custom(signInBtn);
	
	}
	
			
}

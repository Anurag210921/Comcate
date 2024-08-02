package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ActionEngine;
import Utilities.Assertions;

public class ReviewAndPaymentPage extends ActionEngine {
	
	public ReviewAndPaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	WebDriver driver;

	@FindBy(xpath = "//input[@id='billing-address-same-as-shipping-checkmo']")
	WebElement billing_shipping_checkbox;
	
	@FindBy(xpath="//div/button[@class='action primary checkout']")
	WebElement PlaceOrder_btn;
	
	@FindBy(xpath="//span[contains(text(),'Thank you for your purchase!')]")
	WebElement ThankU_text;
	
	public void check_billingAndShippingAddress_checkbox() throws InterruptedException
	{
		Thread.sleep(10000);
		selectCheckBox(billing_shipping_checkbox);
	}
	
	public void place_order() throws InterruptedException
	{
		Thread.sleep(5000);
		click_custom(PlaceOrder_btn);
	}
	
	public void verify_order_placed_successfully() throws InterruptedException
	{
		Thread.sleep(5000);
		String text=get_Text(ThankU_text);
		//Assert.assertEquals(text, "Thank you for your purchase!");
		Assertions.soft_assert_String(text, "hank you for your purchase!");
		System.out.println("I failed but still executed");
		Assertions.view_soft_assert();
		
	}
	
	
}

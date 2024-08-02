package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ActionEngine;

public class Checkout_shippingPage extends ActionEngine {
	WebDriver driver;
	ReviewAndPaymentPage rp;
	
	
	public Checkout_shippingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextBtn;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/input[1]")
	WebElement shippin_method;
	
	public void select_shipping_method()
	{
		WebDriverWait w = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(shippin_method));
		selectCheckBox(shippin_method);
	}
	
	public ReviewAndPaymentPage goto_reviewAndPaymentsPage() throws InterruptedException
	{
		Thread.sleep(5000);
		click_custom(nextBtn);
		rp= new ReviewAndPaymentPage(driver);
		return rp;
	}
	

}

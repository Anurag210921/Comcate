package PageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ActionEngine;

public class WatchesPage extends ActionEngine {

	WebDriver driver;
	Checkout_shippingPage sp;

	public WatchesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[contains(text(),'Gender')]")
	WebElement gender;

	@FindBy(xpath = "//body/div[1]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/ol[1]/li[1]/a[1]")
	WebElement men_gender;

	@FindBy(xpath = "//header/div[2]/div[1]/a[1]")
	WebElement viewCart;

	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
	WebElement checkout;

	public void set_gender_male() {
		click_custom(gender);
		click_custom(men_gender);

	}

	public void add_to_cart() {
		// System.out.println("Hello I am in cart methid");
		List<WebElement> item = new ArrayList<>();
		item = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
		// System.out.println(item.size());
		Iterator<WebElement> it = item.iterator();
		int i = 0;
		while (it.hasNext()) {

			String item_name = it.next().getText();
			i++;
			if (item_name.equalsIgnoreCase("Dash Digital Watch")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("window.scrollBy(0, 500);");
				Actions a = new Actions(driver);
				a.moveToElement(
						driver.findElement(By.xpath("(//strong[@class='product name product-item-name'])[" + i + "]")))
						.perform();
				WebDriverWait w = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
				driver.findElement(By.xpath("(//button/span[text()='Add to Cart'])[" + i + "]")).click();

				break;

			}

		}
		

	}
	
	public void clk_view_cart() throws InterruptedException
	{
		Thread.sleep(5000);
		click_custom(viewCart);
		
	}

	public Checkout_shippingPage proceed_to_checkout() {
		click_custom(checkout);
		sp= new Checkout_shippingPage(driver);
		return sp;

	}
}

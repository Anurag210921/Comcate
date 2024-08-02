package PageObjects;

import static org.assertj.core.api.Assertions.withMarginOf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ActionEngine;

public class HoodiesAndSweatshirtsPage extends ActionEngine {

	WebDriver driver;

	public HoodiesAndSweatshirtsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBox;

	@FindBy(xpath = "//header/div[2]/div[1]/a[1]")
	WebElement viewCart;

	@FindBy(xpath = "//div[contains(text(),'Size')]")
	WebElement size;

	@FindBy(xpath = "//div[@class='swatch-attribute swatch-layered size']/div/a[2]/div")
	WebElement small_size;

	@FindBy(xpath = "//div[@class='swatch-attribute swatch-layered size']/div/a[3]/div")
	WebElement medium_size;

	@FindBy(xpath = "//div[contains(text(),'Price')]")
	WebElement price;

	@FindBy(xpath = "//div[contains(text(),'Color')]")
	WebElement colour;

	@FindBy(xpath = "(//a[@class='swatch-option-link-layered']/div)[1]")
	WebElement blackColor;

	@FindBy(xpath = "//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[4]/select[1]")
	WebElement SortBy;

	@FindBy(xpath = "//a[@class='action clear filter-clear']")
	WebElement clear_filters;

	@FindBy(xpath = "//button[@class='action-primary action-accept']")
	WebElement alertOk;

	@FindBy(xpath = "//button[@class='action-secondary action-dismiss']")
	WebElement alertCancel;

	public void sort_products_by_price() {
		selectByVisibleText(SortBy, "Price");

	}

	public void select_size_small() {
		click_custom(size);
		click_custom(small_size);

	}

	public void select_color_black() {
		click_custom(colour);
		click_custom(blackColor);
	}

	public void clear_all_filters() {
		click_custom(clear_filters);

	}

	public void add_to_cart() {
		List<WebElement> item = new ArrayList<>();
		item = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
		System.out.println(item.size());
		Iterator<WebElement> it = item.iterator();
		int i = 0;
		while (it.hasNext()) {

			String item_name = it.next().getText();
			i++;
			System.out.println(item_name);
			if (item_name.equalsIgnoreCase("Hero Hoodie")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, 500);");
				Actions a = new Actions(driver);
				a.moveToElement(
						driver.findElement(By.xpath("(//strong[@class='product name product-item-name'])[" + i + "]")))
						.perform();
				WebDriverWait w = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
				driver.findElement(By.xpath("(//button/span[text()='Add to Cart'])[" + i + "]")).click();

			}
		}

	}

	public void clear_cart() throws InterruptedException {

		Thread.sleep(5000);
		click_custom(viewCart);
		Thread.sleep(5000);

		int size = driver.findElements(By.xpath("//a[@title='Remove item']")).size();
		System.out.println(size);
		if (size != 0) {
			List<WebElement> items = new ArrayList<>();
			System.out.println("a");
			items = driver.findElements(By.xpath("//a[@title='Remove item']"));
			System.out.println(size);
			for (int i = 0; i < size; i++) {

				click_custom(driver.findElement(By.xpath("//a[@title='Remove item']")));
				Thread.sleep(5000);
				click_custom(alertOk);
				System.out.println("Your cart is emptied now");
				Thread.sleep(3000);

			}
		}

		else {

			System.out.println("Already empty");
		}

	}

}

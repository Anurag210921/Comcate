package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ActionEngine;

public class MensCollectionPage extends ActionEngine {
	
	WebDriver driver;
	HoodiesAndSweatshirtsPage hs;
	MensCollectionPage mcp;
	
	public MensCollectionPage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Tops')]")
	WebElement tops;
	
	@FindBy(xpath="//a[contains(text(),'Bottoms')]")
	WebElement bottoms;
	
	@FindBy(xpath="//a[contains(text(),'Hoodies')]")
	WebElement hoodiesAndSweatshirts;

	public void shop_tops()
	{
		click_custom(tops);
	}
	public void shop_bottoms()
	{
		click_custom(bottoms);
	}
	public HoodiesAndSweatshirtsPage shop_hoodiesAndTshirts()
	{
		click_custom(hoodiesAndSweatshirts);
		HoodiesAndSweatshirtsPage hs= new HoodiesAndSweatshirtsPage(driver);
		return hs;
		
	}
	
}

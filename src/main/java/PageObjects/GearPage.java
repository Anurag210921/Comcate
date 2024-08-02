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

public class GearPage extends ActionEngine {
	WebDriver driver;
	WatchesPage wp;

	public GearPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//body/div[1]/main[1]/div[4]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]")
	WebElement bags_tab;
	
	@FindBy(xpath="//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[2]/dl[1]/dd[1]/ol[1]/li[3]/a[1]")
	WebElement watches_tab;
	
	public WatchesPage click_watches_tab()
	{
		click_custom(watches_tab);
		wp= new WatchesPage(driver);
		return wp;
		
	}
	
	public void click_bags_tab()
	{
		click_custom(bags_tab);
		
	}
	
	
		

	}
	
	



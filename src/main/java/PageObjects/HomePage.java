package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import Utilities.ActionEngine;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HomePage extends ActionEngine {
	WebDriver driver;
	MensCollectionPage mcp;
	GearPage gp;
	
		
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}

 

	
	
	@FindBy(xpath="//header/div[2]/a[1]/img[1]")
	WebElement logo;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement searchBox;
	
	@FindBy(xpath="//header/div[2]/div[1]/a[1]")
	WebElement cartButton;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[1]/a[1]/span[1]")
	WebElement WhatsNewTab;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]/span[2]")
	WebElement WomenTab;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/a[1]/span[2]")	
	WebElement MenTab;
	
	@FindBy(xpath="//span[contains(text(),'Gear')]")
	WebElement GearTab;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[5]/a[1]/span[2]")
	WebElement TrainingTab;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[6]/a[1]/span[1]")
	WebElement SaleTab;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[1]/a[1]/span[1]")
	WebElement AccountInfo;
	
	@FindBy(xpath="//ul[@id='ui-id-2']/li/a")
	List<WebElement> menu;
	
	public MensCollectionPage click_men_tab() throws InterruptedException
	{
		
		click_custom(MenTab);
		mcp= new MensCollectionPage(driver); 
		return mcp;
		
		
		
	}
	public GearPage goTo_gearPage() throws InterruptedException
	{
		
		click_custom(GearTab);
		gp= new GearPage(driver);
		return gp;
		
		
		
	}
	public void verify_links() throws MalformedURLException, IOException
	{
//		List<WebElement> list= findElements_custom(menu);
//		System.out.println(list.size());
		
		for(WebElement lists: menu)
		{
			String url=lists.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode=conn.getResponseCode();
			System.out.println(url+" "+"Response code: "+  resCode);
			if(resCode>400)
				System.out.println("Broken"+" "+ url);
		}
		
		
		
		
	}
	
	
	

}

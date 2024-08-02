package com.AutomatiomTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.HoodiesAndSweatshirtsPage;
import PageObjects.MensCollectionPage;
import testComponents.baseTest;


public class MenClothing extends baseTest {
	MensCollectionPage mcp; 
	HoodiesAndSweatshirtsPage hs;
	
	
	
	
	@Test(priority=1)
	public void shop_men_hoodie() throws InterruptedException 
	{
		mcp=hp.click_men_tab();
		hs=mcp.shop_hoodiesAndTshirts();
		hs.select_size_small();
		hs.sort_products_by_price();
		hs.select_color_black();
		hs.add_to_cart();
		
	}
	
	@Test(priority=2)
	public void delete_all_cart_items() throws InterruptedException
	{
		hs.clear_cart();
		
	}
	
	
	
	

}

package com.AutomatiomTestCases;



import org.testng.annotations.Test;

import PageObjects.Checkout_shippingPage;
import PageObjects.GearPage;
import PageObjects.ReviewAndPaymentPage;
import PageObjects.WatchesPage;
import testComponents.baseTest;

public class buy_watch extends baseTest{
	
	GearPage gp;
	WatchesPage wp;
	Checkout_shippingPage sp;
	ReviewAndPaymentPage rp;
	
	
	@Test(priority=1)
	public void add_watch_to_cart() throws InterruptedException
	{
		
		gp=hp.goTo_gearPage();
		wp=gp.click_watches_tab();
		wp.add_to_cart();
		wp.clk_view_cart();
		
	}
	
	@Test(priority = 2)
	public void checkout()
	{
		sp=wp.proceed_to_checkout();
		
	}
	
	@Test(priority = 3)
	public void placeOrder() throws InterruptedException
	{
		sp.select_shipping_method();
		rp=sp.goto_reviewAndPaymentsPage();
		rp.check_billingAndShippingAddress_checkbox();
		rp.place_order();
		
	}
	
	@Test(priority = 4, retryAnalyzer = RetryFailedTest.class)
	public void verify_placedOrder() throws InterruptedException
	{
		rp.verify_order_placed_successfully();
		
	}
	
	

}

package com.AutomatiomTestCases;



import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import testComponents.baseTest;

public class verifyLinksTest extends baseTest {
	
	@Test
	public void verify_broken_links() throws MalformedURLException, IOException
	{
		hp.verify_links();
		
	}
	

}

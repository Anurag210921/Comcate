package Utilities;

import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Assertions {
	static SoftAssert sf;

	
	public static void soft_assert_String(String actual, String expected)
	{
		 sf= new SoftAssert();
		sf.assertEquals(actual, expected);
		
		
		
		
	}
	
	public static void assert_String(String actual, String expected)
	{
		Assert.assertEquals(actual, expected);
		
	
		
	}
	public static void view_soft_assert()
	{
		sf.assertAll();
		
	}
	
	
}

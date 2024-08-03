package TestCases;
import BrowsersBase.BrowsersInvoked;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import ExtentReport.ExtentReportClass;

public class MissingFlow extends BrowsersInvoked{
	
	public WebDriver driver;
	CaseAssignmentUtility obj ;
	ExtentReportClass extent;
	

	
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = BrowsersInvoked.Setup();
		obj = new CaseAssignmentUtility(driver);
		
			
	}
	
	@Test(priority = 0)
	public void LoginTest() throws InterruptedException {
		obj.LoginAgency();
	}

	

	
	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

}

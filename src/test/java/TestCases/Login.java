package TestCases;
import BrowsersBase.BrowsersInvoked;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;

public class Login extends BrowsersInvoked{
	
	public WebDriver driver;
	public LoginUtility log;
	
	
	

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		log = new LoginUtility(driver);
	}
	
	@Test(description = "Verify that user is able to log in with valid credentials.")
	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();
	}
	
	
	@Test(description = "Pre-requisite(Login)")
	public void LoginAdmin() throws InterruptedException {
		log.LoginAdmin();
	}
	
	
	@AfterClass
	public void closeDriver() {
		System.out.print("CaseAssignment Close Driver-----");
		BrowsersInvoked.tearDown(driver);
	}

}

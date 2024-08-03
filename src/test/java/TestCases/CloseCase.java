package TestCases;

import BrowsersBase.BrowsersInvoked;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CLPUtility;
import POM.CaseAssignmentUtility;
import POM.CloseCaseUtility;
import POM.ForcedAbatementUtility;
import POM.LoginUtility;
import POM.PerformInspectionUtility;
import POM.ReopenCasesUtility;

//@Listeners(Listeners.Listener.class)

public class CloseCase extends BrowsersInvoked {

	public WebDriver driver;
	CloseCaseUtility obj;
	ExtentReportClass extentClass;
	ITestResult result;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		obj = new CloseCaseUtility(driver);

	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

//	@Test(priority =0, description = " Verify that 'Close Case' option appears, when user clicks on 'More' button, on CDP. ")
//	public void LoginAgency() throws InterruptedException {
//		obj.LoginAgency();
//
//	}

	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(driver);
		System.out.println(BrowsersInvoked.suiteName);

		log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);

	}

	@Test(priority = 1, description = " CloseCase_ConfirmationPopupForCloseCaseValidViolations ")
	public void CloseCase_PreRequisite() throws InterruptedException {
		obj.CloseCase_PreRequisite();

	}

	@Test(priority = 2, description = " Verify that 'Close Case' popup opens up, when user selects 'Close Case' option, after clicking on 'More' button, on CDP. ")
	public void CloseCase_OpenCloseCasePopup() throws InterruptedException {

		obj.CloseCase_OpenCloseCasePopup();

	}

	@Test(priority = 3, description = " Verify that 'Close Case' popup gets closed, when user clicks on 'Cross' icon or 'Cancel' button, on 'Verify Violations' section. ")
	public void CloseCase_CloseCloseCasePopup() throws InterruptedException {

		obj.CloseCase_CloseCloseCasePopup();

	}

//	@Test(priority = 4, description = " Verify that 'Voluntary' toggle button appears selected by default, on 'Close Case' popup. ")
//	public void CloseCase_VerifyVoluntaryToggleBtnState() throws InterruptedException {
//
//		obj.CloseCase_VerifyVoluntaryToggleBtnState();
//
//	}
//
//	@Test(priority = 5, description = " Verify that user is able to select 'Forced' toggle button, on 'Close Case' popup. ")
//	public void CloseCase_SelectForcedToggleBtn() throws InterruptedException {
//		obj.CloseCase_SelectForcedToggleBtn();
//	}
//
//	@Test(priority = 6, description = " Verify that 'Closed' status appears after Case gets closed, when user clicks on 'Close Case' button, on 'Close Case' popup. ")
//	public void CloseCase_VerifyClosedStatus() throws InterruptedException {
//
//		obj.CloseCase_VerifyClosedStatus();
//
//	}
//
//	@Test(priority = 7, description = " CloseCase_ConfirmationPopupForCloseCaseValidViolations ")
//	public void CloseCase_PreRequisiteCaseCreationForCloseCase() throws InterruptedException {
//		obj.CloseCase_PreRequisiteCaseCreationForCloseCase();
//	}
//
//	@Test(priority = 8, description = " Verify that confirmation popup opens up, when user clicks on 'Complete Inspection & Close Case' button for invalid violations, under 'Verify Violations' section. ")
//	public void CloseCase_ConfirmationPopupForCloseCaseInvalidViolations() throws InterruptedException {
//
//		obj.CloseCase_ConfirmationPopupForCloseCaseInvalidViolations();
//
//	}
//
//	@Test(priority = 9, description = " Verify that confirmation popup gets closed, when user clicks on 'Cancel' button, under 'Verify Violations' section. ")
//	public void CloseCase_CloseConfirmationPopupForCloseCase() throws InterruptedException {
//
//		obj.CloseCase_CloseConfirmationPopupForCloseCase();
//
//	}
//
//	@Test(priority = 10, description = " Verify that 'Closed' status appears after Case gets closed, when user clicks on 'Yes' button, on 'Close Case' popup. ")
//	public void CloseCase_VerifyClosedStatusViaPerformInspection() throws InterruptedException {
//
//		obj.CloseCase_VerifyClosedStatusViaPerformInspection();
//	}
//
//	@Test(priority = 11, description = " Verify that user is able to close the case for valid violations, after clicking on 'Complete Inspection & Close Case' button > 'Close Case' button, on 'Close Case' popup. ")
//	public void CloseCase_CloseCasewithValidViolations() throws InterruptedException {
//
//		obj.CloseCase_CloseCasewithValidViolations();
//
//	}

}

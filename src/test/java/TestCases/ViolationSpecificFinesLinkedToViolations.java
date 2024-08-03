package TestCases;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import POM.FinesUtility;

public class ViolationSpecificFinesLinkedToViolations extends BrowsersInvoked {
	
	public WebDriver driver;
	ITestResult result;
	FinesUtility fines;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		fines = new FinesUtility(driver);
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
		fines.LoginAgency();

	}
	
	@Test(priority = 1, description="Verify violation specific fines linked to violations only is displayed on perform inspection")
	public void verifyViolationSpecificFineIsDisplayedOnPerformInspection() throws InterruptedException {
		fines.createCaseAndPerformInspectionWithWaterFFViolation();
		fines.selectNoticeOnPerformInspection("Notice For Violation Fine Linked To Violations");
		fines.verifyVSFineLinkedToViolationIsDisplayed();

	}
	@Test(priority = 2, description = "Verify amount and name of VS fine linked to violation only is correctly displayed when user performs inspection")
	public void verifyVSFineLinkedToViolation_AmountIsDisplayedOnPI() throws InterruptedException {
		fines.verifyFineAmountIsDisplayed();

	}
	
	
	@Test(priority = 5, description = "Verify user is able to edit violation specific fine linked to violations only amount when user performs inspection")
	public void verifyUserIsAbleToEditVSFineLinkedToViolationsOnPI() throws InterruptedException {
		fines.verifyUserIsAbleToEditFlatFine();

	}

	@Test(priority = 6, description = "Verify do not issue the fine checkbox is displayed for violation specific fine linked to violations only when user performs inspection")
	public void verifyDoNotIssueTheFineCheckboxIsDisplayed() throws InterruptedException {
		fines.verifyDoNotIssueFineCheckboxDisplayed();

	}

	@Test(priority = 7, description = "Verify amount of violation specific fine linked with violations only is added under outstanding balance after PI is done ")
	public void verifyViolationSpecificFineAmountIsAddedUnderOutstandingBalance() throws InterruptedException {
		fines.completePIFromVerificationInspectionInProgressPageAndGoToCDP();
		fines.verifyFineAmountIsAddedUnderOutstandingBalance();

	}

	@Test(priority = 8, description = "Verify violation specific fine with linked to violation only applied on case is displayed on Fines and Payments details page after clicking on outstanding balance on CDP")
	public void verifyViolationSpecificFineIsDisplayedOnFinesAndPaymentsPage() throws InterruptedException {
		fines.verifyFineNameDisplayedOnFineAndPaymentPage("Violation Specific Fine Linked To Violations Only");
		fines.navigatToCDPFromFinesAndPaymentsPage();

	}
	
	//Generate Notice Out of inspection//
	
	@Test(priority = 9, description = "Verify violation specific fine linked to violations is displayed when user performs generate notice out of inspection")
	public void verifyFlatFineWithNoticeDisplayedForGenerateNotice() throws InterruptedException {
		fines.performGenerateNoticeOnCDP();
		fines.selectNoticeOnGenerateNoticeOutOfInspection("Notice For Violation Fine Linked To Violations");
		fines.verifyVSFineLinkedToViolationIsDisplayed();

	}

	@Test(priority = 10, description = "Verify amount of VS fine linked to violations is correctly displayed when user performs generate notice out of inspection")
	public void verifyFlatFineWithNoticeAmountIsDisplayedForGenerateNotice() throws InterruptedException {

		fines.verifyFineAmountIsDisplayed();

	}

	@Test(priority = 11, description = "Verify user is able to edit VS fine linked to violations amount when user performs generate notice out of inspection")
	public void verifyUserIsAbleToEditFlatFineAmount() throws InterruptedException {

		fines.verifyUserIsAbleToEditFlatFine();

	}

	@Test(priority = 12, description = "Verify outstanding balance is updated after VS fine linked to violations is added on generate notice out of inspection is applied")
	public void verifyOutstandingBalanceIsUpdatedAfterNoticeGeneratedIsApplied() throws InterruptedException {

		fines.completeGenerateNoticeFlowFromGenerateNoticeInProgressPage();
		fines.applyNoticeGeneatedThroughGenerateNotice();
		fines.verifyOutstandingBalanceIsUpdated();

	}



}
package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import ExtentReport.ExtentReportClass;
import POM.CDP_Utility;
import POM.LoginUtility;
import POM.NoticesUtility;

public class CDP extends BrowsersInvoked {

	public WebDriver driver;
	ExtentReportClass extentClass;
	ITestResult result;
	CDP_Utility cdp;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		// extentClass = new ExtentReportClass(driver);
		cdp = new CDP_Utility(driver);
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}
	
	@Test(priority = 0, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
		LoginUtility log = new LoginUtility(driver);
		System.out.println(BrowsersInvoked.suiteName);
		if(BrowsersInvoked.suiteName.equalsIgnoreCase("CRMSuite")) {
			log.LoginAgencyUser(BrowsersInvoked.AgencyCRMUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCEUsername, BrowsersInvoked.AgencyPassword);
			}
			else if(BrowsersInvoked.suiteName.equalsIgnoreCase("CESuite2")) {
				log.LoginAgencyUser(BrowsersInvoked.AgencyCE2Username, BrowsersInvoked.AgencyPassword);
			}
			else {
				log.LoginAgencyUser(BrowsersInvoked.AgencyUsername, BrowsersInvoked.AgencyPassword);
			}
	}

//	@Test(priority = 0, description = "")
//	public void LoginTest() throws InterruptedException {
//		cdp.LoginAgency();
//	}

	@Test(priority = 1, description = "Case Detail Page PreRequisite.")
	public void CDP_CaseDetailPagePreRequisite() throws InterruptedException {

		cdp.CDP_CaseDetailPagePreRequisite();

	}

	@Test(priority = 2, description = "Verify that user is able to change or update the assignee on CDP. ")
	public void CDP_UserAbleToChangeAssignee() throws InterruptedException {

		cdp.CDP_UserAbleToChangeAssignee();

	}

	@Test(priority = 3, description = "Verify that User gets directed to the Time Tracking popup after clicking on the 'Time Tracking' link under 'Hours logged' section on the CDP.")
	public void CDP_VerifyUserDirectedToTimeTracking() throws InterruptedException {
		cdp.CDP_VerifyUserDirectedToTimeTracking();

	}

	@Test(priority = 4, description = "Verify that User is able to add time log on the 'Time Tracking' popup.")
	public void CDP_VerifyUserAbleToAddTimeLogOnTimeTracking() throws InterruptedException {
		cdp.CDP_VerifyUserAbleToAddTimeLogOnTimeTracking();

	}

	@Test(priority = 5, description = "Verify that User is able to delete added time log on the 'Time Tracking' popup.")
	public void CDP_VerifyUserAbleToDeleteAddedLogTime() throws InterruptedException {
		cdp.CDP_VerifyUserAbleToDeleteAddedLogTime();

	}

	@Test(priority = 6, description = "Verify that the 'Abatement Activities' tile appears in expand view on opening the CDP.")
	public void CDP_VerifyAbatementActivityTile() throws InterruptedException {
		cdp.CDP_VerifyAbatementActivityTile();

	}

	@Test(priority = 7, description = "Verify that Admin User is able to edit the contact after clicking the 'Edit' icon next to that contact under the 'Contacts' tile.")
	public void CDP_VerifyUserAbletoEditContact() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoEditContact();

	}

	@Test(priority = 8, description = "Verify that User is able to delete the contact under the 'Contacts' tile.")
	public void CDP_VerifyUserAbletoDeleteContact() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoDeleteContact();

	}

	@Test(priority = 9, description = "Verify that User is able to add new contact under the 'Contacts' tile.")
	public void CDP_VerifyUserAbletoAddNewContact() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoAddNewContact();

	}

//	    @Test(priority = 10,description ="Verify that Admin User is able to check the 'Bill To Contact' checkbox under the 'Contacts' tile on the CDP.")
//	    public void CDP_VerifyUserAbletoSelectetheContactAsBilltoContact() throws InterruptedException{
//	    	cdp.CDP_VerifyUserAbletoSelectetheContactAsBilltoContact();
//	    }
//
//	    @Test(priority = 11)
//	    public void CDP_VerifyUserAbletoUpdateCustomeTileFields() throws InterruptedException{
//	    	cdp.CDP_VerifyUserAbletoUpdateCustomeTileFields();
//	       
//
//	    }

	@Test(priority = 12, description = "Verify that Admin User is able to add multiple photos and attachments under 'Photos & Attachments' section on the CDP.")
	public void CDP_VerifyUserAbletoAddMultipleAttachment() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoAddMultipleAttachment();

	}

	@Test(priority = 13, description = "Verify that Admin User is able to delete the added images under 'Photos & Attachments' section.")
	public void CDP_VerifyUserAbletoDeleteAttachment() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoDeleteAttachment();

	}

	@Test(priority = 14, description = "Verify that Admin User is able to print the added images under 'Photos & Attachments' section.")
	public void CDP_VerifyUserAblePrintSelectedAttatchment() throws InterruptedException {
		cdp.CDP_VerifyUserAblePrintSelectedAttatchment();

	}

	@Test(priority = 15, description = "Verify that Admin User is able to download the added attachments under 'Photos & Attachments' section.")
	public void CDP_VerifyUserAbleDownloadSelectedAttatchment() throws InterruptedException {
		cdp.CDP_VerifyUserAbleDownloadSelectedAttatchment();

	}

	@Test(priority = 16, description = "Verify that User is able to generate notice outside of inspection after clicking the 'Generate Notice' button on the CDP.")
	public void CDP_VerifyUserAbleGenerateNoticeOutsideofInspection() throws InterruptedException {
		cdp.CDP_VerifyUserAbleGenerateNoticeOutsideofInspection();

	}

	@Test(priority = 17, description = "Verify that User is able to delete notice on the CDP.")
	public void CDP_VerifyUserAbleToDeleteNotice() throws InterruptedException {
		cdp.CDP_VerifyUserAbleToDeleteNotice();

	}

	@Test(priority = 18, description = "Verify that User is able to 'Delete and Reissue' notice on the CDP.")
	public void CDP_VerifyUserAbleToDeleteAndReissueNotice() throws InterruptedException {
		cdp.CDP_VerifyUserAbleToDeleteAndReissueNotice();

	}

	@Test(priority = 19, description = "Verify that User is able to apply outside inspection generated notice on the CDP.")
	public void CDP_VerifyUserAbleApplyNoticeOutsideofInspection() throws InterruptedException {
		cdp.CDP_VerifyUserAbleApplyNoticeOutsideofInspection();

	}

	@Test(priority = 20, description = "Verify Case history should be displayed after clicking on view case history on case summary header.")
	public void CDP_VerifyCaseHistory() throws InterruptedException {
		cdp.CDP_VerifyCaseHistory();

	}

	@Test(priority = 21, description = "Verify that Admin User is able to print the case after clicking the 'Print' button on the CDP.")
	public void CDP_VerifyPrintCaseDetailsPage() throws InterruptedException {
		cdp.CDP_VerifyPrintCaseDetailsPage();

	}

	@Test(priority = 22, description = "Verify that Admin User is able to edit the entity details of a violation after clicking on the 'Edit' icon next to that Entity under the 'Violations' tile.")
	public void CDP_VerifyUserAbletoEditviolationsonCDP() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoEditviolationsonCDP();

	}

	@Test(priority = 23, description = "Veirfy add payment from fines & payment details.")
	public void CDP_VerifyAddPaymentFromFineAndPaymentDetalis() throws InterruptedException {
		cdp.CDP_VerifyAddPaymentFromFineAndPaymentDetalis();

	}

	@Test(priority = 24, description = "Verify Overdue label for outstanding balance column.")
	public void CDP_VerifyOverdueFinePayment() throws InterruptedException {
		cdp.CDP_VerifyOverdueFinePayment();

	}

	@Test(priority = 25, description = "Verify User Able to Make Fine As Void on CDP.")
	public void CDP_VerifyUserAbletoMakeFineAsVoid() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoMakeFineAsVoid();

	}

	@Test(priority = 26, description = "Verify User Able to Make Fine As Waive on CDP.")
	public void CDP_VerifyUserAbletoMakeFineAsWaive() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoMakeFineAsWaive();

	}

	@Test(priority = 27, description = "Verify User Able to Make Payment As Void on CDP.")
	public void CDP_VerifyUserAbletoMakePaymentAsVoid() throws InterruptedException {
		cdp.CDP_VerifyUserAbletoMakePaymentAsVoid();

	}

	@Test(priority = 28, description = "Verify Oustanding balance on CDP is equal to Outstanding balance on CLP.")
	public void CDP_VerifyOustandingBalWithCLP() throws InterruptedException {
		cdp.CDP_VerifyOustandingBalWithCLP();
	}

}

package TestCases;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CSDPUtility;
import POM.LoginUtility;

public class CSDP extends BrowsersInvoked {

	public WebDriver driver;
	ExtentReportClass extentClass;
	ITestResult result;
	CSDPUtility csdp;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		csdp = new CSDPUtility(driver);
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}



//	@Test(priority = 0)
//	public void LoginAgency() throws InterruptedException {
//		csdp.LoginAgency();
//
//	}
	
	
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
	

	@Test(priority = 1)
	public void CSDP_OpenCSDPAfterSubmissionCreation() throws InterruptedException {
		csdp.CSDP_OpenCSDPAfterSubmissionCreation();

	}

	@Test(priority = 3)
	public void CSDP_ChangeDueByDate() throws InterruptedException {

		csdp.CSDP_ChangeDueByDate();

	}

	@Test(priority = 4)
	public void CSDP_VerifyInternalNotesContent() throws InterruptedException {
		csdp.CSDP_VerifyInternalNotesContent();

	}

	@Test(priority = 5)
	public void CSDP_VerifyEscalatedIssue() throws InterruptedException {
		csdp.CSDP_VerifyEscalatedIssue();

	}

	@Test(priority = 6)
	public void CSDP_VerifyReasonWithInternalNotes() throws InterruptedException {
		csdp.CSDP_VerifyReasonWithInternalNotes();

	}

	@Test(priority = 7)
	public void CSDP_VerifyNoEscalationOnCancel() throws InterruptedException {
		csdp.CSDP_VerifyNoEscalationOnCancel();

	}



	@Test(priority = 9)
	public void CSDP_VerifyDirectionToCoDP() throws InterruptedException {
		csdp.CSDP_VerifyDirectionToCoDP();

	}

	@Test(priority = 10)
	public void CSDP_VerifyDirectionToCSLPFromTags() throws InterruptedException {
		csdp.CSDP_VerifyDirectionToCSLPFromTags();

	}


	@Test(priority = 12)
	public void CSDP_VerifyAddedAttachments() throws InterruptedException {
		csdp.CSDP_VerifyAddedAttachments();

	}

	@Test(priority = 13)
	public void CSDP_VerifyAddedInternalNote() throws InterruptedException {
		csdp.CSDP_VerifyAddedInternalNote();

	}

	@Test(priority = 14)
	public void CSDP_VerifyUpdatedNote() throws InterruptedException {
		csdp.CSDP_VerifyUpdatedNote();

	}

	@Test(priority = 15)
	public void CSDP_VerifyUserIsAbleToPrintCSD() throws InterruptedException {
		csdp.CSDP_VerifyUserIsAbleToPrintCSD();

	}

	@Test(priority = 16)
	public void CSDP_VerifyMultipleTagsAddition() throws InterruptedException {
		csdp.CSDP_VerifyMultipleTagsAddition();

	}

	@Test(priority = 20)
	public void CSDP_VerifyAdditionOfTasks() throws InterruptedException {

		csdp.CSDP_VerifyAdditionOfTasks();

	}

	@Test(priority = 21)
	public void CSDP_VerifyUpdationAndDeletionOfTasks() throws InterruptedException {

		csdp.CSDP_VerifyUpdationAndDeletionOfTasks();

	}

	@Test(priority = 22)
	public void CSDP_VerifyClosedSubmission() throws InterruptedException {
		csdp.CSDP_VerifyClosedSubmission();

	}

	@Test(priority = 23)
	public void CSDP_VerifyReopenedSubmission() throws InterruptedException {
		csdp.CSDP_VerifyReopenedSubmission();

	}

	@Test(priority = 24)
	public void CSDP_VerifySubmissionAssignee() throws InterruptedException {
		csdp.CSDP_VerifySubmissionAssignee();

	}

	@Test(priority = 25)
	public void CSDP_VerifySubmissionCollaborator() throws InterruptedException {
		csdp.CSDP_VerifySubmissionCollaborator();

	}

	@Test(priority = 25)
	public void CSDP_VerifySubmissionCollaboratorDeselect() throws InterruptedException {
		csdp.CSDP_VerifySubmissionCollaboratorDeselect();

	}

	@Test(priority = 26)
	public void CSDP_VerifyEmailTileWhenNoEmail() throws InterruptedException {
		csdp.CSDP_VerifyEmailTileWhenNoEmail();

	}


	@Test(priority = 27)
	public void CSDP_VerifyEmailTileExpandClickMore() throws InterruptedException {
		csdp.CSDP_VerifyEmailTileExpandClickMore();


	}


	@Test(priority = 28)
	public void CSDP_UpdateTheSubjectOfMail() throws InterruptedException {
		csdp.CSDP_UpdateTheSubjectOfMail();


	}

	@Test(priority = 29)
	public void CSDP_SubmissionDetails() throws InterruptedException {
		csdp.CSDP_SubmissionDetails();


	}

}

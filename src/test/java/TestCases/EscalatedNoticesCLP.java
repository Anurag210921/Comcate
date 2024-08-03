package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CLPUtility;
import POM.CaseAssignmentUtility;
import POM.SupervisorUtility;

public class EscalatedNoticesCLP extends BrowsersInvoked {
	
	public WebDriver driver;
	CLPUtility clp ;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		clp = new CLPUtility(driver);
		
		
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}



	@Test(priority = 0,description="Log in Agency With Valid Credential")
	public void Login() throws InterruptedException {
		clp.LoginAgency();

	}
	
	
	@Test(priority = 1,description="Verify the 'Pending Supervisor Approval' status  under 'Escalated Notice Status' column")
	public void VerifyEsclatedColAndPendingApprovalStatus() throws InterruptedException {
		clp.VerifyEsclatedColAndPendingApprovalStatus();

	}
	
	
	@Test(priority = 2,description="Verify the  'Approved' status  under 'Escalated Notice Status' column")
	public void VerifyEsclatedColStatusApproved() throws InterruptedException {
		clp.VerifyEsclatedColStatusApproved();

	}
	
	
	@Test(priority = 3,description="Verify the  'Approved & Applied to Case' status  under 'Escalated Notice Status' column")
	public void VerifyEsclatedColStatusApprovedAppliedCase() throws InterruptedException {
		clp.VerifyEsclatedColStatusApprovedAppliedCase();

	}
	
	
	@Test(priority = 4,description="Verify the  'Not Approved' status  under 'Escalated Notice Status' column")
	public void VerifyEsclatedColStatusNotApproved() throws InterruptedException {
		clp.VerifyEsclatedColStatusNotApproved();

	}
	
	
	@Test(priority = 5,description="Verify that 'Escalated Notice Status' new option with checkbox appears, on secondary filter pop up CLP")
	public void VerifyEsclatedColStatusSecondaryFilter() throws InterruptedException {
		clp.VerifyEsclatedColStatusSecondaryFilter();

	}
	
	
	
	@Test(priority = 6,description="Verify that only 'Pending Supervisor Approval' record should display after applying filter on Esclated notice status secondary filter on CLP")
	public void VerifyEsclatedColStatusPendingApprovalFilter() throws InterruptedException {
		clp.VerifyEsclatedColStatusPendingApprovalFilter();

	}
	
	
	@Test(priority = 7,description="Verify that only 'Approved and Applied to Case' record should display after applying filter on Esclated notice status secondary filter on CLP")
	public void VerifyEsclatedColStatusApprovedandAppliedCaseFilter() throws InterruptedException {
		clp.VerifyEsclatedColStatusApprovedandAppliedCaseFilter();

	}
	
	@Test(priority = 8,description="Verify that only 'Approved' record should display after applying filter on Esclated notice status secondary filter on CLP")
	public void VerifyEsclatedColStatusApprovedFilter() throws InterruptedException {
		clp.VerifyEsclatedColStatusApprovedFilter();

	}
	
	
	

}

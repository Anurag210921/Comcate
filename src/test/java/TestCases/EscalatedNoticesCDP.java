package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.AppPreRequisiteUtility;
import POM.CDP_Utility;
import POM.CLPUtility;
import POM.CaseAssignmentUtility;
import POM.SupervisorUtility;

public class EscalatedNoticesCDP extends BrowsersInvoked {
	
	public WebDriver driver;
	CDP_Utility cdp ;
	AppPreRequisiteUtility appPreRequisite;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		cdp = new CDP_Utility(driver);
		appPreRequisite = new AppPreRequisiteUtility(driver);
		
		
		
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}



	@Test(priority = 0,description="Log in Agency With Valid Credential")
	public void Login() throws InterruptedException {
		cdp.LoginAgency();

	}
	
	
	
	
	@Test(priority = 1,description="Verify the 'Approve Notice' button appear to basic supervisor user.")
	public void EscalatedNoticesCDP_VerifyApproveNoticeAppearBasicSupervisor() throws InterruptedException {
		cdp.VerifyApproveNoticeAppearBasicSupervisor();

	}
	
	@Test(priority=2,description="verify the 'Approve Notice' is not appear to basic user when case is created by user outside of the group")
	public void EscalatedNoticesCDP_VerifyApproveNoticeNotAppear() throws InterruptedException{
		cdp.VerifyApproveNoticeNotAppear();
	}
	
	
	@Test(priority=3,description="verify the Supervisor able to approve the case which is created by user outside of the group")
	public void EscalatedNoticesCDPVerifyApproveNoticeOutsideGroup() throws InterruptedException{
		cdp.VerifyApproveNoticeOutsideGroup();
	}
	
	
	@Test(priority=4,description="verify the 'Approved' 'Apply Notice' 'Manage Link' should appear to Non-supervisor user after notice approved by supervisor manager.")
	public void EscalatedNoticesCDP_VerifyApprovedNoticeStatusAppearNonSuperviosr() throws InterruptedException{
		cdp.VerifyApprovedNoticeStatusAppearNonSuperviosr();
	}
	
	
	@Test(priority=5,description="verify the 'Approved and Appiled to case' 'View Notice' 'Manage Link' should appear to supervisor manager user after notice approved by supervisor manager.")
	public void EscalatedNoticesCDP_VerifyEsclatedNoticeStatusAppearToSupervisorManager() throws InterruptedException{
		cdp.VerifyEsclatedNoticeStatusAppearToSupervisorManager();
	}
	
	
	
	@Test(priority=6,description="verify the 'Approved and Appiled to case' 'View Notice' 'Manage Link' should appear to Non-supervisor user after notice approved by supervisor manager.")
	public void EscalatedNoticesCDP_VerifyEsclatedNoticeStatusAppearToNonSupervisorManager() throws InterruptedException{
		cdp.VerifyEsclatedNoticeStatusAppearToNonSupervisorManager();
	}
	
	@Test(priority=7,description="Verify that supervisor manager from outside the group is able to reject the escalated notice created by the any users in the agency, on CDP")
	public void EscalatedNoticesCDP_VerifyRejectNoticeOutsideGroupManager() throws InterruptedException {
		cdp.VerifyRejectNoticeOutsideGroupManager();
	}
	
	
	
	

}

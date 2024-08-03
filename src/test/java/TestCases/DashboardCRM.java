package TestCases;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CaseAssignmentUtility;
import POM.DashBoardCRMUtility;
import POM.LoginUtility;
import POM.SubmissionAssignmentUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashboardCRM extends BrowsersInvoked {
	public WebDriver driver;

	ITestResult result;
	
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = BrowsersInvoked.Setup();
		

	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

//	@Test(priority = 0, description = "Login Test Case")
//	public void LoginTest() throws InterruptedException {
//		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
//		dashCRM.LoginAgency();
//		
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
	public void Dashboard_VerifyCRMToggleButton() throws InterruptedException {

		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.Dashboard_VerifyCRMToggleButton();

	}

	@Test(priority = 2)
	public void Dashboard_VerifyDirectionToCRMDashboard() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.Dashboard_VerifyDirectionToCRMDashboard();

	}

	@Test(priority = 3)
	public void Dashboard_VerifyDirectionToCSLPForAssignedToMELink() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.Dashboard_VerifyDirectionToCSLPForAssignedToMELink();

	}

//	@Test(priority = 4)
//	public void Dashboard_VerifyDirectionToCSLPForMyDepartment() throws InterruptedException {
//		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
//		dashCRM.Dashboard_VerifyDirectionToCSLPForMyDepartment();
//
//	}

	@Test(priority = 5)
	public void Dashboard_VerifyDirectionToCSLPForMyAgency() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.Dashboard_VerifyDirectionToCSLPForMyAgency();

	}

//	@Test(priority = 6)
//	public void Dashboard_VerifyTheCountOfSubmissions() throws InterruptedException {
//		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
//		dashCRM.Dashboard_VerifyTheCountOfSubmissions();
//
//	}

	@Test(priority = 7)
	public void LoginNoSupervisorUser() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.logoutCurrentUserAndLoginOther("No Supervisor");

	}

	@Test(priority = 8)
	public void VerifyEscalatedinkForMyAgencyDisplayedForNoSupervisorUser() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyEscalatedinkForMyAgencyDisplayedForNoSupervisorUser();

	}

	@Test(priority = 9)
	public void VerifyNonSupervisorIsNaviagtedToCLP() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyUserIsNaviagtedToCLP();

	}

	@Test(priority = 10)
	public void VerifyEscalatedNoticeFilterAppliedByDefault() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyEscalatedNoticeFilterAppliedByDefault();

	}

	@Test(priority = 11)
	public void VerifyAllOptionsSelectedForEscalatedFilter() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyAllOptionsSelectedForEscalatedFilter();

	}

	@Test(priority = 12)
	public void VerifyAppropriateResultsAppearAfterFilter() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyAppropriateResultsAppearAfterFilter();

	}

	@Test(priority = 13)
	public void LoginBasicSupervisorUser() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.logoutCurrentUserAndLoginOther("Basic Supervisor");

	}

	@Test(priority = 14)
	public void EscalatedNoticeForMyAgencyDisplayed() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.EscalatedNoticeForMyAgencyDisplayed();

	}

	@Test(priority = 15)
	public void verifyBasicSupervisorNavigatedToCLP() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyUserIsNaviagtedToCLP();

	}

	@Test(priority = 16)
	public void verifyFilteeIsAppliedForEscalatedNotice() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyEscalatedNoticeFilterAppliedByDefault();

	}

	@Test(priority = 17)
	public void verifyAllOptionsAreSelected() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyAllOptionsSelectedForEscalatedFilter();

	}

	@Test(priority = 18)
	public void VerifyAppropriateResultsAppearAfterApplyingFilter() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyAppropriateResultsAppearAfterFilter();

	}

	// manager

	@Test(priority = 19)
	public void LoginSupervisorManagerUser() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.logoutCurrentUserAndLoginOther("Supervisor Manager");

	}

	@Test(priority = 20)
	public void EscalatedNoticeForMyAgencyDisplayedForSupervisorManager() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.EscalatedNoticeForMyAgencyDisplayed();

	}

	@Test(priority = 21)
	public void verifySupervisorManagerNavigatedToCLP() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyUserIsNaviagtedToCLP();

	}

	@Test(priority = 22)
	public void verifyFilteeIsAppliedForEscalatedNoticeForSupervisorManager() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyEscalatedNoticeFilterAppliedByDefault();

	}

	@Test(priority = 23)
	public void verifyAllOptionsAreSelectedForSupervisorManager() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyAllOptionsSelectedForEscalatedFilter();

	}

	@Test(priority = 24)
	public void VerifyAppropriateResultsAppearAfterApplyingFilterForSupervisorManager() throws InterruptedException {
		DashBoardCRMUtility dashCRM = new DashBoardCRMUtility(driver);
		dashCRM.VerifyAppropriateResultsAppearAfterFilter();

	}

}

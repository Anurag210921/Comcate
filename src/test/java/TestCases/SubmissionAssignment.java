package TestCases;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;
import POM.SubmissionAssignmentUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SubmissionAssignment extends BrowsersInvoked{

    public WebDriver driver;
    CaseAssignmentUtility obj ;
    ExtentReportClass extentClass;
    ITestResult result;
    SubmissionAssignmentUtility  subAss;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = BrowsersInvoked.Setup();
        subAss = new SubmissionAssignmentUtility(driver);
    }

    @AfterClass
    public void closeDriver() {
        BrowsersInvoked.tearDown(driver);
    }
    
//    @Test(priority =-1)
//	public void LoginAgency() throws InterruptedException {
//    	subAss.LoginAgency();
//
//	}
    
    
    @Test(priority = -1, description = "Login Test Case")
	public void LoginTest() throws InterruptedException {
    	LoginUtility log = new LoginUtility(driver);
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
	

    @Test(priority = 0,description = "Verify that 'Edit Assignment' popup opens up after clicking the 'Edit' icon next to 'Submission Assignment' rule on the 'Assignment Rules' page.")
    public void SubmissionAssignment_OpenEditAssignmentPopup() throws InterruptedException {
        subAss.SubmissionAssignment_OpenEditAssignmentPopup();
    }

    @Test(priority = 1,description = "Verify that user is not able to save the changes, when no Rule is added under 'Rules Set' tile, on 'Edit Assignment' popup. ")
    public void SubmissionAssignment_VerifyNoUpdationWithoutARule() throws InterruptedException {
        subAss.SubmissionAssignment_VerifyNoUpdationWithoutARule();
    }

    @Test(priority = 2,description = "Verify that 'Create Rule' popup opens up, when user clicks the 'Add Rule' button, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_OpenCreateRulePopup() throws InterruptedException {
        subAss.SubmissionAssignment_OpenCreateRulePopup();
    }

    @Test(priority = 3,description = "Verify that user is able to add multiple criterias under 'Define Critera' tile, after clicking on 'Add Criteria' link, on 'Create Rule' popup.")
    public void SubmissionAssignment_AddMultipleCriterias() throws InterruptedException {
        subAss.SubmissionAssignment_AddMultipleCriterias();
    }

    @Test(priority = 4,description = "Verify that the created rule gets added under 'Rules Set' tile, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_VerifyAddedRule() throws InterruptedException {
        subAss.SubmissionAssignment_VerifyAddedRule();
    }

    @Test(priority = 5,description = "Verify that user is able to edit the added Rules under 'Rules Set' tile, on 'Edit Assignment' popup")
    public void SubmissionAssignment_EditAddedRule() throws InterruptedException {
        subAss.SubmissionAssignment_EditAddedRule();
    }

    @Test(priority = 6,description = "Verify that user is able to delete that added Rules under 'Rules Set' tile, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_DeleteAddedRule() throws InterruptedException {
        subAss.SubmissionAssignment_DeleteAddedRule();
    }

    @Test(priority = 7,description = "Verify that Assignment Rule appears under 'Inactive' section, when user sets 'Status' toggle button as Inactive, on 'Edit Assignment' popup.")
    public void SubmissionAssignment_AssignmentRuleUnderInactiveSection() throws InterruptedException {
        subAss.SubmissionAssignment_AssignmentRuleUnderInactiveSection();
    }

    @Test(priority = 8,description = "Verify submission assignment works as per configure rule.")
    public void SubmissionAssignmentBaseOnAddedRule() throws InterruptedException {
        subAss.SubmissionAssignmentBaseOnAddedRule();
    }

    @Test(priority = 9,description = "Verify Case assignment works as per configure rule.")
    public void CaseAssignmentBaseOnAddedRule() throws InterruptedException {
        subAss.CaseAssignmentBaseOnAddedRule();
    }
}

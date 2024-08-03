package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.NotificationManagementUtility;

public class NotificationManagement extends BrowsersInvoked {

	public WebDriver driver;
	ExtentReportClass extentClass;
	ITestResult result;
	NotificationManagementUtility nm;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		nm = new NotificationManagementUtility(driver);
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
		nm.LoginAdmin();

	}

	@Test(priority = 1, description = "Verify navigation to 'Notification Management' and default Active -5 and Inactive -4 Notification count")
	public void AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount() throws InterruptedException {
		nm.AgencySetup_NotificationPreRequisiteAndDefaultNotificationCount();

	}

	@Test(priority = 2, description = "Verify that user is able to open and close the 'Create Notification' popup after clicking the 'Create Notification' and 'Cancel' buttons on 'Notification' and 'Create Notification' pages respectively")
	public void AgencySetup_CreateNotificationPopCloseOpenAndValidations() throws InterruptedException {
		nm.AgencySetup_CreateNotificationPopCloseOpenAndValidations();

	}

	@Test(priority = 3,description = "Verify that user is able to open and close the 'Create Rule' popup after clicking the 'Add Rule' and 'Cancel' buttons on 'Create Rule' and 'Create Rule' pages respectively")
	public void AgencySetup_CreateNotificationAddRulePopupValidations() throws InterruptedException {
		nm.AgencySetup_CreateNotificationAddRulePopupValidations();

	}

	@Test(priority = 4,description = "Verify that user is able to add Rules under 'Rules Set' section, on 'Create Notification' popup.")
	public void AgencySetup_CreateNotificationAddRule() throws InterruptedException {
		nm.AgencySetup_CreateNotificationAddRule();

	}

	@Test(priority = 5,description = "Verify that user is able to add Rules under 'Rules Set' section, on 'Create Notification' popup.")
	public void AgencySetup_CreateNotificationEditRule() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEditRule();

	}

	@Test(priority = 6,description = "Verify that user is able to create & add a Notification, under 'Notifications' tab.")
	public void AgencySetup_CreateNotificationCreateNotifiction() throws InterruptedException {
		nm.AgencySetup_CreateNotificationCreateNotifiction();

	}

	@Test(priority = 7,description = "Verify that user is able to create & add a Notification, under 'Notifications' tab.")
	public void AgencySetup_CreateNotifictionMultipleCriteriaDeliveryOption() throws InterruptedException {
		nm.AgencySetup_CreateNotifictionMultipleCriteriaDeliveryOption();

	}

	@Test(priority = 8,description = "Verify that user is able to Inactivate the Active notification on 'Notofication Mangement' Page")
	public void AgencySetup_CreateNotificationInactivateActiveNotificatiion() throws InterruptedException {
		nm.AgencySetup_CreateNotificationInactivateActiveNotificatiion();

	}

	@Test(priority = 9,description = "Verify that user is able to Activate the Inactive notification on 'Notofication Mangement' Page")
	public void AgencySetup_CreateNotificationActivateInactiveNotificatiion() throws InterruptedException {
		nm.AgencySetup_CreateNotificationActivateInactiveNotificatiion();

	}

	@Test(priority = 10, description = "Verify that user able to create 'Esclated Notice Generated' Notification on Notification Management Page")
	public void AgencySetup_CreateNotificationEscalatedNoticeGenerated() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEscalatedNoticeGenerated();

	}

	@Test(priority = 11, description = "Verify that user able to create 'Escalated Notice Reviewed by Supervisor' Notification on Notification Management Page")
	public void AgencySetup_CreateNotificationEscalatedNoticeReviewdSuperVisor() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEscalatedNoticeReviewdSuperVisor();

	}
	
	
	@Test(priority = 12, description = "Verify that user able to create 'Escalated Notice Edited' Notification on Notification Management Page")
	public void AgencySetup_CreateNotificationEscalatedNoticeEdited() throws InterruptedException {
		nm.AgencySetup_CreateNotificationEscalatedNoticeEdited();

	}

}

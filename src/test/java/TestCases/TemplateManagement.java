package TestCases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.Helper;
import Constant.CRMConstants;
import POM.LoginUtility;
import POM.TemplateManagementUtility;

public class TemplateManagement extends BrowsersInvoked {

	public WebDriver driver;
	ITestResult result;
	TemplateManagementUtility templateManagement;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		templateManagement = new TemplateManagementUtility(driver);
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
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

	@Test(priority = 1, description = "Verify TemplateMangement sub tab is open after clicking on TemplateMangement sidebar under Agency setup.")
	public void templateMangement_PreRequisite() throws InterruptedException {

		// Template Management Prerequisite (Navigation)
		templateManagement.TemplateMangement_PreRequisite();

		// get email Template Tab text
		String emailTemplatesLabel = templateManagement.getEmailTemplateTab();

		// get text Template Tab text
		String textMessageTemplateLabel = templateManagement.getTextTemplateTab();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(emailTemplatesLabel, CRMConstants.EMAIL_TEMPLATE_LABEL);
		softAssert.assertEquals(textMessageTemplateLabel, CRMConstants.TEXT_MESSAGE_TEMPLATE_LABEL);
		softAssert.assertAll();

	}

	@Test(priority = 2, description = "Verify that user is able to open and close the '' popup after clicking the '' and '' buttons on '' and '' pages respectively")
	public void templateMangement_CloseandOpenCreateTemplatePOpup() throws InterruptedException {

		// open create Template pop up

		templateManagement.openCreateTemplatePopUp();

		// get title
		String crtTemplateHeader = templateManagement.getCrtTemplatePopupTitle();

		// close create Template pop up

		templateManagement.closeCreateTemplatePopUp();

		// get title
		int count = templateManagement.getCreateTemplateHeaderCount();
        Boolean check = count == 0;
		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(crtTemplateHeader, CRMConstants.CREATE_TEMPLATE_HEADER);
		softAssert.assertEquals(check, Boolean.TRUE);
		softAssert.assertAll();

	}

	@Test(priority = 3, description = "Verify that appropriate validation messages appears, on clicking the 'Save' button when no/ data exceeding the max limit is entered in fields, on 'Create Template' popup")
	public void templateMangement_VerifyValidationsOnCreateTemplatePOpup() throws InterruptedException, AWTException {

		// open create Template pop up
		templateManagement.openCreateTemplatePopUp();

		// click on save Template button
		templateManagement.clickOnSaveTemplate();

		// get Template name validation text
		String actualNameValidMsg = templateManagement.getTemplateNameValidationMsg();

		// get email subject line validation text
		String actualEmailSubLineValidMsg = templateManagement.getTemplateEmailSubValidationMsg();

		// get email body validation text
		String actualEmailBdyValidMsg = templateManagement.getEmailBodyvalidMsg();

		// set email sub line 151 random character String 
		templateManagement.setEmailSubLineRndChar(151);

		// click on save Template button
		templateManagement.clickOnSaveTemplate();

		// get email subject line validation text
		String emailSubLineValidMsg = templateManagement.getTemplateEmailSubValidationMsg();

		// Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualNameValidMsg, CRMConstants.NAME_VALID_MSG);
		softAssert.assertEquals(actualEmailSubLineValidMsg, CRMConstants.EMAIL_SUBLINE_VALIDMSG);
		softAssert.assertEquals(actualEmailBdyValidMsg, CRMConstants.EMAIL_BODY_VALIDMSG);
		softAssert.assertEquals(actualEmailSubLineValidMsg, emailSubLineValidMsg);
		softAssert.assertAll();

	}

	@Test(priority = 4, description = "Verify that user is able to add/remove a single as well as multiple documents, on 'Create Template' popup")
	public void templateMangement_VerifyAdditionofMultipleDocTemplatePOpup() throws InterruptedException, AWTException {
		Helper helper = new Helper(driver);
		
		// add 1 template files 
		templateManagement.addTemplateFile("Jellyfish_11zon.jpg");
		
		// add 2 template files 
		templateManagement.addTemplateFile("Panda_11zon.jpg");
		
		// static wait applied 
		helper.forcedWaitTime(2);
		
		// get added file count
		int filesCount = templateManagement.getAddedTemplateFileCount();
		
		// remove file
		templateManagement.clickOnRemovefilesIcon();
		
		// static wait applied 
		helper.forcedWaitTime(2);
		
		// get added file count
		int filescountAfter = templateManagement.getAddedTemplateFileCount();
				
		// Test Data Added (add 1 template files) 
		templateManagement.addTemplateFile("Jellyfish_11zon.jpg");
				
		
		// Assert 		
		Boolean filesCountCheck = filesCount == 2;
		Boolean filesAfterCountCheck = filescountAfter < filesCount;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(filesCountCheck, Boolean.TRUE);
		softAssert.assertEquals(filesAfterCountCheck, Boolean.TRUE);
		softAssert.assertAll();
		
		
		

	}

	@Test(priority = 5, description = "Verify that 'Preview Email Template' popup opens up with appropriate data, when user clicks 'Preview' button, on 'Create Template' popup.")
	public void templateMangement_VerifyEmailPreviewPopDataAutoPopulated() throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyEmailPreviewPopDataAutoPopulated();

	}

	@Test(priority = 6, description = "New template gets added under 'Email templates' tab, when user clicks on 'Save' button after entering data in mandatory fields, on 'Create Template' popup.")
	public void TemplateMangement_VerifyTemplateAdditionOfTemplate() throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyTemplateAdditionOfTemplate();

	}

	@Test(priority = 7, enabled = true, description = "Verify that respective 'Edit Template Name' popup opens up, when user clicks on 'Edit' icon of any template and able to edit template on 'Template Management' page.")
	public void TemplateMangement_VerifyEditTheTemplate() throws InterruptedException, AWTException {

		templateManagement.TemplateMangement_VerifyEditTheTemplate();

	}

	@Test(priority = 8, description = "Verify that an error message appears & Template does not get created, when user clicks on 'Save' button, after entering existing data in 'Name' field, on 'Create Template' popup.")
	public void TemplateMangement_VerifyErrorMessgeOnAdditionOfExistingTemplate()
			throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyErrorMessgeOnAdditionOfExistingTemplate();

	}

	@Test(priority = 9, description = "Verify that user able to activate/deactivate the template on 'Email Template' Page")
	public void TemplateMangement_VerifyActivateAndDeActivateTemplate() throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyActivateAndDeActivateTemplate();

	}

	@Test(priority = 10, description = "Verify Default Esclated Notices Email Template 'Escalated Notice Generated' and 'Escalated Notice Reviewed by Supervisor' should present on Email Template Page.")
	public void TemplateMangement_VerifyDefaultEsclatedNoticeTemplate() throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyDefaultEsclatedNoticeTemplate();

	}

	@Test(priority = 11, description = "Verify that appropriate email body and Email Subject Line field, after editing the 'Escalated Notice Generated' email template, on 'Template Management' page")
	public void TemplateMangement_VerifyEscalatedNoticeGeneratedTemplate() throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyEscalatedNoticeGeneratedTemplate();

	}

	@Test(priority = 12, description = "Verify that appropriate email body and Email Subject Line field, after editing the 'Escalated Notice Reviewed by Supervisor' email template, on 'Template Management' page")
	public void TemplateMangement_VerifyEscalatedNoticeSupervisorTemplate() throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyEscalatedNoticeSupervisorTemplate();

	}

	@Test(priority = 13, description = "Verify that appropriate email body and Email Subject Line field, after editing the 'Escalated Notice Edited' email template, on 'Template Management' page")
	public void TemplateMangement_VerifyEscalatedNoticeEditedTemplate() throws InterruptedException, AWTException {
		templateManagement.TemplateMangement_VerifyEscalatedNoticeEditedTemplate();

	}

}

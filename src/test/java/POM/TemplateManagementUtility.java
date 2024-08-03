package POM;

import BrowsersBase.BrowsersInvoked;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import CommonMethods.Helper;
import CommonMethods.PropertiesUtils;
import CommonMethods.RandomStrings;

public class TemplateManagementUtility extends Helper {

	public WebDriver driver;
	LoginUtility log;
	CRMCommonMethods crmCommonMethod;
	CECommonMethods ceCommonMethod;

	public TemplateManagementUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
		crmCommonMethod = new CRMCommonMethods(driver);
		ceCommonMethod = new CECommonMethods(driver);
	}

	public static String loggedUserName = "//div[@class='app-header__user-name']//label";
	public static String templateManagementSideBarTab = "//label[text()='Template Management']";
	public static String textTemplatesTab = "//div[@class='tab-name ']";
	public static String createTemplateBtn = "//h2[contains(text(),'Active')]//parent::div//button";
	public static String emailTemplatesTab = "//div[@class='tab-name ']//preceding-sibling::div";
	public static String createTemplatePopupHeader = "//div[@class='modal-header']//h1";

	public static String inactiveTemplate = "//h2[contains(text(),'Inactive')]";

	public static String cancelCrtTemplate = "//button[text()='Cancel']";
	public static String saveCrtTemplate = "//button[text()='Save']";
	public static String templateNameTxt = "//input[@name='name']";
	public static By TemplateNameTxt = By.xpath(templateNameTxt);
	public static By MessageBody = By.xpath("//body[@class='mce-content-body ']");
	public static By IncludeMagicLinkchk = By.xpath("//input[@name='MagicLinkToggle'][@type='checkbox']");
	public static By PreviewTemplateBtn = By.xpath("//button[text()='Preview']");
	public static By PreviewTempHeader = By.xpath("(//div[@class='modal-header'])[2]");
	public static By PreviewTemplateBdyMesg = By.xpath("(//div[@class='modal-header'])[2]//following-sibling::div//p");
	public static By ClosePreview = By.xpath("//button[text()='Close']");
	public static By IframeBody = By.xpath("//iframe[@id='editor_ifr']");
	public static String activeTooglebtn = "//button[text()='Active']";
	public static String inactiveTooglebtn = "//button[text()='Inactive']";

	public static String ExistingErrorTemplate = "//div[contains(text(),'Error while creating config email template')]";

	public static By ActiveTogglebtn = By.xpath(activeTooglebtn);
	public static By InactiveTooglebtn = By.xpath(inactiveTooglebtn);

	public static By EmailTemplatesTab = By.xpath(emailTemplatesTab);
	public static By CreateTemplateBtn = By.xpath(createTemplateBtn);
	public static By TextTemplatesTab = By.xpath(textTemplatesTab);
	public static By TemplateManagementSideBarTab = By.xpath(templateManagementSideBarTab);
	public static By CreateTemplatePopupHeader = By.xpath(createTemplatePopupHeader);
	public static By CancelCrtTemplate = By.xpath(cancelCrtTemplate);
	public static By SaveCrtTemplate = By.xpath(saveCrtTemplate);
	public static By LoggedUserName = By.xpath(loggedUserName);
	public static By InactiveTemplate = By.xpath(inactiveTemplate);
	public static String TempalteName = "//div[text()='%s']";
	public static String EditTemplate = "//div[text()='%s']//parent::div/div/button";
	public static By TemplateSubjectLine = By.xpath("//input[@name='subject']");

	public static String nameValidMsg = "";
	public static String emailSubLineValidMsg = "";
	public static String emailBdyValidMsg = "//label[@class='html-editor__error']";
	public static String emailSubLineInput = "//input[@name='subject']";
	public static By TemplateEmailBodyMsz = By.xpath("//body[@class='mce-content-body ']//p");

	public static By EmailBdyValidMsg = By.xpath(emailBdyValidMsg);
	public static By EmailSubLineInput = By.xpath(emailSubLineInput);

	// Global Variables

	public static String emailTemplatesLabel;
	public static String TextMessageTemplateLabel;
	public static String CrtTemplateHeader;
	public static Boolean ClosedCrtTemplatePopup;
	public static String ActualNameValidMsg;
	public static String ActualEmailSubLineValidMsg;
	public static String ActualEmailBdyValidMsg;
	public static String EmailSubLnMsg;
	public static String templateName;
	public static String rndSubLine;
	public static String TemplateMessgae;
	public static String ActualpreviewTempData;
	public static String ExpectedpreviewTemplateData;
	public static String ActualpreviewTempHeader;
	public static String LoggedUser;

	public static String ExpectedpreviewTemplateHeader = "Preview Email Template";
	public static String ExpectedNameValidMsg = "The Name is required.";
	public static String ExpectedEmailSubLineValidMsg = "Min 1 and Max 150 characters limit.";
	public static String ExpectedEmailBdyValidMsg = "The Email Body is required.";
	public static String ExpectedemailTemplatesLabel = "Email Templates";
	public static String ExpectedTextMessageTemplateLabel = "Text Message Templates";
	public static String ExpectedCrtTemplateHeader = "Create Template";

	public void LoginAdmin() throws InterruptedException {
		log.LoginAgency();

	}

	public String getEmailTemplateTab() {
		String text = getTextElement(EmailTemplatesTab);
		return text;
	}

	public String getTextTemplateTab() {
		String text = getTextElement(TextTemplatesTab);
		return text;
	}

	public String getLoggedUser() {
		String loggedUser = getTextElement(LoggedUserName);
		return loggedUser;
	}

	public void TemplateMangement_PreRequisite() throws InterruptedException {
		refreshPage();
		waitForCurserRunning(10);
		scrolltoUp();
		crmCommonMethod.navigateToAgencySetup();
		crmCommonMethod.navigateToTemplateManagement();
	}

	public void closeCreateTemplatePopUp() {
		waitUntilElementIsVisible(CancelCrtTemplate);
		scrollIntoView(CancelCrtTemplate);
		waitForElementIsInteractable(CancelCrtTemplate);
		clickByJsExecuter(CancelCrtTemplate);
		waitUntilElementInvisibleLocated(CancelCrtTemplate);
	}

	public void openCreateTemplatePopUp() {
		waitUntilElementIsVisible(CreateTemplateBtn);
		scrollIntoView(CreateTemplateBtn);
		waitForElementIsInteractable(CreateTemplateBtn);
		clickByJsExecuter(CreateTemplateBtn);
		waitUntilElementIsVisible(CreateTemplatePopupHeader);
	}

	public String getCrtTemplatePopupTitle() {
		String title = getTextElement(CreateTemplatePopupHeader);
		return title;
	}

	public int getCreateTemplateHeaderCount() {
		waitUntilElementIsVisible(CreateTemplatePopupHeader);
		int count = driver.findElements(CreateTemplatePopupHeader).size();
		return count;
	}

	public String GetCustomXPath(int index) {
		String xpath = "(//span[@class='field__error'])[" + index + "]";
		return xpath;
	}

	public void clickOnSaveTemplate() {
		waitUntilElementIsVisible(SaveCrtTemplate);
		scrollIntoView(SaveCrtTemplate);
		waitForElementIsInteractable(SaveCrtTemplate);
		clickByJsExecuter(SaveCrtTemplate);
	}

	public String getTemplateNameValidationMsg() {
		waitUntilElementIsVisible(By.xpath(GetCustomXPath(1)));
		String text = findElementByXPath(GetCustomXPath(1)).getText();
		return text;
	}

	public String getTemplateEmailSubValidationMsg() {
		waitUntilElementIsVisible(By.xpath(GetCustomXPath(2)));
		String text = findElementByXPath(GetCustomXPath(2)).getText();
		return text;
	}

	public String getEmailBodyvalidMsg() {
		String text = getTextElement(EmailBdyValidMsg);
		return text;
	}

	public void setEmailSubLineRndChar(int charCount) {
		scrollIntoView(EmailSubLineInput);
		String rng = RandomStrings.requiredString(charCount);
		waitForElementIsInteractable(EmailSubLineInput);
		sendKeysWithWait(EmailSubLineInput, rng);
	}

	public String AddDocument = "//label[text()='Add Related Documents']";
	public String addedFiles = "//div[@class='chip__body']";
	public String removeFiles = "//button[@class='chip__close-button']";

	public By AddedFiles = By.xpath(addedFiles);
	public By RemoveFiles = By.xpath(removeFiles);
	public int filescount;
	public Boolean filesCountCheck;
	public String DocumentJellyFish = "Jellyfish_11zon.jpg";
	public String DocumentPanda = "Panda_11zon.jpg";
	public Boolean filesAfterCountCheck;
	public int filescountAf;

	
	public void addTemplateFile(String fileName) throws InterruptedException, AWTException {
		String filePath = ceCommonMethod.SetTestDataFilePath(fileName);
		crmCommonMethod.addTemplateFiles(AddDocument, filePath);
		waitUntilElementIsVisible(AddedFiles);
	}
	
	public int getAddedTemplateFileCount() {
		int filesCount = driver.findElements(AddedFiles).size();
		return filesCount;
		
	}
	
	public void clickOnRemovefilesIcon() {
		waitUntilElementIsVisible(RemoveFiles);
		scrollIntoView(RemoveFiles);
		waitForElementIsInteractable(RemoveFiles);
		WebElement ele = driver.findElement(RemoveFiles);
		ele.click();
		waitUntilElementIsVisible(AddedFiles);
	}
	
	
	public void setTemplateName(String templateName) {
		waitUntilElementIsVisible(TemplateNameTxt);
		scrollIntoView(TemplateNameTxt);
		waitForElementIsInteractable(TemplateNameTxt);
		sendKeysWithWait(TemplateNameTxt, templateName);
		
		
	}
	
	public void setTemplateEmailSubLine(String emailSubLine) {
		scrollIntoView(EmailSubLineInput);
		waitForElementIsInteractable(EmailSubLineInput);
		clearElement(EmailSubLineInput);
		waitForElementIsInteractable(EmailSubLineInput);
		sendKeysWithWait(EmailSubLineInput, emailSubLine);
		
	}
	
	public void TemplateMangement_VerifyEmailPreviewPopDataAutoPopulated() throws InterruptedException, AWTException {
		waitUntilElementIsVisible(TemplateNameTxt);
		scrollIntoView(TemplateNameTxt);
		waitForElementIsInteractable(TemplateNameTxt);
		templateName = RandomStrings.requiredCharacters(3) + "Template";
		sendKeysWithWait(TemplateNameTxt, templateName);
		
		
		scrollIntoView(EmailSubLineInput);
		rndSubLine = RandomStrings.requiredCharacters(3) + "EmailSubjectLine";
		waitForElementIsInteractable(EmailSubLineInput);
		clearElement(EmailSubLineInput);
		waitForElementIsInteractable(EmailSubLineInput);
		sendKeysWithWait(EmailSubLineInput, rndSubLine);
		waitForElementIsInteractable(EmailSubLineInput);
		
		scrollIntoView(TemplateManagementSideBarTab);
		TemplateMessgae = RandomStrings.requiredCharacters(10);
		ExpectedpreviewTemplateData = TemplateMessgae;
		
		String currentWindow = driver.getWindowHandle();
		WebElement switchFrame = waitUntilVisibleWE(IframeBody);
		driver.switchTo().frame(switchFrame);
		
		waitForElementIsInteractable(MessageBody);
		sendKeysWithWait(MessageBody, TemplateMessgae);
		forcedWaitTime(4);
		
		// driver.switchTo().defaultContent();
		driver.switchTo().window(currentWindow);
		forcedWaitTime(4);
		
		scrollIntoView(IncludeMagicLinkchk);
		clickByJsExecuter(IncludeMagicLinkchk);
		
		scrollIntoView(SaveCrtTemplate);
		
		waitForElementIsInteractable(PreviewTemplateBtn);
		clickByJsExecuter(PreviewTemplateBtn);
		
		waitUntilElementIsVisible(PreviewTempHeader);
		waitUntilElementIsVisible(PreviewTemplateBdyMesg);
		
		ActualpreviewTempHeader = getTextElement(PreviewTempHeader);
		ActualpreviewTempData = getTextElement(PreviewTemplateBdyMesg);
		
		waitForElementIsInteractable(ClosePreview);
		clickByJsExecuter(ClosePreview);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualpreviewTempData, ExpectedpreviewTemplateData);
		softAssert.assertEquals(ActualpreviewTempHeader, ExpectedpreviewTemplateHeader);
		softAssert.assertAll();
	}

	public String TemplateGridNameLbl;
	public String TemplateGridSubLine;

	public String TemplateGridRelatedDoc;

	public String TemplateGridLastUpdated;

	public String ActiveTemplatecount;

	public By ActiveTemplates = By.xpath("//h2[contains(text(),'Active')]");

	public String GetInactiveTemplateXPath(int index) {
		return "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])["
				+ index + "]";
	}

	public String GetCustomTemplateGridXPath(int index) {
		return "(//div[@class='sortable-table__body__tr']/div)[" + index + "]";
	}

	public String GetInactiveEditIconXPath(int index) {
		return "(//h2[contains(text(),'Inactive')]//ancestor::div[@class='agency-setup-tab__section']//div[@class='rt-td'])["
				+ index + "]//button";
	}

	public String GetTemplateEditButtonXPath(int index) {
		return "(//div[@class='sortable-table__body__tr']/div)[" + index + "]//button";
	}

	public String GetCustomTemplateMoreLinlXPath(int index) {

		return "(//div[@class='sortable-table__body__tr']/div)[" + index
				+ "]//span//following-sibling::a[text()='more']";
	}

	public String GetCustomTemplateLessLinlXPath(int index) {

		return "(//div[@class='sortable-table__body__tr']/div)[" + index
				+ "]//span//following-sibling::a[text()=' less']";
	}

	public String LastUpdatedGridXPath(int index) {
		return "(//div[@class='sortable-table__body__tr']/div)[" + index + "]//span";
	}

	public void TemplateMangement_VerifyTemplateAdditionOfTemplate() throws InterruptedException, AWTException {

		waitUntilElementIsVisible(SaveCrtTemplate);
		scrollIntoView(SaveCrtTemplate);
		waitForElementIsInteractable(SaveCrtTemplate);
		clickByJsExecuter(SaveCrtTemplate);
		waitForCurserRunning(3);
		waitUntilElementIsVisible(CreateTemplateBtn);
		waitForElementIsInteractable(CreateTemplateBtn);
		scrollIntoView(ActiveTemplates);
		forcedWaitTime(4);
		ActiveTemplatecount = getTextElement(ActiveTemplates).split(" ")[0];
		int index = ((Integer.parseInt(ActiveTemplatecount)) * 5) - 4;
		waitUntilElementIsVisible(By.xpath(GetCustomTemplateGridXPath(index)));
		TemplateGridNameLbl = driver.findElement(By.xpath(GetCustomTemplateGridXPath(index))).getText();
		TemplateGridSubLine = driver.findElement(By.xpath(GetCustomTemplateGridXPath(index + 1))).getText();
		waitUntilElementIsVisible(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		scrollIntoView(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		waitForElementIsInteractable(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		WebElement ele = driver.findElement(By.xpath(GetCustomTemplateMoreLinlXPath(index + 2)));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
		forcedWaitTime(4);
		waitUntilElementIsVisible(By.xpath(GetCustomTemplateGridXPath(index + 2)));
		TemplateGridRelatedDoc = driver.findElement(By.xpath(GetCustomTemplateGridXPath(index + 2))).getText();
		TemplateGridLastUpdated = driver.findElement(By.xpath(LastUpdatedGridXPath(index + 3))).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TemplateGridNameLbl, templateName);
		softAssert.assertEquals(TemplateGridSubLine.trim(), rndSubLine.trim());
		softAssert.assertEquals(TemplateGridRelatedDoc.contains((DocumentJellyFish.replace(".jpg", ""))), true);
		softAssert.assertEquals(TemplateGridRelatedDoc.contains((DocumentPanda.replace(".jpg", ""))), true);
		softAssert.assertEquals(TemplateGridLastUpdated.contains(LoggedUser), true);
		softAssert.assertAll();
	}

	public Boolean TemplateNameStatus;

	public String EditTemplateHeader;
	public String actualTemplateName;

	public By EditTemplatePopHeader = By.xpath(createTemplatePopupHeader);

	public void TemplateMangement_VerifyEditTheTemplate() throws InterruptedException, AWTException {

		scrollIntoView(ActiveTemplates);
		ActiveTemplatecount = getTextElement(ActiveTemplates).split(" ")[0];
		int index = Integer.parseInt(ActiveTemplatecount) * 5;
		forcedWaitTime(2);
		scrollIntoView(By.xpath(GetTemplateEditButtonXPath(index)));
		actualTemplateName = "Edit " + getTextElement(By.xpath(GetCustomTemplateGridXPath(index - 4)));
		clickByJsExecuter(By.xpath(GetTemplateEditButtonXPath(index)));
		waitUntilElementIsVisible(EditTemplatePopHeader);
		forcedWaitTime(4);
		EditTemplateHeader = getTextElement(EditTemplatePopHeader);
		TemplateNameStatus = driver.findElement(TemplateNameTxt).isEnabled();
		scrollIntoView(EmailSubLineInput);
		waitForElementIsInteractable(EmailSubLineInput);
		rndSubLine = RandomStrings.requiredString(3) + "EmailSubEdited";
		clearElement(EmailSubLineInput);
		waitForElementIsInteractable(EmailSubLineInput);
		sendKeysWithWait(EmailSubLineInput, rndSubLine);
		scrollIntoView(SaveCrtTemplate);
		waitForElementIsInteractable(SaveCrtTemplate);
		clickByJsExecuter(SaveCrtTemplate);
		waitForCurserRunning(4);
		forcedWaitTime(4);
		waitUntilElementIsVisible(By.xpath(GetCustomTemplateGridXPath(index)));
		scrollIntoView(By.xpath(GetCustomTemplateGridXPath(index)));
		forcedWaitTime(4);
		TemplateGridSubLine = driver.findElement(By.xpath(GetCustomTemplateGridXPath(index - 3))).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(TemplateGridSubLine.trim(), rndSubLine.trim());
		softAssert.assertEquals(TemplateNameStatus, Boolean.FALSE);
		softAssert.assertEquals(actualTemplateName, EditTemplateHeader);
		softAssert.assertAll();
	}

	public String InactivatedTemplate;
	public String ActivatedTemplate;
	public String InactiveTemplatecount;
	public String InactiveTemplatecountBefore;
	public String InactiveTemplatecountAfter;
	public int actualCount;
	public int expectedCount;

	public int actualCountActive;
	public int expectedCountActive;

	public void TemplateMangement_VerifyActivateAndDeActivateTemplate() throws InterruptedException, AWTException {

		forcedWaitTime(2);
		waitUntilElementIsVisible(ActiveTemplates);
		scrollIntoView(ActiveTemplates);
		ActiveTemplatecount = getTextElement(ActiveTemplates).split(" ")[0];
		int indexActive = Integer.parseInt(ActiveTemplatecount) * 5;
		ActivatedTemplate = driver.findElement(By.xpath(GetCustomTemplateGridXPath(indexActive - 4))).getText();
		scrollIntoView(InactiveTemplate);
		InactiveTemplatecountBefore = getTextElement(InactiveTemplate).split(" ")[0];
		expectedCount = Integer.parseInt(InactiveTemplatecountBefore) + 1;

		scrollIntoView(By.xpath(GetTemplateEditButtonXPath(indexActive)));
		waitForElementIsInteractable(By.xpath(GetTemplateEditButtonXPath(indexActive)));
		clickByJsExecuter(By.xpath(GetTemplateEditButtonXPath(indexActive)));

		forcedWaitTime(4);
		waitUntilElementIsVisible(InactiveTooglebtn);
		waitForElementIsInteractable(InactiveTooglebtn);
		clickByJsExecuter(InactiveTooglebtn);

		forcedWaitTime(2);
		waitUntilElementIsVisible(SaveCrtTemplate);
		scrollIntoView(SaveCrtTemplate);
		waitForElementIsInteractable(SaveCrtTemplate);
		clickByJsExecuter(SaveCrtTemplate);
		waitUntilElementInvisibleLocated(SaveCrtTemplate);

		waitForCurserRunning(7);

		waitUntilElementIsVisible(InactiveTemplate);
		scrollIntoView(InactiveTemplate);
		InactiveTemplatecountAfter = getTextElement(InactiveTemplate).split(" ")[0];
		int indexInactive = Integer.parseInt(InactiveTemplatecountAfter) * 5;
		actualCount = Integer.parseInt(InactiveTemplatecountAfter);
		InactivatedTemplate = driver.findElement(By.xpath(GetInactiveTemplateXPath(indexInactive - 4))).getText();
		scrollIntoView(ActiveTemplates);
		ActiveTemplatecount = getTextElement(ActiveTemplates).split(" ")[0];
		expectedCountActive = Integer.parseInt(ActiveTemplatecount) + 1;

		scrollIntoView(By.xpath(GetInactiveEditIconXPath(indexInactive)));
		waitForElementIsInteractable(By.xpath(GetInactiveEditIconXPath(indexInactive)));
		clickByJsExecuter(By.xpath(GetInactiveEditIconXPath(indexInactive)));

		forcedWaitTime(4);
		waitUntilElementIsVisible(ActiveTogglebtn);
		waitForElementIsInteractable(ActiveTogglebtn);
		clickByJsExecuter(ActiveTogglebtn);

		forcedWaitTime(2);
		scrollIntoView(SaveCrtTemplate);
		waitForElementIsInteractable(SaveCrtTemplate);
		clickByJsExecuter(SaveCrtTemplate);
		waitUntilElementInvisibleLocated(SaveCrtTemplate);

		waitForCurserRunning(5);

		waitUntilElementIsVisible(ActiveTemplates);
		scrollIntoView(ActiveTemplates);
		ActiveTemplatecount = getTextElement(ActiveTemplates).split(" ")[0];
		actualCountActive = Integer.parseInt(ActiveTemplatecount);
		indexActive = Integer.parseInt(ActiveTemplatecount) * 5;
		ActivatedTemplate = driver.findElement(By.xpath(GetCustomTemplateGridXPath(indexActive - 4))).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualCount, expectedCount);
		softAssert.assertEquals(ActivatedTemplate, InactivatedTemplate);
		softAssert.assertEquals(InactivatedTemplate, ActivatedTemplate);
		softAssert.assertEquals(actualCountActive, expectedCountActive);
		softAssert.assertAll();
	}

	public String existingTemplateName;
	public String expectedMsg;
	public String actualMsg = "Error while creating config email template";

	public void TemplateMangement_VerifyErrorMessgeOnAdditionOfExistingTemplate()
			throws InterruptedException, AWTException {

		forcedWaitTime(2);
		waitUntilElementIsVisible(ActiveTemplates);
		scrollIntoView(ActiveTemplates);
		ActiveTemplatecount = getTextElement(ActiveTemplates).split(" ")[0];
		int indexActive = Integer.parseInt(ActiveTemplatecount) * 5;
		existingTemplateName = driver.findElement(By.xpath(GetCustomTemplateGridXPath(indexActive - 4))).getText();
		crmCommonMethod.addNewTemplate(existingTemplateName);
		waitUntilElementIsVisible(By.xpath(ExistingErrorTemplate));
		expectedMsg = getTextElement(By.xpath(ExistingErrorTemplate));
		scrollIntoView(CancelCrtTemplate);
		waitForElementIsInteractable(CancelCrtTemplate);
		clickOn(CancelCrtTemplate);
		waitUntilElementInvisibleLocated(CancelCrtTemplate);
		waitForCurserRunning(3);
		waitForElementIsInteractable(CreateTemplateBtn);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualMsg, expectedMsg);
		softAssert.assertAll();

	}

	public void TemplateMangement_VerifyDefaultEsclatedNoticeTemplate() throws InterruptedException {

		waitUntilElementIsVisible(By.xpath(stringFormat(TempalteName, "Escalated Notice Generated")));
		waitUntilElementIsVisible(By.xpath(stringFormat(TempalteName, "Escalated Notice Reviewed by Supervisor")));

		Boolean EsclatedNoticesTemplate1 = elementIsDisplayed(
				By.xpath(stringFormat(TempalteName, "Escalated Notice Generated")));
		Boolean EsclatedNoticesTemplate2 = elementIsDisplayed(
				By.xpath(stringFormat(TempalteName, "Escalated Notice Reviewed by Supervisor")));

		Assert.assertTrue(EsclatedNoticesTemplate1, "Escalated Notice Generated template is not Present.");
		Assert.assertTrue(EsclatedNoticesTemplate2, "Escalated Notice Reviewed by Supervisor template is not Present.");

	}

	public void ClickonCancelTemplateButton() {
		waitUntilElementIsVisible(CancelCrtTemplate);
		scrollIntoView(CancelCrtTemplate);
		waitForElementIsInteractable(CancelCrtTemplate);
		clickByJsExecuter(CancelCrtTemplate);
		waitUntilElementInvisibleLocated(CancelCrtTemplate);
	}

	public void TemplateMangement_VerifyEscalatedNoticeGeneratedTemplate() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath(stringFormat(TempalteName, "Escalated Notice Generated")));
		scrollIntoView(By.xpath(stringFormat(TempalteName, "Escalated Notice Generated")));
		clickByJsExecuter(By.xpath(stringFormat(EditTemplate, "Escalated Notice Generated")));
		waitForCurserRunning(5);
		waitUntilElementIsVisible(TemplateSubjectLine);
		forcedWaitTime(4);
		waitUntilElementIsVisible(TemplateSubjectLine);
		String subjectLine = getValueAttribute(TemplateSubjectLine);
		WebElement switchFrame = waitUntilVisibleWE(IframeBody);
		driver.switchTo().frame(switchFrame);
		waitForElementIsInteractable(MessageBody);
		String EmailBodyMsz = getTextElement(TemplateEmailBodyMsz);
		forcedWaitTime(4);
		driver.switchTo().defaultContent();
		forcedWaitTime(4);
		Assert.assertEquals(subjectLine.trim(), "Escalated Notice Generated",
				"Subject Line is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz1")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz2")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz3")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz4")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz5")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz6")),
				"Esclated Notice Email Template BodyMsz is not as per the acceptance.");

		ClickonCancelTemplateButton();

	}

	public void TemplateMangement_VerifyEscalatedNoticeSupervisorTemplate() throws InterruptedException {

		waitUntilElementIsVisible(By.xpath(stringFormat(TempalteName, "Escalated Notice Reviewed by Supervisor")));
		scrollIntoView(By.xpath(stringFormat(TempalteName, "Escalated Notice Reviewed by Supervisor")));
		clickByJsExecuter(By.xpath(stringFormat(EditTemplate, "Escalated Notice Reviewed by Supervisor")));
		waitForCurserRunning(5);
		waitUntilElementIsVisible(TemplateSubjectLine);
		forcedWaitTime(5);
		String subjectLine = getValueAttribute(TemplateSubjectLine);
		WebElement switchFrame = waitUntilVisibleWE(IframeBody);
		driver.switchTo().frame(switchFrame);
		waitForElementIsInteractable(MessageBody);
		String EmailBodyMsz = getTextElement(TemplateEmailBodyMsz);
		forcedWaitTime(4);
		driver.switchTo().defaultContent();
		forcedWaitTime(4);
		Assert.assertEquals(subjectLine.trim(), "Escalated Notice Reviewed by Supervisor",
				"Subject Line is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMszSupervisor1")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMszSupervisor2")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz3")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz4")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz5")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz6")),
				"Esclated Notice Supervisor Email Template BodyMsz is not as per the acceptance.");

		ClickonCancelTemplateButton();
	}

	public void TemplateMangement_VerifyEscalatedNoticeEditedTemplate() throws InterruptedException {
		waitUntilElementIsVisible(By.xpath(stringFormat(TempalteName, "Escalated Notice Edited")));
		scrollIntoView(By.xpath(stringFormat(TempalteName, "Escalated Notice Edited")));
		clickByJsExecuter(By.xpath(stringFormat(EditTemplate, "Escalated Notice Edited")));
		waitForCurserRunning(5);
		waitUntilElementIsVisible(TemplateSubjectLine);
		forcedWaitTime(5);
		String subjectLine = getValueAttribute(TemplateSubjectLine);
		WebElement switchFrame = waitUntilVisibleWE(IframeBody);
		driver.switchTo().frame(switchFrame);
		waitForElementIsInteractable(MessageBody);
		String EmailBodyMsz = getTextElement(TemplateEmailBodyMsz);
		forcedWaitTime(4);
		driver.switchTo().defaultContent();
		forcedWaitTime(4);
		Assert.assertEquals(subjectLine.trim(), "Escalated Notice Edited".trim(),
				"Subject Line is not as per the acceptance.");
		System.out.println("length of subjectLine :" + subjectLine.length());
		String s = "Escalated Notice Edited";
		System.out.println("Escalated Notice Edited : " + s.length());
		String subjectLine2 = subjectLine.trim();
		System.out.println("after length of subjectLine :" + subjectLine2.length());

		Assert.assertEquals(subjectLine2, "Escalated Notice Edited", "Subject Line is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz1")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedNoticeEditedBodyMsz2")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz3")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz4")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz5")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");
		Assert.assertTrue(EmailBodyMsz.contains(PropertiesUtils.getPropertyValue("EsclatedEmailBodyMsz6")),
				"Escalated Notice Edited BodyMsz is not as per the acceptance.");

		ClickonCancelTemplateButton();

	}

}

package CommonMethods;

import BrowsersBase.BrowsersInvoked;
import POM.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.Point;
import java.time.Duration;
import java.util.List;

import static POM.CCPDirect20Utility.GisDataAddress;
import static POM.CCPUtility.*;
import static POM.CCPUtility.SaveButton;
import static POM.SubmissionAssignmentUtility.*;

public class CECommonMethods extends BrowsersInvoked {
	public WebDriver driver;
	public Helper helper;
	public CECommonMethods CEcommonMethod;
	public CCPUtility ccp;
	public CDP_Utility cdp;
	public CRMCommonMethods crmCommonMethods;
	public CCPDirect20Utility CCPDirect20Utility;

	public CECommonMethods(WebDriver driver) {
		super();
		this.driver = driver;
		helper = new Helper(driver);
		crmCommonMethods = new CRMCommonMethods(driver);
//		CCPDirect20Utility = new CCPDirect20Utility(driver);

	}

	public By addAttachmentCDP = By
			.xpath("//span[contains(text(),'Attachments')]//parent::h2//button[@class='attach-btn btn btn-primary']");

	By hamburger = By.xpath("//*[@class='app-header__menu__icon']");
	By agencySetupIcon = By.xpath("(//*[@class='tools-dropdown__tool flex-column--center']/a)[1]");
	By agencyName = By.xpath("(//*[@class='agency-info__summary flex-column--left']/h2)[1]");

	public String searchLocationKey1O = PropertiesUtils.getPropertyValue("searchLocationKey1O");
	public String searchLocationKey = PropertiesUtils.getPropertyValue("searchLocationKey");
	public boolean proActiveButton;

	public String SetTestDataFilePath(String filename) {
		String resourcePath;
		if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
			resourcePath = System.getProperty("user.dir") + "\\TestData\\" + filename;
		} else {
			resourcePath = System.getProperty("user.dir") + "/TestData/" + filename;
		}
		return resourcePath;
	}

	public String getAgencyName() throws InterruptedException {
		helper.clickByJsExecuter(hamburger);
		helper.clickByJsExecuter(agencySetupIcon);
		// helper.clickByJsExecuter();(agencySetupIcon);
		helper.waitForPresenceandVisiblity(agencyName);
		helper.forcedWaitTime(2);
		String AgencyName = helper.getTextElement(agencyName).toUpperCase();
		return AgencyName;

	}

	public void creationCustomeFANotices(String NoticesName, String MergFields) throws InterruptedException {
		helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateHtmlNoticeBtn);
		helper.waitForElementIsInteractable(AppPreRequisiteUtility.CreateHtmlNoticeBtn);
		helper.clickByJsExecuter(AppPreRequisiteUtility.CreateHtmlNoticeBtn);
		helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.FADocumentToggle);
		helper.waitForElementIsInteractable(AppPreRequisiteUtility.FADocumentToggle);
		helper.clickByJsExecuter(AppPreRequisiteUtility.FADocumentToggle);
		helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LabelField);
		helper.sendKeysWithWait(AppPreRequisiteUtility.LabelField, NoticesName);
		WebElement frameNotice = helper.findElement(By.id("editor_ifr"));
		driver.switchTo().frame(frameNotice);
		helper.waitForElementIsInteractable(By.id("tinymce"));
		helper.sendKeysWithWait(By.id("tinymce"), MergFields);
		driver.switchTo().defaultContent();
		helper.waitForElementIsInteractable(AppPreRequisiteUtility.CreateNoticeBtn);
		helper.clickByJsExecuter(AppPreRequisiteUtility.CreateNoticeBtn);
		helper.waitForCurserRunning(8);
		helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CountNotices);
		helper.waitForPresenceandVisiblity(
				By.xpath(helper.stringFormat(AppPreRequisiteUtility.noticeName, NoticesName)));
	}

	public void searchCaseoOnCLP(String caseId) throws InterruptedException {

		navigationToCaseListPage();
		helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
		helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
		helper.clearElement(CSLPUtility.CSLPSearchField);
		helper.waitForElementIsInteractable(CSLPUtility.CSLPSearchField);
		helper.sendKeysWithWait(CSLPUtility.CSLPSearchField, caseId);
		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
		helper.waitForElementIsInteractable(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
		Thread.sleep(3000);
	}

	public void addAttachmentCDP(String path) throws InterruptedException {

		helper.waitUntilElementIsVisible(addAttachmentCDP);
		helper.scrollIntoView(addAttachmentCDP);
		helper.clickByJsExecuter(addAttachmentCDP);
		WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
		UploadFile4.sendKeys(path);
		helper.waitForCurserRunning(5);
		helper.waitForElementIsInteractable(CCPUtility.AddBtn);
		helper.clickOn(CCPUtility.AddBtn);
	}

	public void selectUserScheduleFollowUpInspection(String username) throws InterruptedException {
		int check = helper
				.fineElementsSize(By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));
		if (check > 0) {
			helper.waitUntilElementIsVisible(
					By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));
			try {
				helper.clickOn(By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));
			} catch (Exception e) {
				Thread.sleep(3000);
				helper.clickOn(By.xpath(helper.selectorFormate(PerformInspectionUtility.buttonText, username)));

			}
		} else {
			helper.waitUntilElementIsVisible(By.xpath(helper.selectorFormate(CSLPUtility.labelLnkText, "More...")));
			helper.clickOn(By.xpath(helper.selectorFormate(CSLPUtility.labelLnkText, "More...")));
			helper.forcedWaitTime(5);
			helper.waitUntilElementIsVisible(PerformInspectionUtility.userNameSearch);
			helper.sendKeysWithWait(PerformInspectionUtility.userNameSearch, username);
			helper.forcedWaitTime(4);
			helper.waitUntilElementIsVisible(
					By.xpath(helper.selectorFormate(PerformInspectionUtility.followUpInspectionAssignee, username)));
			helper.clickOn(
					By.xpath(helper.selectorFormate(PerformInspectionUtility.followUpInspectionAssignee, username)));

		}
	}

	public void createCustomeUsers(String FirstName, String LastName, String UserRoles) throws InterruptedException {
		helper.waitUntilElementIsVisible(CreateCRMUserUtility.CreateUserButton);
		helper.scrollIntoView(CreateCRMUserUtility.CreateUserButton);
		helper.waitForElementIsInteractable(CreateCRMUserUtility.CreateUserButton);
		helper.forcedWaitTime(2);
		helper.clickByJsExecuter(CreateCRMUserUtility.CreateUserButton);
		helper.waitUntilElementIsVisible(CreateCRMUserUtility.FirstNameField);
		helper.waitForElementIsInteractable(CreateCRMUserUtility.FirstNameField);
		String rn = RandomStrings.requiredDigits(4);
		helper.sendKeysWithWait(CreateCRMUserUtility.FirstNameField, FirstName);
		helper.sendKeysWithWait(CreateCRMUserUtility.LastNameField, LastName);
		String EmailRandom = FirstName + LastName + rn + CreateCRMUserUtility.RandomLastNameCRM + "@yopmail.com";
		helper.waitForElementIsInteractable(CreateCRMUserUtility.EmailField);
		helper.sendKeysWithWait(CreateCRMUserUtility.EmailField, EmailRandom);
		helper.waitForElementIsInteractable(CreateCRMUserUtility.RoleDropdown);
		helper.clickOn(CreateCRMUserUtility.RoleDropdown);
		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CreateCRMUserUtility.customUserRoles, UserRoles)));
		helper.waitForElementIsInteractable(
				By.xpath(helper.stringFormat(CreateCRMUserUtility.customUserRoles, UserRoles)));
		helper.clickOn(By.xpath(helper.stringFormat(CreateCRMUserUtility.customUserRoles, UserRoles)));

//		helper.waitUntilElementIsVisible(CreateCRMUserUtility.AddGroupDropdown);
//		helper.waitForElementIsInteractable(CreateCRMUserUtility.AddGroupDropdown);
//		helper.clickOn(CreateCRMUserUtility.AddGroupDropdown);
//		helper.waitUntilElementIsVisible(CreateCRMUserUtility.StandardGroupCheckbox);
//		helper.waitForElementIsInteractable(CreateCRMUserUtility.StandardGroupCheckbox);
//		helper.clickOn(CreateCRMUserUtility.StandardGroupCheckbox);
//		helper.waitUntilElementIsVisible(CreateCRMUserUtility.ApplyButton);
//		helper.waitForElementIsInteractable(CreateCRMUserUtility.ApplyButton);
//		helper.clickOn(CreateCRMUserUtility.ApplyButton);
		helper.waitUntilElementIsVisible(CreateCRMUserUtility.CreateUserPopupBtn);
		Thread.sleep(4000);
		helper.waitForElementIsInteractable(CreateCRMUserUtility.CreateUserPopupBtn);
		helper.clickOn(CreateCRMUserUtility.CreateUserPopupBtn);
		helper.waitUntilElementInvisibleLocated(CreateCRMUserUtility.CreateUserPopupBtn);
		helper.waitForCurserRunning(10);
		Thread.sleep(4000);
	}

	public void createCaseAndPerformInspection() throws InterruptedException {
		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			closeCaseDetailPage();
		}
		navigateToCCP();
		helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
		helper.waitForElementIsInteractable(CCPUtility.CCButton);
		Thread.sleep(5000);
		addLocationCCP();
		Thread.sleep(5000);
		addViolationParam("Wa");
		Thread.sleep(3000);
		ce_addContact();
		addAttachmentCCP(SetTestDataFilePath("pexels-mike-b-170811.jpg"));
		addAttachmentCCP(SetTestDataFilePath("pexels-mike-b-810357.jpg"));

		Thread.sleep(5000);
		helper.waitUntilElementIsVisible(CCPUtility.CreateCaseButton);
		helper.scrollIntoView(CCPUtility.CreateCaseButton);
		helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
		helper.clickOn(CCPUtility.CreateCaseButton);
		helper.handleReviewContact();
		helper.waitForCurserRunning(10);
		helper.waitUntilElementIsVisible(CCPUtility.performInspectionToogel);
		helper.clickOn(CCPUtility.performInspectionToogel);
		helper.waitUntilElementIsVisible(CCPUtility.proActiveButton);
		proActiveButton = helper.elementIsDisplayed(CCPUtility.proActiveButton);
		helper.waitUntilElementIsVisible(CCPUtility.performInspectionAndCreateCase);
		helper.scrollIntoView(CCPUtility.performInspectionAndCreateCase);
		helper.clickOn(CCPUtility.performInspectionAndCreateCase);
		helper.waitForCurserRunning(5);
		String title = "Verification Inspection";
		// helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CCPUtility.headerText,
		// title.toLowerCase())));
	}

	public void createCaseAndPerformInspectionWithoutAttachment() throws InterruptedException {
		if (driver.findElements(CCPUtility.CloseCDP).size() > 0) {
			closeCaseDetailPage();
		}
		navigateToCCP();
		helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
		helper.waitForElementIsInteractable(CCPUtility.CCButton);
		Thread.sleep(5000);
		addLocationCCP();
		Thread.sleep(5000);
		addViolationParam("Wa");
		Thread.sleep(3000);
		ce_addContact();

		Thread.sleep(5000);
		helper.waitUntilElementIsVisible(CCPUtility.CreateCaseButton);
		helper.scrollIntoView(CCPUtility.CreateCaseButton);
		helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
		helper.clickOn(CCPUtility.CreateCaseButton);
		helper.handleReviewContact();
		helper.waitForCurserRunning(5);

		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(CCPUtility.CaseAssigneeTo);
		helper.waitUntilElementPresent(CCPUtility.CaseAssigneeTo);
		helper.waitUntilElementIsVisible(CCPUtility.performInspectionToogel);
		helper.clickOn(CCPUtility.performInspectionToogel);
		helper.waitUntilElementIsVisible(CCPUtility.proActiveButton);
		proActiveButton = helper.elementIsDisplayed(CCPUtility.proActiveButton);
		helper.waitUntilElementIsVisible(CCPUtility.performInspectionAndCreateCase);
		helper.scrollIntoView(CCPUtility.performInspectionAndCreateCase);
		helper.clickOn(CCPUtility.performInspectionAndCreateCase);
		helper.waitForCurserRunning(5);
		String title = "Verification Inspection";
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CCPUtility.headerText, title.toLowerCase())));
	}

	public void selectCaseAssineCCP(String asignee) throws InterruptedException {
		helper.waitUntilElementIsVisible(CCPUtility.CaseAssignToArrow);
		helper.waitUntilElementPresent(CCPUtility.CaseAssignToArrow);
		try {
			helper.clickOn(CCPUtility.CaseAssignToArrow);
		} catch (Exception e) {
			Thread.sleep(3000);
			helper.clickOn(CCPUtility.CaseAssignToArrow);
		}
		helper.waitUntilElementPresent(CCPUtility.TypeCaseAssigne);
		helper.sendKeysWithWait(CCPUtility.TypeCaseAssigne, asignee);
		helper.waitUntilElementIsVisible(CCPUtility.AssineSuggested);
		helper.waitForElementIsInteractable(CCPUtility.AssineSuggested);
		helper.clickOn(CCPUtility.AssineSuggested);
		helper.forcedWaitTime(1);
		helper.clickOn(CCPUtility.CaseAssignToArrow);

	}

	public void selectInspectionAssineCCP(String asignee) throws InterruptedException {
		helper.waitUntilElementIsVisible(CCPUtility.InspectionAssineArrow);
		helper.waitUntilElementPresent(CCPUtility.InspectionAssineArrow);
		helper.clickOn(CCPUtility.InspectionAssineArrow);
		helper.waitUntilElementPresent(CCPUtility.TypeInspectionAssinge);
		helper.sendKeysWithWait(CCPUtility.TypeInspectionAssinge, asignee);
		helper.waitUntilElementIsVisible(CCPUtility.AssineSuggested);
		helper.clickOn(CCPUtility.AssineSuggested);
		helper.forcedWaitTime(1);
		helper.clickOn(CCPUtility.InspectionAssineArrow);

	}

	public void createCaseCCP() throws InterruptedException {
		navigateToCCP();
		addLocationCCP();
		addViolationParam("Wa");
		Thread.sleep(5000);
		ce_addContact();
		helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
		helper.clickOn(CCPUtility.CreateCaseButton);
		Thread.sleep(5000);

		if (driver.findElements(By.xpath("//button[text()='Close']")).size() >= 1) {
			helper.clickOn(CDP_Utility.closeBtn);

			List<WebElement> keepContacts = driver.findElements(CDP_Utility.keepContactBtn);
			int size = keepContacts.size();
			if (size == 1) {
				helper.scrollIntoView(CDP_Utility.keepContactBtn);
				helper.clickByJsExecuter(CDP_Utility.keepContactBtn);
			}
			if (size > 1) {
				for (WebElement i : keepContacts) {
					helper.scrollIntoViewWebElement(i);
					i.click();
				}

			}

			helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
			helper.clickOn(CCPUtility.CreateCaseButton);

		}

		helper.waitForCurserRunning(5);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
			selectCaseAssineCCP("Mark Shane");
			selectInspectionAssineCCP("Mark Shane");
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			selectCaseAssineCCP("Amandeep Singh");
			selectInspectionAssineCCP("Amandeep Singh");

		} else {
			selectCaseAssineCCP("Shane Es");
			selectInspectionAssineCCP("Shane Es");
		}

		helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
		helper.clickOn(CCPUtility.CreateScheduleInspectionButton);
		helper.waitForCurserRunning(10);

	}

	public void addAttachmentCCP(String path) throws InterruptedException {

		helper.scrollIntoView(CCPUtility.addAttachmentCCP);
		helper.clickByJsExecuter(CCPUtility.addAttachmentCCP);
		WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
		String testtDataPath = System.getProperty("user.dir");
		UploadFile4.sendKeys(path);
		helper.clickOn(CCPUtility.AddBtn);
	}

	public void addAttachmentTopRightCCP(String path) throws InterruptedException {

		helper.waitUntilElementIsVisible(CCPUtility.addAttachmenttop);
		helper.scrollIntoView(CCPUtility.addAttachmenttop);
		helper.clickByJsExecuter(CCPUtility.addAttachmenttop);
		WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
		String testtDataPath = System.getProperty("user.dir");
		UploadFile4.sendKeys(testtDataPath + path);
		helper.waitForCurserRunning(5);
		helper.waitForElementIsInteractable(CCPUtility.AddBtn);
		helper.clickOn(CCPUtility.AddBtn);
		helper.waitForCurserRunning(5);
	}

	public void addAttachmentBottom(String path) throws InterruptedException {

		helper.waitUntilElementIsVisible(CCPUtility.addAttachmentbottom);
		helper.scrollIntoView(CCPUtility.addAttachmentbottom);
		helper.clickByJsExecuter(CCPUtility.addAttachmentbottom);
		WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
		String testtDataPath = System.getProperty("user.dir");
		UploadFile4.sendKeys(testtDataPath + path);
		helper.waitForCurserRunning(5);
		helper.waitForElementIsInteractable(CCPUtility.AddBtn);
		helper.clickOn(CCPUtility.AddBtn);
	}

	public void addAttachmentAddActivityPage(String path) throws InterruptedException {
		helper.waitUntilElementIsVisible(ForcedAbatementUtility.AddAttachment);
		helper.scrollIntoView(ForcedAbatementUtility.AddAttachment);
		helper.clickByJsExecuter(ForcedAbatementUtility.AddAttachment);
		WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
		String testtDataPath = System.getProperty("user.dir");
		UploadFile4.sendKeys(testtDataPath + path);
		helper.waitForCurserRunning(5);
		helper.waitForElementIsInteractable(CCPUtility.AddBtn);
		helper.clickOn(CCPUtility.AddBtn);
	}

	public void addLocationCCP() throws InterruptedException {
		if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect1o)
				|| BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			serachLocationCCP(searchLocationKey1O);
 
		}
		else if(agencyConfig.equalsIgnoreCase(agencyConfigEnterpriseHosted20)) {
			serachLocationCCP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_QA"));
		}
		else {
			serachLocationCCP(searchLocationKey);
		}

	}

	public void addViolationCCP() throws InterruptedException {
		helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
		helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
		helper.waitForCurserRunning(3);
		helper.clickOn(CCPUtility.ViolationSearchBox);
		helper.sendKeysWithWait(CCPUtility.ViolationSearchBox, "Wa");
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CCPUtility.violationListlabel, "Wa")));
		try {
			helper.waitForElementIsInteractable(CCPUtility.ViolationsList);
			helper.waitForCurserRunning(3);
			helper.clickByJsExecuter(CCPUtility.ViolationsList);
		} catch (StaleElementReferenceException e) {
			WebElement violationsList = driver.findElement(CCPUtility.violationSuggested);
			helper.waitForElementInteractable(violationsList);
			helper.clickOnElement(violationsList);
		}

	}

	public void addViolationParam(String vName) throws InterruptedException {
		Thread.sleep(3000);
		helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
		helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
		try {
			helper.clickOn(CCPUtility.ViolationSearchBox);
		} catch (Exception e) {
			Thread.sleep(3000);
			helper.clickByJsExecuter(CCPUtility.ViolationSearchBox);

		}
		Thread.sleep(5000);
		helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
		helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
		helper.sendKeysWithWait(CCPUtility.ViolationSearchBox, vName);
		helper.waitUntilElementIsVisible(CCPUtility.ViolationsList);
		helper.waitForElementIsInteractable(CCPUtility.ViolationsList);
		try {
			helper.clickOn(CCPUtility.ViolationsList);
		} catch (Exception e) {
			Thread.sleep(3000);
			helper.clickByJsExecuter(CCPUtility.ViolationsList);
		}
	}

	public void ce_addContact() throws InterruptedException {

		helper.waitUntilElementIsVisible(CCPUtility.AddContactField);
		helper.scrollIntoView(CCPUtility.AddContactField);
		helper.waitUntilElementIsVisible(CCPUtility.AddContactField);
		helper.waitForElementIsInteractable(CCPUtility.AddContactField);
		try {
			helper.clickOn(CCPUtility.AddContactField);
		} catch (Exception e) {
			Thread.sleep(5000);
			helper.waitForElementIsInteractable(CCPUtility.AddContactField);
			helper.clickOn(CCPUtility.AddContactField);

		}
		helper.waitUntilElementIsVisible(CCPUtility.CreateNewContact);
		helper.waitForElementIsInteractable(CCPUtility.CreateNewContact);
		helper.clickByJsExecuter(CCPUtility.CreateNewContact);
		String RandomName = RandomStrings.requiredCharacters(8);
		String RandomMail = RandomName + "@yopmail.com";
		String RandomContact = RandomStrings.requiredDigits(10);
		helper.sendKeysWithWait(CCPUtility.NameField, RandomName);
		helper.sendKeysWithWait(CCPUtility.EmailField, RandomMail);
		helper.sendKeysWithWait(CCPUtility.WorkPhoneField, RandomContact);

		helper.scrollIntoView(CCPUtility.CreateContactBtn);
		helper.waitForElementIsInteractable(CCPUtility.CreateContactBtn);
		try {
			helper.clickOn(CCPUtility.CreateContactBtn);
		} catch (Exception e) {
			Thread.sleep(3000);
			helper.clickOn(CCPUtility.CreateContactBtn);
		}

		helper.waitUntilElementIsVisible(CCPUtility.PropertyOwnerOption);
		helper.waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
		helper.clickOn(CCPUtility.PropertyOwnerOption);
		helper.waitForElementIsInteractable(CCPUtility.ApplyButton);
		helper.clickOn(CCPUtility.ApplyButton);

	}

	public void serachLocationCCP(String Address) throws InterruptedException {
		helper.waitUntilElementIsVisible(CCPUtility.LocationFld);
		helper.waitForElementIsInteractable(CCPUtility.LocationFld);
		helper.sendKeysWithWait(CCPUtility.LocationFld, Address);
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			try {
				helper.waitUntilElementIsVisible(CCPUtility.MapGis2);
				helper.waitForElementIsInteractable(CCPUtility.MapGis2);
				helper.clickOn(CCPUtility.MapGis2);
			} catch (Exception e) {
				Thread.sleep(3000);
				helper.waitUntilElementIsVisible(CCPUtility.MapGis2);
				helper.waitForElementIsInteractable(CCPUtility.MapGis2);
				helper.clickOn(CCPUtility.MapGis2);
			}

		} else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20))
		{
			helper.waitUntilElementIsVisible(CCPUtility.MapGis2);
			helper.waitForElementIsInteractable(CCPUtility.MapGis2);
			helper.clickByJsExecuter(CCPUtility.MapGis2);
			//			helper.clickByJsExecuter(By.xpath(GisDataAddress));

		}
		
		else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
			helper.waitForCurserRunning(5);
			helper.forcedWaitTime(2);
			helper.waitUntilElementIsVisible(By.xpath("(//label[text()='Comcate Application Addresses']//ancestor::div[@class='react-autosuggest__section-container']//ul//li)[1]"));
			helper.scrollIntoView(By.xpath("(//label[text()='Comcate Application Addresses']//ancestor::div[@class='react-autosuggest__section-container']//ul//li)[1]"));
			helper.waitForElementIsInteractable(By.xpath("(//label[text()='Comcate Application Addresses']//ancestor::div[@class='react-autosuggest__section-container']//ul//li)[1]"));
			helper.clickOn(By.xpath("(//label[text()='Comcate Application Addresses']//ancestor::div[@class='react-autosuggest__section-container']//ul//li)[1]"));
			helper.waitForCurserRunning(5);

		}
		
		else {
			helper.waitUntilElementIsVisible(CCPUtility.Map3);
			helper.waitUntilElementIsVisible(CCPUtility.Map3);
			helper.waitForElementIsInteractable(CCPUtility.Map3);
			helper.clickOn(CCPUtility.Map3);
		}
		helper.waitForCurserRunning(10);

	}

	public void creation50PlusCases() throws InterruptedException {

		for (int i = 0; i <= 50; i++) {
			createCaseCCP();
			helper.waitUntilElementIsVisible(CloseCaseUtility.CloseCDPIcon);
			helper.scrollIntoView(CloseCaseUtility.CloseCDPIcon);
			helper.waitForElementIsInteractable(CloseCaseUtility.CloseCDPIcon);
			helper.clickOn(CloseCaseUtility.CloseCDPIcon);
			helper.waitUntilElementInvisibleLocated(CloseCaseUtility.CloseCDPIcon);
			helper.waitForCurserRunning(4);

		}
	}

	public void navigateToCCP() throws InterruptedException {

		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(CLPUtility.plusButtonHeader);
		helper.waitUntilElementPresent(CLPUtility.plusButtonHeader);
		WebElement CCPBtnJSE = driver.findElement(CLPUtility.plusButtonHeader);
		helper.scrollIntoView(CLPUtility.plusButtonHeader);
		helper.waitForElementInteractable(CCPBtnJSE);
		helper.waitForElementIsInteractable(CLPUtility.plusButtonHeader);
		helper.clickByJsExecuter(CLPUtility.plusButtonHeader);
		helper.waitUntilElementIsVisible(CCPUtility.CCPOption);
		helper.waitForElementIsInteractable(CCPUtility.CCPOption);
		helper.clickByJsExecuter(CCPUtility.CCPOption);
		helper.waitForCurserRunning(10);
		helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
		helper.waitUntilElementPresent(CCPUtility.CCPTitle);
		helper.waitForElementIsInteractable(CCPUtility.CCButton);
	}

	public void closeCaseDetailPage() throws InterruptedException {
		helper.waitUntilElementIsVisible(CCPUtility.CloseCDP);
		helper.scrollIntoView(CCPUtility.CloseCDP);
		helper.waitForElementIsInteractable(CCPUtility.CloseCDP);
		helper.clickByJsExecuter(CCPUtility.CloseCDP);
		helper.waitUntilElementInvisibleLocated(CCPUtility.CloseCDP);
		helper.waitForCurserRunning(5);
	}

	public void navigateToUserManagement() throws InterruptedException {

		helper.waitUntilElementIsVisible(UserManagementUtility.UserMangementSideBar);
		helper.waitUntilElementPresent(UserManagementUtility.UserMangementSideBar);
		helper.scrollIntoView(UserManagementUtility.UserMangementSideBar);
		helper.waitForElementIsInteractable(UserManagementUtility.UserMangementSideBar);
		helper.clickByJsExecuter(UserManagementUtility.UserMangementSideBar);
		helper.waitForCurserRunning(4);
		helper.waitUntilElementIsVisible(UserManagementUtility.CreateUserbtn);
		helper.waitUntilElementPresent(UserManagementUtility.CreateUserbtn);
		helper.waitForElementIsInteractable(UserManagementUtility.CreateUserbtn);

	}

	public void navigationToCaseListPage() throws InterruptedException {
		helper.waitUntilElementIsVisible(CLPUtility.CLP);
		helper.waitUntilElementPresent(CLPUtility.CLP);
		helper.scrollIntoView(CLPUtility.CLP);
		helper.waitForElementIsInteractable(CLPUtility.CLP);
		helper.waitForElementIsInteractable(CLPUtility.CLP);
		helper.clickByJsExecuter(CLPUtility.CLP);
		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(CLPUtility.Cases);
		helper.waitUntilElementPresent(CLPUtility.Cases);
		WebElement CasesText = helper.waitUntilVisibleWE(CLPUtility.Cases);
		if ((CasesText.isDisplayed()) == false) {

			SoftAssert s1 = new SoftAssert();
			s1.assertEquals(false, true);
			s1.assertAll();
		}

	}

	public void searchCaseAndNavigateToCDP(String caseId) throws InterruptedException {

		System.out.println("case id is " + caseId);
		navigationToCaseListPage();
		// Thread.sleep(5000);
		helper.waitUntilElementPresent(CLPUtility.CSLPSearchField);
		helper.waitUntilElementPresent(CLPUtility.CSLPSearchField);
		helper.waitForElementIsInteractable(CLPUtility.CSLPSearchField);
		helper.WaitForGridTableEnable();
		helper.sendKeysWithWait(CLPUtility.CSLPSearchField, caseId);
		helper.waitForCurserRunning(2);
		helper.WaitForGridTableEnable();
		// helper.WaitForUntillCaseCountOne(By.xpath("(//span[@class='cases-count'])[1]"));
		Thread.sleep(5000);
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
		helper.waitForElementIsInteractable(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CSLPUtility.CaseIdLnk, caseId)));
		helper.waitForCurserRunning(10);
		helper.waitUntilElementIsVisible(By.xpath(CDP_Utility.openedCaseId));
		helper.forcedWaitTime(3);

	}

	public void createACase() throws InterruptedException {
		navigateToCCP();
		helper.waitUntilElementIsVisible(CCPUtility.CCPTitle);
		helper.waitForElementIsInteractable(CCPUtility.CCButton);
		addLocationCCP();
		Thread.sleep(2000);
		ce_addContact();
		addViolationParam("Water");
		helper.waitUntilElementIsVisible(CCPUtility.CreateCaseButton);
		helper.scrollIntoView(CCPUtility.CreateCaseButton);
		helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
		helper.clickOn(CCPUtility.CreateCaseButton);
		helper.waitForCurserRunning(5);
		Thread.sleep(3000);
		helper.handleReviewContact();
		//	Thread.sleep(3000);
		//	helper.handleReviewContact();

		helper.waitForCurserRunning(5);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Stage")) {
			selectCaseAssineCCP("Mark Shane");
			selectInspectionAssineCCP("Mark Shane");
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {
			selectCaseAssineCCP("Amandeep Singh");
			selectInspectionAssineCCP("Amandeep Singh");

		} else {
			selectCaseAssineCCP("Shane Es");
			selectInspectionAssineCCP("Shane Es");
		}
		helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
		helper.clickOn(CCPUtility.CreateScheduleInspectionButton);
		helper.waitForCurserRunning(10);
		helper.waitUntilElementIsVisible(CCPUtility.CaseStatus);
		WebElement Case = helper.findElement(CCPUtility.CaseStatus);
		if ((Case.isDisplayed()) == false) {

			SoftAssert s62 = new SoftAssert();
			s62.assertEquals(false, true);
			s62.assertAll();
		}
	}

	public void addViolationWithEntity(String Vname, String entityName) throws InterruptedException {

		if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
			helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
			helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
			helper.sendKeysWithWait(CCPUtility.ViolationSearchBox, Vname);
			helper.waitUntilElementIsVisible(CCPUtility.violationList20);
			helper.waitForElementIsInteractable(CCPUtility.violationList20);
			helper.clickOn(CCPUtility.violationList20);
			helper.waitUntilElementIsVisible(CCPUtility.EntityField1);
			helper.waitForElementIsInteractable(CCPUtility.EntityField1);
			helper.sendKeysWithWait(CCPUtility.EntityField1, entityName);
			helper.waitForElementIsInteractable(CCPUtility.AddButton);
			helper.clickOn(CCPUtility.AddButton);

		} else {
			helper.waitUntilElementIsVisible(CCPUtility.ViolationSearchBox);
			helper.waitForElementIsInteractable(CCPUtility.ViolationSearchBox);
			helper.clickOn(CCPUtility.ViolationSearchBox);
			helper.sendKeysWithWait(CCPUtility.ViolationSearchBox, Vname);
			helper.waitUntilElementIsVisible(CCPUtility.ViolationList);
			helper.waitForElementIsInteractable(CCPUtility.ViolationList);
			helper.clickOn(CCPUtility.ViolationList);
			helper.waitUntilElementIsVisible(CCPUtility.EntityField1);
			helper.waitForElementIsInteractable(CCPUtility.EntityField1);
			helper.sendKeysWithWait(CCPUtility.EntityField1, entityName);
			helper.waitForElementIsInteractable(CCPUtility.AddButton);
			helper.clickOn(CCPUtility.AddButton);
		}
	}

	public void addSubmissionAssignmentRule(String attribute, String operator, String value, String assignee, String collaborator) throws InterruptedException {
		helper.waitUntilElementIsVisible(AddRuleButton);
		helper.clickByJsExecuter(AddRuleButton);
		helper.waitUntilElementIsVisible(CreateRule);
		helper.waitUntilElementPresent(CriteriaFields);
		helper.waitForElementIsInteractable(CriteriaFields);
		helper.clickOn(CriteriaFields);
		helper.waitForElementIsInteractable(By.xpath(getSubmissionAttribute(attribute)));
		helper.clickOn(By.xpath(getSubmissionAttribute(attribute)));
		helper.waitUntilElementIsVisible(CriteriaFields);
		helper.clickOn(CriteriaFields);
		helper.waitForElementIsInteractable(By.xpath(getSubmissionAttribute(operator)));
		helper.clickOn(By.xpath(getSubmissionAttribute(operator)));
		helper.waitUntilElementIsVisible(CriteriaFields);
		helper.clickOn(CriteriaFields);
		helper.waitUntilElementIsVisible(By.xpath(getSubmissionAttribute(value)));
		helper.scrollIntoView(By.xpath(getSubmissionAttribute(value)));
		helper.clickOn(By.xpath(getSubmissionAttribute(value)));

		helper.waitUntilElementIsVisible(DefaultAssigneeField);
		helper.scrollIntoView(DefaultAssigneeField);
		helper.clickOn(DefaultAssigneeField);
		helper.waitUntilElementIsVisible(AssigneeSearch);
		helper.sendKeysWithWait(AssigneeSearch, assignee);
		helper.waitUntilElementIsVisible(SearchedAssignee);
		helper.waitForElementIsInteractable(SearchedAssignee);
		helper.clickOn(SearchedAssignee);

		helper.waitForElementIsInteractable(SelectCollaboratorField);
		helper.clickOn(SelectCollaboratorField);
		helper.waitForElementIsInteractable(CollaboratorSearch);
		helper.sendKeysWithWait(CollaboratorSearch, collaborator);

		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA")) {
			helper.waitUntilElementIsVisible(CollaboratorQA);
			helper.clickOn(CollaboratorQA);
		} else {
			helper.waitUntilElementIsVisible(By.xpath(helper.selectorFormate(collaborators, collaborator)));
			helper.clickByJsExecuter(By.xpath(helper.selectorFormate(collaborators, collaborator)));
			//helper.clickOn(CollaboratorsOption);
		}
		helper.waitForElementIsInteractable(CreateRulebutton);
		helper.clickOn(CreateRulebutton);
		helper.waitUntilElementInvisibleLocated(CreateRulebutton);

		helper.waitForCurserRunning(2);
		helper.waitUntilElementIsVisible(AddedRule);
		helper.waitUntilElementPresent(AddedRule);
	}

	public void deleteRules(int ruleCount) throws InterruptedException {
		int check = driver.findElements(CrossIconRuleSet).size();
		if (check > ruleCount) {
			helper.waitForElementIsInteractable(CrossIconRuleSet);
			Boolean crosscheck = driver.findElement(CrossIconRuleSet).isDisplayed();
			while (crosscheck) {
				helper.waitForElementIsInteractable(CrossIconRuleSet);
				driver.findElement(CrossIconRuleSet).click();

				if (driver.findElements(CrossIconRuleSet).size() > 0) {
					crosscheck = driver.findElement(CrossIconRuleSet).isDisplayed();
				} else {
					crosscheck = false;
				}
			}
		}
	}

	public void addCaseAssignmentRule(String attribute, String operator, String value, String caseassignee,
									  String inspectionAssignee) throws InterruptedException {
		helper.waitUntilElementIsVisible(AddRuleButton);
		helper.clickOn(AddRuleButton);
		helper.waitUntilElementIsVisible(CreateRule);
		helper.waitUntilElementPresent(CriteriaFields);
		helper.waitForElementIsInteractable(CriteriaFields);
		helper.clickOn(CriteriaFields);
		helper.waitForElementIsInteractable(By.xpath(getSubmissionAttribute(attribute)));
		helper.clickOn(By.xpath(getSubmissionAttribute(attribute)));
		helper.waitUntilElementIsVisible(CriteriaFields);
		helper.clickOn(CriteriaFields);
		helper.waitForElementIsInteractable(By.xpath(getSubmissionAttribute(operator)));
		helper.clickOn(By.xpath(getSubmissionAttribute(operator)));
		helper.waitUntilElementIsVisible(CriteriaFields);
		helper.clickOn(CriteriaFields);
		helper.waitUntilElementIsVisible(By.xpath(getSubmissionAttribute(value)));
		helper.scrollIntoView(By.xpath(getSubmissionAttribute(value)));
		helper.clickOn(By.xpath(getSubmissionAttribute(value)));

		helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.CaseAssignee);
		helper.scrollIntoView(SubmissionAssignmentUtility.CaseAssignee);
		helper.clickOn(SubmissionAssignmentUtility.CaseAssignee);
		helper.waitUntilElementIsVisible(caseAssigneeSearch);
		helper.sendKeysWithWait(caseAssigneeSearch, caseassignee);
		helper.waitUntilElementIsVisible(caseAssigneeList);
		helper.waitForElementIsInteractable(caseAssigneeList);
		helper.clickOn(caseAssigneeList);

		helper.waitForElementIsInteractable(insepctionAssignee);
		helper.clickOn(insepctionAssignee);
		helper.waitForElementIsInteractable(insepctionAssigneeSearch);
		helper.sendKeysWithWait(insepctionAssigneeSearch, inspectionAssignee);

		helper.waitUntilElementIsVisible(insepctionAssingeeList);
		helper.clickOn(insepctionAssingeeList);

		helper.waitForElementIsInteractable(CreateRulebutton);
		helper.clickOn(CreateRulebutton);
		helper.waitUntilElementInvisibleLocated(CreateRulebutton);

		helper.waitForCurserRunning(2);
		helper.waitUntilElementIsVisible(AddedRule);
		helper.waitUntilElementPresent(AddedRule);
	}

	public void ExternalCSPPinLocation() throws InterruptedException {

		helper.waitUntilElementIsVisible(CCPUtility.ZoomInMapLocation);
		helper.waitForElementIsInteractable(CCPUtility.ZoomInMapLocation);
		WebElement zoomIn = helper.findElement(CCPUtility.ZoomInMapLocation);
		String aria = zoomIn.getAttribute("aria-disabled");
		while (aria.equalsIgnoreCase("false")) {
			helper.waitForElementIsInteractable(CCPUtility.ZoomInMapLocation);
			helper.clickByJsExecuter(CCPUtility.ZoomInMapLocation);
			helper.waitUntilElementIsVisible(CCPUtility.ZoomInMapLocation);
			zoomIn = helper.findElement(CCPUtility.ZoomInMapLocation);
			aria = zoomIn.getAttribute("aria-disabled");
		}

		WebElement element = helper.findElement(CSPInternalUtility.mapView);
		Point offset = element.getLocation();
		int xoffset = (int) offset.getX();
		int yoffset = (int) offset.getY();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
		element.click();
	}

	public void createCaseWithCustomeNotices(String NoticeName) throws InterruptedException {
		createCaseAndPerformInspection();
		helper.scrollIntoView(PerformInspectionUtility.ContinueBtn);
		helper.clickByJsExecuter(PerformInspectionUtility.ContinueBtn);
		Thread.sleep(2000);
		int size = driver.findElements(By.xpath(helper.stringFormat(PerformInspectionUtility.notices, NoticeName)))
				.size();
		if (size > 0) {
			helper.clickByJsExecuter(By.xpath(helper.stringFormat(PerformInspectionUtility.notices, NoticeName)));
		} else {

			Thread.sleep(3000);

			if (helper.fineElementsSize(By.xpath(
					"//span[@aria-selected='true']//ancestor::div[@class='Select-multi-value-wrapper']//following-sibling::span")) > 0) {
				helper.waitForElementIsInteractable(By.xpath(
						"//span[@aria-selected='true']//ancestor::div[@class='Select-multi-value-wrapper']//following-sibling::span"));

				helper.clickOn(By.xpath(
						"//span[@aria-selected='true']//ancestor::div[@class='Select-multi-value-wrapper']//following-sibling::span"));
			} else {
				helper.waitForElementIsInteractable(PerformInspectionUtility.selectNoticeDownArrow);
				helper.clickOn(PerformInspectionUtility.selectNoticeDownArrow);

			}
			Thread.sleep(3000);
			helper.scrollIntoViewWebElement(
					driver.findElement(By.xpath(helper.stringFormat(PerformInspectionUtility.notices, NoticeName))));
			helper.movetoElementAndClick(
					driver.findElement(By.xpath(helper.stringFormat(PerformInspectionUtility.notices, NoticeName))));

		}

		helper.clickByJsExecuter(PerformInspectionUtility.ContinueBtnSec2);
		helper.waitForElementIsInteractable(PerformInspectionUtility.GenerateNoticeBtn);
		helper.scrollIntoView(PerformInspectionUtility.GenerateNoticeBtn);
		Thread.sleep(3000);
		helper.movetoElementAndClick(PerformInspectionUtility.GenerateNoticeBtn);
		helper.waitUntilElementIsVisible(PerformInspectionUtility.DoNotPrintBtn);
		helper.scrollIntoView(PerformInspectionUtility.DoNotPrintBtn);
		Thread.sleep(1000);
		helper.clickByJsExecuter(PerformInspectionUtility.DoNotPrintBtn);
		Thread.sleep(1000);
		try {
			helper.clickByJsExecuter(SupervisorUtility.completeInspAndGenerateNoticeForApproval);
			helper.waitForCurserRunning(5);
		} catch (Exception e) {
			helper.clickByJsExecuter(SupervisorUtility.completeInspAndGenerateNoticeForApproval2);
			helper.waitForCurserRunning(5);
		}


	}

	public void approvedPendingEsclatedNoticeCDP() throws InterruptedException {
		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
		helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Approve Notice?")));
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
		helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Approved")));
	}

	public void applyEsclatedNoticeCDP() throws InterruptedException {

		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Apply Notice")));
		helper.scrollIntoView(
				By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Apply Approved Notice")));
		helper.clickByJsExecuter(
				By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Apply Approved Notice")));
		helper.clickByJsExecuter(CDP_Utility.applyApprovedNotice2);
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Yes")));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Yes")));
		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CDP_Utility.appliedNoticePOpup, "Approved & Applied to Case")));
	}

	public void rejectORNotApprovedEsclatedNoticeCDP() throws InterruptedException {

		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
		helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Approve Notice")));
		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Approve Notice?")));
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Reject")));
		helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Reject")));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Reject")));
		helper.sendKeysWithWait(CDP_Utility.rejectNotice, "NoticeRejected");
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
		helper.scrollIntoView(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CDP_Utility.buttonsEsclatedNotices, "Save")));
		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(By.xpath(helper.stringFormat(CDP_Utility.approveNoticePOpup, "Not Approved")));

	}

	public void escaltedNoticeFilterApply(String filterCriteria) {
		helper.waitUntilElementIsVisible(
				By.xpath(helper.stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CLPUtility.SecondaryFilters, "escalatedNoticeStatus")));
		helper.waitUntilElementPresent(By.xpath("//div[@class='dropdown__wrapper  dropdown__wrapper--open']"));
		helper.clickByJsExecuter(By.xpath(helper.stringFormat(CLPUtility.SecondaryFilterCriteria, filterCriteria)));
		helper.WaitForGridTableEnable();

	}

	public void logOutCurrentUser() throws InterruptedException {
		Thread.sleep(3000);
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("QA"))
			Thread.sleep(5000);
		helper.waitForElementIsInteractable(By.xpath("//*[@class='app-header__user-name']/div"));
		helper.movetoElementAndClick(By.xpath("//*[@class='app-header__user-name']/div"));
		helper.waitForElementIsInteractable(By.xpath("//label[text()='Logout']"));
		helper.movetoElementAndClick(By.xpath("//label[text()='Logout']"));
		helper.waitForCurserRunning(5);
		helper.waitForElementIsInteractable(LoginUtility.OKTAUsernameField);

	}

	public void addCustomCategorySubmissionRule(String Category) throws InterruptedException {
		if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("stage")) {
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Mark Shane", "Amandeep Singh");
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Mark Shane", "Amandeep Singh");
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Mark Shane", "Amandeep Singh");
		} else if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("Production")) {

			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Amandeep", "Amandeep Singh");
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Amandeep", "Amandeep Singh");
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Amandeep", "Amandeep Singh");
		} else {
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Shane ES", "Amandeep Singh");
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Shane ES", "Amandeep Singh");
			addSubmissionAssignmentRule("Submission Category", "Equals", Category, "Shane ES", "Amandeep Singh");
//			addSubmissionAssignmentRule("Submission Category", "Equals", "all","Shane ES", "Shane ES");
//			addSubmissionAssignmentRule("Submission Category", "Equals", "all", "Shane ES", "Amandeep");
//			addSubmissionAssignmentRule("Submission Category", "Equals", "all", "Shane ES", "Amandeep");

		}
//		helper.waitForElementIsInteractable(SaveButton);
//		helper.clickByJsExecuter(SaveButton);
//		helper.waitUntilElementInvisibleLocated(SaveButton);
//		helper.waitForCurserRunning(2);

		helper.waitForElementIsInteractable(By.xpath("//button[normalize-space()='Save']"));
		helper.clickByJsExecuter(By.xpath("//button[normalize-space()='Save']"));
		helper.waitForCurserRunning(2);
	}

	public void selectScheduleFollowUpInspectionCheckbox() {
		Boolean checked = helper.elementIsChecked(CDP_Utility.scheduleFollowUpInspectonChkbox);
		if (checked == false) {
			helper.clickByJsExecuter(CDP_Utility.scheduleFollowUpInspectonChkbox);

		}

	}

	public void initiateForceAbatement() throws InterruptedException {
		helper.waitUntilElementPresent(ForcedAbatementUtility.MoreBtn);
		helper.waitForElementIsInteractable(ForcedAbatementUtility.MoreBtn);
		helper.clickByJsExecuter(ForcedAbatementUtility.MoreBtn);
		helper.waitForElementIsInteractable(ForcedAbatementUtility.InitiateFABtn);
		helper.clickOn(ForcedAbatementUtility.InitiateFABtn);
		helper.waitUntilElementIsVisible(ForcedAbatementUtility.PopupTitleFA);
		helper.sendKeysWithWait(ForcedAbatementUtility.NoteField, "Notes for FA");
		helper.waitForElementIsInteractable(ForcedAbatementUtility.IFAPopupBtn);
		helper.clickOn(ForcedAbatementUtility.IFAPopupBtn);
		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(ForcedAbatementUtility.AbatementInfo);
	}

	public void clickOnAddActivityBtn() throws InterruptedException {
		helper.waitForElementIsInteractable(ForcedAbatementUtility.AddActivityBtn);
		helper.clickByJsExecuter(ForcedAbatementUtility.AddActivityBtn);
		helper.waitForCurserRunning(3);
		helper.waitUntilElementIsVisible(ForcedAbatementUtility.FAactivityPopup);
	}

	public void clickOnSelectFADocDropdown() throws InterruptedException {

		helper.waitForElementIsInteractable(ForcedAbatementUtility.selectFAADocArrow);
		helper.clickOn(ForcedAbatementUtility.selectFAADocArrow);
		Thread.sleep(5000);
	}

	public void searchFADocument(String fAADoc) throws InterruptedException {
		helper.waitUntilElementIsVisible(ForcedAbatementUtility.SearchFADoc);
		helper.sendKeysWithWait(ForcedAbatementUtility.SearchFADoc, fAADoc);
		helper.forcedWaitTime(2);
		helper.waitUntilElementIsVisible(ForcedAbatementUtility.SearchedFAdoc);
		// helper.clickByJsExecuter(ForcedAbatementUtility.SearchedFAdoc);

	}

	public void clickOnSearchedFADoc() {
		helper.clickByJsExecuter(ForcedAbatementUtility.SearchedFAdoc);
	}

	public Boolean FAdocumentIsDisplayed() {
		Boolean checkDoc = helper.elementIsDisplayed(ForcedAbatementUtility.SearchedFAdoc);
		return checkDoc;

	}

	public String associatedFineNameWithFAdoc() {
		String checkFineName = helper.getTextElement(ForcedAbatementUtility.AssociatedFineName);
		return checkFineName;
	}

	public String associatedFineAmountWithFAdoc() {
		String checkFineAmount = helper.getSpecificAttribute(ForcedAbatementUtility.FineAmount, "value");
		return checkFineAmount;
	}

	public void enterFAADetails() throws InterruptedException {
		helper.waitForElementIsInteractable(ForcedAbatementUtility.LabelForText1);
		helper.sendKeysWithWait(ForcedAbatementUtility.LabelForText1, "C123C456");
		helper.sendKeysWithWait(ForcedAbatementUtility.LabelForNumber2, "12345");
		helper.clickOn(ForcedAbatementUtility.LabelForSelect3);
		helper.waitForElementIsInteractable(ForcedAbatementUtility.FirstOption);
		helper.clickOn(ForcedAbatementUtility.FirstOption);
		helper.scrollIntoView(ForcedAbatementUtility.ContinueToGenDoc);
		helper.waitForElementIsInteractable(ForcedAbatementUtility.ContinueToGenDoc);
		helper.clickOn(ForcedAbatementUtility.ContinueToGenDoc);
		helper.waitForCurserRunning(4);
		Thread.sleep(3000);
	}

	public void clickOnGenerateDocumentBtn() throws InterruptedException {
		helper.waitForElementIsInteractable(ForcedAbatementUtility.GenFAADoc);
		helper.clickOn(ForcedAbatementUtility.GenFAADoc);
		helper.waitForCurserRunning(5);

	}

	public void clickonDonotPrintBtn() {
		helper.waitForElementIsInteractable(By.xpath("//button[text()='Do Not Print']"));
		helper.clickOn(By.xpath("//button[text()='Do Not Print']"));

	}

	public void clickonGenerateFAAdocuemtn() throws InterruptedException {
		helper.clickOn(ForcedAbatementUtility.GenerateDocAddFABtn);
		helper.waitForCurserRunning(5);
		helper.waitUntilElementIsVisible(ForcedAbatementUtility.AddedActivity);
	}

	public void clickOnHemburger() {
		helper.waitUntilElementIsVisible(By.cssSelector("div.app-header__menu__icon"));
		helper.clickByJsExecuter(By.cssSelector("div.app-header__menu__icon"));

	}

	public void navigationToFinancePage() throws InterruptedException {
		clickOnHemburger();
		helper.waitUntilElementIsVisible(By.xpath("//label[text()='Finance']"));
		helper.clickByJsExecuter(By.xpath("//label[text()='Finance']"));
		helper.forcedWaitTime(3);
		helper.waitForCurserRunning(4);
		helper.waitUntilElementIsVisible(By.xpath("//h2[text()='Finance']"));

	}

	public String getFineTransactionGridData() {
		String fineName = helper.getTextElement(By.xpath("(//div[@role='gridcell'])[1]"));
		return fineName;

	}

	public void clickOnFineToggelBtn() throws InterruptedException {
		helper.waitForElementIsInteractable(By.xpath("//button[text()='Fines']"));
		helper.clickByJsExecuter(By.xpath("//button[text()='Fines']"));
		helper.forcedWaitTime(3);
		helper.waitForCurserRunning(5);

	}

	public void CCPGisDirectPinLocation() throws InterruptedException {

		if (agencyConfig.equalsIgnoreCase(CCPUtility.agencyConfigGisDirect2o)) {
			helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
			helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
			WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
			String aria = zoomIn.getAttribute("aria-disabled");
			while (aria.equalsIgnoreCase("false")) {
				helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
				helper.clickByJsExecuter(CCPDirect20Utility.ZoomInMapLocation);
				helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
				zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
				aria = zoomIn.getAttribute("aria-disabled");
			}

			WebElement element = helper.findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
			Point offset = element.getLocation();
			int xoffset = offset.getX();
			int yoffset = offset.getY();
			((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
			try {
				element.click();
			} catch (Exception e) {
				element.click();

			}
			helper.waitUntilVisibleWE(GisDataAddress);
			helper.waitForElementIsInteractable(GisDataAddress);
//		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
//		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
		} else {
			System.out.println("enter in else conidition");
			helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
			helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
			WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
			String aria = zoomIn.getAttribute("aria-disabled");

			WebElement element = helper.findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
			Point offset = element.getLocation();
			int xoffset = offset.getX();
			int yoffset = offset.getY();
			xoffset = -20;
			yoffset = -20;

			Actions actions = new Actions(driver);
			Thread.sleep(3000);
			actions.moveToElement(element, xoffset, yoffset).click().perform();
			helper.waitUntilVisibleWE(GisDataAddress);
			helper.waitForElementIsInteractable(GisDataAddress);
		}
		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
//		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
//		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
	}

	public void CCPGisDirectSelectAPNAddress() throws InterruptedException {
		helper.waitUntilElementIsVisible(CCPDirect20Utility.ApnAddrresses);

		helper.scrollIntoView(CCPDirect20Utility.ApnAddrresses);
		helper.waitForElementIsInteractable(CCPDirect20Utility.ApnAddrresses);
		helper.clickOn(CCPDirect20Utility.ApnAddrresses);
		helper.waitForCurserRunning(8);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.EditLocIcon);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
		CCPDirect20Utility.ValidateStreetAdd = helper.getTextElement(CCPDirect20Utility.StreetLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
		CCPDirect20Utility.validatestate = helper.getTextElement(CCPDirect20Utility.stateLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
		CCPDirect20Utility.validateCity = helper.getTextElement(CCPDirect20Utility.CityLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
		CCPDirect20Utility.validateZip = helper.getTextElement(CCPDirect20Utility.ZipLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
		CCPDirect20Utility.validateApn = helper.getTextElement(CCPDirect20Utility.apnLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
		CCPDirect20Utility.validateOwnerName = helper.getTextElement(CCPDirect20Utility.OwnerName);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
		CCPDirect20Utility.validateOwnerAddress = helper.getTextElement(CCPDirect20Utility.OwnerAddress);
	}

	public void CCPGisDirectSelectComcateAddress() throws InterruptedException {

		Thread.sleep(3000);
		helper.scrollIntoView(CCPDirect20Utility.ComcateAddresses);
		Thread.sleep(2000);
		helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
		helper.waitForCurserRunning(8);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.EditLocIcon);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.StreetLabel);
		CCPDirect20Utility.ValidateStreetAdd = helper.getTextElement(CCPDirect20Utility.StreetLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.stateLabel);
		CCPDirect20Utility.validatestate = helper.getTextElement(CCPDirect20Utility.stateLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.CityLabel);
		CCPDirect20Utility.validateCity = helper.getTextElement(CCPDirect20Utility.CityLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.ZipLabel);
		CCPDirect20Utility.validateZip = helper.getTextElement(CCPDirect20Utility.ZipLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.apnLabel);
		CCPDirect20Utility.validateApn = helper.getTextElement(CCPDirect20Utility.apnLabel);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerName);
		CCPDirect20Utility.validateOwnerName = helper.getTextElement(CCPDirect20Utility.OwnerName);
		helper.waitUntilElementIsVisible(CCPDirect20Utility.OwnerAddress);
		CCPDirect20Utility.validateOwnerAddress = helper.getTextElement(CCPDirect20Utility.OwnerAddress);
	}

	public void SelectGISDataAddressOnCDP() throws InterruptedException {
		if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearElement(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
			helper.waitUntilElementIsVisible(GisDataAddress);
			helper.waitForElementIsInteractable(GisDataAddress);
			helper.forcedWaitTime(4);
			helper.clickByJsExecuter(GisDataAddress);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
		} else {
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearElement(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(CSPInternalGISDirect20Utility.searchLocationHosted20);
			helper.waitUntilElementIsVisible(GisDataAddress);
			helper.waitForElementIsInteractable(GisDataAddress);
			helper.forcedWaitTime(4);
			helper.clickOn(GisDataAddress);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
		}
	}


	public void SelectComcateApplicationAddressOnCSDP() throws InterruptedException {
		if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
			helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitForElementIsInteractable(CSDPGISDirect20Utility.EditLocation_btn);
			helper.clickByJsExecuter(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearElement(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
			helper.forcedWaitTime(4);
			helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
			helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
			helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);

		} else {
			helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitForElementIsInteractable(CSDPGISDirect20Utility.EditLocation_btn);
			helper.clickByJsExecuter(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearElement(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(CSPInternalGISDirect20Utility.searchLocationHosted20);
			helper.forcedWaitTime(4);
			helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
			helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
			helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);

		}

	}


	public void SelectGISDataAddressOnCSDP() throws InterruptedException {
		if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearByJSE(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
			helper.waitUntilElementIsVisible(GisDataAddress);
			helper.waitForElementIsInteractable(GisDataAddress);
			helper.forcedWaitTime(4);
			helper.clickByJsExecuter(GisDataAddress);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
		} else {
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearByJSE(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(CSPInternalGISDirect20Utility.searchLocationHosted20);
			helper.waitUntilElementIsVisible(GisDataAddress);
			helper.waitForElementIsInteractable(GisDataAddress);
			helper.forcedWaitTime(4);
			helper.clickByJsExecuter(GisDataAddress);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CSDPGISDirect20Utility.EditLocation_btn);
			helper.waitUntilElementPresent(CSDPGISDirect20Utility.EditLocation_btn);
		}
	}

	public void SelectComcateApplicationAddressOnCDP() throws InterruptedException {
		if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditLocation_btn);
			helper.clickByJsExecuter(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearByJSE(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(CCPDirect20Utility.searchLocationKey1O);
			helper.forcedWaitTime(4);
			helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
			helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
			helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
		} else {
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditLocation_btn);
			helper.clickByJsExecuter(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.SearchLocation_text);
			helper.waitForElementIsInteractable(CCPUtility.LocationFld);
			helper.clickOn(CCPUtility.LocationFld);
			helper.clearByJSE(CCPUtility.LocationFld);
			crmCommonMethods.serachLocationCCPNoClick(PropertiesUtils.getPropertyValue("searchLocationKeyHost20"));
			helper.forcedWaitTime(4);
			helper.waitUntilElementIsVisible(CCPDirect20Utility.ComcateAddresses);
			helper.waitForElementIsInteractable(CCPDirect20Utility.ComcateAddresses);
			helper.clickByJsExecuter(CCPDirect20Utility.ComcateAddresses);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditsaveAddress);
			helper.forcedWaitTime(4);
			helper.waitForElementIsInteractable(CDPDirect20GisUtility.EditsaveAddress);
			helper.clickOn(CDPDirect20GisUtility.EditsaveAddress);
			helper.waitForCurserRunning(2);
			helper.waitUntilElementIsVisible(CDPDirect20GisUtility.EditLocation_btn);
			helper.waitUntilElementPresent(CDPDirect20GisUtility.EditLocation_btn);

		}
	}

	public void openCreateRolePopUp() throws InterruptedException {
		helper.scrollIntoView(UserManagementUtility.RolesTab);
		helper.waitForElementIsInteractable(UserManagementUtility.RolesTab);
		helper.clickByJsExecuter(UserManagementUtility.RolesTab);
		helper.waitForElementIsInteractable(UserManagementUtility.CreateRoleButton);
		helper.clickByJsExecuter(UserManagementUtility.CreateRoleButton);
		Thread.sleep(5000);
		// waitUntilElementInvisibleLocated(CreateRoleButton);
		helper.waitUntilElementIsVisible(UserManagementUtility.CreateRolePopupTitle);
	}

	public void roleCreationWithCECRMSettings(String roleName, String role, String description) {

		// waitUntilElementInvisibleLocated(CreateRoleButton);
		// String RandomRoleName = RandomStrings.requiredCharacters(8);
		helper.waitUntilElementIsVisible(UserManagementUtility.RoleNameField);
		helper.waitUntilElementPresent(UserManagementUtility.RoleNameField);
		helper.waitForElementIsInteractable(UserManagementUtility.RoleNameField);
		helper.sendKeysWithWait(UserManagementUtility.RoleNameField, roleName);
		// String RandomDescription = RandomStrings.requiredString(20);
		helper.sendKeysWithWait(UserManagementUtility.DescriptionField, description);

		helper.clickOn(UserManagementUtility.siteSettingUserAdmin);
		helper.clickOn(UserManagementUtility.siteSettingSiteAdmin);
		helper.waitForElementIsInteractable(UserManagementUtility.ProductSettingsToggle);
		helper.clickOn(UserManagementUtility.ProductSettingsToggle);
		helper.waitForElementIsInteractable(UserManagementUtility.CRMSettingToggel);
		helper.clickOn(UserManagementUtility.CRMSettingToggel);

		if (role.equalsIgnoreCase("Basic Supervisor")) {
			helper.clickOn(UserManagementUtility.productAdminYes);
			helper.clickOn(UserManagementUtility.basicSupervisorToggle);
			helper.clickOn(UserManagementUtility.allStaffToggel);
			helper.clickOn(UserManagementUtility.allStaffDashboard);
			helper.clickOn(UserManagementUtility.canVoidWaive);
			helper.clickOn(UserManagementUtility.productExecutiveReport);
			helper.clickOn(UserManagementUtility.productDeleteAndReissue);

			helper.clickOn(UserManagementUtility.violationAnimalBasic);
			helper.clickOn(UserManagementUtility.generalViolationBasic);
			helper.clickOn(UserManagementUtility.crmProductAdminYes);
			helper.clickOn(UserManagementUtility.crmExecutiveReport);
			helper.clickOn(UserManagementUtility.crmPermissionBasic);

		} else if (role.equalsIgnoreCase("Supervisor Manager")) {
			helper.clickOn(UserManagementUtility.supervisorManager);

			helper.clickOn(UserManagementUtility.productAdminYes);
			helper.clickOn(UserManagementUtility.allStaffToggel);
			helper.clickOn(UserManagementUtility.allStaffDashboard);
			helper.clickOn(UserManagementUtility.canVoidWaive);
			helper.clickOn(UserManagementUtility.productExecutiveReport);
			helper.clickOn(UserManagementUtility.productDeleteAndReissue);

			helper.clickOn(UserManagementUtility.violationAdminOverwrite);
			helper.clickOn(UserManagementUtility.generalViolationOverwrite);
			helper.clickOn(UserManagementUtility.crmProductAdminYes);
			helper.clickOn(UserManagementUtility.crmExecutiveReport);
			helper.clickOn(UserManagementUtility.crmOverwritePermission);

		}

		helper.scrollIntoView(UserManagementUtility.CreateRolePopupBtn);
		helper.waitForElementIsInteractable(UserManagementUtility.CreateRolePopupBtn);
		helper.clickOn(UserManagementUtility.CreateRolePopupBtn);
		helper.waitForElementIsInteractable(UserManagementUtility.RoleCreatedSuccessMsg);
		String SuccessMsg = helper.getTextElement(UserManagementUtility.RoleCreatedSuccessMsg);
		Assert.assertEquals(SuccessMsg, "Role created");

	}

	// adding search func.
	public void serachLocationCCPNoClick(String Address) throws InterruptedException {
		helper.waitUntilElementIsVisible(LocationSearchField);
		helper.waitForElementIsInteractable(LocationSearchField);
		helper.sendKeysWithWait(LocationSearchField, Address);
		helper.waitForPresenceandVisiblity(LocationSearchResult);
		helper.waitForElementIsInteractable(LocationSearchResult);
	}

	public String extractAddressFunction(String address) {
		String[] parts = address.split(" ");

		String extracted = " ";
		// Combine the first two parts to get the desired output....
		if (parts.length >= 2) {
			extracted = parts[0] + " " + parts[1];
			System.out.println("Extracted: " + extracted);
		} else {
			System.out.println("The address does not have enough parts.");
		}
		return extracted;
	}

}

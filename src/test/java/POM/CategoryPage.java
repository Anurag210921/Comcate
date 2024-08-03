package POM;

import BrowsersBase.BrowsersInvoked;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;

import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import Constant.CRMConstants;

public class CategoryPage extends Helper {

	public WebDriver driver;
	LoginUtility log;

	public CategoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LoginUtility(driver);
	}

	public static String categoriesTab = "//div[@class='tab-name tab-name--active']";
	public static String otherDefaultCategory = "//div[@class='sortable-table__body__td' and text()='Other']";
	public static String editDefaultLink = "a#edit-default-resolution";
	public static String resolutionTimePopup = "//div[@class='modal-header']";
	public static String resolutionTimeField = "//input[@name='resolveByDays']";
	public static String saveButton = "//button[text()='Save']";
	public static String cancelButton = "//button[text()='Cancel']";
	public static String defaultResolutionTime = "//span[@class='default-resolve-by-days']";
	public static String editCategoryIcon = "//button[@class='edit-btn space-right btn btn-primary']";
	public static String editOtherPopup = "//div[@class='full-page-modal__header']/h1";
	public static String validationMsgResolutionTime = "//span[@class='field__error']";
	public static String createCategoryButton = "//button[text()='Create Category']";
	public static String createACategoryPopup = "//div[@class='full-page-modal__header']/h1";
	public static String resolutionTime = "//span[@class='default-resolve-by-days']";
	public static String createCategoryPopupBtn = "//div[@class='full-page-modal__header']//following::button[text()='Create Category']";
	public static String validationMsgNameField = "(//span[@class='field__error'])[1]";
	public static String resolutionTimeOnCategoryPopup = "//input[@name='resolveByDays']";
	public static String keywordsField = "//input[@name='tags-input']";
	public static String addedKeywords = "//div[@class='chip__body']";
	public static String deleteIconKeyword = "//button[@class='chip__close-button']";
	public static String addFieldLink = "//a[text()='Add Field']";
	public static String addedFields = "//div[@class='category-modal__custom-fields']//li";
	public static String labelValidationMsg = "//div[@class='category-modal__custom-field']//span";
	public static String labelField = "//input[@name='label']";
	public static String dropdownLinkEmail = "//span[@class='dropdown__arrow']";
	public static String emailTemplatesOptions = "//div[@id='templateIds']//label";
	public static String templatesCancelButton = "//div[@class='flex-row--center dropdown__actions']/button[1]";
	public static String templatesSaveButton = "//div[@class='flex-row--center dropdown__actions']/button[2]";
	public static String labelSelect = "//div[@class='dropdown__selector__selected']/label";
	public static String selectedTemplates = "//div[@class='dropdown__selector__selected']/label";
	public static String nameField = "//input[@name='name']";
//	    public static String categoriesCountHeader = "//div[@class='agency-setup-tab__section__header']/h2";
	public static String categoriesCountHeader = "(//div[@class='agency-setup-tab__section__header']/h2)[1]";
	public static String addedCategories = "//li[@class='sortable__element']";
	public static String notificationMsg = "//div[@class='notification-message']";
	public static String editCategoryIcon2 = "(//button[@class='edit-btn space-right btn btn-primary'])[2]";
	public static String inactiveToggle = "//button[text()='Inactive']";
	public static String inactiveCategoriesCount = "(//div[@class='agency-setup-tab__section__header']/h2)[2]";
	public static String inactiveAddedCategories = "//div[@class='rt-tr-group']";
	public static String actualCategoriesCount = "//div[@class='sortable-table__body__tr']";
	public static String locationRequiredCheckbox = "//label[text()='Location Required']";
	public static String noLocationToggle = "//button[text()='No']";

	public static By CategoriesTab = By.xpath(categoriesTab);
	public static By OtherDefaultCategory = By.xpath(otherDefaultCategory);
	public static By EditDefaultLink = By.cssSelector(editDefaultLink);
	public static By ResolutionTimePopup = By.xpath(resolutionTimePopup);
	public static By ResolutionTimeField = By.xpath(resolutionTimeField);
	public static By SaveButton = By.xpath(saveButton);
	public static By CancelButton = By.xpath(cancelButton);
	public static By DefaultResolutionTime = By.xpath(defaultResolutionTime);
	public static By EditCategoryIcon = By.xpath(editCategoryIcon);
	public static By EditOtherPopup = By.xpath(editOtherPopup);
	public static By ValidationMsgResolutionTime = By.xpath(validationMsgResolutionTime);
	public static By ResolutionTime = By.xpath(resolutionTime);
	public static By CreateCategoryButton = By.xpath(createCategoryButton);
	public static By CreateACategoryPopup = By.xpath(createACategoryPopup);
	public static By CreateCategoryPopupBtn = By.xpath(createCategoryPopupBtn);
	public static By ValidationMsgNameField = By.xpath(validationMsgNameField);
	public static By ResolutionTimeOnCategoryPopup = By.xpath(resolutionTimeOnCategoryPopup);
	public static By KeywordsField = By.xpath(keywordsField);
	public static By AddedKeywords = By.xpath(addedKeywords);
	public static By DeleteIconKeyword = By.xpath(deleteIconKeyword);
	public static By AddFieldLink = By.xpath(addFieldLink);
	public static By AddedFields = By.xpath(addedFields);
	public static By LabelValidationMsg = By.xpath(labelValidationMsg);
	public static By LabelField = By.xpath(labelField);
	public static By DropdownLinkEmail = By.xpath(dropdownLinkEmail);
	public static By EmailTemplatesOptions = By.xpath(emailTemplatesOptions);
	public static By TemplatesCancelButton = By.xpath(templatesCancelButton);
	public static By TemplatesSaveButton = By.xpath(templatesSaveButton);
	public static By LabelSelect = By.xpath(labelSelect);
	public static By SelectedTemplates = By.xpath(selectedTemplates);
	public static By NameField = By.xpath(nameField);
	public static By CategoriesCountHeader = By.xpath(categoriesCountHeader);
	public static By AddedCategories = By.xpath(addedCategories);
	public static By NotificationMsg = By.xpath(notificationMsg);
	public static By EditCategoryIcon2 = By.xpath(editCategoryIcon2);
	public static By InactiveToggle = By.xpath(inactiveToggle);
	public static By InactiveCategoriesCount = By.xpath(inactiveCategoriesCount);
	public static By ActualCategoriesCount = By.xpath(actualCategoriesCount);
	public static By LocationRequiredCheckbox = By.xpath(locationRequiredCheckbox);
	public static By NoLocationToggle = By.xpath(noLocationToggle);

	public static String RandomCategoryname = RandomStrings.requiredCharacters(4);
	public static String NewResoTime;
	public static int CategoriesCountBefore;
	public static String TabTitle;
	public static String OtherTabTitle;
	public static String EditOtherPopupTitle;
	public static String EditResolutionPopupTitle;
	public static String ResolutionTimeValidationMsg;
	public static String[] ResoTextAfter;
	public static String CreateCategoryPopupTitle;
	public static String NameFieldValidationMsg;
	public static String ResoTimeOnPopup;
	public static String LabelFieldValidationMsg;
	public static String LabelText;
	public static String CheckedTemplate;
	public static String SelectedTemplate;
	public static String NotificationText;
	public static int KeywordsSizeBefore;
	public static int KeywordsSizeAfter;
	public static int FieldsCount;
	public static int CategoriesCountAfter1;
	public static int CategoriesCountAfter2;
	public static int CategoriesCountAfter3;
	public static int InactiveCountAfter;
	public static int InactiveCountBefore;
	public static int CategoriesCountHeader1;
	public static int CountCategoriesActual;

	public void LoginAgency() throws InterruptedException {
		log.LoginAgency();

	}

	public void naviateToCategory() throws InterruptedException {
		driver.navigate().to(BrowsersInvoked.URLCategories);
		waitForCurserRunning(5);
	}

	public String getCategoryTabName() {
		waitUntilElementIsVisible(CategoriesTab);
		waitUntilElementPresent(CategoriesTab);
		String tabName = getTextElement(CategoriesTab);
		return tabName;
	}

	public String getOtherDefaultCategory() throws InterruptedException {
		forcedWaitTime(1);
		waitUntilElementIsVisible(OtherDefaultCategory);
		waitUntilElementPresent(OtherDefaultCategory);
		String defaultCategory = getTextElement(OtherDefaultCategory);
		return defaultCategory;
	}

	public void clickOnEditCategoryIcon() {
		scrollToRight();
		waitUntilElementPresent(EditCategoryIcon);
		waitForElementIsInteractable(EditCategoryIcon);
		clickByJsExecuter(EditCategoryIcon);
		waitUntilElementIsVisible(EditOtherPopup);

	}

	public String getEditCategoryPopupTitle() {
		waitUntilElementPresent(EditOtherPopup);
		String title = getTextElement(EditOtherPopup);
		return title;
	}

	public void closeTheEditCategoryPopup() {
		waitUntilElementIsVisible(CancelButton);
		waitForElementIsInteractable(CancelButton);
		clickByJsExecuter(CancelButton);
		waitUntilElementInvisibleLocated(CancelButton);
	}

	public int getResolutionTime() {
		waitUntilElementIsVisible(ResolutionTime);
		waitUntilElementPresent(ResolutionTime);
		String[] ResoTextBefore = getTextElement(ResolutionTime).split(" ");
		int resolutionTime = Integer.parseInt(ResoTextBefore[0]);
		return resolutionTime;
	}

	public void clickOnEditDefalutResoTime() {
		waitForElementIsInteractable(EditDefaultLink);
		moveToElement(EditDefaultLink);
		clickByJsExecuter(EditDefaultLink);
	}

	public String getEditResolutionPopupTitle() {
		waitUntilElementIsVisible(ResolutionTimePopup);
		waitUntilElementPresent(ResolutionTimePopup);
		String title = getTextElement(ResolutionTimePopup);
		return title;
	}

	public void clearResoTimeField() {
		waitForElementIsInteractable(ResolutionTimeField);
		WebElement ResolutionField = driver.findElement(ResolutionTimeField);
		ResolutionField.clear();
	}

	public String setResolutionTime(String time) {
		WebElement ResolutionField = driver.findElement(ResolutionTimeField);
		ResolutionField.sendKeys(time);
		return time;
	}

	public void clickOnSaveButton() throws InterruptedException {
		waitForElementIsInteractable(SaveButton);
		clickByJsExecuter(SaveButton);
		waitUntilElementInvisibleLocated(SaveButton);
		waitForCurserRunning(5);
	}

	public int getCategoryCount() {
		String[] HeaderCount = getTextElement(CategoriesCountHeader).split(" ");
		int count = Integer.parseInt(HeaderCount[0]);
		return count;
	}

	public void clickOnCreateCategoryBtn() throws InterruptedException {
		waitForElementIsInteractable(CreateCategoryButton);
		clickByJsExecuter(CreateCategoryButton);
		waitForCurserRunning(2);
	}

	public String getCreateCategoryTitle() {
		waitUntilElementIsVisible(CreateACategoryPopup);
		waitForElementIsInteractable(CreateACategoryPopup);
		String title = getTextElement(CreateACategoryPopup);
		return title;
	}

	public void clickOnCreateCategoryPopbtn() {
		clickByJsExecuter(CreateCategoryPopupBtn);

	}

	public String getCategoryNameValidationText() {
		String text = getTextElement(ValidationMsgNameField);
		return text;
	}

	public String ResolutionTimeOnCategoryPopup() {
		String ResoTimeOnPopup = driver.findElement(ResolutionTimeOnCategoryPopup).getAttribute("value");
		return ResoTimeOnPopup;
	}

	public void addCategoryKeywords(int count) {
		waitUntilElementIsVisible(KeywordsField);
		waitUntilElementPresent(KeywordsField);
		WebElement AddKeywordsField = findElement(KeywordsField);
		for (int i = 0; i < count; i++) {
			String RandomKeyword = RandomStrings.requiredCharacters(4);
			AddKeywordsField.sendKeys(RandomKeyword);
			AddKeywordsField.sendKeys(Keys.SPACE);
		}
	}

	public void deleteAddedkeywords(int count) throws InterruptedException {
		waitUntilElementIsVisible(AddedKeywords);
		waitUntilElementPresent(AddedKeywords);
		List<WebElement> KeywordsAdded = driver.findElements(AddedKeywords);
		for (int i = 0; i < count; i++) {
			forcedWaitTime(1);
			clickOn(DeleteIconKeyword);
		}
	}

	public int getAddedKeywordCount() {

		waitUntilElementIsVisible(AddedKeywords);
		List<WebElement> KeywordsAfterDeletion = driver.findElements(AddedKeywords);
		int count = KeywordsAfterDeletion.size();
		return count;
	}

	public void clickOnAddFieldLink() {
		clickOn(AddFieldLink);
	}

	public int getAddedFieldCount() {
		List<WebElement> FieldsAdded = driver.findElements(AddedFields);
		int fieldCount = FieldsAdded.size();
		return fieldCount;
	}

	public String getCatLabelValidationText() {
		String text = getTextElement(LabelValidationMsg);
		return text;
	}

	public void setCategoryLabelText() {
		sendKeysWithWait(LabelField, "TextLabel");
	}
	
	public void clickOnDropdownLinkemail() {
		waitUntilElementPresent(DropdownLinkEmail);
		waitForElementIsInteractable(DropdownLinkEmail);
		clickOn(DropdownLinkEmail);
	}
	
	public void selectEmailTemplateOption() {
		waitForElementIsInteractable(EmailTemplatesOptions);
		clickOn(EmailTemplatesOptions);
	}
	
	public void clickOnTemplateCancelBtn() {
		waitForElementIsInteractable(TemplatesCancelButton);
		clickOn(TemplatesCancelButton);
		
	}
	
	public String getLabelText() {
		waitUntilElementIsVisible(LabelSelect);
		String text = getTextElement(LabelSelect);
		return text;
	}
	
	public String getTextEmailTemplateOption() {
		waitUntilElementIsVisible(EmailTemplatesOptions);
		String text = getTextElement(EmailTemplatesOptions);
		return text;
	}
	
	public void clickOnTemplateSaveBtn() {
		waitForElementIsInteractable(TemplatesSaveButton);
		scrollIntoView(TemplatesSaveButton);
		clickByJsExecuter(TemplatesSaveButton);
	}
	
	public String getSelectedTemplate() {
		waitUntilElementIsVisible(SelectedTemplates);
		String text = getTextElement(SelectedTemplates);
		return text;
	}
	
	public String setCategoryName() {
		String RandomCN = RandomStrings.requiredCharacters(5);
		String categoryName = "Category " + RandomCN;
		sendKeysWithWait(NameField, RandomCategoryname);
		return categoryName;
	}
	
	public String setCategoryNameCustom(String name) {
		sendKeysWithWait(NameField, name);
		return name;
	}
	
	public void waitForButtonInvisibility() throws InterruptedException {
		waitUntilElementInvisibleLocated(CreateCategoryPopupBtn);
		waitForCurserRunning(5);
		
	}
	
	public int  getCategoryCountHeader() {
		waitUntilElementIsVisible(CategoriesCountHeader);
		waitUntilElementPresent(CategoriesCountHeader);	
		String[] HeaderCount = getTextElement(CategoriesCountHeader).split(" ");
		int count  = Integer.parseInt(HeaderCount[0]);
		return count ;
	}

	
	public void clickOnCreateCategorybutton() {
		waitUntilElementIsVisible(CreateCategoryButton);
		waitUntilElementPresent(CreateCategoryButton);
		waitForElementIsInteractable(CreateCategoryButton);
		clickOn(CreateCategoryButton);
	}
	
	
	public String getExistingCatValidationText() {
		waitUntilElementIsVisible(NotificationMsg);
		String text = getTextElement(NotificationMsg);
		return text;
	}
	
	public int getInactiveCategoryCount() {
		waitUntilElementIsVisible(InactiveCategoriesCount);
		waitUntilElementPresent(InactiveCategoriesCount);
		String[] InactiveCountHeader = getTextElement(InactiveCategoriesCount).split(" ");
		int count  = Integer.parseInt(InactiveCountHeader[0]);
		return count;
	}
	
	public void clicOnEditCategoryActive() throws InterruptedException {
		waitForElementIsInteractable(EditCategoryIcon2);
		clickOn(EditCategoryIcon2);
		forcedWaitTime(4);
	}
	
	public void clickOnInactiveToggleButton() throws InterruptedException {
		waitUntilElementIsVisible(InactiveToggle);
		waitUntilElementPresent(InactiveToggle);
		waitForElementIsInteractable(InactiveToggle);
		clickByJsExecuter(InactiveToggle);
		forcedWaitTime(2);
	}
	
	public void clearCategoryName() {
		WebElement NameFld = waitUntilVisibleWE(NameField);
		NameFld.clear();
	}


	public int getCountFormGrid() {
		
		List<WebElement> ActualCountCategories = driver.findElements(ActualCategoriesCount);
		int count = ActualCountCategories.size();
		return count;
	}
	

}

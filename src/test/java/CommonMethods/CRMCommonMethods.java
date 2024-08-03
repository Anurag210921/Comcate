package CommonMethods;


import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import POM.*;
import TestCases.CCP;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowsersBase.BrowsersInvoked;
import BrowsersBase.BrowsersInvoked;

import static POM.CCPDirect20Utility.GisDataAddress;
import static POM.CCPUtility.*;
import static POM.CSDPUtility.SubmitAnywayButton;
import static POM.CSPInternalGISDirect20Utility.ExtractedSearchLocationHosted20;
import static POM.CSPInternalUtility.CellPhoneField;

public class CRMCommonMethods {

	
    public WebDriver driver;
    public Helper helper;
    public CSPExternalUtility cspExternal;
    CECommonMethods ceMethod;

    public CRMCommonMethods(WebDriver driver) {
        this.driver = driver;
        helper = new Helper(driver);
        cspExternal = new CSPExternalUtility(driver);
//       ceMethod = new CECommonMethods(driver);

    }

    public String searchLocationKey1O = PropertiesUtils.getPropertyValue("searchLocationKey1O");
    public String searchLocationKey = PropertiesUtils.getPropertyValue("searchLocationKey");
    public static String searchAPNLocation20 = PropertiesUtils.getPropertyValue("searchAPNLocation20");

    // search on CSLP with Location
    public void searchLocationCSP(String Address) throws InterruptedException {
        helper.waitForElementIsInteractable(CSPInternalUtility.LocationField);
        helper.forcedWaitTime(3);
        System.out.println("Address CSP: -> " + Address);
        helper.sendKeysWithWait(CSPInternalUtility.LocationField, Address);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.LocationSearchResult);
        helper.waitForElementIsInteractable(CSPInternalUtility.LocationSearchResult);
        helper.forcedWaitTime(4);
        // add on for deugging
        // helper.clickOn(SubmitAnywayButton);
        helper.clickByJsExecuter(CSPInternalUtility.LocationSearchResult);
        Thread.sleep(3000);
        helper.waitForCurserRunning(7);


    }

    public void addAttachmentOnCSDP(String path) throws InterruptedException {
        helper.waitUntilElementIsVisible(CSDPUtility.attachmentDefaultbtn);
        helper.clickOn(CSDPUtility.attachmentDefaultbtn);
        WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
        UploadFile4.sendKeys(path);
        helper.waitForCurserRunning(5);
        helper.waitForElementIsInteractable(CCPUtility.AddBtn);
        helper.clickOn(CCPUtility.AddBtn);
        helper.waitForCurserRunning(4);

    }

    public void navigationToNotices() throws InterruptedException {
        navigateToAgencySetup();
        helper.waitForPresenceandVisiblity(By.xpath("//label[text()='Change Logo']"));
        helper.waitForElementIsInteractable(By.xpath("//label[text()='Change Logo']"));
        helper.forcedWaitTime(2);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("STAGE") || BrowsersInvoked.RunEnvironment.equalsIgnoreCase("production")) {
            helper.waitForPresenceandVisiblity(NoticesUtility.CE);
            helper.scrollIntoView(NoticesUtility.CE);
            helper.waitUntilElementIsVisible(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.clickByJsExecuter(NoticesUtility.CE);
        } else {
            int ceSize = driver.findElements(NoticesUtility.CE).size();
            int ProductDemoSize = driver.findElements(NoticesUtility.ProductDemo).size();
            if (ceSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.CE);
                helper.scrollIntoView(NoticesUtility.CE);
                helper.waitUntilElementPresent(NoticesUtility.CE);
                helper.waitForElementIsInteractable(NoticesUtility.CE);
                helper.clickByJsExecuter(NoticesUtility.CE);
            } else if (ProductDemoSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.ProductDemo);
                helper.scrollIntoView(NoticesUtility.ProductDemo);
                helper.waitUntilElementPresent(NoticesUtility.ProductDemo);
                helper.waitForElementIsInteractable(NoticesUtility.ProductDemo);
                helper.clickByJsExecuter(NoticesUtility.ProductDemo);
            }


        }
        helper.waitForPresenceandVisiblity(NoticesUtility.NoticesPageLink);
        helper.scrollIntoView(NoticesUtility.NoticesPageLink);
        helper.waitForElementIsInteractable(NoticesUtility.NoticesPageLink);
        helper.clickByJsExecuter(NoticesUtility.NoticesPageLink);
        helper.implicitWaitforCustometime(3);
        helper.scrollIntoView(NoticesUtility.AppHeaderIcon);
        helper.waitForPresenceandVisiblity(NoticesUtility.ActiveTab);
    }


    public void navigationToCSP() throws InterruptedException {
        helper.waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
        Thread.sleep(2000);
        System.out.println("enter in click by js executor");
        helper.clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
        helper.clickByJsExecuter(CSPInternalUtility.CustomerSubmissionOption);
        helper.waitForCurserRunning(2);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CSPPopupTitle);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForElementIsInteractable(CSPInternalUtility.CreateSubmissionButton);
    }

    public void navigateToCSLP() throws InterruptedException {
        helper.waitUntilElementIsVisible(CSLPUtility.CSLPTab);
        helper.waitForElementIsInteractable(CSLPUtility.CSLPTab);
        helper.clickByJsExecuter(CSLPUtility.CSLPTab);
        helper.waitForCurserRunning(7);
        helper.waitUntilElementIsVisible(CSLPUtility.CustomerSubmissionsHeader);

    }

    public void searchLocationExternalCS(String Address) throws InterruptedException {
        helper.waitUntilElementPresent(CSPExternalUtility.LocationSearchField);
        helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
        helper.clickByJsExecuter(CSPExternalUtility.LocationSearchField);
        helper.sendKeysWithWait(CSPExternalUtility.LocationSearchField, Address);
        helper.forcedWaitTime(4);
        Thread.sleep(4000);
        helper.waitForPresenceandVisiblity(CSPExternalUtility.LocationSearchResult);
//        helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchResult);
        helper.clickByJsExecuter(CSPExternalUtility.LocationSearchResult);
        helper.waitForCurserRunning(5);

    }

    public void creationOf50PlusSubmissions() throws InterruptedException {

        for (int i = 0; i <= 50; i++) {
            createSubmission("No", "Yes", "Yes", "Yes", "Yes", "Location Required");

        }
    }

    public void switchToAnotherTab(WebDriver driver) {

        System.out.println("enter in function ...");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to open the provided link in a new tab
        try {
            //	String url = "https://app-stage.comcate.com/agencies/212/products/customer-submission/create";
            String url2 = BrowsersInvoked.URLCreateCustomerSubmission;

            js.executeScript("window.open('" + url2 + "');");

            // Switch to the new tab
            // Get the handles of all open windows/tabs
            for (String handle : driver.getWindowHandles()) {
                // Switch to the new tab
                driver.switchTo().window(handle);
            }

        } catch (Exception e) {
            System.out.println("enter in catch ...");

        }

        System.out.println("exit from this function ....");
    }


    public void createSubmission(String Anonymous, String Customer, String Tags, String Location, String Attachment, String CategoryName) throws InterruptedException {
        //driver.get(BrowsersInvoked.URLCreateCustomerSubmission);
        try {
            System.out.println("enteer in try ..");
            helper.navigatePage(BrowsersInvoked.URLCreateCustomerSubmission);
            Thread.sleep(2000);
            System.out.println("referesh 1");
            helper.refreshPage();

            System.out.println("Execute successfully");

        } catch (Exception e) {
            //e.getMessage();
            System.out.println("Exception while rendering.");
            //helper.refreshPage();

        }
        System.out.println("Link .... " + BrowsersInvoked.URLCreateCustomerSubmission);
        helper.waitForCurserRunning(5);
        Thread.sleep(2000);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
        Thread.sleep(3000);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);

        helper.scrollIntoView(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
        helper.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
        helper.sendKeysWithWait(CSPInternalUtility.SearchCategory, CategoryName);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchResultsCategory);
        Thread.sleep(5000);
        helper.clickOn(CSPInternalUtility.SearchResultsCategory);
        String RandomDescription = RandomStrings.requiredString(20);
        helper.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);

        By email = By.xpath("//*[@name='email']");

        if (Anonymous == "Yes") {
            JavascriptExecutor jser = (JavascriptExecutor) driver;
            WebElement PostAnonymouslyCheckbox = (WebElement) jser.executeScript("return document.querySelector('div > div:nth-child(2) > span > input')");
            PostAnonymouslyCheckbox.click();

        }
        if (Customer == "Yes") {
            helper.sendKeysWithWait(CSPInternalUtility.AddExistingCustomerField, PropertiesUtils.getPropertyValue("crmCustomerName"));
            Thread.sleep(2000);
            helper.clickOn(CSPInternalUtility.ContactSearchResults);
            if (helper.getValueAttribute(CellPhoneField).isEmpty()) {
                helper.sendKeysWithWait(CellPhoneField, "12057547399");
            }

            if (helper.getValueAttribute(email).isEmpty()) {
                helper.sendKeysWithWait(email, "a@a.com");
            }

            int Emailcheck = driver.findElements(By.xpath("//button[@class='square-btn preference-selected-button btn btn-primary'][text()='Email']")).size();
            int Textcheck = driver.findElements(By.xpath("//button[@class='square-btn preference-selected-button btn btn-primary'][text()='Text Message']")).size();

            if (Emailcheck == 0) {
                helper.clickOn(By.xpath("//button[contains(text(),'Email')]"));

            }
            if (Textcheck == 0) {
                helper.clickOn(By.xpath("//button[text()='Text Message']"));

            }

        }
        if (Tags == "Yes") {
            for (int i = 0; i < 5; i++) {
                String RandomTags = RandomStrings.requiredString(4);
                helper.sendKeysWithWait(CSPInternalUtility.TagsField, RandomTags + ",");
            }
        }
        if (Location == "Yes") {

            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
                serachLocationCCP(searchLocationKey1O);
            } 
            
            else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
                serachLocationCCP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_prod"));
            }
            
            else {
                serachLocationCCP(searchLocationKey);
            }
            helper.waitForPresenceandVisiblity(CSPInternalUtility.FlagToggle);
            if (helper.elementIsDisplayed(CSPInternalUtility.ToggleChecked)) {
                helper.clickOn(CSPInternalUtility.FlagToggle);
                int flagCheck = helper.fineElementsSize(By.xpath("//textarea[@name='reasonForFlagging']"));
                if (flagCheck > 0) {
                    helper.sendKeysWithWait(By.xpath("//textarea[@name='reasonForFlagging']"), "Unflagged");
                    helper.waitForElementIsInteractable(By.xpath("//button[text()='Unflag address']"));
                    helper.clickOn(By.xpath("//button[text()='Unflag address']"));
                    helper.waitForCurserRunning(5);
                    helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);

                }

            }

        }
        if (Attachment == "Yes") {
            helper.clickByJsExecuter(CSPInternalUtility.AttachmentIcon);
            WebElement UploadFile3 = driver.findElement(By.xpath("//input[@type='file']"));
            UploadFile3.sendKeys(System.getProperty("user.dir") + "/TestData/Cat_11zon.jpg");
           Thread.sleep(3000);
           helper.scrollIntoView(CSPInternalUtility.AddButton);
            helper.clickOn(CSPInternalUtility.AddButton);
            helper.waitUntilElementInvisibleLocated(CSPInternalUtility.AddButton);

        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.waitUntilElementPresent(CSPInternalUtility.CreateSubmissionButton);
        helper.scrollIntoView(CSPInternalUtility.CreateSubmissionButton);
        helper.clickByJsExecuter(CSPInternalUtility.CreateSubmissionButton);
        //helper.waitUntilElementInvisibleLocated(CSPInternalUtility.CreateSubmissionButton);

        helper.waitForCurserRunning(5);
        List<WebElement> DuplicateSubsPopup = driver.findElements(CSDPUtility.PossibleDuplicateSubmissionsPopup);
        if (DuplicateSubsPopup.size() == 1) {
            helper.scrollIntoView(SubmitAnywayButton);
            helper.waitForElementIsInteractable(SubmitAnywayButton);
            helper.clickByJsExecuter(SubmitAnywayButton);
            helper.waitForCurserRunning(4);
        }

    }


    public void editCaseAssignmentRule() throws InterruptedException {
        helper.waitForCurserRunning(5);
        Thread.sleep(3000);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.scrollIntoView(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.waitForElementIsInteractable(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.clickByJsExecuter(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.waitUntilElementInvisibleLocated(SubmissionAssignmentUtility.EditCaseAssingment);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditAssignmentPopup);
        helper.waitUntilElementPresent(SubmissionAssignmentUtility.EditAssignmentPopup);
    }

    public void editSubmissionAssignmentRule() throws InterruptedException {
        helper.waitForCurserRunning(5);
        Thread.sleep(3000);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.scrollIntoView(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.waitForElementIsInteractable(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.clickByJsExecuter(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.waitUntilElementInvisibleLocated(SubmissionAssignmentUtility.EditAssignmentIcon);
        helper.waitUntilElementIsVisible(SubmissionAssignmentUtility.EditAssignmentPopup);
        helper.waitUntilElementPresent(SubmissionAssignmentUtility.EditAssignmentPopup);
    }


    public void createSubmissionPreRequisite(String Anonymous, String Customer, String Tags, String Location, String Attachment, String CategoryName) throws InterruptedException {

        int CheckCancel = driver.findElements(CSPInternalUtility.CancelCreateCase).size();
        if (CheckCancel > 0) {
            helper.scrollIntoView(CSPInternalUtility.CancelCreateCase);
            helper.clickOn(CSPInternalUtility.CancelCreateCase);

        }

        int CancelSubmission = driver.findElements(CSPInternalUtility.CloseSubmissionIcon).size();
        if (CancelSubmission > 0) {
            helper.scrollIntoView(CSPInternalUtility.CloseSubmissionIcon);
            helper.clickOn(CSPInternalUtility.CloseSubmissionIcon);

        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
        helper.scrollIntoView(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
        helper.clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.CustomerSubmissionOption);
        helper.clickByJsExecuter(CSPInternalUtility.CustomerSubmissionOption);
        helper.waitForCurserRunning(2);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
        helper.scrollIntoView(CSPInternalUtility.CategoryDropdown);
        helper.waitUntilElementPresent(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
        helper.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
        helper.sendKeysWithWait(CSPInternalUtility.SearchCategory, CategoryName);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.SearchResultsCategory);
        helper.clickByJsExecuter(CSPInternalUtility.SearchResultsCategory);
        String RandomDescription = RandomStrings.requiredString(20);
        helper.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);

        if (Anonymous == "Yes") {
            JavascriptExecutor jser = (JavascriptExecutor) driver;
            WebElement PostAnonymouslyCheckbox = (WebElement) jser.executeScript("return document.querySelector('div > div:nth-child(2) > span > input')");
            PostAnonymouslyCheckbox.click();

        }
        if (Customer == "Yes") {
            helper.sendKeysWithWait(CSPInternalUtility.AddExistingCustomerField, PropertiesUtils.getPropertyValue("crmCustomerName"));
            if (PropertiesUtils.getPropertyValue("RunEnvironment").equalsIgnoreCase("stage") || (PropertiesUtils.getPropertyValue("RunEnvironment").equalsIgnoreCase("Production"))) {
                helper.waitUntilElementIsVisible(By.xpath("(//div[@class='list-label']//b)[1]"));
                helper.waitForElementIsInteractable(By.xpath("(//div[@class='list-label']//b)[1]"));
                helper.clickByJsExecuter(By.xpath("(//div[@class='list-label']//b)[1]"));
            } else {
                //helper.waitForElementIsInteractable(By.xpath("//div[contains(text(),'automationcomcate')]"));
              //  helper.forcedWaitTime(3);
               // helper.clickByJsExecuter(By.xpath("//div[contains(text(),'automationcomcate')]"));
         helper.waitForElementIsInteractable(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
               helper.clickByJsExecuter(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
            }
            if (helper.getValueAttribute(CellPhoneField).isEmpty())
                helper.sendKeysWithWait(CellPhoneField, "12057547399");

        }
        if (Tags == "Yes") {
            for (int i = 0; i < 5; i++) {
                String RandomTags = RandomStrings.requiredString(4);
                helper.sendKeysWithWait(CSPInternalUtility.TagsField, RandomTags + ",");
            }
        }
        if (Location == "Yes") {
            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o)) {
                searchLocationCSP(searchLocationKey1O);
            }else if(BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)){
                searchLocationCSP(CSPInternalGISDirect20Utility.searchLocationHosted20);
            }
            else {
                searchLocationCSP(searchLocationKey);
            }
            helper.waitForPresenceandVisiblity(CSPInternalUtility.FlagToggle);
            if (helper.elementIsDisplayed(CSPInternalUtility.ToggleChecked)) {
                helper.clickOn(CSPInternalUtility.FlagToggle);
                int flagCheck = helper.fineElementsSize(By.xpath("//textarea[@name='reasonForFlagging']"));
                if (flagCheck > 0) {
                    helper.sendKeysWithWait(By.xpath("//textarea[@name='reasonForFlagging']"), "Unflagged");
                    helper.waitForElementIsInteractable(By.xpath("//button[text()='Unflag address']"));
                    helper.clickOn(By.xpath("//button[text()='Unflag address']"));
                    helper.waitForCurserRunning(5);
                    helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);

                }
            }
        }
        if (Attachment == "Yes") {
            helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);
            helper.waitForElementIsInteractable(CSPInternalUtility.AttachmentIcon);
            helper.clickByJsExecuter(CSPInternalUtility.AttachmentIcon);
            WebElement UploadFile3 = driver.findElement(By.xpath("//input[@type='file']"));
            UploadFile3.sendKeys(System.getProperty("user.dir") + "/TestData/Cat_11zon.jpg");
            helper.waitForCurserRunning(5);
            helper.waitForElementIsInteractable(CSPInternalUtility.AddButton);
            helper.clickOn(CSPInternalUtility.AddButton);
            helper.waitForCurserRunning(4);
        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.scrollIntoView(CSPInternalUtility.CreateSubmissionButton);
        helper.waitUntilElementPresent(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForElementIsInteractable(CSPInternalUtility.CreateSubmissionButton);
        helper.clickByJsExecuter(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForCurserRunning(5);
        List<WebElement> DuplicateSubsPopup = driver.findElements(CSDPUtility.PossibleDuplicateSubmissionsPopup);
        if (DuplicateSubsPopup.size() == 1) {
            helper.clickOn(SubmitAnywayButton);
        }

    }

    public void createCategory(String Checkbox, String IncludeLoc, String Keywords, String CategoryName) throws InterruptedException {

        driver.navigate().to(BrowsersInvoked.URLCategories);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
        helper.scrollToRight();
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryButton);
        Thread.sleep(3000);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryButton);

        if (Checkbox == "Yes") {
            helper.waitForElementIsInteractable(CategoryPage.LocationRequiredCheckbox);
            helper.clickByJsExecuter(CategoryPage.LocationRequiredCheckbox);
        }
        if (IncludeLoc == "No") {
          //  helper.waitForElementIsInteractable(CategoryUtility.NoLocationToggle);
            try{
                System.out.println("enter in try for category ...");
                helper.waitForElementIsInteractable(CategoryPage.NoLocationToggle);
                helper.clickByJsExecuter(CategoryPage.NoLocationToggle);
            }catch (Exception e){
                System.out.println("in catch of category ");
                Thread.sleep(3000);
                helper.waitForElementIsInteractable(CategoryPage.NoLocationToggle);
                helper.clickByJsExecuter(CategoryPage.NoLocationToggle);
            }
         //   helper.clickByJsExecuter(CategoryUtility.NoLocationToggle);
        }
        if (Keywords == "Yes") {
            WebElement AddKeywordsField = helper.findElement(CategoryPage.KeywordsField);
            for (int i = 0; i < 10; i++) {
                String RandomKeyword = RandomStrings.requiredCharacters(4);
                AddKeywordsField.sendKeys(RandomKeyword);
                AddKeywordsField.sendKeys(Keys.SPACE);
            }
        }
        helper.waitForPresenceandVisiblity(CategoryPage.NameField);
        helper.waitForElementIsInteractable(CategoryPage.NameField);
        helper.sendKeysWithWait(CategoryPage.NameField, CategoryName);
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryPopupBtn);
        helper.scrollIntoView(CategoryPage.CreateCategoryPopupBtn);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryPopupBtn);
        List<WebElement> ExistsOrNot = driver.findElements(CategoryPage.NotificationMsg);
        if (ExistsOrNot.size() == 1) {
            helper.clickOn(CategoryPage.CancelButton);
        }

    }

    public void createCategoryAppPrerequisute(String Checkbox, String IncludeLoc, String Keywords, String CategoryName) throws InterruptedException {

        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
        helper.scrollToRight();
        helper.scrollIntoView(CategoryPage.CreateCategoryButton);
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryButton);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryButton);
        helper.waitForPresenceandVisiblity(CategoryPage.LocationRequiredCheckbox);
        if (Checkbox == "Yes") {
          //  helper.clickOn(CategoryUtility.LocationRequiredCheckbox);
            Thread.sleep(2000);
            helper.clickByJsExecuter(CategoryPage.LocationRequiredCheckbox);
        }
        if (IncludeLoc == "No") {
           // helper.clickOn(CategoryUtility.NoLocationToggle);
            Thread.sleep(2000);
           helper.clickByJsExecuter(CategoryPage.NoLocationToggle);
        }
        if (Keywords == "Yes") {
            WebElement AddKeywordsField = helper.findElement(CategoryPage.KeywordsField);
            for (int i = 0; i < 10; i++) {
                String RandomKeyword = RandomStrings.requiredCharacters(4);
                AddKeywordsField.sendKeys(RandomKeyword);
                AddKeywordsField.sendKeys(Keys.SPACE);
            }
        }
        helper.waitForElementIsInteractable(CategoryPage.NameField);
        helper.sendKeysWithWait(CategoryPage.NameField, CategoryName);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryPopupBtn);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryPopupBtn);
        List<WebElement> ExistsOrNot = driver.findElements(CategoryPage.NotificationMsg);
        if (ExistsOrNot.size() == 1) {
            helper.clickOn(CategoryPage.CancelButton);
        }
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
    }

    public void createExternalSubmission(String Attachment, String Category, String Anonymous, String Contact) throws InterruptedException {

        cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePage();
        String RandomDescription = RandomStrings.requiredString(50);
        helper.waitUntilElementIsVisible(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
        helper.scrollIntoView(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
        helper.clickOn(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
        helper.waitUntilElementIsVisible(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"));
        helper.sendKeysWithWait(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"), Category);
        helper.waitUntilElementIsVisible(By.xpath("//div[@class='option-black']"));
        helper.clickOn(By.xpath("//div[@class='option-black'][contains(text(),'" + Category + "')]"));
        helper.sendKeysWithWait(CSPExternalUtility.IssueDescriptionField, RandomDescription);
        if (Attachment == "Yes") {

            WebElement UploadFile = driver.findElement(By.xpath("//input[@type='file']"));
            UploadFile.sendKeys(System.getProperty("user.dir") + "/TestData/Panda_11zon.jpg");

        }
        clickOnIssueDescriptionNextButton();

        String validationMssg = "The location you have entered falls outside the city limits. Please select a location within the city limits to continue";

        if (Category == "Location Required" || Category == "Location Not Required") {

          if(BrowsersInvoked.agencyConfig.equalsIgnoreCase("GisDirect2o")) {
              helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchField);
              helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
              helper.clickByJsExecuter(CSPExternalUtility.LocationSearchField);
              helper.sendKeysWithWait(CSPExternalUtility.LocationSearchField, "1400 Boulder Highway, Henderson, NV 89011");
              helper.forcedWaitTime(3);
              helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchResult);
              Thread.sleep(3000);
              helper.clickOn(CSPExternalUtility.LocationSearchResult);
          }
          else{
              helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchField);
              helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
              helper.clickByJsExecuter(CSPExternalUtility.LocationSearchField);
              helper.sendKeysWithWait(CSPExternalUtility.LocationSearchField, "Texas City Museum, Texas City, TX 77590");
              helper.forcedWaitTime(3);
              helper.waitUntilElementIsVisible(CSPExternalUtility.LocationSearchResult);
              Thread.sleep(3000);
              helper.clickOn(CSPExternalUtility.LocationSearchResult);

          }


        }

        clickOnLocationNextButton();
        if (Anonymous == "Yes") {
            helper.waitUntilElementIsVisible(CSPExternalUtility.YesButton);
            helper.scrollIntoView(CSPExternalUtility.YesButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.YesButton);
            helper.clickByJsExecuter(CSPExternalUtility.YesButton);

            helper.waitUntilElementIsVisible(CSPExternalUtility.SubmitButton);
            helper.scrollIntoView(CSPExternalUtility.SubmitButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.SubmitButton);
            helper.clickByJsExecuter(CSPExternalUtility.SubmitButton);
            helper.clickOn(CSPExternalUtility.SubmitButton);
        }

        if (Contact == "Yes") {

            helper.waitForPresenceandVisiblity(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.EmailPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.TextMsgPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.TextMsgPreferenceButton);
            String RandomFirstName = RandomStrings.requiredCharacters(6);
            String RandomLastName = RandomStrings.requiredCharacters(6);
            helper.sendKeysWithWait(CSPExternalUtility.FirstNameField, RandomFirstName);
            helper.sendKeysWithWait(CSPExternalUtility.LastNameField, RandomLastName);
            helper.sendKeysWithWait(CSPExternalUtility.EmailField, "automationcomcate@gmail.com");
            helper.sendKeysWithWait(CSPExternalUtility.MobileNumberField, "+12057547399");
        }


        helper.waitForPresenceandVisiblity(By.cssSelector("div.actions button.btn-primary"));
        helper.scrollIntoView(By.cssSelector("div.actions button.btn-primary"));
        helper.forcedWaitTime(2);
        helper.waitForElementIsInteractable(By.cssSelector("div.actions button.btn-primary"));
        helper.clickByJsExecuter(By.cssSelector("div.actions button.btn-primary"));
    }

    public void createExternalSubmissionWithoutLogin(String Attachment, String Category, String Anonymous, String Contact) throws InterruptedException {
        cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePageNOLogin();
        String RandomDescription = RandomStrings.requiredString(50);
        helper.sendKeysWithWait(CSPExternalUtility.IssueDescriptionField, RandomDescription);
        if (Attachment == "Yes") {
            WebElement UploadFile = driver.findElement(By.xpath("//input[@type='file']"));
            UploadFile.sendKeys(System.getProperty("user.dir") + "/TestData/Panda_11zon.jpg");

        }

        helper.clickOn(CSPExternalUtility.NextButton);

        if (Category == "Location Not Included") {

            String CategorySelected = helper.getTextElement(CSPExternalUtility.SelectedCategory);
            boolean CompareSelCategory = CategorySelected.equals("Location Not Included");
            if (!CompareSelCategory) {
                List<WebElement> CountCategories = driver.findElements(CSPExternalUtility.OtherCategories);
                for (int i = 0; i < CountCategories.size(); i++) {
                    WebElement AllCategories = CountCategories.get(i);
                    String CategoriesText = AllCategories.getText();
                    if (CategoriesText.equals("Location Not Included")) {
                        AllCategories.click();
                        break;
                    }
                }
            }
        } else if (Category == "Location Required") {

            String CategorySelected = helper.getTextElement(CSPExternalUtility.SelectedCategory);
            boolean CompareSelCategory = CategorySelected.equals("Location Required");
            if (!CompareSelCategory) {
                List<WebElement> CountCategories = driver.findElements(CSPExternalUtility.OtherCategories);
                for (int i = 0; i < CountCategories.size(); i++) {
                    WebElement AllCategories = CountCategories.get(i);
                    String CategoriesText = AllCategories.getText();
                    if (CategoriesText.equals("Location Required")) {
                        AllCategories.click();
                        break;
                    }
                }
            }
            helper.waitForElementIsInteractable(CSPExternalUtility.LocationSearchField);
            helper.clickOn(CSPExternalUtility.LocationSearchField);
            helper.sendKeysWithWait(CSPExternalUtility.LocationSearchField, "Texas City Museum");
            helper.clickOn(CSPExternalUtility.LocationSearchResult);
        } else if (Category == "Location Not Required") {
            helper.waitForPresenceandVisiblity(CSPExternalUtility.SelectedCategory);
            String CategorySelected = helper.getTextElement(CSPExternalUtility.SelectedCategory);
            boolean CompareSelCategory = CategorySelected.equals("Location Not Required");
            if (!CompareSelCategory) {
                List<WebElement> CountCategories = driver.findElements(CSPExternalUtility.OtherCategories);
                for (int i = 0; i < CountCategories.size(); i++) {
                    WebElement AllCategories = CountCategories.get(i);
                    String CategoriesText = AllCategories.getText();
                    if (CategoriesText.equals("Location Not Required")) {
                        AllCategories.click();
                        break;
                    }
                }
            }
        }
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButtonSec2);
        helper.clickOn(CSPExternalUtility.NextButtonSec2);
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButtonSec3);
        helper.clickOn(CSPExternalUtility.NextButtonSec3);

        if (Anonymous == "Yes") {
            helper.waitForElementIsInteractable(CSPExternalUtility.YesButton);
            helper.clickOn(CSPExternalUtility.YesButton);
            helper.clickOn(CSPExternalUtility.SubmitButton);
        }

        if (Contact == "Yes") {
            helper.waitForPresenceandVisiblity(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.EmailPreferenceButton);
            helper.clickOn(CSPExternalUtility.EmailPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.FirstNameField);
            String RandomFirstName = RandomStrings.requiredCharacters(6);
            String RandomLastName = RandomStrings.requiredCharacters(6);
            helper.sendKeysWithWait(CSPExternalUtility.FirstNameField, RandomFirstName);
            helper.sendKeysWithWait(CSPExternalUtility.LastNameField, RandomLastName);
            helper.sendKeysWithWait(CSPExternalUtility.EmailField, "automationcomcate@gmail.com");
            helper.sendKeysWithWait(CSPExternalUtility.MobileNumberField, "+12057547399");
        }
        helper.clickOn(CSPExternalUtility.SubmitButton);

    }


    public void createACase() throws InterruptedException {

        JavascriptExecutor jser = (JavascriptExecutor) driver;
        WebElement CCPBtnJSE = (WebElement) jser.executeScript("return document.querySelector('#header > div.app-header__right > div:nth-child(2) > div.app-header__new')");

        helper.clickOnWE20(CCPBtnJSE);
        helper.clickOn(CCPUtility.CCPOption);
        helper.waitForCurserRunning(8);
        helper.waitForPresenceandVisiblity(CCPUtility.CreateCaseButton);

        addLocation();
        addViolation();
        addContact();
        helper.waitForPresenceandVisiblity(CCPUtility.CreateCaseButton);
        helper.waitForElementIsInteractable(CCPUtility.CreateCaseButton);
        helper.clickOn(CCPUtility.CreateCaseButton);
        helper.waitForPresenceandVisiblity(CCPUtility.AssignCaseTo);
        helper.implicitWaitforCustometime(2);
        helper.waitForElementIsInteractable(CCPUtility.AssignCaseTo);
        helper.clickOn(CCPUtility.AssignCaseTo);
        helper.waitForElementIsInteractable(CCPUtility.InspectionAssigneeTo);
        helper.clickOn(CCPUtility.InspectionAssigneeTo);
        helper.waitForElementIsInteractable(CCPUtility.CreateScheduleInspectionButton);
        helper.clickOn(CCPUtility.CreateScheduleInspectionButton);
        helper.waitForCurserRunning(5);

    }

    public void addAttachment() throws InterruptedException {
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        WebElement AttachmentIcon = (WebElement) jser.executeScript("return document.querySelector('div.tile-header-container > div > h2 > button')");
        AttachmentIcon.click();
        WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
        UploadFile4.sendKeys(System.getProperty("user.dir") + "/TestData/Jellyfish_11zon.jpg");
        helper.clickOn(CCPUtility.AddButton);

    }

    public void serachLocationCCP(String Address) throws InterruptedException {
        helper.waitForElementIsInteractable(LocationSearchField);
        helper.sendKeysWithWait(LocationSearchField, Address);
        helper.waitForPresenceandVisiblity(LocationSearchResult);
        helper.waitForElementIsInteractable(LocationSearchResult);
        helper.clickOn(LocationSearchResult);

    }

    public void addLocation() throws InterruptedException {

        if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
            serachLocationCCP(searchLocationKey1O);
        }
        
        else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
            serachLocationCCP(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_prod"));
        }
        else {
            serachLocationCCP(searchLocationKey);
        }

    }

    public void addViolation() throws InterruptedException {

        helper.waitForElementIsInteractable(CCPUtility.violationSearch_Box);
        helper.clickByJsExecuter(CCPUtility.violationSearch_Box);
        helper.waitForElementIsInteractable(CCPUtility.violationSearch_Box);
        helper.sendKeysWithWait(CCPUtility.violationSearch_Box, "Wa");
        helper.waitForPresenceandVisiblity(CCPUtility.ViolationsList);
        helper.waitForElementIsInteractable(CCPUtility.ViolationsList);
        helper.clickByJsExecuter(CCPUtility.ViolationsList);
    }

    public void addContact() throws InterruptedException {

        helper.waitForPresenceandVisiblity(CCPUtility.AddContactField);
        helper.waitForElementIsInteractable(CCPUtility.AddContactField);
        helper.clickOn(CCPUtility.AddContactField);
        helper.clickOn(CCPUtility.CreateNewContact);
        String RandomName = RandomStrings.requiredCharacters(8);
        String RandomMail = RandomName + "@yopmail.com";
        String RandomContact = RandomStrings.requiredDigits(10);
        helper.sendKeysWithWait(CCPUtility.NameField, RandomName);
        helper.sendKeysWithWait(CCPUtility.EmailField, RandomMail);
        helper.sendKeysWithWait(CCPUtility.WorkPhoneField, RandomContact);

        helper.waitForCurserRunning(4);
        System.out.println("successfully enter after waitforCurserRunning..... ");
        helper.waitForElementIsInteractable(CCPUtility.CreateContactBtn);
        helper.clickOn(CCPUtility.CreateContactBtn);
        Thread.sleep(3000);
        helper.waitForPresenceandVisiblity(CCPUtility.PropertyOwnerOption);
        helper.waitForElementIsInteractable(CCPUtility.PropertyOwnerOption);
        helper.clickOn(CCPUtility.PropertyOwnerOption);
        helper.clickOn(CCPUtility.ApplyButton);
        helper.waitForCurserRunning(4);

    }

    public void closeCaseOnCDP() throws InterruptedException {

        helper.waitForPresenceandVisiblity(PerformInspectionUtility.PerformInsButton);
        helper.waitForElementIsInteractable(PerformInspectionUtility.PerformInsButton);
        helper.clickOn(PerformInspectionUtility.PerformInsButton);
        helper.waitForElementIsInteractable(PerformInspectionUtility.InvalidVioToggle);
        helper.clickOn(PerformInspectionUtility.InvalidVioToggle);
        helper.waitForElementIsInteractable(PerformInspectionUtility.FooterButton);
        helper.clickOn(PerformInspectionUtility.FooterButton);
        helper.waitForElementIsInteractable(PerformInspectionUtility.YesBtnConfirmationPopup);
        helper.clickOn(PerformInspectionUtility.YesBtnConfirmationPopup);

    }

    public void navigateToAgencySetup() throws InterruptedException {
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.AppMenuIcon);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.AppMenuIcon);
        helper.scrollIntoView(AppPreRequisiteUtility.AppMenuIcon);
        helper.clickByJsExecuter(AppPreRequisiteUtility.AppMenuIcon);

        //	helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.AgencySetUpIconLbl);
        helper.scrollIntoView(AppPreRequisiteUtility.AgencySetUpIconLbl);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.AgencySetUpIconLbl);
        helper.clickByJsExecuter(AppPreRequisiteUtility.AgencySetUpIconLbl);

        helper.waitForCurserRunning(10);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.AuditTrial);
        helper.scrollIntoView(AppPreRequisiteUtility.AuditTrial);
    }

    public void navigationToPayment() throws InterruptedException {

        // helper.scrollIntoView();(OnlinePaymentUtility.PaymentSideBar);
        if (!driver.findElement(OnlinePaymentUtility.CitizenPaymentProtal).isDisplayed()) {
            helper.waitUntilElementIsVisible(OnlinePaymentUtility.PaymentSideBar);
            helper.scrollIntoView(OnlinePaymentUtility.PaymentSideBar);
            helper.waitForElementIsInteractable(OnlinePaymentUtility.PaymentSideBar);
            helper.waitForElementIsInteractable(OnlinePaymentUtility.PaymentSideBar);
            helper.clickByJsExecuter(OnlinePaymentUtility.PaymentSideBar);

        }
        helper.waitForPresenceandVisiblity(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.scrollIntoView(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.waitForElementIsInteractable(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.clickByJsExecuter(OnlinePaymentUtility.CitizenPaymentProtal);
        helper.waitForCurserRunning(4);
        helper.implicitWaitforCustometime(3);
        helper.scrolltoUp();
    }

    public void navigationToNoticesUtility() throws InterruptedException {
        navigateToAgencySetup();
        helper.waitForPresenceandVisiblity(By.xpath("//label[text()='Change Logo']"));
        helper.waitForElementIsInteractable(By.xpath("//label[text()='Change Logo']"));
        helper.forcedWaitTime(2);
        if (BrowsersInvoked.RunEnvironment.equalsIgnoreCase("STAGE")) {
            helper.waitForPresenceandVisiblity(NoticesUtility.CE);
            helper.scrollIntoView(NoticesUtility.CE);
            helper.waitUntilElementIsVisible(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.waitForElementIsInteractable(NoticesUtility.CE);
            helper.clickByJsExecuter(NoticesUtility.CE);
        } else {
            int ceSize = driver.findElements(NoticesUtility.CE).size();
            int ProductDemoSize = driver.findElements(NoticesUtility.ProductDemo).size();
            if (ceSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.CE);
                helper.scrollIntoView(NoticesUtility.CE);
                helper.waitUntilElementPresent(NoticesUtility.CE);
                helper.waitForElementIsInteractable(NoticesUtility.CE);
                helper.clickByJsExecuter(NoticesUtility.CE);
            } else if (ProductDemoSize > 0) {
                helper.waitForPresenceandVisiblity(NoticesUtility.ProductDemo);
                helper.scrollIntoView(NoticesUtility.ProductDemo);
                helper.waitUntilElementPresent(NoticesUtility.ProductDemo);
                helper.waitForElementIsInteractable(NoticesUtility.ProductDemo);
                helper.clickByJsExecuter(NoticesUtility.ProductDemo);
            }

        }
        helper.waitForPresenceandVisiblity(NoticesUtility.NoticesPageLink);
        helper.scrollIntoView(NoticesUtility.NoticesPageLink);
        helper.waitForElementIsInteractable(NoticesUtility.NoticesPageLink);
        helper.clickByJsExecuter(NoticesUtility.NoticesPageLink);
        helper.implicitWaitforCustometime(3);
        helper.scrollIntoView(NoticesUtility.AppHeaderIcon);
        helper.waitForPresenceandVisiblity(NoticesUtility.ActiveTab);
    }

    public void navigateToFines() throws InterruptedException {
        helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
        if (!driver.findElement(AppPreRequisiteUtility.FinesSideBar).isDisplayed()) {
            helper.waitUntilElementIsVisible(AppPreRequisiteUtility.CEProdSideBar);
            helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
            helper.clickByJsExecuter(AppPreRequisiteUtility.CEProdSideBar);

        }
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.FinesSideBar);
        helper.scrollIntoView(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.FinesSideBar);
        helper.clickByJsExecuter(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForCurserRunning(4);
        helper.implicitWaitforCustometime(3);
        helper.scrolltoUp();

    }

    public void navigateToLateFeesSubTab() throws InterruptedException {

        helper.scrollIntoView(AppPreRequisiteUtility.CEProdSideBar);
        if (!driver.findElement(AppPreRequisiteUtility.FinesSideBar).isDisplayed()) {
            helper.clickOn(AppPreRequisiteUtility.CEProdSideBar);

        }
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.FinesSideBar);
        helper.scrollIntoView(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.FinesSideBar);
        helper.clickByJsExecuter(AppPreRequisiteUtility.FinesSideBar);
        helper.waitForCurserRunning(4);
        helper.scrolltoUp();
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LateFeeSubtab);
        helper.scrollIntoView(AppPreRequisiteUtility.LateFeeSubtab);
        helper.clickByJsExecuter(AppPreRequisiteUtility.LateFeeSubtab);
        helper.implicitWaitforCustometime(3);

    }

    public void navigateToTemplateManagement() throws InterruptedException {

        helper.waitForPresenceandVisiblity(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.scrollIntoView(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.waitForElementIsInteractable(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.clickByJsExecuter(TemplateManagementUtility.TemplateManagementSideBarTab);
        helper.waitForPresenceandVisiblity(TemplateManagementUtility.EmailTemplatesTab);

    }

    public void addTemplateFiles(String selector, String filePath) throws InterruptedException, AWTException {

        helper.waitForPresenceandVisiblity(By.xpath(selector));
        helper.scrollIntoView(By.xpath(selector));
        WebElement UploadFile4 = driver.findElement(By.xpath("//input[@type='file']"));
        UploadFile4.sendKeys(filePath);

    }

    public void addNewTemplate(String templateName) throws InterruptedException, AWTException {

        helper.scrollIntoView(TemplateManagementUtility.CreateTemplateBtn);
        helper.waitForElementIsInteractable(TemplateManagementUtility.CreateTemplateBtn);
        helper.clickByJsExecuter(TemplateManagementUtility.CreateTemplateBtn);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(TemplateManagementUtility.TemplateNameTxt);
        helper.scrollIntoView(TemplateManagementUtility.TemplateNameTxt);
        helper.waitForElementIsInteractable(TemplateManagementUtility.TemplateNameTxt);
        helper.sendKeysWithWait(TemplateManagementUtility.TemplateNameTxt, templateName);
        helper.scrollIntoView(TemplateManagementUtility.EmailSubLineInput);
        String rndSubLine = RandomStrings.requiredString(3) + "EmailSubjectLine";
        helper.waitForElementIsInteractable(TemplateManagementUtility.EmailSubLineInput);
        helper.clearElement(TemplateManagementUtility.EmailSubLineInput);
        helper.waitForElementIsInteractable(TemplateManagementUtility.EmailSubLineInput);
        helper.sendKeysWithWait(TemplateManagementUtility.EmailSubLineInput, rndSubLine);
        String TemplateMessgae = RandomStrings.requiredCharacters(10);
        String ExpectedpreviewTemplateData = TemplateMessgae;
        WebElement switchFrame = helper.findElement(TemplateManagementUtility.IframeBody);
        driver.switchTo().frame(switchFrame);
        helper.sendKeysWithWait(TemplateManagementUtility.MessageBody, TemplateMessgae);
        driver.switchTo().defaultContent();
        helper.waitUntilElementIsVisible(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.scrollIntoView(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.waitForElementIsInteractable(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.clickByJsExecuter(TemplateManagementUtility.IncludeMagicLinkchk);
        helper.scrollIntoView(TemplateManagementUtility.SaveCrtTemplate);
        helper.waitForElementIsInteractable(TemplateManagementUtility.SaveCrtTemplate);
        helper.clickOn(TemplateManagementUtility.SaveCrtTemplate);

    }

    public void navigateToNotificationMangement() throws InterruptedException {

        helper.waitForPresenceandVisiblity(NotificationManagementUtility.NotificationMangementSideBar);
        helper.scrollIntoView(NotificationManagementUtility.NotificationMangementSideBar);
        helper.waitForElementIsInteractable(NotificationManagementUtility.NotificationMangementSideBar);
        helper.clickByJsExecuter(NotificationManagementUtility.NotificationMangementSideBar);
        helper.waitForCurserRunning(4);

    }

    public void navigateToAssignmentRules() throws InterruptedException {

        helper.waitForPresenceandVisiblity(POM.CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.scrollIntoView(CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.waitForElementIsInteractable(CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.clickByJsExecuter(CaseAssignmentUtility.AssignmentRuleSideBar);
        helper.waitForCurserRunning(2);

    }

    public void navigateToSLA() throws InterruptedException {

        helper.waitForPresenceandVisiblity(SLAUtility.SLASideBar);
        helper.scrollIntoView(SLAUtility.SLASideBar);
        helper.waitForElementIsInteractable(SLAUtility.SLASideBar);
        helper.clickByJsExecuter(SLAUtility.SLASideBar);
        helper.waitForCurserRunning(4);

    }

    public void navigationToFAAAdmin(By CaseManagementSidebar) throws InterruptedException {
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        jser.executeScript("window.scrollBy(0,450)", "");
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CEProdSideBar);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.CEProdSideBar);
        helper.clickOn(AppPreRequisiteUtility.CEProdSideBar);
        helper.waitForPresenceandVisiblity(CaseManagementSidebar);
        helper.waitForElementIsInteractable(CaseManagementSidebar);
        helper.clickByJsExecuter(CaseManagementSidebar);
        helper.waitForCurserRunning(4);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.ForcedAbatementTab);
        jser.executeScript("window.scrollBy(0,-450)", "");

    }

    public void navigationToViolationAdmin(By ViolationsSidebarOption) throws InterruptedException {
        helper.refreshPage();
        helper.waitForCurserRunning(6);
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        jser.executeScript("window.scrollBy(0,450)", "");
        helper.waitForPresenceandVisiblity(ViolationsSidebarOption);
        helper.scrollIntoView(ViolationsSidebarOption);
        helper.waitForElementIsInteractable(ViolationsSidebarOption);
        helper.waitUntilElementPresent(ViolationsSidebarOption);
        helper.clickByJsExecuter(ViolationsSidebarOption);
        helper.waitForCurserRunning(3);
        jser.executeScript("window.scrollBy(0,-450)", "");
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.MunicipalCodeTab);
        // helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateMunicipalCodeButton);
    }

    public void addNewViolationAdmin(String violationName) throws InterruptedException {
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.LabelField);
        helper.sendKeysWithWait(AppPreRequisiteUtility.LabelField, violationName);

        helper.scrollIntoView(AppPreRequisiteUtility.ViolationTypeDropdown);
        helper.clickOn(AppPreRequisiteUtility.ViolationTypeDropdown);

        if (violationName.equalsIgnoreCase("Animal")) {

            helper.scrollIntoView(AppPreRequisiteUtility.VioOptionAnimal);
            helper.clickOn(AppPreRequisiteUtility.VioOptionAnimal);
        } else {
            helper.waitForElementIsInteractable(AppPreRequisiteUtility.VioOptionGeneral);
            helper.clickOn(AppPreRequisiteUtility.VioOptionGeneral);
        }
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeField);
        helper.clickOn(AppPreRequisiteUtility.MunicipalCodeField);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.MunicipalCodeOption);
        helper.clickOn(AppPreRequisiteUtility.MunicipalCodeOption);

        helper.waitForElementIsInteractable(AppPreRequisiteUtility.CreateViolationButton2);
        helper.clickByJsExecuter(AppPreRequisiteUtility.CreateViolationButton2);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(By.xpath(AppPreRequisiteUtility.getMuncipalVioCode(violationName)));

    }

    public void navigateToDisposition() throws InterruptedException {
        helper.refreshPage();
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.DispositionsTab);
        JavascriptExecutor jser = (JavascriptExecutor) driver;
        helper.scrollIntoView(AppPreRequisiteUtility.DispositionsTab);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.DispositionsTab);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.DispositionsTab);
        helper.clickByJsExecuter(AppPreRequisiteUtility.DispositionsTab);
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.CreateInvalidDispositionButton);
    }

    public void clickOnIssueDescriptionNextButton() {
        helper.waitUntilElementIsVisible(CSPExternalUtility.NextButton);
        helper.waitUntilElementPresent(CSPExternalUtility.NextButton);
        helper.scrollIntoView(CSPExternalUtility.NextButton);
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButton);
        helper.clickByJsExecuter(CSPExternalUtility.NextButton);
    }

    public void clickOnBackButtonCRMExternal() {
        helper.waitUntilElementIsVisible(CSPExternalUtility.BackButton);
        helper.scrollIntoView(CSPExternalUtility.BackButton);
        helper.waitForElementIsInteractable(CSPExternalUtility.BackButton);
        helper.clickByJsExecuter(CSPExternalUtility.BackButton);
    }

    public void clickOnLocationNextButton() {
        helper.waitUntilElementIsVisible(CSPExternalUtility.NextButtonSec2);
        helper.waitUntilElementPresent(CSPExternalUtility.NextButtonSec2);
        helper.scrollIntoView(CSPExternalUtility.NextButtonSec2);
        helper.waitForElementIsInteractable(CSPExternalUtility.NextButtonSec2);
        helper.clickByJsExecuter(CSPExternalUtility.NextButtonSec2);
    }

    public void createCategoryCustomKeyWord(String Checkbox, String IncludeLoc, String Keywords, String CategoryName, String KeywordName) throws InterruptedException {

        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
        helper.scrollToRight();
        helper.scrollIntoView(CategoryPage.CreateCategoryButton);
        helper.waitForElementIsInteractable(CategoryPage.CreateCategoryButton);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryButton);
        helper.waitForPresenceandVisiblity(CategoryPage.LocationRequiredCheckbox);
        if (Checkbox == "Yes") {
            helper.clickOn(CategoryPage.LocationRequiredCheckbox);
        }
        if (IncludeLoc == "No") {
            helper.clickOn(CategoryPage.NoLocationToggle);
        }
        if (Keywords == "Yes") {
            WebElement AddKeywordsField = helper.findElement(CategoryPage.KeywordsField);
            for (int i = 0; i < 10; i++) {
                String RandomKeyword = RandomStrings.requiredCharacters(4);
                AddKeywordsField.sendKeys(RandomKeyword);
                AddKeywordsField.sendKeys(Keys.SPACE);
            }

            AddKeywordsField.sendKeys(KeywordName);
            AddKeywordsField.sendKeys(Keys.SPACE);
        }
        helper.waitForElementIsInteractable(CategoryPage.NameField);
        helper.sendKeysWithWait(CategoryPage.NameField, CategoryName);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryPopupBtn);
        helper.clickByJsExecuter(CategoryPage.CreateCategoryPopupBtn);
        List<WebElement> ExistsOrNot = driver.findElements(CategoryPage.NotificationMsg);
        if (ExistsOrNot.size() == 1) {
            helper.clickOn(CategoryPage.CancelButton);
        }
        helper.waitForCurserRunning(5);
        helper.waitForPresenceandVisiblity(CategoryPage.CreateCategoryButton);
    }

    public void customExternalSubmissionPinLocation(String description, String Attachment, String Category, String Anonymous, String Contact) throws InterruptedException {
        cspExternal.CSPExternal_PreRequisite_OpenReportAnIssuePage();
        helper.waitUntilElementIsVisible(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
        helper.scrollIntoView(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
        helper.clickOn(By.xpath("//h2[contains(text(),'Category')]//parent::div//div[@class='dropdown__label']"));
        helper.waitUntilElementIsVisible(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"));
        helper.sendKeysWithWait(By.xpath("//div[@class='dropdown-content__search-container']//input[@type='text']"), Category);
        helper.waitUntilElementIsVisible(By.xpath("//div[@class='option-black']"));
        helper.clickOn(By.xpath("//div[@class='option-black'][contains(text(),'" + Category + "')]"));
        helper.sendKeysWithWait(cspExternal.IssueDescriptionField, description);
        if (Attachment == "Yes") {

            WebElement UploadFile = driver.findElement(By.xpath("//input[@type='file']"));
            UploadFile.sendKeys(System.getProperty("user.dir") + "/TestData/Panda_11zon.jpg");

        }

        clickOnIssueDescriptionNextButton();

        if (Category != "Location Not Included") {
            ExternalCSPPinLocation();

        }
        helper.forcedWaitTime(4);
        clickOnLocationNextButton();

        if (Anonymous == "Yes") {
            helper.waitUntilElementIsVisible(CSPExternalUtility.YesButton);
            helper.scrollIntoView(CSPExternalUtility.YesButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.YesButton);
            helper.clickByJsExecuter(CSPExternalUtility.YesButton);

            helper.waitUntilElementIsVisible(CSPExternalUtility.SubmitButton);
            helper.scrollIntoView(CSPExternalUtility.SubmitButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.SubmitButton);
            helper.clickByJsExecuter(CSPExternalUtility.SubmitButton);
            helper.clickOn(CSPExternalUtility.SubmitButton);
        }

        if (Contact == "Yes") {

            helper.waitForPresenceandVisiblity(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.EmailPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.EmailPreferenceButton);
            helper.scrollIntoView(CSPExternalUtility.TextMsgPreferenceButton);
            helper.waitForElementIsInteractable(CSPExternalUtility.TextMsgPreferenceButton);
            helper.clickByJsExecuter(CSPExternalUtility.TextMsgPreferenceButton);
            String RandomFirstName = RandomStrings.requiredCharacters(6);
            String RandomLastName = RandomStrings.requiredCharacters(6);
            helper.sendKeysWithWait(CSPExternalUtility.FirstNameField, RandomFirstName);
            helper.sendKeysWithWait(CSPExternalUtility.LastNameField, RandomLastName);
            helper.sendKeysWithWait(CSPExternalUtility.EmailField, "automationcomcate@gmail.com");
            helper.sendKeysWithWait(CSPExternalUtility.MobileNumberField, "+12057547399");
        }

        helper.waitForPresenceandVisiblity(By.cssSelector("div.actions button.btn-primary"));
        helper.scrollIntoView(By.cssSelector("div.actions button.btn-primary"));
        helper.forcedWaitTime(2);
        helper.waitForElementIsInteractable(By.cssSelector("div.actions button.btn-primary"));
        helper.clickByJsExecuter(By.cssSelector("div.actions button.btn-primary"));
    }

    public void composeCRMMessage(String randomSubject) throws InterruptedException {
        helper.waitForCurserRunning(7);
        helper.waitUntilElementIsVisible(CreateAndLinkCaseUtility.SubmissionNumber);
        String SubmissionNumberSplit[] = helper.getTextElement(CreateAndLinkCaseUtility.SubmissionNumber).split("#");
        String SubmissionNumberCSDP = SubmissionNumberSplit[1];
        helper.clickOn(SmsAndEmailVerificationUtility.MessagesIcon);
        helper.sendKeysWithWait(SmsAndEmailVerificationUtility.SubjectField, randomSubject);
        WebElement switchFrame = helper.waitUntilVisibleWE(SmsAndEmailVerificationUtility.IframeBody);
        driver.switchTo().frame(switchFrame);
        String RandomBody = "Random Body" + RandomStrings.requiredString(50);
        helper.waitForElementIsInteractable(SmsAndEmailVerificationUtility.MessageBody);
        helper.sendKeysWithWait(SmsAndEmailVerificationUtility.MessageBody, RandomBody);
        driver.switchTo().defaultContent();
        helper.clickByJsExecuter(SmsAndEmailVerificationUtility.SendButton);
        helper.waitUntilElementInvisibleLocated(SmsAndEmailVerificationUtility.SendButton);
        helper.waitForCurserRunning(7);
        helper.waitUntilElementIsVisible(CreateAndLinkCaseUtility.SubmissionNumber);
    }

    public void searchSubmissionCSLP(String filtersearch) throws InterruptedException {
        helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
        helper.waitForElementIsInteractable(CSLPUtility.CSLPSearchField);
        helper.sendKeysWithWait(CSLPUtility.CSLPSearchField, filtersearch);
        helper.forcedWaitTime(4);
        helper.waitForCurserRunning(4);
        helper.WaitForGridTableEnable();
    }


    public void closeSubmissionDetailPage() throws InterruptedException {
        helper.waitUntilElementIsVisible(CSDPUtility.CloseSDPage);
        helper.scrollIntoView(CSDPUtility.CloseSDPage);
        helper.waitForElementIsInteractable(CSDPUtility.CloseSDPage);
        helper.clickByJsExecuter(CSDPUtility.CloseSDPage);
        helper.waitUntilElementInvisibleLocated(CSDPUtility.CloseSDPage);
        helper.waitForCurserRunning(5);
    }


    public void SearchCaseOnCSLP(String caseId) throws InterruptedException{
        Thread.sleep(2000);
       // helper.waitUntilElementIsInvisible(CSLPUtility.CSLPSearchField);
       helper.waitUntilElementPresent(CSLPUtility.CSLPSearchField);
        helper.clearElement(CSLPUtility.CSLPSearchField);
        helper.waitForElementIsInteractable(CSLPUtility.CSLPSearchField);
        helper.sendKeysWithWait(CSLPUtility.CSLPSearchField, caseId);
        helper.waitForCurserRunning(2);
        System.out.println("caseID" + caseId);
        helper.waitUntilElementIsVisible(By.xpath("//a[text()='" + caseId + "']"));
        helper.waitUntilElementPresent(By.xpath("//a[text()='" + caseId + "']"));
        helper.waitForElementIsInteractable(By.xpath("//a[text()='" + caseId + "']"));
    }

    public  void CRM_CreateSubmissionCustomeAddress(String Anonymous, String Customer, String Tags, String Location,
                                                          String Attachment, String CategoryName, String AddressLocator, Boolean APN, Boolean PinLocation) throws InterruptedException {


        helper.waitForCurserRunning(5);
        int CheckCancel = driver.findElements(CSPInternalUtility.CancelCreateCase).size();
        if (CheckCancel > 0) {
            helper.scrollIntoView(CSPInternalUtility.CancelCreateCase);
            helper.clickOn(CSPInternalUtility.CancelCreateCase);

        }

        int CancelSubmission = driver.findElements(CSPInternalUtility.CloseSubmissionIcon).size();
        if (CancelSubmission > 0) {
            helper.scrollIntoView(CSPInternalUtility.CloseSubmissionIcon);
            helper.clickOn(CSPInternalUtility.CloseSubmissionIcon);

        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.PlusIconToCRM);
        helper.scrollIntoView(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.PlusIconToCRM);
        helper.clickByJsExecuter(CSPInternalUtility.PlusIconToCRM);
        helper.waitForElementIsInteractable(CSPInternalUtility.CustomerSubmissionOption);
        helper.clickByJsExecuter(CSPInternalUtility.CustomerSubmissionOption);
        helper.waitForCurserRunning(2);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.CategoryDropdown);
        helper.scrollIntoView(CSPInternalUtility.CategoryDropdown);
        helper.waitUntilElementPresent(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.CategoryDropdown);
        helper.clickByJsExecuter(CSPInternalUtility.CategoryDropdown);
        helper.waitForElementIsInteractable(CSPInternalUtility.SearchCategory);
        helper.sendKeysWithWait(CSPInternalUtility.SearchCategory, CategoryName);
        helper.waitForPresenceandVisiblity(CSPInternalUtility.SearchResultsCategory);
        helper.clickByJsExecuter(CSPInternalUtility.SearchResultsCategory);
        String RandomDescription = RandomStrings.requiredString(20);
        helper.sendKeysWithWait(CSPInternalUtility.IssueDescriptionField, RandomDescription);

        if (Anonymous == "Yes") {
            JavascriptExecutor jser = (JavascriptExecutor) driver;
            WebElement PostAnonymouslyCheckbox = (WebElement) jser
                    .executeScript("return document.querySelector('div > div:nth-child(2) > span > input')");
            PostAnonymouslyCheckbox.click();

        }
        if (Customer == "Yes") {
            helper.sendKeysWithWait(CSPInternalUtility.AddExistingCustomerField, PropertiesUtils.getPropertyValue("crmCustomerName"));
            if (PropertiesUtils.getPropertyValue("RunEnvironment").equalsIgnoreCase("stage")) {
                helper.waitForElementIsInteractable(By.xpath("(//div[@class='list-label']//b)[1]"));
                helper.forcedWaitTime(3);
                helper.clickOn(By.xpath("(//div[@class='list-label']//b)[1]"));
            } else {
                if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o) || BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
                    try{
                        helper.waitForElementIsInteractable(By.xpath("(//div[@class='list-label']//b)[1]"));
                        helper.clickOn(By.xpath("(//div[@class='list-label']//b)[1]"));
                    }catch (Exception e){
                        System.out.println("enter in catch of CRM_CreateSubmissionCustomeAddress ........ ");
                        helper.forcedWaitTime(4);
                        helper.waitForElementIsInteractable(By.xpath("(//div[@class='list-label']//b)[1]"));
                        helper.clickByJsExecuter(By.xpath("(//div[@class='list-label']//b)[1]"));
                    }

                } else if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterprise)) {
                    helper.waitForElementIsInteractable(By.xpath("//div[contains(text(),'automationcomcate')]"));
                    helper.clickOn(By.xpath("//div[contains(text(),'automationcomcate')]"));
                }

            }
            if (helper.getValueAttribute(CellPhoneField).isEmpty())
                helper.sendKeysWithWait(CellPhoneField, "12057547399");


        }
        if (Tags == "Yes") {
            for (int i = 0; i < 5; i++) {
                String RandomTags = RandomStrings.requiredString(4);
                helper.sendKeysWithWait(CSPInternalUtility.TagsField, RandomTags + ",");
            }
        }
        if (Location == "Yes") {
            if (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect1o)) {
                if (PinLocation) {
                    CCPGisDirectPinLocation();
                } else {

                    if (APN) {
//                        CRMCommonMethods.serachLocationCCPNoClick(searchAPNLocation20);
                        serachLocationCCPNoClick(searchAPNLocation20);
                    } else {
//                        CRMCommonMethods.serachLocationCCPNoClick(searchLocationKey1O);
                        serachLocationCCPNoClick(searchLocationKey1O);
                    }
                }

                Thread.sleep(3000);
                helper.scrollIntoView(By.xpath(AddressLocator));
                helper.waitUntilElementIsVisible(By.xpath(AddressLocator));
                helper.waitUntilElementPresent(By.xpath(AddressLocator));
                helper.waitForElementIsInteractable(By.xpath(AddressLocator));
                helper.forcedWaitTime(4);
                helper.clickByJsExecuter(By.xpath(AddressLocator));
                helper.waitForCurserRunning(4);
            } else if
            (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigGisDirect2o)) {
                if (PinLocation) {
                    CCPGisDirectPinLocation();
                } else {
                    if (APN) {
                        serachLocationCCPNoClick(searchAPNLocation20);
                    } else {
                        serachLocationCCPNoClick(searchLocationKey1O);
                    }
                }
                helper.forcedWaitTime(3);
                helper.scrollIntoView(By.xpath(AddressLocator));
                Thread.sleep(2000);
                helper.waitUntilElementIsVisible(By.xpath(AddressLocator));
                helper.waitUntilElementPresent(By.xpath(AddressLocator));
                helper.waitForElementIsInteractable(By.xpath(AddressLocator));
                helper.forcedWaitTime(4);
                helper.clickByJsExecuter(By.xpath(AddressLocator));
                helper.waitForCurserRunning(4);
            } 

            else if
            (BrowsersInvoked.agencyConfig.equalsIgnoreCase(BrowsersInvoked.agencyConfigEnterpriseHosted20)) {
                if (PinLocation) {
                    CCPGisDirectPinLocation();
                } else {
                    if (APN) {

                            serachLocationCCPNoClick("7030-0207-0006-000");

                    } else {

                            //serachLocationCCPNoClick(ExtractedSearchLocationHosted20);
                            serachLocationCCPNoClick(PropertiesUtils.getPropertyValue("searchLocationKeyHost20_prod"));
                        }

                }
                helper.forcedWaitTime(3);

                helper.scrollIntoView(By.xpath(AddressLocator));
                Thread.sleep(2000);
                helper.waitUntilElementIsVisible(By.xpath(AddressLocator));
            //    helper.waitUntilElementPresent(By.xpath(AddressLocator));
             //   helper.waitForElementIsInteractable(By.xpath(AddressLocator));
                helper.forcedWaitTime(4);
                helper.clickByJsExecuter(By.xpath(AddressLocator));
                helper.waitForCurserRunning(4);
            } 
            
            
            
            else {
                searchLocationCSP(searchLocationKey);
            }
            helper.waitForPresenceandVisiblity(CSPInternalUtility.FlagToggle);
            if (helper.elementIsDisplayed(CSPInternalUtility.ToggleChecked)) {
                helper.clickOn(CSPInternalUtility.FlagToggle);
                int flagCheck = helper.fineElementsSize(By.xpath("//textarea[@name='reasonForFlagging']"));
                if (flagCheck > 0) {
                    helper.sendKeysWithWait(By.xpath("//textarea[@name='reasonForFlagging']"), "Unflagged");
                    helper.waitForElementIsInteractable(By.xpath("//button[text()='Unflag address']"));
                    helper.clickOn(By.xpath("//button[text()='Unflag address']"));
                    helper.waitForCurserRunning(5);
                    helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);

                }
            }
        }
        if (Attachment == "Yes") {
            helper.waitForPresenceandVisiblity(CSPInternalUtility.AttachmentIcon);
            helper.waitForElementIsInteractable(CSPInternalUtility.AttachmentIcon);
            helper.clickByJsExecuter(CSPInternalUtility.AttachmentIcon);
            WebElement UploadFile3 = driver.findElement(By.xpath("//input[@type='file']"));
            UploadFile3.sendKeys(System.getProperty("user.dir") + "/TestData/Cat_11zon.jpg");
            helper.waitForCurserRunning(5);
            helper.waitForElementIsInteractable(CSPInternalUtility.AddButton);
            helper.clickOn(CSPInternalUtility.AddButton);
            helper.waitForCurserRunning(4);
        }

        helper.waitForPresenceandVisiblity(CSPInternalUtility.CreateSubmissionButton);
        helper.scrollIntoView(CSPInternalUtility.CreateSubmissionButton);
        helper.waitUntilElementPresent(CSPInternalUtility.CreateSubmissionButton);
        helper.waitForElementIsInteractable(CSPInternalUtility.CreateSubmissionButton);
        helper.clickByJsExecuter(CSPInternalUtility.CreateSubmissionButton);
        //Thread.sleep(3000);
        System.out.println("create submission popup appears ");
        helper.waitForCurserRunning(5);

        List<WebElement> DuplicateSubsPopup = driver
                .findElements(CSDPUtility.PossibleDuplicateSubmissionsPopup);
        if (DuplicateSubsPopup.size() == 1) {
            helper.clickOn(SubmitAnywayButton);
        }
        Thread.sleep(3000);

    }


    public  void serachLocationCCPNoClick(String Address) throws InterruptedException {
        helper.waitUntilElementIsVisible(LocationSearchField);
        helper.waitForElementIsInteractable(LocationSearchField);
       // Thread.sleep(3000);
        helper.sendKeysWithWait(LocationSearchField, Address);
        System.out.println("Address : -> "+ Address);
        Thread.sleep(3000);
        System.out.println("successfully passs ");
        helper.waitForPresenceandVisiblity(LocationSearchResult);
        helper.waitForElementIsInteractable(LocationSearchResult);
    }


    public  void NavigateTo_LocationManagement(By subtab) throws InterruptedException {
//        helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LocationManagementTab);
//        helper.scrollIntoView(AppPreRequisiteUtility.LocationManagementTab);
//        helper.waitForElementIsInteractable(AppPreRequisiteUtility.LocationManagementTab);
//        helper.forcedWaitTime(2);

     if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
         helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LocationManagementTab);
         helper.scrollIntoView(AppPreRequisiteUtility.LocationManagementTab);
         helper.waitForElementIsInteractable(AppPreRequisiteUtility.LocationManagementTab);
         helper.forcedWaitTime(2);

         helper.clickByJsExecuter(AppPreRequisiteUtility.locationAndMapsTab);
         helper.waitForCurserRunning(3);
         helper.clickByJsExecuter(AppPreRequisiteUtility.securedLocationSetting);
         helper.waitForCurserRunning(3);
         boolean checkSubtab = helper.elementIsDisplayed(subtab);
         if (!checkSubtab) {
             helper.clickByJsExecuter(AppPreRequisiteUtility.LocationManagementTab);
         }
         helper.waitForPresenceandVisiblity(subtab);
         helper.waitForElementIsInteractable(subtab);
         helper.clickByJsExecuter(subtab);
         helper.waitUntilVisibleWE(AppPreRequisiteUtility.parcelLayerTab);
         helper.waitUntilElementPresent(AppPreRequisiteUtility.parcelLayerTab);
     }else{
         helper.waitForPresenceandVisiblity(AppPreRequisiteUtility.LocationManagementTab);
        helper.scrollIntoView(AppPreRequisiteUtility.LocationManagementTab);
        helper.waitForElementIsInteractable(AppPreRequisiteUtility.LocationManagementTab);
        helper.forcedWaitTime(2);
         boolean checkSubtab = helper.elementIsDisplayed(subtab);
         if (!checkSubtab) {
             helper.clickByJsExecuter(AppPreRequisiteUtility.LocationManagementTab);
         }
         helper.waitForPresenceandVisiblity(subtab);
         helper.waitForElementIsInteractable(subtab);
         helper.clickByJsExecuter(subtab);
         helper.waitUntilVisibleWE(AppPreRequisiteUtility.parcelLayerTab);
         helper.waitUntilElementPresent(AppPreRequisiteUtility.parcelLayerTab);

     }
    }

    public void CCPGisDirectPinLocation() throws InterruptedException {

//        helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
//        helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
//        WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
//        String aria = zoomIn.getAttribute("aria-disabled");
//        while (aria.equalsIgnoreCase("false")) {
//            helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
//            helper.clickByJsExecuter(CCPDirect20Utility.ZoomInMapLocation);
//            helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
//            zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
//            aria = zoomIn.getAttribute("aria-disabled");
//        }
//
//        WebElement element = helper.findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
//        Point offset = element.getLocation();
//        int xoffset = offset.getX();
//        int yoffset = offset.getY();
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + xoffset + "," + yoffset + ");");
//        element.click();
////		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
////		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);

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
        }else {
            System.out.println("enter in else conidition");
            helper.waitUntilVisibleWE(CCPDirect20Utility.ZoomInMapLocation);
            helper.waitForElementIsInteractable(CCPDirect20Utility.ZoomInMapLocation);
            WebElement zoomIn = helper.findElement(CCPDirect20Utility.ZoomInMapLocation);
            String aria = zoomIn.getAttribute("aria-disabled");

            WebElement element = helper.findElement(By.xpath("(//div[@class='map-container']//div)[1]"));
            Point offset = element.getLocation();
            int xoffset = offset.getX();
            int yoffset = offset.getY();
            xoffset= -20;
            yoffset= -20;

            Actions actions =  new Actions(driver);
            Thread.sleep(3000);
            actions.moveToElement(element,xoffset,yoffset).click().perform();
            helper.waitUntilVisibleWE(GisDataAddress);
            helper.waitForElementIsInteractable(GisDataAddress);
//		helper.waitUntilVisibleWE(CCPDirect20Utility.GisDataAddress);
//		helper.waitForElementIsInteractable(CCPDirect20Utility.GisDataAddress);
        }
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

    public static String extractAddressFunction(String address){
        String[] parts = address.split(" ");

        String extracted =" ";
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
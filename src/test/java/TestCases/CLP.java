package TestCases;

import BrowsersBase.BrowsersInvoked;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import BrowsersBase.BrowsersInvoked;
import CommonMethods.CheckDownloadedFile;
import CommonMethods.Helper;
import CommonMethods.RandomStrings;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CLPUtility;
import POM.CaseAssignmentUtility;
import POM.LoginUtility;

public class CLP extends BrowsersInvoked {

	public WebDriver driver;
	CLPUtility obj;
	ExtentReportClass extentClass;
	ITestResult result;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		obj = new CLPUtility(driver);

	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

//	@Test(priority = 0)
//	public void LoginTest() throws InterruptedException {
//		obj.LoginAgency();
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

	@Test(priority = 1, description = " Verify that 'Case Listing' page opens up, when user clicks on 'Cases' tab, on Dashboard.")
	public void CLP_VerifyCLPOpensUp() throws InterruptedException {

		obj.CLP_VerifyCLPOpensUp();
	}

	@Test(priority = 2, description = "Verify that all default columns appear on CLP.")
	public void CLP_VerifyDefaultColumns() throws InterruptedException {
		obj.CLP_VerifyDefaultColumns();

	}

	@Test(priority = 3, description = "Verify that user is able to navigate to the next page, after clicking on the 'Next' arrow icon, on CLP. ")
	public void CLP_VerifyNavigationToNextPage() throws InterruptedException {

		obj.CLP_VerifyNavigationToNextPage();

	}

	@Test(priority = 4, description = " Verify that user gets navigated to the specific page, when a digit is entered in the pagination field, on CLP. ")
	public void CLP_VerifynavigationToSpecificPage() throws InterruptedException {

		obj.CLP_VerifynavigationToSpecificPage();

	}

	public ArrayList<Integer> IDArray = new ArrayList<Integer>();

	@Test(priority = 5, description = "Verify that by default cases are arranged in descending order, on CLP. ")
	public void CLP_VerifyDescendingOrderOfCases() throws InterruptedException {

		obj.CLP_VerifyDescendingOrderOfCases();
	}

	@Test(priority = 6, description = "Verify that user is able to sort the cases, after clicking on the 'Case Number' header, on CLP.")
	public void CLP_VerifyAscendingOrderOfCases() throws InterruptedException {

		obj.CLP_VerifyAscendingOrderOfCases();

	}

	@Test(priority = 7, description = " Verify that 'Delete Case' popup opens up, when user clicks on 'Delete' link text corresponding to a case, on CLP. ")
	public void CLP_OpenDeleteCasePopup() throws InterruptedException {

		obj.CLP_OpenDeleteCasePopup();

	}

	@Test(priority = 8, description = "Verify that validation message appears, when user clicks on 'Delete Case' button without entering dat in mandatory field, on 'Delete Case' popup.")
	public void CLP_ValidationMsgForDeleteCase() throws InterruptedException {

		obj.CLP_ValidationMsgForDeleteCase();

	}

	@Test(priority = 9, description = "Verify that user is able to delete a case, after entering 'DELETE' text in mandatory field, on 'Delete Case' popup.")
	public void CLP_VerifyDeletedcase() throws InterruptedException {

		obj.CLP_VerifyDeletedcase();

	}

	@Test(priority = 10, description = " Verify that case does not get deleted, when user clicks on 'Do Not Delete' button, on 'Delete Case' popup.")
	public void CLP_VerifyCasesForDoNotDeleteOption() {

		obj.CLP_VerifyCasesForDoNotDeleteOption();

	}

	@Test(priority = 11, description = "Verify that accurate total count of cases appear above cases, on CLP. ")
	public void CLP_VerifyTotalCountOfCases() throws InterruptedException {

		obj.CLP_VerifyTotalCountOfCases();

	}

	@Test(priority = 12, description = "Verify that all the Primary filters appear on the CLP.")
	public void CLP_VerifyPrimaryFilters() throws InterruptedException {

		obj.CLP_VerifyPrimaryFilters();

	}

	@Test(priority = 13, description = " Verify that user is able to apply the primary filters on the cases, on CLP. ")
	public void CLP_VerifyApplicationOfPrimaryFilters() throws InterruptedException {

		obj.CLP_VerifyApplicationOfPrimaryFilters();

	}

	@Test(priority = 14, description = "Verify that 'Clear all filters' link text appears, when user applies any filter on the cases, on CLP.")
	public void CLP_VerifyClearAllFiltersLinkText() throws InterruptedException {

		obj.CLP_VerifyClearAllFiltersLinkText();

	}

	@Test(priority = 15, description = "Verify that 'Clear all filters' link text no longer appears, when user clicks on 'Clear all filters' link text, on CLP.")
	public void CLP_VerifyClearAllFiltersLinkNotPresent() throws InterruptedException {

		obj.CLP_VerifyClearAllFiltersLinkNotPresent();

	}

	@Test(priority = 16, description = "Verify that user is able to select secondary filters, after clicking on 'Filters' slider icon, on CLP.")
	public void CLP_VerifySelectionOfSecondaryFilters() throws InterruptedException {

		obj.CLP_VerifySelectionOfSecondaryFilters();

	}

	@Test(priority = 17, description = "Verify that all selected secondary filters appear under primary filters, on CLP.")
	public void CLP_VerifyPresenceOfSecondaryFiltersUnderPrimaryFilters() throws InterruptedException {

		obj.CLP_VerifyPresenceOfSecondaryFiltersUnderPrimaryFilters();

	}

	@Test(priority = 18, description = "Verify that user is able to apply the secondary filters on cases, on CLP.")
	public void CLP_VerifyApplicationOfsecondaryFilters() throws InterruptedException {

		obj.CLP_VerifyApplicationOfsecondaryFilters();

	}

	@Test(priority = 19, description = "Verify that secondary filter gets removed, when user clicks on 'Cross' icon of filter, on CLP.")
	public void CLP_VerifyRemovalOfSecondaryFilters() throws InterruptedException {

		obj.CLP_VerifyRemovalOfSecondaryFilters();

	}

	@Test(priority = 20, description = "Verify that user is able to filter & search the cases by Case #, Location or APN, after entering data in the search field on CLP.")
	public void CLP_VerifySearchField() throws InterruptedException {

		obj.CLP_VerifySearchField();

	}

	@Test(priority = 21, description = "Verify that an information message appears, when no search results are found for the entered data, on CLP.")
	public void CLP_VerifyInfoMsgForNoSearchResults() throws InterruptedException {

		obj.CLP_VerifyInfoMsgForNoSearchResults();

	}

	@Test(priority = 22, description = "Verify that user is able to add respective columns, after selecting the checkboxes from 'Column Control' widget, on CLP. ")
	public void CLP_VerifyAdditionOfColumns() throws InterruptedException {

		obj.CLP_VerifyAdditionOfColumns();
	}

	@Test(priority = 23, description = "Verify that recently checked boxes get restored to default, when user clicks on 'Restore Defaults' link text, on CLP.")
	public void CLP_VerifyRestorationOfCheckedBoxes() throws InterruptedException {

		obj.CLP_VerifyRestorationOfCheckedBoxes();

	}

	@Test(priority = 24, description = " Verify that added columns no longer appear on CLP, when user clicks on 'Restore Defaults' link text.")
	public void CLP_VerifyAddedColumnsAfterRestoreDefaultsLink() throws InterruptedException {

		obj.CLP_VerifyAddedColumnsAfterRestoreDefaultsLink();

	}

	@Test(priority = 25, description = "Verify that 'Save As' popup opens up, when user clicks on 'Save As' button on the top of CLP.")
	public void CLP_OpenSaveAsPopup() throws InterruptedException {

		obj.CLP_OpenSaveAsPopup();

	}

	@Test(priority = 26, description = "Verify that validation message appears, when user clicks on 'Save' button without entering data in 'Filter Name' field, on 'Save As' popup.")
	public void CLP_VerifyValidationMessageForSaveBtn() throws InterruptedException {

		obj.CLP_VerifyValidationMessageForSaveBtn();

	}

	@Test(priority = 27, description = "Verify that filter gets saved under 'Default' dropdown list, when user clicks on 'Save' button, on CLP. ")
	public void CLP_VerifySavedFilter() throws InterruptedException {

		obj.CLP_VerifySavedFilter();

	}

	@Test(priority = 28, description = "Verify that user is able to delete the added filter under 'Default' dropdown list, on CLP.")
	public void CLP_VerifyDeletionOfSavedFilter() throws InterruptedException {

		obj.CLP_VerifyDeletionOfSavedFilter();

	}

	@Test(priority = 29, description = "Verify that CCP opens up, when user clicks on 'Create Case' button, on CLP. ")
	public void CLP_OpenCCPFromCreateCaseBtn() throws InterruptedException {
		obj.CLP_OpenCCPFromCreateCaseBtn();

	}

	@Test(priority = 30, description = "Verify that user is able to download the CSV file, after clicking on 'Download' button > 'CSV' option, on CLP")
	public void CLP_VerifyCSVFileDownloaded() throws InterruptedException {
		obj.CLP_VerifyCSVFileDownloaded();

	}

	@Test(priority = 31, description = " Verify that user gets directed to the respective case, after clicking on any case link, on CLP.")
	public void CLP_VerifyDirectionToCDP() throws InterruptedException {
		obj.CLP_VerifyDirectionToCDP();

	}

	@Test(priority = 32, description = "Verify that user gets directed to Case List Print Preview, after clicking on 'Print' button, on CLP.")
	public void CLP_VerifyDirectionToCLPPreview() throws InterruptedException {
		obj.CLP_VerifyDirectionToCLPPreview();

	}

	@Test(priority = 33, description = "Verify that only logged in Agency user's cases appear, when user clicks on 'Mine' button, on CLP. ")
	public void CLP_VerifyMineButtonApplication() throws InterruptedException {

		obj.CLP_VerifyMineButtonApplication();

	}

}
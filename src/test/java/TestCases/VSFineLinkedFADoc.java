package TestCases;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowsersBase.BrowsersInvoked;
import CommonMethods.CECommonMethods;
import CommonMethods.CRMCommonMethods;
import POM.AppPreRequisiteUtility;
import POM.CDP_Utility;
import POM.FinesUtility;
import POM.ForcedAbatementUtility;

public class VSFineLinkedFADoc extends BrowsersInvoked {
	
	public WebDriver driver;
	ITestResult result;
	FinesUtility fines;
	CECommonMethods ceMethod;

	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		fines = new FinesUtility(driver);
		ceMethod = new CECommonMethods(driver);
		
	}

	@AfterClass
	public void closeDriver() {
		BrowsersInvoked.tearDown(driver);
	}

	@Test(priority = 0)
	public void LoginAgency() throws InterruptedException {
		fines.LoginAgency();

	}
	
	public static String ViolationfineName;
	public static String attachedNotice;
	public static String defaultAmount;
	
	@Test(priority = 1,enabled=true, description="Verify 'Associated Notice & FA Document' is mandatory while creating violation specific fine when notice is attached")
	public void verifyAssociateNoticeAndFADocumentRequired() throws InterruptedException {
		fines.navigateToCreateFinePageFromDashboard();
		fines.selectViolationSpecifcToggelButton();
		ViolationfineName = fines.setandReturnValueInLabelField("ViolationSpecific");
		fines.setValueInDefaultAmountField();
		defaultAmount = fines.returnDefaultAmount();
		fines.clickCreateFineButtonOnCreateFinePage();
		String actualValidationText = fines.getValidationText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualValidationText, "The Notice is required.","Validation Message is not Appear");
		softAssert.assertAll();
		

	}
	
	
	@Test(priority = 2,enabled=true, description="Verify user is able to create violation specific fine with FA doc attached when 'Do not associate a notice' checkbox is unchecked.")
	public void verifyCreateViolationSpecficfineFADocument() throws InterruptedException {
		fines.SelectNoticeAndFAdocument("FA");
		fines.SelectViolationSpecification("Water");
		fines.clickCreateFineButtonOnCreateFinePage();
		String actualCreatedFine = fines.getCreatedFineText();
		attachedNotice = fines.getAssociatedNoticeWithFine();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ViolationfineName, actualCreatedFine,"Fine is not Created or assertion failed.");
		softAssert.assertAll();
		

	}
	
	
	@Test(priority = 3, description="Verify that violation specific fine with FA document attached appears on selecting a notice on 'Select Notice Type & Associated Fines' section,  when user generate FAA  document on CDP")
	public void verifyAssocitedFineFADocumentAppearOnFAA() throws InterruptedException {
		// Create Prerequisite Case 
		ceMethod.createCaseCCP();
		
		// Initiate forceAbatement on Case
		ceMethod.initiateForceAbatement();
		
		// Add Activity 		
		ceMethod.clickOnAddActivityBtn();
		
		//Enter FAA details 
		ceMethod.enterFAADetails();
		
		// Assert FA document with violation specific fine is appeared
		
		// click on FAA doc select drop down 
		
		//check if FA doc is displayed in first 3 notices else click on dropdown
		
		Boolean flag=(driver.findElements(By.xpath("//*[text()='" + attachedNotice + "']")).size())>0;
		Boolean FAADocument;
		if(flag=true)
		{
			fines.selectFAADocumentOnAbatementDetailsSection(attachedNotice);
			FAADocument=true;
		}
		else
		{
		ceMethod.clickOnSelectFADocDropdown();
		ceMethod.searchFADocument(attachedNotice);
		FAADocument = ceMethod.FAdocumentIsDisplayed();
		}
		 
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(FAADocument,"FAA docuemnt is not present.");
		softAssert.assertAll();
		
		
	}
	
	
	

	@Test(priority = 4, description="Verify violation specific fine  name is correctly displayed  on selecting a notice on 'Select Notice Type & Associated Fines' section,  when user generate FAA  document on CDP")
	public void verifyAssocitedFineAppearWithFADocOnFAA() throws InterruptedException {
		
		
		// select FAA document 
		
		ceMethod.clickOnSearchedFADoc();
		Thread.sleep(2000);
		// assert associated fine name 
		String associated_FineName = ceMethod.associatedFineNameWithFAdoc();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(associated_FineName,ViolationfineName,"Associated FineName is not present.");
		softAssert.assertAll();
		
		
	}
	
	
	@Test(priority = 5, description="Verify appropriate violation specific fine amount is displayed  on selecting a notice on selecting a notice on 'Select Notice Type & Associated Fines' section,  when user generate FAA  document on CDP")
	public void verifyAssocitedFineAmountAppearWithFADocOnFAA() throws InterruptedException {
		
		// assert associated fine amount 
		String associated_FineAmount = ceMethod.associatedFineAmountWithFAdoc();

		double number = Double.parseDouble(associated_FineAmount);

		// Convert the double to an integer to remove the decimal part
		int result = (int) number;
		String associated_FineAmount2 = Integer.toString(result);

		System.out.println("associated_FineAmount : "+associated_FineAmount2);
		System.out.println("defaultAmount : "+defaultAmount);

		
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(associated_FineAmount,defaultAmount.split("[.]")[0],"Associated Fine Amount is not Equal.");
		softAssert.assertAll();
		
		
	}
	
	@Test(priority = 6, description="Verify violation specific fine with notice attached amount gets added on case under the 'Outstanding Balance' section, when user generate FAA document on CDP")
	public void verifyAmountAddOnOutstandingBalance() throws InterruptedException {
		
		// Generate a document 
		ceMethod.clickOnGenerateDocumentBtn();
		ceMethod.clickonDonotPrintBtn();
		ceMethod.clickonGenerateFAAdocuemtn();
        CDP_Utility cdp_Utility = new CDP_Utility(driver);
        String outStandingBal = (cdp_Utility.getOutstandingBalance()).split("\\$")[1];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(outStandingBal,defaultAmount,outStandingBal+"Associated Fine Amount  is not Equal." + defaultAmount);
		softAssert.assertAll();
		
		
	}
	
	@Test(priority = 7, description="Verify that applied violation specific fines with notice attached on case appears on the  'All' 'Fines' view of 'Finanace' page.")
	public void verifyFineonFinanacePage() throws InterruptedException {
		
		// Close Case Details Page
		ceMethod.closeCaseDetailPage();
		ceMethod.navigationToFinancePage();
		String alltransactionFine = ceMethod.getFineTransactionGridData();
		
		ceMethod.clickOnFineToggelBtn();
		String finetransactionFine = ceMethod.getFineTransactionGridData();
       
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(alltransactionFine.contains(ViolationfineName));
		softAssert.assertTrue(finetransactionFine.contains(ViolationfineName));
		softAssert.assertAll();
		
		
	}
	
	@Test(priority = 8, description="Violation Fines Clean Up")
	public void cleanUp() throws InterruptedException {
		
		CRMCommonMethods crm = new CRMCommonMethods(driver);
		// Navigate to Fine Page
		crm.navigateToAgencySetup();
		crm.navigateToFines();
		fines.getCreatedFineText();
		fines.editFineChangeVioToFlat(ViolationfineName);
		
		
		
		
		
	}

}

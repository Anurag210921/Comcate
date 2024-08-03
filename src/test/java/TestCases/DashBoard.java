package TestCases;
import BrowsersBase.BrowsersInvoked;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ExtentReport.ExtentReportClass;
import POM.DashBoardUtility;
import POM.LoginUtility;

public class DashBoard extends BrowsersInvoked{
	
	public WebDriver driver;
	DashBoardUtility obj ;
	ExtentReportClass extentClass;
	ITestResult result;
	
	@BeforeClass
	public void setUp() {
		driver = BrowsersInvoked.Setup();
		obj = new DashBoardUtility(driver);
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
	
	
	
	  @Test(priority = 1, description = "Verify that Admin User is able to view the 'All Staff' Dashboard, on 'Dashboard' page.")
	 public  void TC_Dashboard_ViewAllStaffDashboard() throws InterruptedException {
	        
		  obj.TC_Dashboard_ViewAllStaffDashboard();
	      

	    }

	  @Test(priority = 2,description = " Verify that Admin User is able to view the 'User' Dashboard, on 'Dashboard' page. ")
	    public  void TC_Dashboard_ViewMeDashboard() throws InterruptedException {
	        
	       obj.TC_Dashboard_ViewMeDashboard();

	    }

	   
	  @Test(priority = 3, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Open cases assigned to me' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_OpenCasesAssignedToMeLink() throws  InterruptedException{
	       
	       obj.TC_Dashboard_OpenCasesAssignedToMeLink();
	    }

	    @Test(priority = 4, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Open cases for my agency' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_OpenCasesForMyAgencyLink() {
	        
	        obj.TC_Dashboard_OpenCasesForMyAgencyLink();
	    }

	   
	    @Test(priority = 5, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Overdue Inspections' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_OverdueInspectionsLink() {
	       obj.TC_Dashboard_OverdueInspectionsLink();
	       
	    }

	  
	    @Test(priority = 6, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Inspections Due Today' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_InspectionsDueTodayLink() {
	      obj.TC_Dashboard_InspectionsDueTodayLink();
	       
	    }

	   
	    @Test(priority = 7, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Total Inspections' link, when 'Me' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_TotalInspectionsLink() {
	      obj.TC_Dashboard_TotalInspectionsLink();
	   
	    }

	   
	    @Test(priority = 8, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Open cases for my agency' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_AllStaff_OpenCasesForMyAgency() throws InterruptedException {
	        obj.TC_Dashboard_AllStaff_OpenCasesForMyAgency();
	    }

	    
	    @Test(priority = 9,description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Overdue Inspections' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_TotalcasesForMyAgencyLink() {
	       
	      obj.TC_Dashboard_TotalcasesForMyAgencyLink();
	    }

	   
	    @Test(priority = 10, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Inspections Due Today' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_AllStaff_OverdueInspections() {
	        
	        obj.TC_Dashboard_AllStaff_OverdueInspections();
	    }

	    @Test(priority = 11, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Total Inspections' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public void TC_Dashboard_AllStaff_InspectionsDueToday() {
	       obj.TC_Dashboard_AllStaff_InspectionsDueToday();
	        
	    }

	   
	    @Test(priority = 12, description = " Verify that Admin User gets directed to the 'Cases' page on clicking the 'Total Inspections' link, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_AllStaff_TotalInspectionsLink() {
	       
	       obj.TC_Dashboard_AllStaff_TotalInspectionsLink();
	    }

	  
	    @Test(priority = 13, description = " Verify that '<Count> Total Inspections' popup opens up after clicking on the 'Show More' link under '<Count> Total Inspections' section, when 'All Staff' option is selected from the 'Staff' dropdown, on 'Dashboard' page. ")
	    public  void TC_Dashboard_OpenTotalInspectionPopup() {
	       
	        obj.TC_Dashboard_OpenTotalInspectionPopup();
	      
	    }

	   
	    @Test(priority = 14, description = " Verify that accurate count of cases appear on 'Dashboard' page with respect to CLP. ")
	    public  void TC_Dashboard_CompareCountOfCasesWithCLP() throws InterruptedException {
	        
	       obj.TC_Dashboard_CompareCountOfCasesWithCLP();
	    }

	   
	    @Test(priority = 15, description = " Verify that 'Print Queue' popup opens up, when user clicks on '<count> notices in your print queue' link, on 'Dashboard' page. ")
	    public void TC_Dashboard_OpenPrintQueuePopup() throws InterruptedException {
	       
	    	obj.TC_Dashboard_OpenPrintQueuePopup();
	        
	      

	    }
	
	
	
}

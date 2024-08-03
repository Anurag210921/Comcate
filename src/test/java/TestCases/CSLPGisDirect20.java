package TestCases;

import BrowsersBase.BrowsersInvoked;
import ExtentReport.ExtentReportClass;
import POM.CCPUtility;
import POM.CSDPGISDirect20Utility;
import POM.CSPInternalUtility;
import POM.CategoryPage;
import POM.CSLPGisDirect20Utility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CSLPGisDirect20 extends BrowsersInvoked {

    public static SoftAssert softAssert = new SoftAssert();
    public WebDriver driver;
    public  CSLPGisDirect20 CSLPGisDirect20;
    ITestResult result;
    CCPUtility ccp;
    CategoryPage category;
    CSPInternalUtility CSPInternalUtils;
    CSLPGisDirect20Utility CSLPGisDirect20Utility;

    @BeforeClass
    public void setUp() {
        driver = BrowsersInvoked.Setup();
        CSPInternalUtils=new CSPInternalUtility(driver);
        CSLPGisDirect20Utility= new CSLPGisDirect20Utility(driver);
    }

    @AfterClass
    public void closeDriver() {
        BrowsersInvoked.tearDown(driver);
    }
    @Test(priority = -1)
    public void LoginAgency() throws InterruptedException {
        CSLPGisDirect20Utility.LoginAgency();

    }



    @Test(priority = 0,description = "Verify that invalid icon appear before the GIS invalid address on CSLP")
        public void CSLP_VerifyAppropriateIconAppearwithInvalidGisAddress() throws InterruptedException{
            CSLPGisDirect20Utility.CSLP_VerifyAppropriateIconAppearwithInvalidGisAddress();

        }

        @Test(priority = 1,description = "Verify that Valid icon appear before the GIS Valid address on CSLP.")
        public void CSLP_VerifyAppropriateIconAppearwithValidGisAddress() throws InterruptedException{
            CSLPGisDirect20Utility.CSLP_VerifyAppropriateIconAppearwithValidGisAddress();
       }
    }


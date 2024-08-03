package BrowsersBase;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import CommonMethods.PropertiesUtils;
import Constant.CRMConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowsersInvoked {

	// public static ExtentReports extent;
	// public static ExtentTest extentTest;
	public static String browser = "CHROME";
	public static String RunEnvironment = "STAGE";
	public static String AgencyName = PropertiesUtils.getPropertyValue("AgencyName");
	public static String agencyConfig = PropertiesUtils.getPropertyValue("agencyConfig");
	public static String agencyConfigEnterprise = PropertiesUtils.getPropertyValue("agencyConfigEnterprise");
	public static String agencyConfigGisDirect1o = PropertiesUtils.getPropertyValue("agencyConfigGisDirect1o");
	public static String agencyConfigGisDirect2o = PropertiesUtils.getPropertyValue("agencyConfigGisDirect2o");
	public static String agencyConfigGisLite = PropertiesUtils.getPropertyValue("agencyConfigGisLite");
	public static String agencyConfigEnterpriseHosted20 = PropertiesUtils
			.getPropertyValue("agencyConfigEnterpriseHosted20");

	public static String basicSupervisorUserNameStage = PropertiesUtils.getPropertyValue("basicSupervisorStage");
	public static String nonSupervisorUserNameStage = PropertiesUtils.getPropertyValue("nonSupervisorStage");
	public static String supervisorManagerUserNameStage = PropertiesUtils.getPropertyValue("supervisorManagerStage");

	public static String basicSupervisorUserNameQA = PropertiesUtils.getPropertyValue("basicSupervisorQA");
	public static String nonSupervisorUserNameQA = PropertiesUtils.getPropertyValue("nonSupervisorQA");
	public static String supervisorManagerUserNameQA = PropertiesUtils.getPropertyValue("supervisorManagerQA");

	public static String basicSupervisorUserNameProd = PropertiesUtils.getPropertyValue("BasicSupervisorProd");
	public static String nonSupervisorUserNameProd = PropertiesUtils.getPropertyValue("nonSupervisorProd");
	public static String supervisorManagerUserNameProd = PropertiesUtils.getPropertyValue("supervisorManagerProd");

	// adding user for Stage Gis2.0
	public static String basicSupervisorUserNameStageGis20 = PropertiesUtils
			.getPropertyValue("basicSupervisorStageGis20");
	public static String nonSupervisorUserNameStageGis20 = PropertiesUtils.getPropertyValue("nonSupervisorStageGis20");
	public static String supervisorManagerUserNameStageGis20 = PropertiesUtils
			.getPropertyValue("supervisorManagerStageGis20");

	// adding user for Prod Gis2.0
	public static String basicSupervisorUserNameProdGis20 = PropertiesUtils
			.getPropertyValue("basicSupervisorUserNameProdGis20");
	public static String nonSupervisorUserNameProdGis20 = PropertiesUtils
			.getPropertyValue("nonSupervisorUserNameProdGis20");
	public static String supervisorManagerUserNameProdGis20 = PropertiesUtils
			.getPropertyValue("supervisorManagerUserNameProdGis20");

	// adding user for QA direct Gis2.0
	public static String basicSupervisorUserNameQAGis20 = PropertiesUtils
			.getPropertyValue("basicSupervisorUserNameQAGis20");
	public static String nonSupervisorUserNameQAGis20 = PropertiesUtils
			.getPropertyValue("nonSupervisorUserNameQAGis20");
	public static String supervisorManagerUserNameQAGis20 = PropertiesUtils
			.getPropertyValue("supervisorManagerUserNameQAGis20");

	// CI Direct 20
	public static String basicSupervisorCI_Direct20 = PropertiesUtils.getPropertyValue("basicSupervisorCI_Direct20");
	public static String supervisorManagerCI_Direct20 = PropertiesUtils
			.getPropertyValue("supervisorManagerCI_Direct20");
	public static String noSupervisorCI_Direct20 = PropertiesUtils.getPropertyValue("noSupervisorCI_Direct20");

	// Hosted 10
	public static String BasicSuperviserCI_hosted10 = PropertiesUtils.getPropertyValue("BasicSuperviserCI_hosted10");
	public static String nonsupervisorCI_hosted10 = PropertiesUtils.getPropertyValue("nonsupervisorCI_hosted10");
	public static String SupervisorManagerCI_hosted10 = PropertiesUtils
			.getPropertyValue("SupervisorManagerCI_hosted10");

	// Hosted Direct20 Prod
	public static String basicSupervisorHosted20_prod = PropertiesUtils
			.getPropertyValue("basicSupervisorHosted20_prod");
	public static String nonsupervisorHosted20_prod = PropertiesUtils.getPropertyValue("nonsupervisorHosted20_prod");
	public static String supervisorMangerHosted20_prod = PropertiesUtils
			.getPropertyValue("supervisorMangerHosted20_prod");

	// Hosted 20 Stage
	public static String basicSupervisorHosted20_stage = PropertiesUtils
			.getPropertyValue("basicSupervisorHosted20_stage");
	public static String nonsupervisorHosted20_stage = PropertiesUtils.getPropertyValue("nonsupervisorHosted20_stage");
	public static String supervisorMangerHosted20_stage = PropertiesUtils
			.getPropertyValue("supervisorMangerHosted20_stage");

	// adding user for Hosted 2.0 QA
	public static String basicSupervisorHosted20_QA = PropertiesUtils.getPropertyValue("basicSupervisorHosted20_QA");
	public static String nonSupervisorUserNameHost20_QA = PropertiesUtils.getPropertyValue("nonsupervisorHosted20_QA");
	public static String supervisorManagerUserNameHost20_QA = PropertiesUtils
			.getPropertyValue("supervisorMangerHosted20_QA");

	// Hosted Direct 20 CI
	public static String basicSupervisorHosted20_CI = PropertiesUtils.getPropertyValue("basicSupervisorHosted20_CI");
	public static String nonsupervisorHosted20_CI = PropertiesUtils.getPropertyValue("nonsupervisorHosted20_CI");
	public static String supervisorMangerHosted20_CI = PropertiesUtils.getPropertyValue("supervisorMangerHosted20_CI");

	public static int AgencyID;
	public static String agencyName;
	public static String Instance;
	public static String AgencyUsername;
	public static String AgencyPassword;
	public static String AdminURL;
	public static String AdminUsername;
	public static String AdminPassword;

	public static String StreetAddress;
	public static String City;
	public static String Zip;
	public static String mailReset;

	public static String CCPStreetAddress1;
	public static String CCPStreetAddress2;
	public static String CCPCity1;
	public static String CCPZip1;
	public static String CCPmailReset1;

	public static String AgencyURL;

	public static String URLCreateCase;
	public static String URLCases;
	public static String URLDashboard;
	public static String URLCasesManagement;
	public static String URLAssignmentRules;
	public static String URLUserManagement;
	public static String URLNotices;
	public static String URLCreateCustomerSubmission;
	public static String URLCategories;
	public static String URLSubmissionSettings;
	public static String URLViolations;
	public static String URLReports;
	public static String AgencyCRMUsername;
	public static String AgencyCEUsername;
	public static String AgencyCE2Username;

	public static WebDriver Setup() {
		RunEnvironmentSetup();
		  // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
		
		
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("disable-blink-features=AutomationControlled");
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//	//	options.addArguments("--headless");
//		options.addArguments("--window-size=1552x832");
//		options.addArguments("disable-blink-features=AutomationControlled");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// getting size of window//
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();

		// Print window size
		System.out.println("Window size is: " + width + " x " + height);
		return driver;

	}

	public static void RunEnvironmentSetup() {
		switch (RunEnvironment.toUpperCase()) {
		case "QA": {

			// GIS Direct 2.0 Configuration on QA

			if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {

				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyID_QAGisDirect2O"));
				Instance = PropertiesUtils.getPropertyValue("NewInstanceQA");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsername_QAGisDirect2O");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPassword_QAGisDirect2O");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				City = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				Zip = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				mailReset = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				CCPCity1 = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				CCPZip1 = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");

			}

			// GIS Direct 1.0 Configuration on QA

			else if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect1o)) {

				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyID_QAGisDirect1O"));
				Instance = PropertiesUtils.getPropertyValue("InstanceQA");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsername_QaGisDirect1O");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPassword_QAGisDirect1O");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				City = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				Zip = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				mailReset = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddressQAGISDirect1O");
				CCPCity1 = PropertiesUtils.getPropertyValue("CityQAGISDirect1O");
				CCPZip1 = PropertiesUtils.getPropertyValue("ZipQAGISDirect1O");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetQAGISDirect1O");
			}

			// GIS Lite Configuration on QA

			else if (agencyConfig.equalsIgnoreCase(agencyConfigGisLite)) {

				AgencyID = 000;
				Instance = "";
				AgencyUsername = "";
				AgencyPassword = "";
				StreetAddress = "";
				City = "";
				Zip = "";
				mailReset = "";
			}

			// Hosted 2.0 Configuration on QA

			else if (agencyConfig.equalsIgnoreCase(agencyConfigEnterpriseHosted20)) {

				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIdHosted20_QA"));
				Instance = PropertiesUtils.getPropertyValue("NewInstanceQA");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameHosted20_QA");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordQA");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressHosted20_QA");
				City = PropertiesUtils.getPropertyValue("CityHosted20_QA");
				Zip = PropertiesUtils.getPropertyValue("ZipHosted20_QA");
				mailReset = PropertiesUtils.getPropertyValue("mailResetHosted20_QA");
				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddressHosted20_QA");
				CCPCity1 = PropertiesUtils.getPropertyValue("CityHosted20_QA");
				CCPZip1 = PropertiesUtils.getPropertyValue("ZipHosted20_QA");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetHosted20_QA");
			}

			// Hosted 1.0 Configuration on QA

			else {
				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIDQA"));
				Instance = PropertiesUtils.getPropertyValue("NewInstanceQA");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameQA");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordQA");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise");
				City = PropertiesUtils.getPropertyValue("CityQAEnterPrise");
				Zip = PropertiesUtils.getPropertyValue("ZipQAEnterPrise");
				mailReset = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("CCPStreetAddress1");
				CCPCity1 = PropertiesUtils.getPropertyValue("CCPCity1");
				CCPZip1 = PropertiesUtils.getPropertyValue("CCPZip1");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");

			}
			AdminURL = PropertiesUtils.getPropertyValue("NewAdminQA");
			AdminUsername = PropertiesUtils.getPropertyValue("AdminUsername");
			AdminPassword = PropertiesUtils.getPropertyValue("AdminPassword");
			break;
		}
		case "CI": {

			// GIS Direct 2.0 Configuration on CI

			if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIdCIDirect20"));
				System.out.println("20 direct CI :" + AgencyID);
				Instance = PropertiesUtils.getPropertyValue("InstanceCI");
				AdminURL = PropertiesUtils.getPropertyValue("AdminURLCI");
				AdminUsername = PropertiesUtils.getPropertyValue("AdminUsernameCI");
				AdminPassword = PropertiesUtils.getPropertyValue("AdminPasswordCI");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameDirect20_CI");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordDirect20_CI");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				City = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				Zip = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				mailReset = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				CCPCity1 = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				CCPZip1 = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");
				CCPStreetAddress2 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect_1O");

			}

			// Hosted 1.0 Configuration on CI

			else if (agencyConfig.equalsIgnoreCase(agencyConfigEnterpriseHosted20)) {

				System.out.println("Enter in 20 asdfgfhjfds");
				// System.out.println(AgencyID);
				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIdHosted20_CI"));
				System.out.println("20 direct CI :" + AgencyID);
				Instance = PropertiesUtils.getPropertyValue("InstanceCI");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameHosted20_CI");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordCIHosted20");
				AdminURL = PropertiesUtils.getPropertyValue("AdminURLCI");
				AdminUsername = PropertiesUtils.getPropertyValue("AdminUsernameCI");
				AdminPassword = PropertiesUtils.getPropertyValue("AdminPasswordCI");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise");
				City = PropertiesUtils.getPropertyValue("CityQAEnterPrise");
				Zip = PropertiesUtils.getPropertyValue("ZipQAEnterPrise");
				mailReset = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("CCPStreetAddress1");
				CCPCity1 = PropertiesUtils.getPropertyValue("CCPCity1");
				CCPZip1 = PropertiesUtils.getPropertyValue("CCPZip1");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");
				break;

			} else {

				System.out.println("Enter in Enterprise");
				System.out.println(AgencyID);
				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIDCI"));
				Instance = PropertiesUtils.getPropertyValue("InstanceCI");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameCI");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordCI");

				AdminURL = PropertiesUtils.getPropertyValue("AdminURLCI");
				AdminUsername = PropertiesUtils.getPropertyValue("AdminUsernameCI");
				AdminPassword = PropertiesUtils.getPropertyValue("AdminPasswordCI");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise");
				City = PropertiesUtils.getPropertyValue("CityQAEnterPrise");
				Zip = PropertiesUtils.getPropertyValue("ZipQAEnterPrise");
				mailReset = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("CCPStreetAddress1");
				CCPCity1 = PropertiesUtils.getPropertyValue("CCPCity1");
				CCPZip1 = PropertiesUtils.getPropertyValue("CCPZip1");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");

				break;
			}
			break;
		}

		case "STAGE": {

			// GIS Direct 2.0 Configuration on Stage

			if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {

				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyID_StageGisDirect2O"));
				Instance = PropertiesUtils.getPropertyValue("InstanceStage");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsername_StageGisDirect2O");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPassword_StageGisDirect2O");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				City = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				Zip = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				mailReset = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				CCPCity1 = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				CCPZip1 = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");
				CCPStreetAddress2 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect_1O");

			}

			// GIS Direct 1.0 Configuration on stage

			else if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect1o)) {

				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyID_StageGisDirect1O"));
				Instance = PropertiesUtils.getPropertyValue("InstanceStage");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsername_StageGisDirect1O");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPassword_StageGisDirect1O");
				AgencyCRMUsername = PropertiesUtils.getPropertyValue("AgencyCRMUsername");
				AgencyCEUsername = PropertiesUtils.getPropertyValue("AgencyCEUsername");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				City = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				Zip = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				mailReset = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				CCPCity1 = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				CCPZip1 = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");

			} else if (agencyConfig.equalsIgnoreCase(agencyConfigEnterpriseHosted20)) {

				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIdHosted20_stage"));
				Instance = PropertiesUtils.getPropertyValue("InstanceStage");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameHosted20_stage");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordStage");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressHosted20_prod");
				City = PropertiesUtils.getPropertyValue("CityHosted20_prod");
				Zip = PropertiesUtils.getPropertyValue("ZipHosted20_prod");
				mailReset = PropertiesUtils.getPropertyValue("mailResetHosted20_prod");
				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddressHosted20_prod");
				CCPCity1 = PropertiesUtils.getPropertyValue("CityHosted20_prod");
				CCPZip1 = PropertiesUtils.getPropertyValue("ZipHosted20_prod");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetHosted20_prod");
			}

			// GIS Lite Configuration on stage

			else if (agencyConfig.equalsIgnoreCase(agencyConfigGisLite)) {

				AgencyID = 00;
				Instance = PropertiesUtils.getPropertyValue("InstanceStage");
				AgencyUsername = "";
				AgencyPassword = "";

			}

			// Hosted 1.0 Configuration on stage

			else {
				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIDStage"));
				Instance = PropertiesUtils.getPropertyValue("InstanceStage");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameStage");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordStage");
				// AgencyCRMUsername = PropertiesUtils.getPropertyValue("AgencyCRMUsername");
				// AgencyCEUsername = PropertiesUtils.getPropertyValue("AgencyCEUsername");
				// AgencyCE2Username = PropertiesUtils.getPropertyValue("AgencyCE2Username");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise");
				City = PropertiesUtils.getPropertyValue("CityQAEnterPrise");
				Zip = PropertiesUtils.getPropertyValue("ZipQAEnterPrise");
				mailReset = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");

				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise");
				CCPCity1 = PropertiesUtils.getPropertyValue("CityQAEnterPrise");
				CCPZip1 = PropertiesUtils.getPropertyValue("ZipQAEnterPrise");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");

			}

			AdminURL = PropertiesUtils.getPropertyValue("AdminURLStage");
			AdminUsername = PropertiesUtils.getPropertyValue("AdminUsernameStage");
			AdminPassword = PropertiesUtils.getPropertyValue("AdminPasswordStage");
			System.out.println(AdminURL);
			break;

		}

		case "PRODUCTION": {

			// GIS Direct 2.0 Configuration on Production

			if (agencyConfig.equalsIgnoreCase(agencyConfigGisDirect2o)) {
				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyID_ProdGisDirect2O"));
				Instance = PropertiesUtils.getPropertyValue("InstanceProd");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsername_ProdGisDirect2O");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordProd");
				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				City = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				Zip = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				mailReset = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");
				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect1O");
				CCPCity1 = PropertiesUtils.getPropertyValue("City_QAGISDirect1O");
				CCPZip1 = PropertiesUtils.getPropertyValue("Zip_QAGISDirect1O");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailReset_QAGISDirect1O");
				CCPStreetAddress2 = PropertiesUtils.getPropertyValue("StreetAddress_QAGISDirect_1O");
			}

			// GIS Hosted 2.0 Configuration on Production

			else if (agencyConfig.equalsIgnoreCase(agencyConfigEnterpriseHosted20)) {

				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIdHosted20_prod"));
				Instance = PropertiesUtils.getPropertyValue("InstanceProd");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameHosted20_prod");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordProd");

				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressHosted20_prod");
				City = PropertiesUtils.getPropertyValue("CityHosted20_prod");
				Zip = PropertiesUtils.getPropertyValue("ZipHosted20_prod");
				mailReset = PropertiesUtils.getPropertyValue("mailResetHosted20_prod");
				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddressHosted20_prod");
				CCPCity1 = PropertiesUtils.getPropertyValue("CityHosted20_prod");
				CCPZip1 = PropertiesUtils.getPropertyValue("ZipHosted20_prod");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetHosted20_prod");
			}

			// Hosted 1.0 Configuration on Production

			else {
				AgencyID = Integer.parseInt(PropertiesUtils.getPropertyValue("AgencyIDProd"));
				Instance = PropertiesUtils.getPropertyValue("InstanceProd");
				AgencyUsername = PropertiesUtils.getPropertyValue("AgencyUsernameProd");
				AgencyPassword = PropertiesUtils.getPropertyValue("AgencyPasswordProd");
				AdminURL = PropertiesUtils.getPropertyValue("AdminURLProd");
				AdminUsername = PropertiesUtils.getPropertyValue("AdminUsernameProd");
				AdminPassword = PropertiesUtils.getPropertyValue("AdminPasswordProd");
				StreetAddress = PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise");
				City = PropertiesUtils.getPropertyValue("CityQAEnterPrise");
				Zip = PropertiesUtils.getPropertyValue("ZipQAEnterPrise");
				mailReset = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");
				CCPStreetAddress1 = PropertiesUtils.getPropertyValue("StreetAddressQAEnterPrise");
				CCPCity1 = PropertiesUtils.getPropertyValue("CityQAEnterPrise");
				CCPZip1 = PropertiesUtils.getPropertyValue("ZipQAEnterPrise");
				CCPmailReset1 = PropertiesUtils.getPropertyValue("mailResetQAEnterPrise");
				break;
			}
			AdminURL = PropertiesUtils.getPropertyValue("AdminURLProd");
			AdminUsername = PropertiesUtils.getPropertyValue("AdminUsernameProd");
			AdminPassword = PropertiesUtils.getPropertyValue("AdminPasswordProd");
		}
		}

		System.out.println(AgencyID);
		AgencyURL = Instance + (AgencyID) + "/login";
		System.out.println(AgencyURL);

		URLCreateCase = Instance + (AgencyID) + "/products/cases/create";
		URLCases = Instance + (AgencyID) + "/products/cases";
		URLDashboard = Instance + (AgencyID) + "/dashboard";
		URLCasesManagement = Instance + (AgencyID) + "/setup/products/case-management";
		URLAssignmentRules = Instance + (AgencyID) + "/setup/agency/assignment-rules";
		// System.out.println(URLAssignmentRules);
		URLUserManagement = Instance + (AgencyID) + "/setup/agency/users-management";
		URLNotices = Instance + (AgencyID) + "/setup/agency/products/notices";
		URLCreateCustomerSubmission = Instance + (AgencyID) + "/products/customer-submission/create";
		URLCategories = Instance + (AgencyID) + "/setup/products/categories";
		URLSubmissionSettings = Instance + (AgencyID) + "/setup/products/submission-settings";
		URLViolations = Instance + (AgencyID) + "/setup/products/violations";
		URLReports = Instance + (AgencyID) + "/reports";
	}

	public static void tearDown(WebDriver driver) {
		driver.quit();
	}

	@BeforeSuite(alwaysRun = true)
	public void deleteExistingReport() {
		String filePath = System.getProperty("user.dir") + "/test-output/ExtentReportResult.html";
		File fileToDelete = new File(filePath);
		if (fileToDelete.exists()) {
			if (fileToDelete.delete()) {
				System.out.println("File deleted successfully.");
			} else {
				System.err.println("Failed to delete the file.");
			}
		} else {
			System.out.println("File does not exist.");
		}

		// Delete screenshots
		String screenshotDirectory = System.getProperty("user.dir") + "/ExtentReports/";

		// Call method to delete screenshots
		deleteScreenshots(screenshotDirectory);
		String os = System.getProperty("os.name");
		System.out.println("Operating System: " + os);

	}

	private void deleteScreenshots(String directoryPath) {
		File directory = new File(directoryPath);

		// Check if the directory exists
		if (directory.exists()) {
			// Get a list of all files in the directory
			File[] files = directory.listFiles();

			if (files != null) {
				// Delete each file in the directory
				for (File file : files) {
					if (file.isFile()) {
						file.delete();
					}
				}
			}
		}
	}

	public static String activeGroup;
	public static String suiteName;

	@BeforeSuite(alwaysRun = true)
	public void beforesuite(ITestContext context) {
		// Retrieve the groups this method belongs to
		activeGroup = String.join(", ", context.getCurrentXmlTest().getIncludedGroups());
		System.out.println(context.getSuite().getName());
		suiteName = context.getSuite().getName();
	}

}

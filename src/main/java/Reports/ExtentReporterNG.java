package Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.propertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReporterNG {
	WebDriver driver;
	static ExtentReports extent;
	
	
	
	public static ExtentReports getExtentReport_Object()
	{
		String path= System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Ecommerce Automation");
		reporter.config().setDocumentTitle("Test Results");
		//reporter.getTemplateModel();
		
		
		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Anurag");
		return extent;
		
	}
	
	

}

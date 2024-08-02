package testComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LandingPage;
import Utilities.ActionEngine;
import Utilities.propertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

	public WebDriver driver; 
	public HomePage hp;
	//public static String URL;

	public WebDriver driverSetup() {

		String browser = System.getProperty("browser") != null ? System.getProperty("browser"): propertiesUtil.getValue("browser");
		// browser= propertiesUtil.getValue("browser");
		String URL = propertiesUtil.getValue("url");

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();;
			driver = new ChromeDriver();
			break;

		case "chromeheadless":
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
				options.addArguments("headless");
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;

	}

	@BeforeClass
	public HomePage login() {
		driver = driverSetup();
		driver.findElement(By.xpath("(//li/a)[1]")).click();
		driver.findElement(By.id("email")).sendKeys(propertiesUtil.getValue("email"));
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys(propertiesUtil.getValue("password"));
		driver.findElement(By.xpath("//button[@class='action login primary']")).click();
		hp = new HomePage(driver);
		return hp;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}

}

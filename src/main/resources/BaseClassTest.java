package resources;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClassTest implements Constants {
	public static Logger log=Logger.getLogger("BaseClassTest");
	public static ExtentReports report;
	@BeforeSuite
	public void createReport()
	{
		report = new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(REPORT_PATH);
		report.attachReporter(htmlReport);
	}

	@AfterSuite
	public void flush()
	{
		report.flush();
	}
	
	static
	{
		log.info("Setting the properties of the browsers");
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser)
	{
		log.info("Opening the browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.orbitz.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod
	public void closeApplication(ITestResult result) {
		log.info("Closing the browser");
		driver.quit();
		String testName = result.getName();
		ExtentTest test = report.createTest(testName);
		if(result.getStatus()==1)
		{
			test.pass("Test Pass");
			
		}
		else {
			test.fail("Test Fail");
		}
	}

}

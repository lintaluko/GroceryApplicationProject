package automationcore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver; // predefined interface

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
			public void browserLaunch(String browser) throws Exception {
			if(browser.equalsIgnoreCase("Chrome")) { //no case sensitivity
				driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("FireFox")) {
		driver= new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("EdgeDriver")) {
		driver=new EdgeDriver();
	}else
	{
		throw new Exception("invalid browser");
	}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait

			}

	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) { // pre-defined interface
			// manages test result lifecycle. (passed/failed/skipped)
			// only captures only when the test is failed

			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		// driver.quit();

	}
}

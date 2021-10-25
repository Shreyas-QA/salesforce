package salesforce_Tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.collections.Lists;

import Utilities.Appconfig;
import Utilities.EmailResult;

public class BaseTest {

	public static WebDriver driver;
	public Appconfig appconfobj;

	@Parameters({ "browser" }) // chrome
	@BeforeSuite
	public void initialize(String browserName) throws Exception {

		appconfobj = new Appconfig();
		appconfobj.readConfigSetting();

		// Check if parameter passed from TestNG is 'firefox'
		if (browserName.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", "D:\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browserName.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.setHeadless(Appconfig.isHeadless());
			System.out.println(Appconfig.isHeadless());
			System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver(options);
			Dimension d = new Dimension(1920, 1080);
			// Resize the current window to the given dimension
			driver.manage().window().setSize(d);
		}
		// Check if parameter passed as 'Edge'
		else if (browserName.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
			// create Edge instance
			driver = new EdgeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.salesforce.com/in/");

	}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		EmailResult.sendEmail();
		driver.quit();
	}

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("D:\\Shreyas\\salesforce\\TestNG.xml");// path to
		testng.setTestSuites(suites);
		testng.run();
	}

}

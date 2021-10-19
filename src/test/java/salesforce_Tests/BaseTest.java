package salesforce_Tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class BaseTest {

	public WebDriver driver;

	@Parameters({ "browser" }) // chrome
	@BeforeClass
	public void initialize(String browserName) throws Exception {

		// Check if parameter passed from TestNG is 'firefox'
		if (browserName.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();

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

		driver.quit();
	}

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("C:\\Users\\shreyas.sambare\\eclipse-workspace\\com.dddframework.project\\testNG.xml");// path to
																											// xml..

		testng.setTestSuites(suites);
		testng.run();
	}

}

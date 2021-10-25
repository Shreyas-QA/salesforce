package salesforce_Tests;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import salesforce_Pages.ContactUs_Pages;
import salesforce_Pages.HomePage;

public class ContactUsTest extends BaseTest {
	private ContactUs_Pages cpage;

	@Test(priority = 1)
	public void ClickOnContactUS_Link() {
		cpage = PageFactory.initElements(driver, ContactUs_Pages.class);
		cpage.ClickOnContactUs();
	}

	@Test(priority = 2)
	public void GoToContactUsPage() {
		
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		

	}
	
}

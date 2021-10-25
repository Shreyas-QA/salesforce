package salesforce_Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import salesforce_Pages.ContactUs_Pages;
import salesforce_Pages.HomePage;

public class ContactUsTest extends BaseTest {
	private ContactUs_Pages cpage;

	@Test
	public void ClickOnContactUS_Link() {
		cpage = PageFactory.initElements(driver, ContactUs_Pages.class);
		cpage.ClickOnContactUs();
	}
	
	@Test
	public void GoToContactUsPage() {
		
	}
}

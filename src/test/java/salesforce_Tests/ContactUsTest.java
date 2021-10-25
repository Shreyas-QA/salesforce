package salesforce_Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import salesforce_Pages.ContactUs_Pages;

public class ContactUsTest extends BaseTest {
	private ContactUs_Pages cpage;

	@Test
	public void ViewMenu() {

		ContactUs_Pages cpage = PageFactory.initElements(driver, ContactUs_Pages.class);

		cpage.ClickOnContactUs();
	}
}

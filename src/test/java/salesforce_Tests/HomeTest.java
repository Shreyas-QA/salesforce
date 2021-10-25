package salesforce_Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import salesforce_Pages.HomePage;

public class HomeTest extends BaseTest {
	private HomePage hpage;

	@Test
	public void ViewMenu() {

		hpage = PageFactory.initElements(driver, HomePage.class);

		hpage.ClickProductTab();
		hpage.ClickResourceTab();
	}

}

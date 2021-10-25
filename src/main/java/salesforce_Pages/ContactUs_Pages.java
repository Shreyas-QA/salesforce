package salesforce_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs_Pages {

	WebDriver driver;

	public ContactUs_Pages(WebDriver driver) {
		System.out.println("Page: "+driver);
		this.driver = driver;
	}

	@FindBy(xpath = "(//a[@href='/in/form/contact/contactme/?d=cta-header-9'])[2]")
	public WebElement clickContactUs;

	public void ClickOnContactUs() {

		clickContactUs.click();
	}
	

}

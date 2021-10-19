package salesforce_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	@FindBy(xpath = "(//button[@class='nav-item-link child-menu'])[1]")
	public WebElement ProductsTab;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

//	public List<WebElement> DisplayMenuOnHomePage() {
//
//		List<WebElement> elementName = driver.findElements(By.xpath("//ul[@id='toggleNav']/li"));
//		for (WebElement en : elementName) {
//
//			System.out.println(en.getText());
//		}
//
//		return elementName;
//
//	}

	public void ClickProductTab() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ProductsTab));
		ProductsTab.click();
		Assert.assertEquals(true, ProductsTab.isDisplayed());
	}

}

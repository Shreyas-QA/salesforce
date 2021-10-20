package salesforce_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	@FindBy(xpath = "(//button[@class='nav-item-link child-menu'])[1]")
	public WebElement ProductsTab;
	@FindBy(xpath = "(//button[@class = 'nav-item-link child-menu'])[2]")
	public WebElement ResourceTab;

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
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ProductsTab));
		actions.moveToElement(ProductsTab).perform();
		Assert.assertEquals(true, ProductsTab.isDisplayed());
	}

	public void ClickResourceTab() {
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(ResourceTab));
		actions.moveToElement(ResourceTab).perform();
		Assert.assertEquals(true, ResourceTab.isDisplayed());
	}

}

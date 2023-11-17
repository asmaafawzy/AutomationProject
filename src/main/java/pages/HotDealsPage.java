package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.Utilities;

public class HotDealsPage {

	private WebDriver driver;

	public HotDealsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By i_name = By.xpath("(//div[contains(@class,\"title mt-2\")])[1]");
	private By i_price = By.xpath("(//div[contains(@class,\"price mx-1\")])[1]");

	public String getItemName() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(i_name));
		return driver.findElement(i_name).getText();
	}

	public String getItemPrice() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(i_price));
		return driver.findElement(i_price).getText();
	}

	public void clickOnItem() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(i_name));
		driver.findElement(i_name).click();
	}
	public void checkForBorkenLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			Utilities.verifyLink(url);
		}
	}
	public Boolean isBrokenLinkHotDeals() {
		return Utilities.isBrokenLink;
	}
}


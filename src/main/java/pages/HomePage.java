package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Utilities;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By viewAllButton = By.xpath("(//button[contains(@class,\"p-element\")])[2]");

	public void scrollToHotDeals() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(viewAllButton));
		new Utilities(driver);
		Utilities.scrollToPosition(1114, 1088);
	}

	public void clickOnViewAllButton() {
		driver.findElement(viewAllButton).click();
	}

	public void checkForBorkenLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			Utilities.verifyLink(url);
		}
	}

	public Boolean isBrokenLinkHome() {
		return Utilities.isBrokenLink;
	}

}

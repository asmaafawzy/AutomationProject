package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailsPage {
	private WebDriver driver;

	public ItemDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By displayedName = By.xpath("//p[contains(@class,\"font-size-20\")]");
	private By displayedPrice = By.xpath("//span[contains(@class,\"tag-now tag-now-old-value\")]");
	private By addToCartbtn = By.xpath("(//button[contains(@class,\"p-button\")])[1]");
	private By cart = By.xpath("//a[contains(@class,\"cart_route\")]");

	public String getItemName() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(displayedName));
		return driver.findElement(displayedName).getText();
	}

	public String getItemPrice() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(displayedPrice));
		return driver.findElement(displayedPrice).getText();
	}

	public void addItemToCart() {
		driver.findElement(addToCartbtn).click();
	}

	public void clickOnCart() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(cart));
		driver.findElement(cart).click();
		
	}
}

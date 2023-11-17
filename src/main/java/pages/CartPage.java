package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	private By productName = By.xpath("//p[contains(@class,\"product_name\")]");
	private By productPrice = By.xpath("(//p[contains(@class,\"was-currency\")]/span)[2]");
	private By quantity = By.xpath("//div[contains(@class,\"p-0 font-size-16\")]");

	public String getItemName() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(productName));
		return driver.findElement(productName).getText();
	}

	public String getItemPrice() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
		return driver.findElement(productPrice).getText();
	}

	public Boolean isQtyDisplayed() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(quantity));
		return true;
	}
}

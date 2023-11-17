package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;

public class Utilities {

	private static WebDriver driver;
	public static Boolean isBrokenLink = false;

	public Utilities(WebDriver driver) {
		Utilities.driver = driver;
	}

	public static void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollToPosition(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0],arguments[1]);", x, y);
	}

	public static void verifyLink(String url) {
		try {
			URI link = new URI(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.toURL().openConnection();
			httpURLConnection.setConnectTimeout(7000);
			httpURLConnection.connect();

			if (isValidHttpStatusCode(httpURLConnection.getResponseCode())) {
				isBrokenLink = true;

			} else {
				isBrokenLink = false;

			}
		} catch (Exception e) {
			isBrokenLink = false;
		}
	}

	public static boolean isValidHttpStatusCode(int responseCode) {
		String httpStatusCodePattern = "^[4-5]\\d{2}$"; // Matches status codes 400 to 599
		String statusCodeString = String.valueOf(responseCode);

		Pattern pattern = Pattern.compile(httpStatusCodePattern);
		Matcher matcher = pattern.matcher(statusCodeString);

		return matcher.matches();
	}
}

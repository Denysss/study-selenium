package pages.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActions {

	private static int defaultElementTimeOut = 5;
	private static int defaultPageTimeOut = 10;
	
	public static void setUpPage (WebDriver driver, String link) {
		driver.get(link);
	}

	public static void sendKey (WebDriver driver, By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}
	
	public static void clear (WebDriver driver, By locator) {
		driver.findElement(locator).clear();
	}
	
	public static void submit (WebDriver driver, By locator) {
		driver.findElement(locator).submit();
	}

	public static void click (WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}

	public static Boolean isSelected (WebDriver driver, By locator) {
		return driver.findElement(locator).isSelected();
	}

	
	public static String getText (WebDriver driver, By locator) {
		waitOnElementWithUnEmptyText(driver, locator);
		return driver.findElement(locator).getText();
	}

	public static String getTitle (WebDriver driver) {
		return driver.getTitle();
	}
	
	public static void waitOnElementWithUnEmptyText (WebDriver driver, final By locator) {

		WebDriverWait wait = new WebDriverWait(driver, defaultElementTimeOut);
		
		wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(locator).getText().length() != 0;
            }
        });
	}
	
	public static void waitOnTitle (WebDriver driver, final String expectedTitle) {

		WebDriverWait wait = new WebDriverWait(driver, defaultPageTimeOut);
		
		wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().contains(expectedTitle);
            }
        });
	}
}

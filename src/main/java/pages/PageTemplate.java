package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.helpers.SeleniumActions;

import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class PageTemplate {
	
	private int defaultElementTimeOut = 5;
	private int defaultPageTimeOut = 10;
	
	protected final WebDriver driver;
	
	public PageTemplate (WebDriver driver) {
        this.driver = driver;
	}
	
	public void setUpPage (String link) {
		SeleniumActions.setUpPage(driver, link);
	}
	
	public void sendKey (By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}
	
	public void clear (By locator) {
		driver.findElement(locator).clear();
	}
	
	public void submit (By locator) {
		driver.findElement(locator).submit();
	}

	public void click (By locator) {
		driver.findElement(locator).click();
	}

	public Boolean isSelected (By locator) {
		return driver.findElement(locator).isSelected();
	}

	
	public String getText (By locator) {
		waitOnElementWithUnEmptyText(locator);
		return driver.findElement(locator).getText();
	}

	public String getTitle () {
		return driver.getTitle();
	}
	
	protected void waitOnElementWithUnEmptyText (final By locator) {

		WebDriverWait wait = new WebDriverWait(driver, defaultElementTimeOut);
		
		wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(locator).getText().length() != 0;
            }
        });
	}

	protected void waitOnTitle (final String expectedTitle) {

		WebDriverWait wait = new WebDriverWait(driver, defaultPageTimeOut);
		
		wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().contains(expectedTitle);
            }
        });
	}
}
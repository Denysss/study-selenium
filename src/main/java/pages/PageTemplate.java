package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.helpers.SeleniumActions;

public abstract class PageTemplate {
	
	protected final WebDriver driver;
	
	public PageTemplate (WebDriver driver) {
        this.driver = driver;
	}
	
	public void setUpPage (String link) {
		SeleniumActions.setUpPage(driver, link);
	}
	
	public void sendKey (By locator, String value) {
		SeleniumActions.sendKey(driver, locator, value);
	}
	
	public void clear (By locator) {
		SeleniumActions.clear(driver, locator);
	}
	
	public void submit (By locator) {
		SeleniumActions.submit(driver, locator);
	}

	public void click (By locator) {
		SeleniumActions.submit(driver, locator);
	}

	public Boolean isSelected (By locator) {
		return SeleniumActions.isSelected(driver, locator);
	}
	
	public String getText (By locator) {
		SeleniumActions.waitOnElementWithUnEmptyText(driver, locator);
		return SeleniumActions.getText(driver, locator);
	}

	public String getTitle () {
		return SeleniumActions.getTitle(driver);
	}
}
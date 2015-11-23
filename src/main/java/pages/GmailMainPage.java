package pages;

import org.openqa.selenium.WebDriver;

import pages.helpers.SeleniumActions;

public class GmailMainPage extends PageTemplate {
	
	private String expectedDefaultTitleEnd = "@gmail.com - Gmail";

	public GmailMainPage(WebDriver driver) {
		super(driver);
		SeleniumActions.waitOnTitle(driver, expectedDefaultTitleEnd);
	}

}

package pages;

import org.openqa.selenium.WebDriver;

public class GmailMainPage extends PageTemplate {
	
	private String expectedDefaultTitleEnd = "@gmail.com - Gmail";

	public GmailMainPage(WebDriver driver) {
		super(driver);
		waitOnTitle(expectedDefaultTitleEnd);
	}

}

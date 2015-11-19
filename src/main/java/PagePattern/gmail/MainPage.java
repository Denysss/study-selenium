package pagePattern.gmail;

import org.openqa.selenium.WebDriver;

import pagePattern.templates.PageTemplate;

public class MainPage extends PageTemplate {
	
	private String expectedDefaultTitleEnd = "@gmail.com - Gmail";

	public MainPage(WebDriver driver) {
		super(driver);
		waitOnTitle(expectedDefaultTitleEnd);
	}

}

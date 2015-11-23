package pages.helpers;

import org.openqa.selenium.WebDriver;

public class SeleniumActions {

	private static int defaultElementTimeOut = 5;
	private static int defaultPageTimeOut = 10;
	
	public static void setUpPage (WebDriver driver, String link) {
		driver.get(link);
	}
	
}

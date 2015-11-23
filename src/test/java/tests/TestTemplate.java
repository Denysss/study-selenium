package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.GmailLoginPage;

import org.junit.After;
import org.junit.Before;

public abstract class TestTemplate {

	protected static WebDriver driver;
	protected static GmailLoginPage logInPage;
	
	@Before
	public void beforeTest () {
		driver = new FirefoxDriver();
		logInPage = new GmailLoginPage(driver);
	}
		
	@After
	public void afterTest () {
		driver.quit();
	}

}
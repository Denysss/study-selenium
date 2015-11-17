import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import PagePattern.GmailLoginPage;
import PagePattern.GmailMainPage;

public class GmailLogIn {

	private GmailLoginPage logInPage;
	private GmailMainPage mainPage;
	private static WebDriver driver;
	
	private String validEmail = "email@gmail.com";
	private String password = "password";
	private String emptyEmail = "";
	private String notValidEmail = "@#$";
	
	@BeforeClass
	public static void beforeClass () {
		driver = new FirefoxDriver();
	}
	
	@Before
	public void beforeTest () {
		logInPage = new GmailLoginPage(driver);
	}
		
	@AfterClass
	public static void afterClass () {
		driver.quit();
	}
	
	
	@Test
	public void testSingInWithEmptyEmail () {
		String alert = logInPage.setEmail(emptyEmail).submitNext().getErrorMessage();
		assertEquals(GmailLoginPage.expectedAlertForEmptyEmail, alert);
		
	}
	
	@Test
	public void testSingInWithNotValidEmail () {
		String alert = logInPage.setEmail(notValidEmail).submitNext().getErrorMessage();
		assertEquals(GmailLoginPage.expectedAlertForNotValidEmail, alert);
		
	}
	
	@Test
	public void testSingInWithValidEmail () {
		String actualEmail = logInPage.setEmail(validEmail).submitNext().getEmailBeforeTypePassword();
		assertEquals(validEmail, actualEmail);
		
		mainPage = logInPage.setPassward(password).submitSignIn();
		String actualTitle = mainPage.getTitle().toLowerCase();
		String assertMessage = "Title of the main Gmail page should contain email: '" + validEmail + "', but actual title - '" + actualTitle + "'";
		assertTrue(assertMessage, actualTitle.contains(validEmail.toLowerCase()));
		
	}

	
}

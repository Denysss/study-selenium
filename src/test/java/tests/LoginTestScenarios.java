package tests;

import pages.GmailLoginPage;
import pages.GmailMainPage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LoginTestScenarios extends TestTemplate {

	private GmailLoginPage logInPage;
	private GmailMainPage mainPage;
	
	private String validEmail = "email@gmail.com"; // your email
	private String password = "password"; // your password
	private String emptyEmail = "";
	private String notValidEmail = "@#$";
	
	@Before
	public void beforeLoginTest () {
		logInPage = new GmailLoginPage(driver);
	}
	
	@Test
	public void LogIntoGmailWithEmptyEmailTest () {
		logInPage.setEmail(emptyEmail);
		logInPage.submitNext();
		assertEquals(GmailLoginPage.expectedAlertForEmptyEmail, logInPage.getErrorMessage());
		
	}
	
	@Test
	public void LogIntoGmailWithNotValidEmailTest () {
		logInPage.setEmail(notValidEmail);
		logInPage.submitNext();
		assertEquals(GmailLoginPage.expectedAlertForNotValidEmail, logInPage.getErrorMessage());
		
	}
	
	@Test
	public void LogIntoGmailTest () {
		logInPage.setEmail(validEmail);
		logInPage.submitNext();
		assertEquals(validEmail, logInPage.getEmailBeforeTypePassword());
		
		logInPage.setPassward(password);
		mainPage = logInPage.submitSignIn();
		String actualTitle = mainPage.getTitle().toLowerCase();
		String assertMessage = "Title of the main Gmail page should contain email: '" + validEmail + "', but actual title - '" + actualTitle + "'";
		assertTrue(assertMessage, actualTitle.contains(validEmail.toLowerCase()));
		
	}
}

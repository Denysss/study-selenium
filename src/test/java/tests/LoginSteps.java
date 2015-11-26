package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import pages.GmailLoginPage;
import pages.GmailMainPage;

public class LoginSteps extends TestTemplate {

	private GmailLoginPage loginPage;
	private GmailMainPage mainPage;
	
	@Given(value = "Login page is opened")
	public void loginPageIsOpened () {
		loginPage = new GmailLoginPage(driver);
		
	}
	
	@When(value = "Set not valid $email to email field")
	@Aliases(values = {"Set empty $email to email field", "Set correct $email to email field"})
	public void setEmail (String email) {
		loginPage.setEmail(email);
	}
	
	@When(value = "Submit Next button")
	public void submitNext () {
		loginPage.submitNext();
	}
	
	@When (value = "Set correct $password to password field")
	public void setPassword (String password) {
		logInPage.setPassward(password);
	}
	
	@When (value = "Sunmit SignIn button")
	public void submitSignIn () {
		mainPage = logInPage.submitSignIn();
	}
	
	@Then(value = "Warning $message should be present on the page")
	public void warningNotValidEmailShouldBePresentOnThePage (String message) {
		assertEquals(message, logInPage.getErrorMessage());
	}
	
	@Then(value = "The $email should be present on the page")
	public void theEmailShouldBePresentOnThePage (String email) {
		assertEquals(email, logInPage.getEmailBeforeTypePassword());
	}
	
	@Then(value = "Title should include the $email")
	public void titleShouldIncludeTheEmail (String email) {
		String actualTitle = mainPage.getTitle().toLowerCase();
		String assertMessage = "Title of the main Gmail page should contain email: '" + email + "', but actual title - '" + actualTitle + "'";
		assertTrue(assertMessage, actualTitle.contains(email.toLowerCase()));
	}
}

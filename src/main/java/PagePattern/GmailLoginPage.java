package PagePattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLoginPage extends Page {

	public static String urlGmailLoginPage = "https://mail.google.com";
	public static String expectedAlertForNotValidEmail = "Please enter a valid email address.";
	public static String expectedAlertForEmptyEmail = "Please enter your email.";
	
	private By edtEmail = By.id("Email");
	private By btnNext = By.id("next");
	private By msgAlert = By.className("alert"); // it was for Chrome
	private By msgError = By.className("error-msg");
	private By edtPassward = By.id("Passwd");
	private By msgEmailBeforeTypePassword = By.id("email-display");
	private By chkStaySignedIn = By.id("PersistentCookie");
	private By btnSignIn = By.id("signIn");
	
	public GmailLoginPage (WebDriver driver) {
		super(driver);
		setUpPage(urlGmailLoginPage);
	}
	
	public GmailLoginPage setPassward(String passward) {
		clear(edtPassward);
		sendKey(edtPassward, passward);
		return this;
	}

	public GmailLoginPage submitNext () {
		submit(btnNext);
        return this;
	}
	
	public GmailMainPage submitSignIn () {
		submit(btnSignIn);
        return new GmailMainPage(driver);
	}
	
	public GmailLoginPage setEmail () {
		clear(edtEmail);
		return this;
	}
	
	public GmailLoginPage setEmail (String email) {
		if (email.isEmpty()) {
			setEmail();
		} else {
			sendKey(edtEmail, email);
		}
		
		return this;
	}
	
	public String getErrorMessage () {
		return getText(msgError);
	}
	
	public String getEmailBeforeTypePassword () {
		return getText(msgEmailBeforeTypePassword);
	}
	
	public GmailLoginPage setStaySignedIn (Boolean shouldStaySignedIn) {
		if (!shouldStaySignedIn.equals(isSelected(chkStaySignedIn))) 
			click(chkStaySignedIn);
		return this;
	}
	
}
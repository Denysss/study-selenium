//import java.util.HashMap;
//import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class MainGooglePage {

	private String urlGoogle = "http://www.google.com";
	//private String namePropertyChromeDriver = "webdriver.chrome.driver";
	//private String pathPropertyChromeDriver = "D:\\workspace\\ChromeDriver\\win32\\2_20";
	//private String pathToChrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	
	@Test
	public void mainGooglePageShouldBeOpened () throws InterruptedException {
	
		//System.setProperty(namePropertyChromeDriver, pathPropertyChromeDriver);
		
		//ChromeOptions options = new ChromeOptions();
		//options.setBinary(pathToChrome);
		
		//Map<String, Object> chromeOptions = new HashMap<String, Object>();
		//chromeOptions.put("binary", pathToChrome);
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		//WebDriver driver = new ChromeDriver(capabilities);
		//WebDriver driver = new ChromeDriver ();
		WebDriver driver = new FirefoxDriver();
		
	    driver.get(urlGoogle);
	
	    WebElement element = driver.findElement(By.name("q"));
	    element.sendKeys("EPAM");
	    element.submit();

	    TimeUnit.SECONDS.sleep(10);
	    
	    driver.quit();
	}
}

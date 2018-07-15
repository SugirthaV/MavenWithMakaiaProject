package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTap {
	
	public ChromeDriver driver;
	
	@Given("Open the Chrome browser")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@And("Launch url")
	public void Launch() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@And("Set timeout")
	public void timeouts() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@And("Type Username as (.*)")
	public void userName(String uname) {
		driver.findElementById("username").sendKeys(uname);
	}


	@And("Type password as (.*)")
	public void passWord(String pass) {
		driver.findElementById("password").sendKeys(pass);
	}


	@And("Click Login")
	public void loginSubmit() {
		driver.findElementByClassName("decorativeSubmit").click();
	}

	
 
	@And("Click CRMSFA")
	public void clickCRM() {
		driver.findElementByLinkText("CRM/SFA").click();
	}

}

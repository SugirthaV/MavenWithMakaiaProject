package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class MyHomePage extends WebDriverServiceImpl {

	public MyHomePage(EventFiringWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Leads")
	WebElement eleLead;
	
	
	public MyLeads clickLeads() {
		 
		click(eleLead);
		return new MyLeads(driver, test);
		}
	
}

package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class MyLeads extends WebDriverServiceImpl{

	public MyLeads(EventFiringWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Create Lead") 
	WebElement eleCreateLead;
	
	
	public CreateLeadPage clickCreateLead() {
		 
		click(eleCreateLead);
		return new CreateLeadPage(driver, test);
	}
	
}

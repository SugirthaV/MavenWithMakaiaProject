package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadPage extends WebDriverServiceImpl{

	public CreateLeadPage(EventFiringWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "createLeadForm_companyName")
	WebElement eleCompName;
	
	@FindBy(id = "createLeadForm_firstName")
	WebElement eleFName;
	
	@FindBy(id = "createLeadForm_lastName")
	WebElement elelName;
	
	@FindBy(className = "smallSubmit")
	WebElement eleSubmit;
	

	public CreateLeadPage companyName(String CompName ) {
		 
		type(eleCompName,CompName);
		return this;
		}
	
	public CreateLeadPage FirstName(String fName ) {
		 
		type(eleFName,fName);
		return this;
		}
	
	public CreateLeadPage LastName(String lName ) {
		 
		type(elelName,lName);
		return this;
		}
	
	public ViewLeadPage ClickSubmit() {
		 
		click(eleSubmit);
		return new ViewLeadPage(driver, test);
		}
 
}





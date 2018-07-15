package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadListener extends PreAndPost{
 
	//@Test(invocationCount = 2 ,invocationTimeOut = 30000)
	@Test(invocationTimeOut = 30000) // This Invocation timeout ill get overriden by the Listener hich in this testNGListener class
	public void createLead() {
		 
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleCreate = locateElement("link", "Create Lead");
		click(eleCreate);
		
		WebElement eleCompanyName = locateElement("id","createLeadForm_companyName");
		type(eleCompanyName,"TestLeaf");
		
		WebElement eleFirstName = locateElement("id","createLeadForm_firstName");
		type(eleFirstName,"Sugirtha");
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName,"V");
		
		WebElement eleLeadButton = locateElement("class", "smallSubmit");
		click(eleLeadButton);
		
		
	}
	
	
}





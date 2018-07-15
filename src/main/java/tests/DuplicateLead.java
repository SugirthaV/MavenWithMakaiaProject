package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends PreAndPost{

	@Test(alwaysRun = false)
	public void duplicateLead() {
	
		WebElement eleUserName = locateElement("id", "username"); 
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleCreate = locateElement("link", "Create Lead");
		click(eleCreate);
		
		WebElement eleCompanyName = locateElement("id","createLeadForm_companyName");
		type(eleCompanyName,"XYZ");
		
		WebElement eleFirstName = locateElement("id","createLeadForm_firstName");
		type(eleFirstName,"Sugirtha");
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName,"V");
		
		WebElement source = locateElement("id","createLeadForm_dataSourceId");
		Select dd = new Select(source);
		dd.selectByVisibleText("Public Relations");
		
		WebElement eleLeadButton = locateElement("class", "smallSubmit");
		click(eleLeadButton);
		
		WebElement eleFindLead = locateElement("xpath","//a[text()='Find Leads']");
		click(eleFindLead);
		
		WebElement eleCompanyDup = locateElement("xpath","(//input[@name='companyName'])[2]");
		type(eleCompanyDup,"XYZ");
		
		WebElement eleButton = locateElement("xpath","//button[text()='Find Leads']");
		click(eleButton);
		
		WebElement eleFound = locateElement("xpath","//a[text()='XYZ']");
		click(eleFound);
		
		WebElement eleDuplicateButton = locateElement("xpath","//a[text()='Duplicate Lead']");
		click(eleDuplicateButton);
		
		WebElement eleClick = locateElement("xpath","//input[@class='smallSubmit']");
		click(eleClick);
		
		
	}

}

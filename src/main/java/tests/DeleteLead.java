package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class DeleteLead extends WebDriverServiceImpl {

	//@Test(dependsOnMethods = "tests.CreateLead.createLead",alwaysRun = true)
	@Test(groups = "sanity")
	public void deletingLead() {
		
		WebElement eleUserName = locateElement("id", "username"); 
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
	
		WebElement eleLeads = locateElement("xpath", "//a[text()='Leads']"); 
		click(eleLeads);
		
		WebElement eleFindLead = locateElement("xpath","//a[text()='Find Leads']");
		click(eleFindLead);
		
		WebElement elePhone = locateElement("xpath","//span[text()='Phone']");
		click(elePhone);
		
		WebElement elePhoneText = locateElement("xpath","//input[@name='phoneNumber']");
		type(elePhoneText,"9159126444");
		
		WebElement eleFindLeadsButton = locateElement("xpath","//button[text()='Find Leads']");
		click(eleFindLeadsButton);
		
		WebElement eleFoundPhone = locateElement("xpath","//a[text()='11210']");
		click(eleFoundPhone);
		 
		WebElement eleDelete = locateElement("class","subMenuButtonDangerous");
		click(eleDelete);
		
		WebElement eleFindLeadSearch = locateElement("xpath","//a[text()='Find Leads']");
		click(eleFindLeadSearch);
		
		WebElement eleNameAndID = locateElement("xpath","//span[text()='Name and ID']");
		click(eleNameAndID);
		
		WebElement eleLeadID = locateElement("xpath", "//input[@name='id']");
		type(eleLeadID,"11210");
		
		WebElement eleFindButton = locateElement("xpath","//button[text()='Find Leads']");
		click(eleFindButton);
		
		String eleFoundText = locateElement("xpath","//div[@class='x-paging-info']").getText();
		if(eleFoundText.contains("No records"))
		{
			System.out.println("Text is Captured");
		}
		else
		{
			System.out.println("Could not captre");
		}
		
		//driver.close();
		} 

}

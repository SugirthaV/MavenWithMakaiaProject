package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class EditLead extends PreAndPost{

	//@Test(dependsOnMethods = "tests.CreateLead.createLead",description = "Editing the existing leads profile")
	@Test(groups = "smoke")
	public void editLead() {
		
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
		type(eleCompanyName,"TestLeaf");
		
		WebElement eleFirstName = locateElement("id","createLeadForm_firstName");
		type(eleFirstName,"Sugirtha");
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName,"V");
		
		WebElement eleLeadButton = locateElement("class", "smallSubmit");
		click(eleLeadButton);
		
		WebElement eleFindLead = locateElement("xpath","//a[text()='Find Leads']");
		click(eleFindLead);
		
		WebElement eleEditFirstName = locateElement("xpath","(//input[@name='firstName'])[3]");
		type(eleEditFirstName,"Sugirtha");
		
		WebElement eleFindLeadClick = locateElement("xpath","//button[text()='Find Leads']");
		click(eleFindLeadClick);
		
		WebElement eleToEditText = locateElement("xpath","//a[text()='Sugirtha']"); 
		click(eleToEditText);
		
		String Title = driver.getTitle();
		//System.out.println(Title);
		if(Title.contains("View Lead | opentaps CRM"))
				{
			System.out.println(Title);
				}
		else
		{
			System.out.println("Title is not Captred ");
		}
		
		WebElement eleEditButtonClick = locateElement("xpath","//a[text()='Edit']");
		click(eleEditButtonClick); 
		   
		WebElement eleCompanyNameEdit = locateElement("id","updateLeadForm_companyName"); 
		clear(eleCompanyNameEdit);
		
		WebElement eleCompanyNameUpdate = locateElement("id","updateLeadForm_companyName"); 
		type(eleCompanyNameUpdate,"TestLeafEdited_tonew");
		
		WebElement eleUpdate = locateElement("class", "smallSubmit");
		click(eleUpdate); 
		
		String Text = locateElement("id","viewLead_companyName_sp").getText();
		System.out.println(Text);
		if(Text.contains("TestLeafEdited_tonew"))
		{
			System.out.println("Entered text is correctly updated");
		}
		//driver.close();
		
		}
}

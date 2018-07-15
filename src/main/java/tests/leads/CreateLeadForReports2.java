package tests.leads;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.MyHomePage;
import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadForReports2 extends PreAndPost{
 
	//@Test(invocationCount = 2 ,invocationTimeOut = 30000)
	//@Test(groups = "smoke")
	
	//Only one vale can be passed at a time i.e either UAT or SIT
	
	@BeforeTest
	public void setValue()
	{
		testCaseName = "TC_001_CreateLead";
		testDesc = "Create a New Lead";
		nodeName = "Lead";
		author = "sugi";
		category = "smoke";
		ExcelFileName = "CreateLead";
	}
	@Test(dataProvider = "TST")
	public void createLead(String compName,String Name,String LastName) {
	new MyHomePage(driver, test).clickLeads().clickCreateLead().companyName(compName).FirstName(Name).LastName(LastName).ClickSubmit();

}


	}





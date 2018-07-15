package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadDataProvider extends PreAndPost{
 
	//@Test(invocationCount = 2 ,invocationTimeOut = 30000)
	//@Test(groups = "smoke")
	
	//Only one vale can be passed at a time i.e either UAT or SIT
	@Test(dataProvider="UAT")
	public void createLead(String compName,String Name,String LastName) {
		 
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleCreate = locateElement("link", "Create Lead");
		click(eleCreate);
		
		WebElement eleCompanyName = locateElement("id","createLeadForm_companyName");
		type(eleCompanyName,compName);
		
		WebElement eleFirstName = locateElement("id","createLeadForm_firstName");
		type(eleFirstName,Name);
		
		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName,LastName);
		
		WebElement eleLeadButton = locateElement("class", "smallSubmit");
		click(eleLeadButton);
		
				
		
		
	}


	@DataProvider(name="UAT")
	public String[][] getData1(){
		
		String[][] data = new String[2][3];
		data[0][0]="TestLeafs";
		data[0][1]="Sugi";
		data[0][2]="V";
		
		data[0][0]="Wipro";
		data[0][1]="Sugirtha";
		data[0][2]="Venkat";
		return data;
		
	}
	//To run only first datas using indices
	@DataProvider(name="SIT",indices= {0})
	public String[][] getData2(){
		
		String[][] data = new String[2][3];
		data[0][0]="TestLeafs";
		data[0][1]="Sugi";
		data[0][2]="V";
		
		data[0][0]="Wipro";
		data[0][1]="Sugirtha";
		data[0][2]="Venkat";
		return data;
		}

	
}





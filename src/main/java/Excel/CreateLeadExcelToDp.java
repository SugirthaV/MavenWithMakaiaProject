package Excel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class CreateLeadExcelToDp extends PreAndPost{
 
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
	public String[][] getData1() throws IOException{
	 
		ReadExcel excel = new ReadExcel();
		return excel.Excel(ExcelFileName);
		
	}
	//To run only first datas using indices
	
	
}





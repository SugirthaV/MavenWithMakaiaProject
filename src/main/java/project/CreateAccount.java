package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class CreateAccount extends WebDriverServiceImpl{

	@Test
	public void createLead() throws InterruptedException {
		
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		WebElement eleAccounts = locateElement("xpath","//a[text()='Accounts']");
		click(eleAccounts);
		
		WebElement eleCreateAcc = locateElement("xpath","//a[text()='Create Account']");
		click(eleCreateAcc);
		
		WebElement eleAccName = locateElement("id", "accountName");
		type(eleAccName, "Demotests");
		
		WebElement eleName = locateElement("name","industryEnumId");
		Select dd = new Select(eleName);
		dd.selectByVisibleText("Computer Software");
	
		WebElement eleCurrency = locateElement("name","currencyUomId");
		Select cc = new Select(eleCurrency);
		cc.selectByVisibleText("AED - United Arab Emirates Dirham");
		
		WebElement eleSource = locateElement("name","dataSourceId");
		Select sss = new Select(eleSource);
		sss.selectByVisibleText("Conference");
		
		WebElement eleMarketing = locateElement("name","marketingCampaignId");
		Select mm = new Select(eleMarketing);
		mm.selectByVisibleText("Automobile");
		
		WebElement elePhone = locateElement("xpath","//input[@id='primaryPhoneNumber']");
		type(elePhone,"1234567881");
		
		WebElement eleCity = locateElement("id", "generalCity");
		type(eleCity, "Chennai");
		
		WebElement eleEmail = locateElement("xpath","//input[@id='primaryEmail']");
		type(eleEmail,"sugirthav.venkat@gmail.com");
	
		WebElement eleCountry = locateElement("id","generalCountryGeoId");
		selectDropDownUsingVisibleText(eleCountry,"India");
		
		WebElement eleState = locateElement("xpath","//select[@id='generalStateProvinceGeoId']");
		selectDropDownUsingVisibleText(eleState,"ASSAM");
		
		WebElement eleCreate = locateElement("class","smallSubmit");
		click(eleCreate); 
		
		WebElement Acctext = locateElement("xpath","(//span[@class='tabletext'])[3]");
		String text = getText(Acctext);
		String Accnum = text.replaceAll("[a-z,A-Z,(,)]", "");
		String AccID = Accnum.trim();
		System.out.println(AccID);
		
		WebElement eleFind = locateElement("xpath","//a[text()='Find Accounts']");
		click(eleFind); 
		
		WebElement eleAccID = locateElement("xpath","//input[@name='id']");
		type(eleAccID, AccID);
		
		WebElement eleAccNameFind = locateElement("xpath","(//input[@name='accountName'])[2]");
		type(eleAccNameFind,"Demotests");
		
		WebElement eleFindButton = locateElement("xpath","//button[text()='Find Accounts']");
		click(eleFindButton);
		
		WebElement eleLinkID = locateElement("xpath","//div[@class='x-grid3-cell-inner x-grid3-col-partyId']");
		click(eleLinkID);
		
		WebElement AccIDVerify = locateElement("xpath","(//span[@class='tabletext'])[3]");
		String ID = getText(AccIDVerify);
		String AccnumVerify = ID.replaceAll("[a-z,A-Z,(,)]", "");
		String FinalID = AccnumVerify.trim();
		
		if(AccID.contains(FinalID))
		{
			System.out.println("Accont Details are correct");
		}
		else
		{
			System.out.println("Not correct");
		}
		}
	}





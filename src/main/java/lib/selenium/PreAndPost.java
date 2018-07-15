package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Excel.ReadExcel;

public class PreAndPost extends WebDriverServiceImpl  {
	
	public String testCaseName,testDesc,nodeName,author,category,ExcelFileName;
	
	@Parameters({"url","userName","passWord"})
	 @BeforeMethod(groups = "smoke")
	  public void beforeMethod(String url,String uName,String pwd) {
		
		//For reports purpose
		startTestModule("Leads");
		test.assignAuthor("Sugi");
		test.assignCategory("smoke");
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			webdriver = new ChromeDriver();
			
			driver = new EventFiringWebDriver(webdriver);
			driver.register(this);
			
			driver.manage().window().maximize();
			driver.get(url);
			//driver.get("https://www.flipkart.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("before Method");
			WebElement eleUserName = locateElement("id", "username");
			type(eleUserName, uName);
			
			WebElement elePassword = locateElement("id", "password");
			type(elePassword, pwd);
			
			WebElement eleLogin = locateElement("class", "decorativeSubmit");
			click(eleLogin);
			
			WebElement eleCRM = locateElement("link", "CRM/SFA");
			click(eleCRM);
			
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("afterMethod");
		  closeActiveBrowser(); 
	  }

	  @BeforeClass
	  public void beforeClass() {
			startTestCase(testCaseName, testDesc);		
		}


	  @AfterClass
	  public void afterClass() {
		  System.out.println("afterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("beforeTest");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("afterTest");
	  }

	  @BeforeSuite
		public void beforeSuite() {
			startReport();
		}

	  @AfterSuite
	  public void afterSuite() {
		  endResult();
	  }
	  
	  @DataProvider(name = "TST")
		public String[][] getData1() throws IOException{
		 
			ReadExcel excel = new ReadExcel();
			return excel.Excel(ExcelFileName);
			
		}
		
	  

}

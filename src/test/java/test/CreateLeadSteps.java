package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLeadSteps {

	public ChromeDriver driver;
	
	@Given("Open Browser")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@And("Launch the url")
	public void Launch() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@And("Maximize Browser")
	public void maxBrowser() {
		driver.manage().window().maximize();
	}

	@And("Set Outtime")
	public void timeouts() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@And("Username as (.*)")
	public void userName(String uname) {
		driver.findElementById("username").sendKeys(uname);
	}


	@And("password as (.*)")
	public void passWord(String pass) {
		driver.findElementById("password").sendKeys(pass);
	}


	@When("Click on Login")
	public void loginSubmit() {
		driver.findElementByClassName("decorativeSubmit").click();
	}

	@And("Click CRMLink")
	public void clickCRM() {
		driver.findElementByLinkText("CRM/SFA").click();
	}

	@Given("Click leads")
	public void leadsClick() {
		driver.findElementByXPath("//a[text()='Leads']").click();
	}

	@And("Click CreateLead")
	public void CreateLeadsClick() {
		driver.findElementByXPath("//a[text()='Create Lead']").click();
	}

	@And("Enter CompanyName (.*)")
	public void enterCompName(String compName) {
		driver.findElementById("createLeadForm_companyName").sendKeys(compName);
	}

	@And("Enter FirstName (.*)")
	public void enterFName(String fName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
	}

	@And("Enter LastName (.*)")
	public void enterLName(String lName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(lName);
	}

	@When("Click on createLead Button")
	public void Submit() {
		driver.findElementByClassName("smallSubmit").click();
	}

	@Then("CreateLead Complete")
	public void createCompletion() {
		System.out.println("creating lead is done .");
	}
}

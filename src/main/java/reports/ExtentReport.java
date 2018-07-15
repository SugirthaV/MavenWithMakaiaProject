package reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	public static void main(String[] args) throws IOException {
		// http://extentreports.com/docs/versions/3/java/
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
		
		ExtentTest testSuite = extent.createTest("TC0001_createLead", "Create a Leadss");
		//This to Create a node for the entire steps in to one.So it ill collapsed inside reports after clicking on it ,the seperate screenshots ill be getting expanded.
		ExtentTest test = testSuite.createNode("Leads");
		test.assignCategory("smoke");
		test.assignAuthor("Sugirtha");
		test.pass("name data is passed", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		test.pass("passord data is passed",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap2.jpg").build());
		test.fail("butoon data is not clicked",MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap3.jpg").build());
		extent.flush(); 
		

	}
	

}

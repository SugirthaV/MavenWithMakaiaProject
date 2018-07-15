package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@CucumberOptions(features ="src/test/java/Feature/CreateLead.feature",glue = "tests",monochrome = true,tags ="@smoke or @sanity")
//monochrome is used to cut off or remove the unwanted characters in the console output
@RunWith(Cucumber.class)
public class runtest {
 
	
}

package test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lib.selenium.WebDriverServiceImpl;

public class LearnHooks extends WebDriverServiceImpl{
	
@Before 
public void beforeScenario(Scenario sc) {
	System.out.println(sc.getName());
	System.out.println(sc.getId());
	startReport();
}
@After 
public void afterScenario(Scenario sc) {
	System.out.println(sc.isFailed());
}

	 
}

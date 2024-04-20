package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features =  "Features/AdminLogin.feature",
//		glue = "stepDefination",
//		dryRun = false ,
//		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:reports/empresult.html"}
//	
//		)
//public class AdminLoginTest {
//
//}


@CucumberOptions(features= "Features/AdminLogin.feature", 
					glue = "stepDefination", dryRun= false,
					plugin = {"com.cucumber.listener.ExtentCucumberFormatter:reports/adminresult.html"})

public class AdminLoginTest extends AbstractTestNGCucumberTests{

	
}



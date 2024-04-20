package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "Features/Employee.feature",
		glue ="stepDefination",
		dryRun = false ,
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:reports/employeeresult.html"}
		
		
		)
public class EmployeeRegTest extends AbstractTestNGCucumberTests{

}

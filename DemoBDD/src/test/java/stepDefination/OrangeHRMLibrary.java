package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMLibrary{
	public static String empid;
	public WebDriver driver ;
	@Given("^i open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url) throws Throwable {
	  System.setProperty("webdriver.chrome.driver", "D:\\3.PROGRAM\\2.LIBRARY\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Then("^i should see login page$")
	public boolean i_should_see_login_page() throws Throwable {
		boolean res = driver.findElement(By.id("btnLogin")).isDisplayed();
		if (res) {
			return true;
		} else {
			return false;

		}
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String username) throws Throwable {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password) throws Throwable {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}

	@When("^i click login button$")
	public void i_click_login_button() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^i should see admin module$")
	public boolean i_should_see_admin_module() throws Throwable {
		boolean res = driver.findElement(By.linkText("Admin")).isDisplayed();
		if (res) {
			return true;
		} else {
			return false;
		}
	}

	@When("^i click logout$")
	public void i_click_logout() throws Throwable {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	

	@Then("^i close the browser$")
	public void i_close_the_browser() throws Throwable {

		driver.quit();
	}
	@Then("^i should see error message$")
	public void i_should_see_error_message() throws Throwable {
		String errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();

		if (errmsg.contains("invalid")) {
			System.out.println("System displayed error msg : pass");
		} else {
			System.out.println("System is not displayed error msg : fail");
		}
	}
	@When("^i goto add employee page$")
	public void i_goto_add_employee_page() {
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();

	}

	@When("^i enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String fname) {

		driver.findElement(By.id("firstName")).sendKeys(fname);
	}

	@When("^i enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lname) {
		driver.findElement(By.id("lastName")).sendKeys(lname);

	}

	@When("^i click save$")
	public void i_click_save() {
		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Emp id : " + empid);
		driver.findElement(By.id("btnSave")).click();

	}

	@Then("^i should see registred employee in employee list$")
	public void i_should_see_registred_employee_in_employee_list() {

		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();

		WebElement emplistTable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows = emplistTable.findElements(By.tagName("tr"));

		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> colmns = rows.get(i).findElements(By.tagName("td"));

			if (colmns.get(1).equals(empid)) {
				System.out.println("Employee registered sucessfully with empid : " + empid);
			}

		}

	}
}

package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.BDD.genericlib.BaseUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef extends BaseUtil {
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	}

	@Given("I enter the url {string}")
	public void i_enter_the_url(String url) {
		 driver.get(url);
		 }

	@When("Login page is displayed enter the username and password and click on login")
	public void login_page_is_displayed_enter_the_username_and_password_and_click_on_login() {
		 driver.findElement(By.name("user_name")).sendKeys("admin");
		    driver.findElement(By.name("user_password")).sendKeys("manju123");
		    driver.findElement(By.id("submitButton")).click();
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		String homeTitle=driver.getTitle();
		  Assert.assertEquals(homeTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		  driver.close();
	}


}

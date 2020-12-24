package hookClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BDD.genericlib.BaseUtil;
import com.BDD.genericlib.FileLib;
import com.BDD.genericlib.WebDriverCommonLib;
import com.BDD.objectRepository.HomePage;
import com.BDD.objectRepository.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook extends BaseUtil{
	BaseUtil base;
	WebDriverCommonLib wdlib=new WebDriverCommonLib();
	FileLib flib=new FileLib();
	public Hook(BaseUtil base) {
		this.base=base;
	}

	@Before(order = 0)
	public void setUp() throws Throwable {
		if(flib.getPropertyKeyValue("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}else if(flib.getPropertyKeyValue("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
		base.driver=new ChromeDriver();
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Before(order = 1)
	public void before() throws Throwable {
		base.driver.get(flib.getPropertyKeyValue("url"));
		lgPage=new LoginPage(base.driver);
		lgPage.login(flib.getPropertyKeyValue("username"), flib.getPropertyKeyValue("password"));
	}
	@After(order=1)
	public void tearDown(Scenario scenario) throws Throwable {
		if(scenario.isFailed()) {
			wdlib.getScreenshot(base.driver, scenario.getName());
		}
	}

	@After(order=0)
	public void after() {
		hmPage=new HomePage(base.driver);
		hmPage.signout();
		base.driver.quit();
	}

}

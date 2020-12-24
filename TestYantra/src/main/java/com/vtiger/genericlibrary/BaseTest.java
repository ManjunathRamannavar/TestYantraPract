package com.vtiger.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;


/**
 * This generic common class contain repeated action
 * @author Manjunath
 *
 */
public abstract class BaseTest implements IAutoConsts {

	public static WebDriver driver;
	public static String LoginPageTitle;
	public static FileLib flib=new FileLib();
	public static WebDriverCommonLib wdlib=new WebDriverCommonLib();
	
	/**
	 * This generic reusable method used to Open the browser,Enter URL and Verify
	 * @throws Throwable
	 */
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		String browser=flib.getPropKeyValue(PROP_PATH, "browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		String appUrl=flib.getPropKeyValue(PROP_PATH, "url");
		driver.get(appUrl);
		wdlib.waitForPage(flib.getPropKeyValue(PROP_PATH, "LoginPage"));
		wdlib.verify(wdlib.getPageTitle(), flib.getPropKeyValue(PROP_PATH, "LoginPage"), "Login page");
		
	}
	
	/**
	 * This generic reusable method is used to Login to application
	 * @throws Throwable
	 */
	@BeforeMethod
   public void clickLogin() throws Throwable
   	{
	   String un=flib.getPropKeyValue(PROP_PATH,"username");
	   String pwd=flib.getPropKeyValue(PROP_PATH, "password");
	   LoginPage lp=new LoginPage(driver);
	   lp.login(un, pwd);
	   wdlib.waitForPage(flib.getPropKeyValue(PROP_PATH, "HomePage"));
	   wdlib.verify(wdlib.getPageTitle(), flib.getPropKeyValue(PROP_PATH, "HomePage"), "Home Page");
	
   	}	
	
	
	/**
	 * This generic method used to sign out from application
	 * @throws Throwable
	 */
	@AfterMethod
	public void signOut() throws Throwable
	{
		
		HomePage hmpage=new HomePage();
		wdlib.mouseHover(hmpage.getLogoutImage());
		//Click on Sign-out
		wdlib.waitForElement(hmpage.getLogoutLink());
		hmpage.getLogoutLink().click();
		wdlib.waitForPage(flib.getPropKeyValue(PROP_PATH, "LoginPage"));
		//Verify the Sign-out
		wdlib.verify(wdlib.getPageTitle(), flib.getPropKeyValue(PROP_PATH, "LoginPage"), "Login page");
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
}


















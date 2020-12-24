package com.vtiger.genericlibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

/**
 * This generic class contains all the reusable components of the WebDriver
 * @author User
 *
 */

public class WebDriverCommonLib extends BaseTest {
	/**
	 * This generic reusable method is used to wait for page to display
	 * @param title
	 */
	public void waitForPage(String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This generic reusable method is used to wait for visibility of element in a page
	 * @param element
	 */
		
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This generic reusable method is used to wait for visibility of list elements in a page
	 * @param element
	 */
	public void waitForListElement(List<WebElement> element){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	/**
	 *   wait for element to be available
	 * @param driver
	 * @param elemnetXpath
	 * @throws InterruptedException
	 */
		public void waitForElementXpath(WebDriver driver , String elemnetXpath) throws InterruptedException {
			int count =0 ; 
			 while(count<40) {
				 try {
					 driver.findElement(By.xpath(elemnetXpath)).isEnabled();
					 break;
				 }catch (Exception e) {
					Thread.sleep(500);
					count ++;
				}
			 }
		}	
	
	/**
	 * This generic reusable method is used to wait for alert pop-up in a page
	 */
	public void waitForAlert()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This generic reusable method is used to get the page title of current page
	 * @return
	 */
	public String getPageTitle()
	{
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	/**
	 * This generic reusable method is used to check actual and expected result displayed in a page
	 * @param actual
	 * @param expected
	 * @param page
	 */
	public void verify(String actual,String expected,String page)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(page+" is Displayed",true);
	}
	
	/**
	 * this generic reusable method is used to check partial value visibility in a page.
	 * @param actual
	 * @param expected
	 * @param page
	 */
	public void verifyContains(String actual,String expected,String page){
		Assert.assertTrue(actual.contains(expected));
		Reporter.log(page+" is Displayed",true);
	}
	
	/**
	 * This generic reusable method is used to move the move point to particular element location in a page
	 * @param element
	 */
	public void mouseHover(WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This generic reusable method is used to do the mouse right click action on element in a page
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This generic reusable method is used to switch the frame from default frame to specified indexed of frame
	 * @param index
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This generic reusable method is used to switch the frame from default frame to specified value of frame
	 * @param id
	 */
	public void switchToFrame(String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This generic reusable method is used to switch the frame from default frame to specified element of frame
	 * @param element
	 */
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This generic reusable method is used to handle Drop-Down option by index 
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This generic reusable method is used to handle Drop-Down option by Visible Text
	 * @param element
	 * @param text
	 */
	public void selectOption(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This generic reusable method is used to handle Drop-Down option by Value 
	 * @param value
	 * @param element
	 */
	public void selectOption(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	
	/**
	 * This generic reusable method is used to handle alert pop-up
	 */
	
	public void handleAlert()
	{
		Alert al = driver.switchTo().alert();
		Reporter.log(al.getText()+" alert message displayed and handled ",true);
		al.accept();
	}
	/**
	 * This generic method used to take screenshot when test is failed
	 * @param name
	 * @throws Throwable
	 */
	public void takePageScreenShot(String name) throws Throwable{
		Date d=new Date();
		String mydate=new SimpleDateFormat("yyyyMMddhhmmss").format(d);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\mynotepad\\Selenium Notes\\SeleniumPrg\\vtiger_maven\\screenshots\\"+name+mydate+".png");
		Files.copy(src, dest);
	}
	
	
	
}

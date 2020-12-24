package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This generic class used for store the all element present in LoginPage Page
 * @author Manjunath
 *
 */
public class LoginPage {
	
	@FindBy(name="user_name") private WebElement untb;
	@FindBy(name="user_password") private WebElement pwdtb;
	@FindBy(id="submitButton") private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getUntb() {
		return untb;
	}
	public void setUntb(String un) {
		untb.sendKeys(un);
	}
	public WebElement getPwdtb() {
		return pwdtb;
	}
	public void setPwdtb(String pwd) {
		pwdtb.sendKeys(pwd);
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void login(String un,String pwd)
	{
		untb.sendKeys(un);
		pwdtb.sendKeys(pwd);
		loginBtn.click(); 
	}
	

	

}

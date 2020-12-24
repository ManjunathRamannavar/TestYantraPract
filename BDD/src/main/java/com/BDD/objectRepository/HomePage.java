package com.BDD.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BDD.genericlib.WebDriverCommonLib;


public class HomePage  {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']") private WebElement leadsLink;
	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']") private WebElement logoutImage;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement logoutLink;
	
	
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	public WebElement getLogoutImage() {
		return logoutImage;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void signout() {
		new WebDriverCommonLib().mouseHover(driver,logoutImage);
		logoutLink.click();
	}
	
	
	

}

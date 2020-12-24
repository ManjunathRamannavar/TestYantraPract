package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericlibrary.BaseTest;

public class HomePage extends BaseTest {
	
	
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']") private WebElement leadsLink;
	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']") private WebElement logoutImage;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement logoutLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	public WebElement getLogoutImage() {
		return logoutImage;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	
	
	

}

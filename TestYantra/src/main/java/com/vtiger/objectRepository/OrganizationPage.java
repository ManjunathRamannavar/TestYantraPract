package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericlibrary.BaseTest;

public class OrganizationPage extends BaseTest {

	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement orgPage;
	
	
	
	public OrganizationPage() {
		PageFactory.initElements(driver, this);
	}



	public WebElement getOrgPage() {
		return orgPage;
	}
	
	
	
	
	
}

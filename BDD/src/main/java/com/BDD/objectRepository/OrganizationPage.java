package com.BDD.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BDD.genericlib.BaseUtil;

public class OrganizationPage extends BaseUtil {

	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement orgPage;
	
	
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getOrgPage() {
		return orgPage;
	}
	
	
	
	
	
}

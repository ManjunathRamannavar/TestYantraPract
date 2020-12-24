package com.vtiger.objectRepository;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.vtiger.genericlibrary.BaseTest;

public class LeadsPage extends BaseTest {

	
	@FindBy(xpath="//img[@title='Create Lead...']") private WebElement createLeadBtn;
	@FindBy(xpath="//tr[contains(@id,'row')]/td[4]/a")private List<WebElement> leadName;
	
	
	
	public LeadsPage() {
		PageFactory.initElements(driver, this);
	}




	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public List<WebElement> getLeadName() {
		return leadName;
	}
	
	public void selectLead(String name){
			for (WebElement ele : leadName) {
				
				if(ele.getText().equals(name))
				{
					Reporter.log(ele.getText()+" is selected",true);
					ele.click();
					break;
				}
			}
			
			
		}
		
	}
	
	
	


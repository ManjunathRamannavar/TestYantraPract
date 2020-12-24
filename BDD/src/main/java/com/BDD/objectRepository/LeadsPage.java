package com.BDD.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.BDD.genericlib.BaseUtil;

public class LeadsPage extends BaseUtil {
	
	
	@FindBy(xpath="//img[@title='Create Lead...']") private WebElement createLeadBtn;
	@FindBy(xpath="//tr[contains(@id,'row')]/td[4]/a")private List<WebElement> leadName;
	
	
	
	public LeadsPage(WebDriver driver) {
		
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
	
	
	


package com.vtiger.objectRepository;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.genericlibrary.JavaUtils;

public class LeadInformationPage extends BaseTest {
	
	
	@FindBy(xpath="//span[text()='Creating New Lead']")private WebElement createNewPage;
	@FindBy(name="salutationtype")private  WebElement selbtn;
	@FindBy(name="firstname")private WebElement firstName;
	@FindBy(name="lastname")private WebElement lastName;
	@FindBy(name="company")private WebElement company;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveBtn;
	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement leadInfoPage;
	@FindBy(xpath="//a[text()='Convert Lead']")private WebElement covertLead;
	@FindBy(xpath="//td[contains(text(),'Convert Lead')]")private WebElement covertleadPopup;
	@FindBy(xpath="//input[@type='checkbox']")private List<WebElement> checkbox;
	@FindBy(xpath="//input[@type='checkbox']/following-sibling::b")private List<WebElement> checkboxLabel;
	@FindBy(xpath="//td[@class='moduleName']/a[text()='Leads']")private WebElement leadsLink;
	@FindBy(xpath="//img[@id='jscal_trigger_closedate']") private WebElement date;
	@FindBy(name="closingdate")private WebElement closeDateText;
	@FindBy(name="Save")private WebElement convertSave;
	
	public LeadInformationPage() {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateNewPage() {
		return createNewPage;
	}


	public WebElement getSelbtn() {
		return selbtn;
	}


	public WebElement getFirstName() {
		return firstName;
	}


	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getCompany() {
		return company;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getLeadInfoPage() {
		return leadInfoPage;
	}
	
	public WebElement getCovertLead() {
		return covertLead;
	}
	


	public WebElement getCovertleadPopup() {
		return covertleadPopup;
	}


	public List<WebElement> getCheckbox() {
		return checkbox;
	}


	public List<WebElement> getCheckboxLabel() {
		return checkboxLabel;
	}


	public WebElement getLeadsLink() {
		return leadsLink;
	}


	public WebElement getDate() {
		return date;
	}


	public WebElement getCloseDateText() {
		return closeDateText;
	}


	public WebElement getConvertSave() {
		return convertSave;
	}


	/**
	 * This method use to create new lead
	 * @throws Throwable
	 */
	public void createNewLead(String fname,String testName) throws Throwable{
		wdlib.selectOption(getSelbtn(),flib.getExcelData("Leads", testName, "Mr/Mrs"));
		firstName.sendKeys(fname);
		lastName.sendKeys(flib.getExcelData("Leads", testName, "LastName")+JavaUtils.getRanDomData());
		company.sendKeys(flib.getExcelData("Leads", testName, "Company")+JavaUtils.getRanDomData());
		saveBtn.click();
		
	}
	
	/**
	 * this method use to select all chechbox present in covert to lead pop-up
	 */
	public void selectAllCheckBox(){
		for (WebElement cbox : checkbox) {
			if(!cbox.isSelected()){
				cbox.click();
			}
		}
	
	}
	/**
	 * This method use to select particular check box in convert lead pop-up
	 * @param labelText
	 */
	public void selectParticularCheckBox(String labelText){
		
				if(checkboxLabel.get(0).getText().contains(labelText)){
					
					checkbox.get(2).click();
					Reporter.log(labelText+" Only selected",true);
				}
				else if(checkboxLabel.get(1).getText().contains(labelText))
				{
					checkbox.get(0).click();
					checkbox.get(1).click();
					checkbox.get(2).click();
					Reporter.log(labelText+" Only selected",true);
				}
				
	}
	
	/**
	 * this method use to convert date into yyyy/mm/dd format.
	 * @return
	 */
	public String ConvertDate(){
//		Date date=JavaUtils.getSystemDate();
//	    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	    String pattern = "yyyy-MM-dd";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	    String date = simpleDateFormat.format(new Date());
//	    System.out.println(date);
	    
//	    String s = df.format(date);
//	    String result = s;
//	    try {
//	        date=df.parse(result);
//	    } catch (ParseException e) {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
//	    }
	    return date;
	  }
/**
 * this method use to pass the date into text field
 */
	public void selectDate(){
		closeDateText.sendKeys(ConvertDate());
	}
	
}
 	
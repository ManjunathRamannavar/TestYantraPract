package com.vtiger.testscript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.genericlibrary.JavaUtils;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LeadInformationPage;
import com.vtiger.objectRepository.LeadsPage;
import com.vtiger.objectRepository.OrganizationPage;


@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class ConvertLeadsToOrganizationBySelectingAllCheckBoxTest extends BaseTest  {

	@Test
	public void convertLeadtToOraganization() throws Throwable{
		HomePage hm=new HomePage();
		LeadsPage ldpage=new LeadsPage();
		LeadInformationPage ldInfoPage=new LeadInformationPage();
		OrganizationPage rgpage=new OrganizationPage();
		//Click on Leads 
		hm.getLeadsLink().click();
		assertTrue(ldInfoPage.getLeadsLink().getText().contains("Leads"));
		//click create lead icon
		ldpage.getCreateLeadBtn().click();		
		//create new Lead
		String fname=flib.getExcelData("Leads", "tc_22", "FirstName")+JavaUtils.getRanDomData();
		ldInfoPage.createNewLead(fname,"tc_22");
		assertTrue(ldInfoPage.getLeadInfoPage().getText().contains("Lead Information"));
		//click on leads
		ldInfoPage.getLeadsLink().click();
		assertTrue(ldInfoPage.getLeadsLink().getText().contains("Leads"));
		//select lead
		ldpage.selectLead(fname);
		//wait for page to be load
		wdlib.waitForElement(ldInfoPage.getCovertLead());
		//click on convert lead link
		ldInfoPage.getCovertLead().click();
		//wait for pop-up
		wdlib.waitForElement(ldInfoPage.getCovertleadPopup());
		//verify the pop-up
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(ldInfoPage.getCovertleadPopup().getText().contains("Convert Lead"));
		//select the all check box on pop-up
		ldInfoPage.selectAllCheckBox();
		//select the close date
		ldInfoPage.selectDate();
		//click on save
		ldInfoPage.getConvertSave().click();
		//verify organization page.
		wdlib.verifyContains(rgpage.getOrgPage().getText(), flib.getExcelData("Leads", "tc_22", "orgPage"), rgpage.getOrgPage().getText());
		sa.assertAll();
		
	}
	
}

package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.BDD.genericlib.BaseUtil;
import com.BDD.genericlib.JavaUtils;
import com.BDD.genericlib.WebDriverCommonLib;
import com.BDD.objectRepository.HomePage;
import com.BDD.objectRepository.LeadInformationPage;
import com.BDD.objectRepository.LeadsPage;
import com.BDD.objectRepository.OrganizationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadsStepDef extends BaseUtil {
	BaseUtil base;
	List<Map<String, String>> data;
	static String fname=""; 
	public LeadsStepDef(BaseUtil base) {
		this.base=base;
	}
	
	@When("I want to click on Leads link in homepage")
	public void i_want_to_click_on_leads_link_in_homepage() {
		//Click on Leads 
		hmPage=new HomePage(base.driver);
		ldInfoPage=new LeadInformationPage(base.driver);
		hmPage.getLeadsLink().click();
		assertTrue(ldInfoPage.getLeadsLink().getText().contains("Leads"));
	    
	}
	
	@When("I will click on create Lead link")
	public void i_will_click_on_create_lead_link() {
		//click create lead icon
		ldPage=new LeadsPage(base.driver);
		ldPage.getCreateLeadBtn().click();	
	}
	
	@When("I create an Lead using mandatory fileds and click on save")
	public void i_create_an_lead_using_mandatory_fileds_and_click_on_save(DataTable dataTable) throws Throwable {
		//create new Lead
		ldInfoPage=new LeadInformationPage(base.driver);
		data = dataTable.asMaps(String.class, String.class);
		String selOption=data.get(0).get("SelOption");
		fname=data.get(0).get("FirstName")+JavaUtils.getRanDomData();
		String lname=data.get(0).get("LastName")+JavaUtils.getRanDomData();
		String company=data.get(0).get("Company")+JavaUtils.getRanDomData();
		
		ldInfoPage.createNewLead(selOption,fname,lname,company);
	}
	
	@Then("Lead information page should display and go back to Lead page")
	public void lead_information_page_should_display_and_go_back_to_lead_page() {
		ldInfoPage=new LeadInformationPage(base.driver);
		assertTrue(ldInfoPage.getLeadInfoPage().getText().contains("Lead Information"));
		//Go back to leads page
		ldInfoPage.getLeadsLink().click();
		assertTrue(ldInfoPage.getLeadsLink().getText().contains("Leads"));
	}
	
	
	@When("I want to select lead from reacord in LeadsPage")
	public void i_want_to_select_lead_from_reacord_in_leads_page() {
		//select lead
		ldPage=new LeadsPage(base.driver);
		ldPage.selectLead(fname);
	
	}
	
	
	
	@Then("Selected lead information page should display")
	public void selected_lead_information_page_should_display() {
		ldInfoPage=new LeadInformationPage(base.driver);
		wdlib=new WebDriverCommonLib();
		wdlib.verifyContains(ldInfoPage.getLeadInfoPage().getText(),"Lead Information",ldInfoPage.getLeadInfoPage().getText());
	}
	
	@Then("I will click on Convert Lead from Actions")
	public void i_will_click_on_convert_lead_from_actions() {
		ldInfoPage=new LeadInformationPage(base.driver);
		wdlib=new WebDriverCommonLib();
		//wait for page to be load
		wdlib.waitForElement(base.driver,ldInfoPage.getCovertLead());
		//click on convert lead link
		ldInfoPage.getCovertLead().click();
		//wait for pop-up
		wdlib.waitForElement(base.driver,ldInfoPage.getCovertleadPopup());
	}
	@Then("Convert Lead pop-up should display")
	public void convert_lead_pop_up_should_display() {
		ldInfoPage=new LeadInformationPage(base.driver);
		wdlib=new WebDriverCommonLib();
		//verify the pop-up
		wdlib.verifyContains(ldInfoPage.getCovertleadPopup().getText(),"Convert Lead",ldInfoPage.getCovertleadPopup().getText());

	}
	
	@Then("Select all the check box from pop-up and fill all mandatory field and click on save")
	public void select_all_the_check_box_from_pop_up_and_fill_all_mandatory_field_and_click_on_save(io.cucumber.datatable.DataTable dataTable) {
		ldInfoPage=new LeadInformationPage(base.driver);
		//select the all check box on pop-up
		ldInfoPage.selectAllCheckBox();
		//select the close date
		ldInfoPage.selectDate();
		//click on save
		ldInfoPage.getConvertSave().click();
		
	}

	@Then("Organization Information page should display")
	public void organization_information_page_should_display() {
		//verify organization page.
		wdlib=new WebDriverCommonLib();
		orgPage=new OrganizationPage(base.driver);
		wdlib.verifyContains(orgPage.getOrgPage().getText(),"Organization Information" , orgPage.getOrgPage().getText());
	}

	
}

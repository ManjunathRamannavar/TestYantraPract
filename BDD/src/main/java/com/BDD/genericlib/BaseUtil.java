package com.BDD.genericlib;

import org.openqa.selenium.WebDriver;

import com.BDD.objectRepository.HomePage;
import com.BDD.objectRepository.LeadInformationPage;
import com.BDD.objectRepository.LeadsPage;
import com.BDD.objectRepository.LoginPage;
import com.BDD.objectRepository.OrganizationPage;


public class BaseUtil {
	
	public  WebDriver driver;
	public LoginPage lgPage;
	public HomePage hmPage;
	public LeadsPage ldPage;
	public LeadInformationPage ldInfoPage;
	public OrganizationPage orgPage;
	public WebDriverCommonLib wdlib;
	public FileLib flib;
	
}

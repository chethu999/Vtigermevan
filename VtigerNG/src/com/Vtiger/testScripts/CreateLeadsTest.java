package com.Vtiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.Vtiger.ObjectRepo.CreateLead;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;

public class CreateLeadsTest extends BaseConfig
{
	CreateLead lead;
	FileLib fl = new FileLib();
	
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Leads");
	}
	@Test(dataProvider = "readData")
	public void createLeadTest(String firstName,String lastName,String company,String leadsource,
			String	industry,String annualrevenue,String noofemployees)
	{
		lead = PageFactory.initElements(driver, CreateLead.class);
		
		lead.getLeadsLink().click();
		Reporter.log("clicked on leads link",true);
		
		lead.getCreateLeadLink().click();
		Reporter.log("clicked on create leads link",true);
		
		lead.getFirstame().sendKeys(firstName);
		Reporter.log("entered firstname into TF",true);
		
		lead.getLastname().sendKeys(lastName);
		Reporter.log("entered lastname into TF",true);
		
		lead.getCompanyTF().sendKeys(company);
		Reporter.log("entered comapny name",true);
		
		lead.selectLeadSource(leadsource);
		Reporter.log("selected lead source",true);
		
		lead.selectIndustry(industry);
		Reporter.log("selected industry type",true);
		
		lead.getAnnualrevenue().sendKeys(annualrevenue);
		Reporter.log("entered annualrevenue into TF",true);
		
		lead.getNoofemployees().sendKeys(noofemployees);
		Reporter.log("entered noofemployees into TF",true);
		
		lead.getSaveButton().click();
		Reporter.log("clicked on save button",true);;
		
	}
}

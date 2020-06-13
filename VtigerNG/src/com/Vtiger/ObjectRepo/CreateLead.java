package com.Vtiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.genericLib.Utility;

public class CreateLead
{
	@FindBy(linkText = "Leads")
	WebElement leadsLink;
	
	@FindBy(xpath = "//img[@title='Create Lead...']")
	WebElement createLeadLink;
	
	@FindBy(name = "firstname")
	WebElement firstname;
	
	@FindBy(name = "lastname")
	WebElement lastname;
	
	@FindBy(name = "company")
	WebElement companyTF;
	
	@FindBy(name = "leadsource")
	WebElement leadsource;
	
	@FindBy(name = "industry")
	WebElement industry;
	
	@FindBy(name = "annualrevenue")
	WebElement annualrevenue;
	
	@FindBy(id = "noofemployees")
	WebElement noofemployees;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveButton;
	//providing getter methods
	
	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getFirstame() {
		return firstname;
	}
	
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCreateLeadLink() {
		return createLeadLink;
	}

	public WebElement getCompanyTF() {
		return companyTF;
	}

	public WebElement getLeadsource() {
		return leadsource;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getAnnualrevenue() {
		return annualrevenue;
	}

	public WebElement getNoofemployees() {
		return noofemployees;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

	//business logic
	public void selectLeadSource(String val)
	{
		Utility.singleSelectDD(leadsource, val);
	}
	public void selectIndustry(String val)
	{
		Utility.singleSelectDD(industry, val);
	}
	
}

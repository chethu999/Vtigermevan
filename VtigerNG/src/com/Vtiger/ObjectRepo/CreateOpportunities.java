package com.Vtiger.ObjectRepo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.sun.source.doctree.LinkTree;
import com.Vtiger.genericLib.Utility;

public class CreateOpportunities 
{
	@FindBy(linkText = "Opportunities")
	WebElement opportunitiesLink;

	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	WebElement createOpportunityLink;

	@FindBy(name = "potentialname")
	WebElement opportunityNameTF;

	@FindBy(xpath = "//input[@id='related_to_display']/../img[@title='Select']")
	WebElement selectOrgLink;

	@FindBy(xpath = "//select[@name='opportunity_type']")
	WebElement typeDropDownSelect;

	@FindBy(xpath = "//select[@name='leadsource']")
	WebElement leadSourceDDSelect;

	@FindBy(xpath = "//select[@name='sales_stage']")
	WebElement saleStageDDSelect;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveButton;

	@FindBy(xpath = "//img[@id='jscal_trigger_closingdate']")
	WebElement expectedCloseDate;

	//providing getter methods
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getCreateOpportunityLink() {
		return createOpportunityLink;
	}

	public WebElement getOpportunityNameTF() {
		return opportunityNameTF;
	}

	public WebElement getSelectOrgLink() {
		return selectOrgLink;
	}

	public WebElement getTypeDropDownSelect() {
		return typeDropDownSelect;
	}

	public WebElement getLeadSourceDDSelect() {
		return leadSourceDDSelect;
	}

	public WebElement getSaleStageDDSelect() {
		return saleStageDDSelect;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	//Business logic
	public void selectOrg(WebDriver driver,String orgName) 
	{
		selectOrgLink.click();
		Reporter.log("clicked on Org link",true);
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();

		driver.switchTo().window(cid);
		Reporter.log("switched to child browser",true);
		driver.findElement(By.linkText(orgName)).click();
		driver.switchTo().window(pid);
		Reporter.log("switched to parent browser",true);
	}

	public void dropDownSelectType( String type)
	{
		WebElement el = typeDropDownSelect;
		Utility.singleSelectDD(el, type);
	}


}

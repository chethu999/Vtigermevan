package com.Vtiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateOrg 
{
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLink;
	
	@FindBy(name = "accountname")
	private WebElement accountnameTF;
	
	@FindBy(name = "website")
	private WebElement websiteTF;
	
	@FindBy(id = "employees")
	private WebElement employeesTF;
	
	@FindBy(xpath = "//select[@name='industry']//option[@value='\"+Industry+\"']")
	private WebElement industryTF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(.,'Organization ')]")
	private WebElement actualOrganizationName;
	
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement organizationsLink;

	//providing getter methods
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}

	public WebElement getAccountnameTF() {
		return accountnameTF;
	}

	public WebElement getWebsiteTF() {
		return websiteTF;
	}

	public WebElement getEmployeesTF() {
		return employeesTF;
	}

	public WebElement getIndustryTF() {
		return industryTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getActualOrganizationName() {
		return actualOrganizationName;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	
	//Business Logic
	public void clickOrgLink()
	{
		createOrgLink.click();
	}
	public void clickCreateOrg()
	{
		createOrgLink.click();
	}
	public void enterOganizationName(String org_name)
	{
		accountnameTF.sendKeys(org_name);
	}
	public void website(String web)
	{
		websiteTF.sendKeys(web);
	}
	public void employees(String emp)
	{
		employeesTF.sendKeys(emp);
	}
	public void industry(String industry)
	{
		industryTF.sendKeys(industry);
	}
	public void save()
	{
		saveButton.click();
	}
	public void actualOrgName(String org_name)
	{
		String actualOrgName = actualOrganizationName.getText();
		Assert.assertTrue(actualOrgName.contains(org_name));
	}
}

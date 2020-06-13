package com.Vtiger.ObjectRepo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CreateContact 
{
	@FindBy(xpath = "//img[@title='Create Contact...']")
	WebElement createContactLink;

	@FindBy(name = "firstname")
	WebElement firstNameTF;

	@FindBy(name = "lastname")
	WebElement lastNameTF;

	@FindBy(xpath = "//input[@name='account_name']/../img[@title='Select']")
	WebElement orgSelectTF;

	//	@FindBy(linkText = "")

	@FindBy(id = "email")
	WebElement emailTF;

	@FindBy(id = "mobile")
	WebElement mobileTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),'Contact Information')]")
	WebElement actualInfo;
	
	//providing getter methods
	public WebElement getCreateContactLink() {
		return createContactLink;
	}

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getOrgSelectTF() {
		return orgSelectTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}
	public WebElement getSaveBuuton() {
		return saveButton;
	}
	public WebElement getActualInfo()
	{
		return actualInfo;
	}

	//business logic
	
	public void selectOrgName(WebDriver driver,String name)
	{
		orgSelectTF.click();
		Reporter.log("clicked on select Organization button",true);
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		
		driver.switchTo().window(cid);
		Reporter.log("switched to childe browser",true);
		driver.findElement(By.linkText(name)).click();
		Reporter.log("selected Organization name",true);
		driver.switchTo().window(pid);
		Reporter.log("switched back to parent browser",true);
	}
	public boolean conformation(String name)
	{
		return  actualInfo.getText().contains(name);
	}


}

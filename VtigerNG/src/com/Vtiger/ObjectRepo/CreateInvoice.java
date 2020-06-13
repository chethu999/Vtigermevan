package com.Vtiger.ObjectRepo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.Vtiger.genericLib.Utility;

public class CreateInvoice {

	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoiceLink;
	
	@FindBy(xpath = "//img[@title='Create Invoice...']")
	private WebElement createInvoiceLink;
	
	@FindBy(name = "subject")
	private WebElement subjectTF;
	
	@FindBy(xpath = "//input[@name='contact_name']/../img[@title='Select']")
	private WebElement contactName;
	
	@FindBy(xpath = "//input[@id='single_accountid']/../img[@title='Select']")
	private WebElement orgName;
	
	@FindBy(name = "bill_street")
	private WebElement billStreetTF;
	
	@FindBy(name = "ship_street")
	private WebElement shipStreetTF;
	
	@FindBy(id = "searchIcon1")
	private WebElement searchIcon1Button;
	
	@FindBy(id = "qty1")
	private WebElement qty1TF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),'Invoice Information')]")
	private WebElement info;

	//providing getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getCreateInvoiceLink() {
		return createInvoiceLink;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getBillStreetTF() {
		return billStreetTF;
	}

	public WebElement getShipStreetTF() {
		return shipStreetTF;
	}

	public WebElement getSearchIcon1Button() {
		return searchIcon1Button;
	}

	public WebElement getQty1TF() {
		return qty1TF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getInfo() {
		return info;
	}
	
	//providing business logic
	public void mousHoverMoreLink(WebDriver driver)
	{
		Utility.moveToElement(driver, moreLink);
	}
	public void contactName(WebDriver driver,String name)
	{
		contactName.click();
		Reporter.log("clicked on contact name",true);
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		driver.switchTo().window(cid);
		Reporter.log("switched to child browser",true);
		driver.findElement(By.linkText(name)).click();
		Alert alr =  driver.switchTo().alert();
		alr.accept();
		driver.switchTo().window(pid);
		Reporter.log("switched to parent browser",true);
	}
	public void orgName(String name,WebDriver driver)
	{
		orgName.click();
		Reporter.log("clicked on organization name",true);
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		driver.switchTo().window(cid);
		Reporter.log("switched to child browser",true);
		driver.findElement(By.linkText(name)).click();
		Alert alr =  driver.switchTo().alert();
		alr.accept();
		driver.switchTo().window(pid);
		Reporter.log("switched to parent browser",true);
	}
	public void searchProduct(String item, WebDriver driver)
	{
		searchIcon1Button.click();
		Reporter.log("clicked on select item",true);
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		driver.switchTo().window(cid);
		Reporter.log("switched to child browser",true);
		driver.findElement(By.linkText(item)).click();
		driver.switchTo().window(pid);
		Reporter.log("switched to parent browser",true);
	}
	
}

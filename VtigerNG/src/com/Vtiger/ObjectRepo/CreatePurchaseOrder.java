package com.Vtiger.ObjectRepo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.Vtiger.genericLib.Utility;

public class CreatePurchaseOrder 
{
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseorderLink;
	
	@FindBy(xpath = "//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseorderLink;
	
	@FindBy(name = "subject")
	private WebElement subjectTF;
	
	@FindBy(xpath = "//input[@name='vendor_name']/../img[@title='Select']")
	private WebElement selectVendor;
	
	@FindBy(name = "postatus")
	private WebElement status;
	
	@FindBy(name = "bill_street")
	private WebElement billstreet;
	
	@FindBy(name = "ship_street")
	private WebElement shipstreet;
	
	@FindBy(id = "searchIcon1")
	private WebElement searchIcon;
	
	@FindBy(id = "search_txt")
	private WebElement searchProd;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	@FindBy(name = "qty1")
	private WebElement qty;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getPurchaseorderLink() {
		return purchaseorderLink;
	}

	public WebElement getCreatePurchaseorderLink() {
		return createPurchaseorderLink;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getSelectVendor() {
		return selectVendor;
	}

	public WebElement getStatus() {
		return status;
	}
	public WebElement getBillstreet() {
		return billstreet;
	}
	public WebElement getShipstreet() {
		return shipstreet;
	}
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	public WebElement getQty() {
		return qty;
	}
	public WebElement getSearchProd() {
		return searchProd;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	//business logic
	public void mouseHoverMore(WebDriver driver)
	{
		Utility.moveToElement(driver, moreLink);
	}
	public void selectVendor(String name,WebDriver driver)
	{
		selectVendor.click();
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		
		driver.switchTo().window(cid);
		driver.findElement(By.linkText(name)).click();;
		driver.switchTo().window(pid);
	}
	public void selectStatus(String val)
	{
		Utility.singleSelectDD(status, val);
	}
	public void selectItemNAme(String name,WebDriver driver)
	{
		searchIcon.click();
		Reporter.log("clicked on searchIcon",true);
		
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		
		driver.switchTo().window(cid);
		Reporter.log("switched to child browser",true);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
//		searchProd.click();
		searchProd.sendKeys(name);
		Reporter.log(name+" entered in search field",true);
		searchButton.click();
		Reporter.log("clicked on search button",true);
		
		driver.findElement(By.linkText(name)).click();
		Reporter.log("selected item is -->"+name,true);
		driver.switchTo().window(pid);
		Reporter.log("switched to parent browser",true);
	}
}

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

public class CreateQuotes
{
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Quotes")
	private WebElement QuotesLink;
	
	@FindBy(xpath = "//img[@title='Create Quote...']")
	private WebElement createQuotationLink;
	
	@FindBy(name = "subject")
	private WebElement subjectTF;
	
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
	
	@FindBy(xpath = "//span[contains(text(),'Quote Information')]")
	private WebElement info;

	//providing getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getQuotesLink() {
		return QuotesLink;
	}

	public WebElement getCreateQuotationLink() {
		return createQuotationLink;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getOrgName() {
		return orgName;
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
	
	public WebElement getBillStreetTF() {
		return billStreetTF;
	}

	public WebElement getShipStreetTF() {
		return shipStreetTF;
	}

	//providing business logic
	public void mousHoverMoreLink(WebDriver driver)
	{
		Utility.moveToElement(driver, moreLink);
	}
	public void orgName(String name,WebDriver driver)
	{
		orgName.click();
		Reporter.log("clicked on organizatio button",true);
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		driver.switchTo().window(cid);
		Reporter.log("switched to child browser",true);
		driver.findElement(By.linkText(name)).click();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.switchTo().window(pid);
		Reporter.log("switched to parent browser",true);
	}
	public void searchProduct(String item, WebDriver driver)
	{
		searchIcon1Button.click();
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		driver.switchTo().window(cid);
		driver.findElement(By.linkText(item)).click();
		driver.switchTo().window(pid);
	}
	
	

}

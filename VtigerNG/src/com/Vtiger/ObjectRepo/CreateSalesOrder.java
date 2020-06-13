package com.Vtiger.ObjectRepo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.genericLib.Utility;



public class CreateSalesOrder 
{
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderLink;
	
	@FindBy(xpath = "//img[@title='Create Sales Order...']")
	private WebElement createSaleOrderLink;
	
	@FindBy(name = "subject")
	private WebElement subjectTF;
	
	@FindBy(name = "sostatus")
	private WebElement statusSelect;
	
	@FindBy(name = "customerno")
	private WebElement customernoTF;
	
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
	WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),'Sales Order Information')]")
	private WebElement info;

	//providing getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getCreateSaleOrderLink() {
		return createSaleOrderLink;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getStatusSelect() {
		return statusSelect;
	}

	public WebElement getCustomernoTF() {
		return customernoTF;
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

	public WebElement getInfo() {
		return info;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	//business logic
	public void mouseHoverSales(WebDriver driver)
	{
		Utility.moveToElement(driver, moreLink);
	}
	public void dropDownSelect(String val)
	{
		Utility.singleSelectDD(statusSelect, val);
	}
	public void selectOrgName(String name,WebDriver driver)
	{
		orgName.click();
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		
		driver.switchTo().window(cid);
		driver.findElement(By.linkText(name)).click();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.switchTo().window(pid);
	}
	public void selectProduct(WebDriver driver,String prod)
	{
		searchIcon1Button.click();
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();
		
		driver.switchTo().window(cid);
		driver.findElement(By.linkText(prod)).click();
		driver.switchTo().window(pid);	
	}
	public boolean confermation(String actual)
	{
		return actual.contains(info.getText());
	}
	
	
}

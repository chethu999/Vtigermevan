package com.Vtiger.ObjectRepo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.genericLib.Utility;

public class CreateProduct
{
	@FindBy(linkText = "Products")
	WebElement productsLink;
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	WebElement createProdcutLink;
	
	@FindBy(name = "productname")
	WebElement productnameTF;
	
	@FindBy(name = "productcategory")
	WebElement productcategoryDropDown;
	
	@FindBy(xpath = "//img[@title='Select']")
	WebElement selectVendor;
	
	@FindBy(name = "glacct")
	WebElement glAcct;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveButton;
	
	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCreateProdcutLink() {
		return createProdcutLink;
	}

	public WebElement getProductnameTF() {
		return productnameTF;
	}

	public WebElement getProductcategoryDropDown() {
		return productcategoryDropDown;
	}

	public WebElement getSelectVendor() {
		return selectVendor;
	}

	public WebElement getGlAcct() {
		return glAcct;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	public void selectProdcutCategery(String val)
	{
		WebElement el = productcategoryDropDown;
		Utility.singleSelectDD(el, val);
	}
	
	public void selectVendor(WebDriver driver, String vendorName)
	{
		selectVendor.click();
		
		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> it = setStr.iterator();
		String pid = it.next();
		String cid = it.next();
		
		driver.switchTo().window(cid);
		driver.findElement(By.linkText(vendorName)).click();;
		driver.switchTo().window(pid);
	}
	public void glAccountSelect(String val)
	{
		WebElement el = glAcct;
		Utility.singleSelectDD(el, val);
	}
}

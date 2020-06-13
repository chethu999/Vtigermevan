package com.Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.Utility;

public class Home extends BaseConfig
{
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement userIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Organizations")
	WebElement organizationsLink;
	
	@FindBy(linkText = "Contacts")
	WebElement contactsLink;
	
	@FindBy(linkText = "Opportunities")
	WebElement opportunitiesLink;
	
	@FindBy(linkText = "Products")
	WebElement productsLink;
	
	@FindBy(linkText = "More")
	WebElement moreLink;
	
	@FindBy(linkText = "Vendors")
	WebElement vendorsLink;
	
	public WebElement getUserIcon() {
		return userIcon;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getVendorsLink() {
		return vendorsLink;
	}
	
	//Business logic for Signout
	public void signOut(WebDriver driver)
	{
		Utility.moveToElement(driver, userIcon);
		signOutLink.click();
	}
	//Business logic for Organization
	public void clickOrganizationLink()
	{
		organizationsLink.click();
	}
	
}

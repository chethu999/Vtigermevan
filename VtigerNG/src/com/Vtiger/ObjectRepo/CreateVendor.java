package com.Vtiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateVendor 
{
	@FindBy(linkText = "More")
	WebElement moreLink;
	
	@FindBy(linkText = "Vendors")
	WebElement vendorsLink;
	
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	WebElement createVendorLink;
	
	@FindBy(name = "vendorname")
	WebElement vendornameTF;
	
	@FindBy(id = "email")
	WebElement emailTF;
	
	@FindBy(id = "phone")
	WebElement phoneTF;
	
	@FindBy(name = "website")
	WebElement websiteTF;
	
	@FindBy(name = "street")
	WebElement streetTF;
	
	@FindBy(id = "city")
	WebElement cityTF;
	
	@FindBy(id = "postalcode")
	WebElement postalcodeTF;
	
	@FindBy(id = "pobox")
	WebElement poboxTF;
	
	@FindBy(id = "state")
	WebElement stateTF;
	
	@FindBy(id = "country")
	WebElement countryTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),'Vendor Information')]")
	WebElement actualInfo;

	
	//providing getter methos
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getCreateVendorLink() {
		return createVendorLink;
	}

	public WebElement getVendornameTF() {
		return vendornameTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getPhoneTF() {
		return phoneTF;
	}

	public WebElement getWebsiteTF() {
		return websiteTF;
	}

	public WebElement getStreetTF() {
		return streetTF;
	}

	public WebElement getCityTF() {
		return cityTF;
	}

	public WebElement getPostalcodeTF() {
		return postalcodeTF;
	}

	public WebElement getPoboxTF() {
		return poboxTF;
	}

	public WebElement getStateTF() {
		return stateTF;
	}

	public WebElement getCountryTF() {
		return countryTF;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	public WebElement getActualInfo() {
		return actualInfo;
	}
	
	
	//Business logic
	public boolean confirmation(String name)
	{
		return actualInfo.getText().contains(name);
	}
	
	
	
}

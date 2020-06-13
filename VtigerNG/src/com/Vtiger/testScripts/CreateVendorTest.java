package com.Vtiger.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepo.CreateVendor;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;
import com.Vtiger.genericLib.Utility;

public class CreateVendorTest extends BaseConfig
{
	CreateVendor vend ;

	FileLib fl = new FileLib();

	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Vendors");
	}
	@Test(dataProvider = "readData")
	public void cretaeVendrTest(String vendorName,String email,String phone,String	website,String	street,String city,
			String postalcode,String	pobox,String state,String country)
	{
		//		String vendorName="lenovo";
		//		WebElement el=driver.findElement(By.linkText("More"));
		//		Utility.moveToElement(driver, el);
		vend = PageFactory.initElements(driver, CreateVendor.class);
		WebElement el = vend.getMoreLink();
		Utility.moveToElement(driver, el);
		Reporter.log("mouse hovered on more link",true);

		//		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		vend.getVendorsLink().click();
		Reporter.log("clicked on vendor link", true);

		//		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		vend.getCreateVendorLink().click();
		Reporter.log("clicked on creater vendor",true);

		//		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		vend.getVendornameTF().sendKeys(vendorName);
		Reporter.log("entered vendor name",true);

		vend.getEmailTF().sendKeys(email);
		Reporter.log("entered vendored email id",true);

		vend.getPhoneTF().sendKeys(phone);
		Reporter.log("entered vendored phone no",true);

		//		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		vend.getSaveButton().click();
		Reporter.log("cliked on save button",true);

		//		String actul=driver.findElement(By.xpath("//span[contains(.,'Vendor Information')]")).getText();
		//		Assert.assertTrue(actul.contains(vendorName));
		Assert.assertTrue(vend.confirmation(vendorName));
		Reporter.log("vendor is created successfully",true);
		
//		driver.findElement(By.linkText("Vendors")).click();
		vend.getVendorsLink().click();
		Reporter.log("clicked on vendors link-->home page displayed",true);
	}
}

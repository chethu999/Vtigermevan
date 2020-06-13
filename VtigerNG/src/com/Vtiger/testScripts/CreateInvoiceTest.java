package com.Vtiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepo.CreateInvoice;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;



public class CreateInvoiceTest extends BaseConfig {

	CreateInvoice invoice;
	FileLib fl = new FileLib();
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Invoice");
	}
	@Test(dataProvider = "readData")
	public void createInvoiceTest(String subject,String	contactName,String orgName,String billinhAddress,String	shippingAddress,
			String item,String qty)
	{
		invoice = PageFactory.initElements(driver, CreateInvoice.class);
		
		invoice.mousHoverMoreLink(driver);
		Reporter.log("mouse hovered on more link",true);
		
		invoice.getInvoiceLink().click();
		Reporter.log("clicked on Invoice Link",true);
		
		invoice.getCreateInvoiceLink().click();
		Reporter.log("clicked on create invoice link",true);
		
		invoice.getSubjectTF().sendKeys(subject);
		Reporter.log(subject+" <-- entered ",true);
		
		invoice.contactName(driver, contactName);
		Reporter.log("selected contact name",true);
		
		invoice.orgName(orgName, driver);
		Reporter.log("selected org name",true);
		
		invoice.getBillStreetTF().sendKeys(billinhAddress);
		Reporter.log("entered billing address",true);
		
		invoice.getShipStreetTF().sendKeys(shippingAddress);
		Reporter.log("entered shipping address",true);
		
		invoice.searchProduct(item, driver);
		Reporter.log("selected item -->"+item,true);
		
		invoice.getQty1TF().sendKeys(qty);
		Reporter.log("selected qty -->"+qty,true);
		
		invoice.getSaveButton().click();
		Reporter.log("clicked on save button",true);
	}
}

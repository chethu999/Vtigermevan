package com.Vtiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepo.CreateQuotes;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;

public class CreateQuotesTest extends BaseConfig
{
	CreateQuotes quotes;
	FileLib fl = new FileLib();
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Quotes");
	}
	@Test(dataProvider = "readData")
	public void createQuoteTest(String subject,String orgName,String billinhAddress,String shippingAddress,
			String item,String qty)
	{
		quotes = PageFactory.initElements(driver, CreateQuotes.class);
		
		quotes.mousHoverMoreLink(driver);
		Reporter.log("mouse hovered on more link",true);
		
		quotes.getQuotesLink().click();
		Reporter.log("clicked on Quotes Link",true);
		
		quotes.getCreateQuotationLink().click();
		Reporter.log("clicked on create quotes link",true);
		
		quotes.getSubjectTF().sendKeys(subject);
		Reporter.log(subject+" <-- entered ",true);
		
		quotes.orgName(orgName, driver);
		Reporter.log("selected org name",true);
		
		quotes.getBillStreetTF().sendKeys(billinhAddress);
		Reporter.log("entered billing address",true);
		
		quotes.getShipStreetTF().sendKeys(shippingAddress);
		Reporter.log("entered shipping address",true);
		
		quotes.searchProduct(item, driver);
		Reporter.log("selected item -->"+item,true);
		
		quotes.getQty1TF().sendKeys(qty);
		Reporter.log("selected qty -->"+qty,true);
		
		quotes.getSaveButton().click();
		Reporter.log("clicked on save button",true);
	}
}

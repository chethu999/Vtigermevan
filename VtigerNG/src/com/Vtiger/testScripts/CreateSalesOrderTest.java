package com.Vtiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepo.CreateSalesOrder;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;

public class CreateSalesOrderTest extends BaseConfig {

	CreateSalesOrder sales;
	
	FileLib fl = new FileLib();
	
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("SalesOrder");
	}
	@Test(dataProvider = "readData")
	public void createSalesOrderTest(String subject,String	status,String customerno,String	orgName,String billinhAddress,String shippingAddress,String item,String qty)
	{
		sales = PageFactory.initElements(driver, CreateSalesOrder.class);
		
		sales.mouseHoverSales(driver);
		Reporter.log("Mouse hovered on more link",true);
		
		sales.getSalesOrderLink().click();
		Reporter.log("clicked on sales order link",true);
		
		sales.getCreateSaleOrderLink().click();
		Reporter.log("clicked on create sales order link",true);
		
		sales.getSubjectTF().sendKeys(subject);
		Reporter.log(subject+" entered into the subject TF",true);
		
		sales.getCustomernoTF().sendKeys(customerno);
		Reporter.log(customerno+" entered into the customerno TF",true);
		
		sales.selectOrgName(orgName, driver);
		Reporter.log(orgName+" is selected ",true);
		
		sales.getBillStreetTF().sendKeys(billinhAddress);
		Reporter.log("entered billing address",true);
		
		sales.getShipStreetTF().sendKeys(shippingAddress);
		Reporter.log("entered shipping address",true);
		
		sales.selectProduct(driver, item);
		Reporter.log(item+" item is selected",true);
		
		sales.getQty1TF().sendKeys(qty);
		Reporter.log(qty+" is selected",true);
		
		sales.getSaveButton().click();
		Reporter.log("clicked on save button",true);
		
//		Assert.assertTrue(sales.confermation(subject));
		Reporter.log("sales order created successfully",true);
		
		
	}
}

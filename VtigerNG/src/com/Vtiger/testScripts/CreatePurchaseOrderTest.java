package com.Vtiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepo.CreatePurchaseOrder;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;

public class CreatePurchaseOrderTest extends BaseConfig
{
	 CreatePurchaseOrder order;
	 FileLib fl =new FileLib();
	 
	 @DataProvider
	 public Object[][] readData()
	 {
		 return fl.readAllDataFromExcel("PurchaseOrder");
	 }
	@Test(dataProvider = "readData")
	public void createPurchaseOrder(String subject,String vendorName,String	status,
			String billinhAddress,String shippingAddress,String item,String	qty)
	{
		order = PageFactory.initElements(driver, CreatePurchaseOrder.class);
		order.mouseHoverMore(driver);
		Reporter.log("mouse hovered on more link",true);
		
		order.getPurchaseorderLink().click();
		Reporter.log("clicked on purchase order link",true);
		
		order.getCreatePurchaseorderLink().click();
		Reporter.log("clicked on create purchase order link",true);
		
		order.getSubjectTF().sendKeys(subject);
		Reporter.log("entered subject--> "+subject,true);
		
		order.selectVendor(vendorName, driver);
		Reporter.log("vendor name selected -->"+vendorName,true);
		
		order.selectStatus(status);
		Reporter.log("selected status -->"+status,true);
		
		order.getBillstreet().sendKeys(billinhAddress);
		Reporter.log("entered billinhAddress address",true);
		
		order.getShipstreet().sendKeys(shippingAddress);
		Reporter.log("entered shippingAddress address",true);
		
		order.selectItemNAme(item, driver);
		Reporter.log("slected item is -->"+item,true);
		
		order.getQty().sendKeys(qty);
		Reporter.log("entered qty is -->"+qty,true);
		
		order.getSaveButton().click();
		Reporter.log("clicked on save button",true);
		
	}
}

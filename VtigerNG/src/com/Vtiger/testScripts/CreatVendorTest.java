package com.Vtiger.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.Utility;

@Listeners(com.Vtiger.genericLib.ListenerImp.class)
public class CreatVendorTest extends BaseConfig
{
	@Test(groups = "smoke")
	public void CreateVendor()
	{
		String vendorName="hp";
		Utility.MovetoElement(driver, driver.findElement(By.linkText("More")));
		Reporter.log("Moved to more option", true);
		/*
		 * Actions action=new Actions(driver);
		 * action.moveToElement(driver.findElement(By.linkText("More"))).build().perform
		 * ();
		 */
		driver.findElement(By.linkText("Vendors")).click();
		Reporter.log("Clicked on Vendor link", true);
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		Reporter.log("Clicked on create vendor", true);
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		Reporter.log("Entered vendor name", true);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Clicked on save button", true);
		
		//verify
		String actVen=driver.findElement(By.id("dtlview_Vendor Name")).getText();
		Reporter.log("Got saved vendor name", true);
		Assert.assertTrue(actVen.contains(vendorName));
		Reporter.log("Compared with actual vendor name", true);
		
		
	}
}

package com.Vtiger.testScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;

import bsh.commands.dir;


@Listeners(com.Vtiger.genericLib.ListenerImp.class)
public class CreateProduct extends BaseConfig
{
	@DataProvider
	public Object[][] giveData()
	{
		Object[][] data=FileLib.readAllDataFromExcel("Prod");
		System.out.println(data);
		return data;
	}
	
	@Test(dataProvider = "giveData",groups = "smoke")
	public  void createproductTest(String Product_Id, String  Product_Name, String Produc_price, String Product_color)
	{
		
		driver.findElement(By.linkText("Products")).click();
		Reporter.log("Clicked on product link", true);
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		Reporter.log("Clicked on create product", true);
		driver.findElement(By.name("productname")).sendKeys(Product_Name);
		Reporter.log("Entered product name", true);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Clicked on save button", true);
		
		//verfiy 
		String actpro=driver.findElement(By.id("dtlview_Product Name")).getText();
		Assert.assertTrue(actpro.contains(Product_Name));
		Reporter.log("Compared with actual product name", true);
		

		
	}
}
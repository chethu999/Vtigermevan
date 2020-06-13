package com.Vtiger.testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepo.CreateOrg;
import com.Vtiger.ObjectRepo.Home;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;

public class CreateOrganizationTest extends BaseConfig
{
	CreateOrg org;

	
	FileLib fl = new FileLib();
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Org");
	}
	
	@Test(dataProvider = "readData")
	public void createOrgTest(String Org_name,String Org_website,String	Org_emp,String Industry,String	Type,
			String	Assigned_to,String Phone_no,String Email,String	Annual_revenu,String Billing_address)
	{
//		driver.findElement(By.linkText("Organizations")).click();
		org = PageFactory.initElements(driver, CreateOrg.class);
//		org.getOrganizationsLink().click();;
		Home home = PageFactory.initElements(driver, Home.class);
		home.clickOrganizationLink();
		Reporter.log("cliked on organization link",true);
		
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		org.clickCreateOrg();
		Reporter.log("clicked on create organization link",true);
		
//		driver.findElement(By.name("accountname")).sendKeys(Org_name);
		org.enterOganizationName(Org_name);
		Reporter.log("organization name is entered",true);
		
//		driver.findElement(By.name("website")).sendKeys(Org_website);
		org.website(Org_website);
		Reporter.log("Organization website entered",true);
		
//		driver.findElement(By.id("employees")).sendKeys(Org_emp);
		org.employees(Org_emp);
		Reporter.log("Entered Employees",true);
		
//		driver.findElement(By.xpath("//select[@name='industry']//option[@value='"+Industry+"']"));
//		org.industry(Industry);
//		Reporter.log("Selected Industry",true);
		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		org.save();
		Reporter.log("clicked on save button",true);
		
		//verifying the organization created
//		String actualOrgaName=driver.findElement(By.xpath("//span[contains(.,'Organization ')]")).getText();
//		Assert.assertTrue(actualOrgaName.contains(Org_name));
		org.actualOrgName(Org_name);
		Reporter.log("organization created successfully",true);
		
//		driver.findElement(By.linkText("Organizations")).click();
		org.clickOrgLink();
		Reporter.log("clicked on organization link link->home page displayed",true);
	}
}

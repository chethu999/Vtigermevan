package com.Vtiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.ObjectRepo.CreateContact;
import com.Vtiger.ObjectRepo.Home;
import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;



public class CreateContactsTest extends BaseConfig {

	FileLib fl = new FileLib();
	CreateContact con;
	Home home;


	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Contact");
	}

	@Test(dataProvider = "readData")
	public void createContTest(String firstName,String	lastName,String	org_name,String	email,String mobileNo)
	{
		home = PageFactory.initElements(driver, Home.class);
		home.getContactsLink().click();
		Reporter.log("clicked on Contact link",true);

		con = PageFactory.initElements(driver, CreateContact.class);
		con.getCreateContactLink().click();
		Reporter.log("clicked on create contact link",true);

		con.getFirstNameTF().sendKeys(firstName);
		Reporter.log("entered first name",true);

		con.getLastNameTF().sendKeys(lastName);
		Reporter.log("entered last name",true);
		
		con.getEmailTF().sendKeys(email);
		Reporter.log("entered email",true);
		
		con.getMobileTF().sendKeys(mobileNo);
		Reporter.log("entered mobile number",true);

		con.selectOrgName(driver, org_name);
		
		con.getSaveBuuton().click();
		Reporter.log("clicked on save button",true);

		Assert.assertTrue(con.conformation(lastName));
		Reporter.log("contact created successfully",true);

		home.getContactsLink();
		Reporter.log("Entered on contacts link-->home page displayed",true);
	}

}

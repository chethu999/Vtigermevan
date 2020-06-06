package com.Vtiger.testScripts;

import com.Vtiger.genericLib.*;

import static org.testng.Assert.assertTrue;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.genericLib.BaseConfig;
import java.util.*;  
  


@Listeners(com.Vtiger.genericLib.ListenerImp.class)
public class CreateOrganistion extends BaseConfig
{
	@DataProvider
	public Object[][] giveData()
	{
		Object[][] data=FileLib.readAllDataFromExcel("Org");
		System.out.println(data);
		return data;
	}

	@Test(dataProvider = "giveData",groups = "smoke")
	public void createorganationTest(String Org_name,
									String Org_website,
									String	Org_emp,
									String Industry,
									String	Type,
									String	Assigned_to,
									String Phone_no,
									String Email,
									String	Annual_revenu,
									String Billing_address)
	{
		
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Clicked on Organizations link", true);
		driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")).click();
		Reporter.log("Clicked on create Organizations", true);
		driver.findElement(By.name("accountname")).sendKeys(Org_name);
		Reporter.log("Entered organization name", true);
		driver.findElement(By.name("website")).sendKeys(Org_website);
		Reporter.log("Entered website", true);
		driver.findElement(By.name("employees")).sendKeys(Org_emp);
		Reporter.log("Entered Number of employees", true);
		Select surname=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
		surname.selectByVisibleText(Industry);
		Reporter.log("Selected industry ", true);
		new Select(driver.findElement(By.xpath("//select[@name='accounttype']"))).selectByVisibleText(Type);
		Reporter.log("Selected type", true);
		List<WebElement> radiobuttons = driver.findElements(By.xpath("//input[@name='assigntype']"));
		for(WebElement radiobutton: radiobuttons)
		{ 
		    if(radiobutton.getAttribute("value").equals(Assigned_to))
		        radiobutton.click();
		    
		}
		Reporter.log("Selected assign type	", true);
		driver.findElement(By.id("phone")).sendKeys(Phone_no);;
		Reporter.log("Entered phone number", true);
		driver.findElement(By.id("email1")).sendKeys(Email);;
		Reporter.log("Entered Email", true);
		driver.findElement(By.name("annual_revenue")).sendKeys(Annual_revenu);
		Reporter.log("Entered annual revenue", true);
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(Billing_address);
		Reporter.log("Entered annual billing address", true);
		driver.findElement(By.xpath("//input[@name='button' and @value='  Save  ']")).click();
		Reporter.log("Clicked on save button", true);
		
		//verfy organization added or not 
		String actorg=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		Reporter.log("Got saved Organization name", true);
		Assert.assertTrue(actorg.contains(Org_name));
		Reporter.log("Compared with actual oraganization name", true);
		
		
	}
}


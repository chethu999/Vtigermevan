package com.Vtiger.testScripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.FileLib;
import com.Vtiger.genericLib.Utility;

@Listeners(com.Vtiger.genericLib.ListenerImp.class)
public class CreatPurchaseOrder  extends BaseConfig
{
	@DataProvider
	public Object[][] giveData()
	{
		Object[][] data=FileLib.readAllDataFromExcel("Purchase");
		System.out.println(data);
		return data;
	}
	
	@Test(dataProvider = "giveData")
	public void CreatePurchaseOrderTest(String Subject,
			String Vendor_Name,String Status,String Assigned_To,String Billing_Address,String Shipping_Address,String Item_Name,String Qty,String ListPrice) 
	{
		
		//mouseOver on more
		Utility.MovetoElement(driver, driver.findElement(By.linkText("More")));
		Reporter.log("Clicked on more", true);
		
		//click on purchse order
		driver.findElement(By.name("Purchase Order")).click();
		Reporter.log("clicked on Purchase order link", true);
		
		/*
		 * //count number of purchase order preset before adding List<WebElement>
		 * purchaseCount =
		 * driver.findElements(By.xpath("//input[@type='checkbox']/../../td[3]"));
		 * System.out.println("no of purchaseorder before order added:= "+(purchaseCount
		 * .size()-1));
		 */
		
		//create purchase order
		driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")).click();
		Reporter.log("Clicked on create purchase order", true);
		
		//subject
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(Subject);
		Reporter.log("Entered subject in subject text field", true);
		
		//select vendor name
		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img")).click();
		Reporter.log("Clicked on vendor name", true);
		Set<String> list = driver.getWindowHandles();
		String parentwindow=driver.getWindowHandle();
		Iterator<String> window=list.iterator();
		String childwindow=null;
		while(window.hasNext())
		{
			childwindow=window.next();
			
			if(!parentwindow.equals(childwindow))
			{
				//switching child(vendor)window
				driver.switchTo().window(childwindow);
				Reporter.log("switched to vendor window", true);
				driver.findElement(By.linkText(Vendor_Name)).click();
				Reporter.log("Selected vendor name", true);
				/*
				 * List<WebElement> allVendors =
				 * driver.findElements(By.xpath("//tr[@class=\"lvtColData\" ]")); for (int i =
				 * 0; i < list.size(); i++) { if (allVendors.get(i).equals("chethan")) {
				 * allVendors.get(i).click();
				 * System.out.println("vendor selected succsusfully"); } }
				 */
				
			}
			
		}
		//swithcing to parent window
		driver.switchTo().window(parentwindow);
		Reporter.log("Switched to parent window", true);
		
		//select status
		Select surname=new Select(driver.findElement(By.xpath("//select[@name='postatus']")));
		surname.selectByVisibleText(Status);
		Reporter.log("Selected status", true);
		
		//billing addres
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(Billing_Address);
		Reporter.log("Entered billing address", true);
		
		//shipping addres
		driver.findElement(By.name("ship_street")).sendKeys(Shipping_Address);
		Reporter.log("Entered sipping address", true);
		
		//Select item name
		driver.findElement(By.id("searchIcon1")).click();
		Reporter.log("Clicked on Select item name", true);
		
		//driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
		//String xpath="//a[text()='chair']";
		//Reporter.log("Calling item selector method from utility", true);
		//Utility.MovetoChildAndSelect(driver, xpath);
		
	
		Set<String> list2= driver.getWindowHandles();
		String parentwindow2=driver.getWindowHandle();
		Iterator<String> window2=list2.iterator();
		String childwindow2;
		while(window2.hasNext())
		{
			childwindow2=window2.next();
			
			if(!parentwindow2.equals(childwindow2))
			{
				//switching child(item window)window
				driver.switchTo().window(childwindow2);
				Reporter.log("switched to item window", true);
				//driver.findElement(By.linkText("Vtiger 5 Users Pack"));
				WebDriverWait wait= new WebDriverWait(driver, 200);
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Item_Name)));
				ele.click();
				Reporter.log("Selected item name", true);
				
			}
			
		}
		//swithcing to parent window
		driver.switchTo().window(parentwindow2);
		Reporter.log("Switched to parent window", true);
		
		
		//qty
		driver.findElement(By.id("qty1")).sendKeys(Qty);
		Reporter.log("qty entered", true);
		
		//enter the list price
		driver.findElement(By.id("listPrice1")).sendKeys(ListPrice);
		Reporter.log("Entered list prize", true);
		
		//save the purchase order
		driver.findElement(By.xpath("//input[@name='button' and @value='  Save  ']")).click();
		Reporter.log("Clicked on save button", true);
		
		//verify
		String actpur=driver.findElement(By.id("mouseArea_Subject")).getText();
		Assert.assertTrue(actpur.contains(Subject));
		Reporter.log("Compared with actual product name", true);
		
	}
	
}

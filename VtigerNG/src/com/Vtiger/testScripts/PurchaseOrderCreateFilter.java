package com.Vtiger.testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.genericLib.BaseConfig;
import com.Vtiger.genericLib.Utility;

@Listeners(com.Vtiger.genericLib.ListenerImp.class)
public class PurchaseOrderCreateFilter extends BaseConfig
{
	@Test(groups = {"smoke","functional"})
	public void PurchaseCreatefilter()
	{
		//mouseOver on more
		Utility.MovetoElement(driver, driver.findElement(By.linkText("More")));
		Reporter.log("Clicked on more", true);
				
		//click on purchse order
		driver.findElement(By.name("Purchase Order")).click();
		Reporter.log("clicked on Purchase order link", true);
				
		//click on create filter option
		driver.findElement(By.linkText("Create Filter")).click();
		Reporter.log("Clicked on create filter option", true);
		
		//enter the view name
		driver.findElement(By.name("viewName")).sendKeys("bvc");
		Reporter.log("Entered view name ", true);
		
		//select subject
		WebElement element = driver.findElement(By.id("column1"));
		Select select=new Select(element);
		List<WebElement> option = select.getOptions();
		for (WebElement item : option) 
		{
			System.out.println(item.getText());
			
		}
		Reporter.log("Selected status", true);
	}
}

package com.Vtiger.genericLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;



public class Utility 
{
	public static void MovetoElement(WebDriver driver,WebElement  element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}

	public static void MovetoChildAndSelect(WebDriver driver,String xpath)
	{
		Set<String> list = driver.getWindowHandles();
		String parentwindow=driver.getWindowHandle();
		Iterator<String> window=list.iterator();
		String childwindow;
		while(window.hasNext())
		{
			childwindow=window.next();
			
			if(!parentwindow.equals(childwindow))
			{
				//switching child(item window)window
				driver.switchTo().window(childwindow);
				Reporter.log("switched to item window", true);
				driver.findElement(By.xpath(xpath));
				Reporter.log("Selected item name", true);
				
			}
			
		}
	}
	
	public static void dropdownselect(WebElement  element,String text)
	{
		Select surname=new Select(element);
		surname.selectByVisibleText("");
		Reporter.log("Selected status", true);
	}
	/*
	 * public static void takeScreenShot(WebDriver driver) { EventFiringWebDriver ef
	 * = new EventFiringWebDriver(driver); File src =
	 * ef.getScreenshotAs(OutputType.FILE); File dest = new
	 * File("./ScreenShots/screeShot1.PNG"); }
	 */
}

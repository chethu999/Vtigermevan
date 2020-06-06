package com.Vtiger.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Vtiger.ObjectRepo.Login;

public class BaseConfig
{
	public FileLib fl = new FileLib();
	public WebDriver driver;
	public static WebDriver staticdriver;
	
	
	@BeforeClass(groups = "smoke")
	public void configBc() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		String br=fl.getPropertyKeyValue("browser");
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
			staticdriver = driver;
		}
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
			staticdriver=driver;
		}
		
		driver.get("http:/localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@BeforeMethod(groups = "smoke")
	public void cofigBm() throws InterruptedException
	{
		Login login = PageFactory.initElements(driver, Login.class);	
		login.login(FileLib.getPropertyKeyValue("username"), FileLib.getPropertyKeyValue("password"));
	}
	
	@AfterMethod(groups = "smoke")
	public void configAM() throws InterruptedException
	{
		
		  driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]")).click();
		  Thread.sleep(500); driver.findElement(By.linkText("Sign Out")).click();
	}
	@AfterClass(groups = "smoke")
	public void configAc()
	{
		driver.quit();	}
	}

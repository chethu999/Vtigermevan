package com.Vtiger.genericLib;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Date;


public class ListenerImp implements ITestListener
{
	

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String methodName=result.getMethod().getMethodName();
		ITestListener.super.onTestFailure(result);
		Date d= new Date();
		int day=d.getDay();
		String[] dt=d.toString().split(" ");
		String  month=dt[1];
		String year=dt[5];
		String time=dt[3].replaceAll(":", "-");
		System.out.println("./Screenshot/"+methodName+"_"+day+"_"+month+"_"+year+"_"+time+".PNG");
		
		
		//Screenshot
		TakesScreenshot ts=(TakesScreenshot)BaseConfig.staticdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./Screenshot/"+methodName+"_"+day+"_"+month+"_"+year+"_"+time+".PNG");
		try
		{
			FileUtils.copyFile(src, des);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}

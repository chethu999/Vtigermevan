package com.Vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class FileLib
{
	public static String getPropertyKeyValue(String key)
	{
		Properties p = null;
		try 
		{
			FileInputStream fi = new FileInputStream("G:\\TY Selenium\\VtigerNG\\src\\commanData\\commonData.properties");
			p = new Properties();
			p.load(fi);
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
	
	public String readDataFromExcel(String sheetName, int rowNum, int celNum)
	{
		FileInputStream fi;
		String celVal = null;
		try
		{
			fi = new FileInputStream("./src\\com\\vTiger\\commonData\\product.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheetName);
			celVal = sh.getRow(rowNum).getCell(celNum).getStringCellValue();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return celVal;
	}
	

	public static  Object[][] readAllDataFromExcel(String sheetName)
	{
		FileInputStream fi ;
		Object[][] data = null;
		try 
		{
			fi = new FileInputStream("G:\\TY Selenium\\VtigerNG\\src\\commanData\\product.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheetName);
			
			int rowNum = sh.getLastRowNum();
			System.out.println("rownum:    "+rowNum);
			int colNum = sh.getRow(0).getLastCellNum();
			data = new Object[rowNum][colNum];
			for (int i = 0; i < rowNum; i++)
			{
				for (int j = 0; j < colNum; j++) 
				{
					data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("exception");
		}
		return data;
	}
}

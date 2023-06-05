package com.codemind.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Utility {
	static WebDriver driver;
	// use for webdriver
	public static WebDriver getWebDriver() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", Utility.getProperty("driverPath"));
		
		 driver=new ChromeDriver();
		 return driver;
	}
	public static String getProperty(String key) throws IOException
	{
		File file =new File("src/test/resources/testData.properties");
		FileInputStream fileinputstream=new FileInputStream(file);
		Properties properties=new Properties();
		properties.load(fileinputstream);
		return properties.getProperty(key);
	}
	public static List<String> readExcel() throws IOException
	{
		List<String> userData =new ArrayList<String>();
		//userData excel file path.userData right click->properties->copy path
		File file=new File("src\\test\\resources\\userData.xlsx");
		
		//FileInputStream is used for connect with file
		FileInputStream fileInputStream=new FileInputStream(file);
		
		//fileInputStream is used for read FileInputStream object
		XSSFWorkbook xSSFWorkbook=new XSSFWorkbook(fileInputStream);
		
		//it reperesent excell sheet pass excell sheet name
		XSSFSheet sheet=xSSFWorkbook.getSheet("data");
		
		//represent lastrownumber of excell sheet.read last row number
		int lastRowNum=sheet.getLastRowNum();
		
		//create reference variable
		XSSFRow row;
		int lastColNum;
		for(int i=1;i<=lastRowNum;i++)
		{
			//get rows from sheet
			 row=sheet.getRow(i);
			  lastColNum=row.getLastCellNum();
		
		for(int j=0;j<lastColNum;j++)
		{
			//System.out.println(row.getCell(j).getStringCellValue());
			userData.add(row.getCell(j).getStringCellValue());
		}
	 }
		return userData;
	}

}













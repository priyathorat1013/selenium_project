package com.omayo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoHomePage;

public class VerifyUserAbleToSelectOptionsFromDropdown {

	WebDriver driver;
	//create reference variable of  OmayHomepage
	OmayoHomePage omayoHomePage;
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		//chome driver 
		this.driver=Utility.getWebDriver();
		
		//launch website
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		//create object of OmayoHomePage
		omayoHomePage=new OmayoHomePage(driver);
	}
	@Test(priority = 0)
	public void verifyUserAbleToSelectOptionsFromDropdown()
	{
		omayoHomePage.selectMultiSelectDropdownOption("Volvo");
		omayoHomePage.selectMultiSelectDropdownOption("Audi");
		List<String> selectedoptions=omayoHomePage.getSelectedOption();
		//print the selected options
		for(String s:selectedoptions)
		{
			System.out.println(s);
		}
		assertEquals(selectedoptions.size(), 2);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}













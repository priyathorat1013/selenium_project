package com.omayo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codemind.utility.Utility;
import com.omayo.pages.NewToursHomePage;
import com.omayo.pages.NewToursRegistrationPage;

public class VerifyUserRegistration {
  WebDriver driver;
  
  //create reference variable of home pages
  NewToursHomePage newToursHomePage;
  NewToursRegistrationPage newToursRegistrationPage;
  List<String> userData;
  
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		//chome driver 
		this.driver=Utility.getWebDriver();
		
		//launch website
		driver.get(Utility.getProperty("newtoururlreg"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		
		//create objects of home pages
		newToursHomePage=new NewToursHomePage(driver);
		newToursRegistrationPage=new NewToursRegistrationPage(driver);
		
		//read exceldata
		 userData=Utility.readExcel();
		
	}
	
	
	@Test
	//public void readExcellFile() throws IOException
	public void verifyUserRegistration() throws IOException
	{
		//click on Register link on home page
		newToursHomePage.clickOnRegisterLink();
		
		
		//send keys on newToursRegistrationPage
		newToursRegistrationPage.getFirstNameTextbox().sendKeys(userData.get(0));
		newToursRegistrationPage.getLastNameTextbox().sendKeys(userData.get(1));
		newToursRegistrationPage.getPhoneTextbox().sendKeys(userData.get(2));
		newToursRegistrationPage.getEmailTextbox().sendKeys(userData.get(3));
		newToursRegistrationPage.getSubmitButton().click();;
		
		assertEquals(newToursRegistrationPage.getDearUserLabel().getText(), "Dear "+userData.get(0)+" "+userData.get(1)+",");
		//print dear user label
		System.out.println(newToursRegistrationPage.getDearUserLabel().getText());
		//assertTrue(newToursRegistrationPage.getDearUserLabel().getText().contains(userData.get(0)));
		
		
		
		//read excell file method call from Utility
		//Utility.readExcel();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

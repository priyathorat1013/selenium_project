package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {

	  WebDriver driver;
		//Home page related locator
		/*right click on registerLink->click on sourse->click on 
		generate getter and setter ->click on generatte*/
		WebElement registerLink;
	   
		

		//create constructor for pass external parameter means driver 
		public NewToursHomePage(WebDriver driver)
		{
			this.driver=driver;
		}


                // getter method
		public WebElement getRegisterLink() {
			setRegisterLink();
			return registerLink;
		}



		public void setRegisterLink() {
			this.registerLink = driver.findElement(By.xpath("//a[text()='REGISTER']"));
		}
		
		
		//create method for click on register link
		public void clickOnRegisterLink()
		{
			getRegisterLink().click();
		}

}

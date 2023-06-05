package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursRegistrationPage {
	WebDriver driver;
	//Home page related locator
	/*right click on webelement one by one->click on sourse->click on 
	generate getter and setter ->click on generatte*/
	WebElement firstNameTextbox;
	WebElement lastNameTextbox;
	WebElement phoneTextbox;
	WebElement emailTextbox;
	
	//webelement of submit button
	WebElement submitButton;
	
	//dearuser label after clicking on submit button
	WebElement dearUserLabel;
   
	

	//create constructor for pass external parameter means driver 
	public NewToursRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	}




	public WebElement getFirstNameTextbox() {
		setFirstNameTextbox();
		return firstNameTextbox;
	}




	public void setFirstNameTextbox() {
		this.firstNameTextbox = driver.findElement(By.xpath("//input[@name='firstName']"));
	}




	public WebElement getLastNameTextbox() {
		setLastNameTextbox();
		return lastNameTextbox;
	}




	public void setLastNameTextbox() {
		this.lastNameTextbox = driver.findElement(By.xpath("//input[@name='lastName']"));
		
	}




	public WebElement getPhoneTextbox() {
		setPhoneTextbox();
		return phoneTextbox;
	}




	public void setPhoneTextbox() {
		this.phoneTextbox =driver.findElement(By.xpath("//input[@name='phone']"));
		
	}




	public WebElement getEmailTextbox() {
		setEmailTextbox();
		return emailTextbox;
	}




	public void setEmailTextbox() {
		this.emailTextbox = driver.findElement(By.xpath("//input[@id='userName']"));
	}




	public WebElement getSubmitButton() {
		setSubmitButton();
		return submitButton;
	}




	public void setSubmitButton() {
		this.submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
	}




	public WebElement getDearUserLabel() {
		setDearUserLabel();
		return dearUserLabel;
	}




	public void setDearUserLabel() {
		this.dearUserLabel = driver.findElement(By.xpath("//b[contains(text(),'Dear')]"));
	}

}

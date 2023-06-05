package com.omayo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OmayoHomePage {
     WebDriver driver;
	//Home page related locator
	/*right click on multiSelectDropdown->click on sourse->click on 
	generate getter and setter ->click on generatte*/
	WebElement multiSelectDropdown;
   
	

	//create constructor for pass external parameter means driver 
	public OmayoHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getMultiSelectDropdown() {
		setMultiSelectDropdown();
		return multiSelectDropdown;
	}

	public void setMultiSelectDropdown() {
		this.multiSelectDropdown = driver.findElement(By.xpath("//select[@id='multiselect1']"));
	}
	
	//select multiple options from multiselect dropdown
	public void selectMultiSelectDropdownOption(String visibleText)
	{
		Select select=new Select(getMultiSelectDropdown());
		select.selectByVisibleText(visibleText);
		
	}
	
	//get all selected options from dropdown
	public List<String> getSelectedOption()
	{
		Select select=new Select(getMultiSelectDropdown());
		List<String> selectOptionFromDropdown=new ArrayList<String>();
				
		List<WebElement> selectedOption=select.getAllSelectedOptions();
		for(WebElement elm:selectedOption)
		{
			selectOptionFromDropdown.add(elm.getText());
		}
		return selectOptionFromDropdown;
	
    }
}












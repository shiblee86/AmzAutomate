package com.scratchproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.setup.BaseSetup;

public class SearchInputTextFieldValidation extends BaseSetup{
	
	@Test(enabled = true, priority = 100)
	public void userValidatesSearchInputTextField() {

		System.out.println("\n Test Case: User validation input text field");
		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		if (searchBox.isEnabled() && searchBox.isEnabled()) {
			searchBox.sendKeys("brakes");
			searchBox.submit();
			System.out.println("\n User is able to click on search box, type and search for items");
		} else {
			System.out.println("\n Searchinng for items has failed.");
		}
	}

}

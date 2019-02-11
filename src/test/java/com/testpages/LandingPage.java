package com.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{
	
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "#twotabsearchtextbox")
	public WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	@FindBy(css ="#nav-search-submit-text")
	public WebElement submitButton;
	
	public WebElement getSubmitButton() {
		return submitButton;
	}

}

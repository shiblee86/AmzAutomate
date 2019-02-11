package com.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderElements extends BasePage{
	
	public HeaderElements(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
	public WebElement addToCartButton;
	
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

}

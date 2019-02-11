package com.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Iphone extends BasePage{

	public Iphone(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[contains(@class,'shopNow--caretRight')]")
	public WebElement shopNowButton;

	public WebElement getShopNowButton() {
		return shopNowButton;
	}
}

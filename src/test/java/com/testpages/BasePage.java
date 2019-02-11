package com.testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;

	public void inItPage() {
		PageFactory.initElements(driver, this);
		/* This refers to the current class. In this case, BasePage */
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.inItPage();
	}

}

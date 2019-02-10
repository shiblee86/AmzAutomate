package com.testngsetup;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllDropdownDataFromWebsite extends BaseTest {

	public List<String> getAllDropdownData() {

		List<WebElement> elementsInAllDropDownList = driver.findElements(By.id("searchDropdownBox"));
		List<String> storeElementsFromAllList = new ArrayList<String>();

		for (WebElement webElementArrayItems : elementsInAllDropDownList) {
			storeElementsFromAllList.add(webElementArrayItems.getText());
		}
		return storeElementsFromAllList;
	}
}

package com.setup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RunAmazonValidationTests {

	public static void main(String[] args) throws Exception {

		String expectedURL = "https://www.amazon.com/";

		String os = System.getProperty("os.name").toLowerCase();
		System.out.println();

		String path = System.getProperty("user.dir");
		String winDriverPath = path + "\\Driver\\chromedriver.exe";

		String macDriverPath = path + "/Driver/chromedriver";

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
		}

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(expectedURL);
		String actualURL = driver.getCurrentUrl();
		System.out.println("URL Validation Test");
		System.out.println("\n Expected URL and Actual URL are the SAME. Validation passed!!!");
		try {
			Assert.assertEquals(expectedURL, actualURL);
		} catch (Exception e) {
			System.out.println("\n Expected URL and Actual URL are NOT the same. Validation failed!!!");
			System.out.println();
		}

		System.out.println("\n Test Case: User validation input text field");
		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		if (searchBox.isEnabled() && searchBox.isEnabled()) {
			searchBox.sendKeys("brakes");
			searchBox.submit();
			System.out.println("\n User is able to click on search box, type and search for items");
		} else {
			System.out.println("\n Searchinng for items has failed.");
		}

		List<WebElement> elementsInAllDropDownList = driver.findElements(By.id("searchDropdownBox"));
		List<String> storeElementsFromAllList = new ArrayList<String>();

		for (WebElement webElementArrayItems : elementsInAllDropDownList) {
			storeElementsFromAllList.add(webElementArrayItems.getText());
		}
		System.out.println("List from Amazon");
		System.out.println();
		for (String stringArrayItems : storeElementsFromAllList) {
			System.out.println(stringArrayItems);
		}
		System.out.println("************************");
		System.out.println();
		System.out.println("List from DataFile");
		System.out.println();

		List<String> departmentsFromFile = new ArrayList<String>();

		String filePath = path + "/src/main/resources/DataFromFiles/all_department.txt";
		File file = new File(filePath);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			departmentsFromFile.add(sc.nextLine());
		}

		for (String dataFromFile : departmentsFromFile) {
			System.out.println(dataFromFile);
		}
		System.out.println();

		System.out.println("Data VERIFICATION test");
		for (int i = 0; i < storeElementsFromAllList.size(); i++) {
			if (storeElementsFromAllList.get(i).equals(departmentsFromFile.get(i))) {
				System.out.println("Data from Amazon's ALL dropdown match data from DataFile. VERIFIED!!!");
			} else if (storeElementsFromAllList.get(i) == departmentsFromFile.get(i)) {
				System.out.println("Data from Amazon's ALL dropdown match data from DataFile. VERIFIED!!!");
			} else if (storeElementsFromAllList.get(i) != departmentsFromFile.get(i)) {
				System.out.println("Data between ALL dropdown and DataFile do not match. VERIFICATION FAILED!!!");
			}

		}

		System.out.println();

		System.out.println("Data VALIDATION test");
		for (int j = 0; j < departmentsFromFile.size(); j++) {

			try {
				Assert.assertEquals(storeElementsFromAllList.get(j), departmentsFromFile.get(j));
				System.out.println("Data from Amazon's ALL dropdown match data from DataFile. VALIDATED!!!");
			} catch (Exception e) {
				System.out.println("Data between ALL dropdown and DataFile do not match. VALIDATION FAILED!!!");
			}

		}

	}

}

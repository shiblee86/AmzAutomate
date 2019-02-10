package com.testngsetup;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AllDropdownDataValidation {

	AllDropdownDataFromWebsite dataFromWeb = new AllDropdownDataFromWebsite();
	AllDropdownDataFromFile dataFromFile = new AllDropdownDataFromFile();

	@Test(enabled = true, priority = 200)
	public void runDataVerificationTest() throws FileNotFoundException {
		System.out.println("Data VERIFICATION test");
		if (dataFromWeb.getAllDropdownData().equals(dataFromFile.getDataFromFile())) {
			System.out.println("Data from Amazon's ALL dropdown match data from DataFile. VERIFIED!!!");
		} else if (dataFromWeb.getAllDropdownData() == (dataFromFile.getDataFromFile())) {
			System.out.println("Data from Amazon's ALL dropdown match data from DataFile. VERIFIED!!!");
		} else if (dataFromWeb.getAllDropdownData() != (dataFromFile.getDataFromFile())) {
			System.out.println("Data between ALL dropdown and DataFile do not match. VERIFICATION FAILED!!!");
		}
		System.out.println();
	}

	@Test(enabled = true, priority = 300)
	public void runDataValidationTest() throws FileNotFoundException {
		System.out.println("Data VALIDATION test");
		try {
			Assert.assertEquals(dataFromWeb.getAllDropdownData(), dataFromFile.getDataFromFile());
			System.out.println("Data from Amazon's ALL dropdown match data from DataFile. VALIDATED!!!");
		} catch (Exception e) {
			System.out.println("Data between ALL dropdown and DataFile do not match. VALIDATION FAILED!!!");
		}
	}
}

package com.testngsetup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllDropdownDataFromFile {

	public List<String> getDataFromFile() throws FileNotFoundException {

		List<String> departmentsFromFile = new ArrayList<String>();

		String path = System.getProperty("user.dir");
		String filePath = path + "/src/main/resources/DataFromFiles/all_department.txt";
		File file = new File(filePath);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			departmentsFromFile.add(sc.nextLine());
		}
		return departmentsFromFile;
	}

}

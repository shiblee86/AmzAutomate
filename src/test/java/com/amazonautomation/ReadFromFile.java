package com.amazonautomation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {

	public static void main(String[] args) throws Exception {

		List<String> departmentsFromFile = new ArrayList<String>();

		File file = new File(
				"/Users/shiblee/eclipse-workspace/com.amazonautomation/src/main/resources/DataFromFiles/all_department.txt");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			departmentsFromFile.add(sc.nextLine());
		}
		
		for(String f : departmentsFromFile) {
			System.out.println(f);
		}
	}
}

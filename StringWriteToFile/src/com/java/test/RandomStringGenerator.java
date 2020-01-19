package com.java.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

public class RandomStringGenerator {

	public static void main(String[] args) {
		// Create a Scanner object
		Scanner myObj = new Scanner(System.in);
		String fileDire = "C:\\Test\\";
		System.out.println("Enter a valid int value from 1 to 2^30-1");
		// Read user input
		int xVal = myObj.nextInt();  
		if (xVal <=0) {
			myObj.close();
			throw new IllegalArgumentException("No Negitive values");
					}
		myObj.close();
		FileWriter fw = null;
		try {
			// Check the file directory exist if not creating
			File file = new File(fileDire);
			boolean fileExists = file.exists();
			if (!fileExists) {
				File fileDir = new File(fileDire);
				fileDir.mkdir();
			}
			
			fw = new FileWriter(fileDire+"\\Test.txt");
			for (int i = 1; i <=xVal ; i++) {
			fw.write(getAlphaNumericString(100)+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("File genrated sucessfully");
	}

	// function to generate a random string of length n 
	static String getAlphaNumericString(int n) 
	{ 

		// chose a Character random from this String 
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz"; 

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(n); 
		SecureRandom random = new SecureRandom();
		for (int i = 1; i < n; i++) { 

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index 
			= (int)(AlphaNumericString.length() * Math.random()); 
			
			// add Character one by one in end of sb 
			sb.append(AlphaNumericString 
					.charAt(index)); 
		} 

		return sb.toString(); 
	} 


}

package com.sonoma.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sonoma.bo.ZipCode;
import com.sonoma.util.UtilityClass;

public class ZipCodeRange {

	public static void main(String[] args) {
		// Regular expression for ZipCode.
		final String zipCodeRegex = "^\\[[0-9]{5},[0-9]{5}\\]";
		
		System.out.println("Please enter the zip code Range eg:[12345,23456] [34567,42345]");

		final List<ZipCode> zipcodeList = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// Read the console input
			final String zipCode = br.readLine();
			for (String code : zipCode.split(" ")) {
				Pattern pattern = Pattern.compile(zipCodeRegex);
				Matcher matcher = pattern.matcher(code);
				// Validating the Input
				if (!matcher.matches()) {
					System.out.println("Invalid Input, please verify the Zip codes entered");
					throw new IllegalArgumentException("Invalid Input, please verify the Zip codes entered"); 
				}
				
				// read the content enclosed by brackets(i.e [])
				String newString = code.substring(1, code.length() - 1);
				String[] splitString = newString.split(",");
				final ZipCode zipcode = new ZipCode(Integer.parseInt(splitString[0]), Integer.parseInt(splitString[1]));
				zipcodeList.add(zipcode);

			}
			System.out.println("\n\n\nConsolidated zip code range: " + UtilityClass.consolidate(zipcodeList));
		} catch (IOException e) {
			System.out.println("Error occured while reading data " + e.getLocalizedMessage());
		}

	}
}

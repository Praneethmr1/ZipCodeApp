package com.sonoma.util;

import java.util.Comparator;

import com.sonoma.bo.ZipCode;

public class ZipCodeComparatorASC implements Comparator<ZipCode> {

	@Override
	public int compare(ZipCode zp1, ZipCode zp2) {

		if (zp1.getLower() < zp2.getLower()) {
			return -1;
		}

		if (zp1.getLower() > zp2.getLower()) {
			return 1;
		}
		return 0;
	}
}

package com.sonoma.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.sonoma.bo.ZipCode;

public class UtilityClass {
	public static List<ZipCode> consolidate(List<ZipCode> zipCodeList) {
		Set<ZipCode> sortedRanges = new TreeSet<>(new ZipCodeComparatorASC());
		if (zipCodeList != null) {
			//Sorting the given list of Zip codes in ascending order
			zipCodeList.sort(new ZipCodeComparatorASC());
			for (ZipCode zCode : zipCodeList) {
				//Cloning object
				ZipCode merge = ZipCode.copy(zCode);
				boolean isOverlapping = false;
				for (ZipCode existingRange : sortedRanges) {
					if (existingRange.isMergeable(merge)) {
						existingRange.merge(merge);
						isOverlapping = true;
						break;
					}
				}
				if (!isOverlapping) {
					sortedRanges.add(merge);
				}
			}
		}
		return new ArrayList<>(sortedRanges);
	}

	public static boolean isInRange(int zipCode, ZipCode range) {
		boolean result = false;
		if (range != null) {
			result = (range.getLower() <= zipCode && zipCode <= range.getUpper());
		}
		return result;
	}
}

package com.sonoma.bo;

import static com.sonoma.util.UtilityClass.isInRange;;

/**
 *  A Business Object class for ZipCode.
*/
public class ZipCode {

	private int lower;
	private int upper;

	public ZipCode() {
	}

	public ZipCode(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}
	/**
	 * Method to verify if the Zip Code can be merged. 
	 * @param merge
	 * @return boolean
	 */
	public boolean isMergeable(ZipCode merge) {
		boolean result = false;
		if (merge != null) {
			result = ((merge.lower + 1 == this.lower) || (merge.lower - 1) == this.upper || isInRange(merge.lower, this)
					|| isInRange(merge.upper, this) || isInRange(this.lower, merge));
		}
		return result;
	}

	/**
	 * Merges any overlapped values
	 * @param range
	 */
	public void merge(ZipCode range) {
		if (range != null && isMergeable(range)) {
			if (range.lower < this.lower) {
				this.lower = range.lower;
			}
			if (range.upper > this.upper) {
				this.upper = range.upper;
			}
		}
	}

	// Copy the given ZipCode object and return it.
	public static ZipCode copy(ZipCode range) {
		return new ZipCode(range.getLower(), range.getUpper());
	}

	@Override
	public String toString() {
		return "ZipCode [lower=" + lower + ", upper=" + upper + "]";
	}

}

package com.leet.arrays.easy;

import java.util.Arrays;

public class PlusOne {
	/**You are given a large integer represented as an integer array digits, 
	 * where each digits[i] is the ith digit of the integer. 
	 * The digits are ordered from most significant to least significant in 
	 * left-to-right order. The large integer does not contain any leading 0's.
	 * 
	 * Increment the large integer by one and return the resulting array of digits.
	 */
	public static void main(String[] args) {
		int [] digits = {9};
		Arrays.stream(plusOne(digits)).forEach(System.out::println);

	}
	
	public static int[] plusOne(int[] digits) {
		
		int [] plusOneAr = new int[digits.length+1];
		int carry = 1;
		for (int i = plusOneAr.length-1; i > 0; i--) {
			plusOneAr[i] = (digits[i-1]+carry)%10;
			carry = (digits[i-1]+carry)/10;
		}
		
		if(carry>0) {
			plusOneAr[0]=carry;
		}else {
			plusOneAr = Arrays.copyOfRange(plusOneAr, 1, plusOneAr.length);
		}
		
		return plusOneAr;
    }

}

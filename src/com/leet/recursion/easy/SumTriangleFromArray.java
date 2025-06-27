package com.leet.recursion.easy;

import java.util.Arrays;

public class SumTriangleFromArray {
	/**Given an array of integers, print a sum triangle from it such that 
	 * the first level has all array elements. From then, at each level 
	 * number of elements is one less than the previous level and elements 
	 * at the level is be the Sum of consecutive two elements in the 
	 * previous level. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5 };
        printTriangle(ar);
	}

	private static void printTriangle(int[] ar) {
		if(ar.length==0) return;
		int [] arrayToBePrinted = new int[ar.length-1];
		for (int i = 0; i < arrayToBePrinted.length; i++) {
			arrayToBePrinted[i] = ar[i]+ar[i+1];
		}
		printTriangle(arrayToBePrinted);
		System.out.println(Arrays.toString(ar));
	}

}

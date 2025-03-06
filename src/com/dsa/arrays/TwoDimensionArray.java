package com.dsa.arrays;

import java.util.Arrays;

public class TwoDimensionArray {

	public static void main(String[] args) {
		//initializing 2-d array
		int [][] ar;
		
		//Declaring a 2d array 
		/**
		 *int [][] ar = {
		 * 	{1,2,3},
		 *  {4,5,6},
		 * 	{7,8,9}
		 * }
		 * 
		 * direct initialization with values
		 * note initialization and declaration should happen in same line
		 * orelse if we declare in different line and try to initialize 
		 * in separate line it will through error
		 */
		
		//its mandatory to initialize the rows but not colums
		//i.e new int[3][]; will work
		ar = new int[3][3];
		initializeWithValues(ar);
//		System.out.println(Arrays.deepToString(ar)); [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
		Arrays.stream(ar).map(Arrays::toString).forEach(System.out::println);

	}

	private static void initializeWithValues(int[][] ar) {
		int count = 1;
		for(int i =0; i<ar.length; i++) {
			for (int j=0; j<ar[i].length;j++) {
				ar[i][j] = count++;
			}
		}
	}

}

package com.dsa.arrays;

import java.util.Arrays;

public class SingleDimensionArray {

	public static void main(String[] args) {
		//Declare a single dimension array of integers
		int [] ar;
		
		//initialize the array
		// ar = {1,2,3} this will initialize with values
		//below will initialize the array as {0,0,0}
		ar = new int[3]; 
		//arrays are pass by reference hence it changes the object
		initializeWithValues(ar); 
		System.out.println(Arrays.toString(ar));

	}

	//changing the original object, as the object here passed is the reference
	//i.e the address of the object we can modify the object directly
	private static void initializeWithValues(int[] ar) {
		for(int i = 0; i<ar.length; i++) {
			ar[i]=i+1;
		}
	}

}

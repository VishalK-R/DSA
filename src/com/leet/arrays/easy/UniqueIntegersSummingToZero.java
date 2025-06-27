package com.leet.arrays.easy;

import java.util.Arrays;

public class UniqueIntegersSummingToZero {
	public static void main(String[]args) {
		int n = 7;
		Arrays.stream(sumZero(n)).forEach(System.out::println);
	}
	public static int[] sumZero(int n) {
        int[] returnAr = new int[n];
        int startValue = -(n/2);
        int endValue = n/2;
        boolean isEven = n%2==0?true:false;
        int index = 0;
        while(startValue<=endValue) {
        	if(isEven&&index==((n/2))) {
        		startValue++;
        		isEven=false;
        	}else {
        		returnAr[index]=startValue++;
        		index++;
        	}	
        }
        return returnAr;
    }
}

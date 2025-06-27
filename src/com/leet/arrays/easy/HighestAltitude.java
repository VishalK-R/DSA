package com.leet.arrays.easy;

public class HighestAltitude {

	public static void main(String[] args) {
		int[] gain = {-4,-3,-2,-1,4,3,2};
		System.out.println(largestAltitude(gain));
	}
	
	public static int largestAltitude(int[] gain) {
        int largestAltitude = 0;
        int[] actualAltitudes = new int[gain.length+1];
        actualAltitudes[0] = 0;
        for (int i = 1; i < actualAltitudes.length; i++) {
        	actualAltitudes[i] = actualAltitudes[i-1]+gain[i-1];
        	if(actualAltitudes[i]>largestAltitude) {
        		largestAltitude = actualAltitudes[i];
        	}
		}
        return largestAltitude;
    }

}

package com.leet.arrays.easy;

import java.util.Arrays;

public class ShuffleTheArray {
	/**Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
	 * 
	 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
	 * 
	 * Constraints:
	 * 1 <= n <= 500
	 * nums.length == 2n
	 * 1 <= nums[i] <= 10^3
	 */
	public static void main(String[] args) {
		int []nums= {1,2,3,4,4,3,2,1};
		System.out.println(Arrays.toString(shuffle(nums, 4)));
	}
	
    private static int[] shuffle(int[] nums, int n) {
        int [] shuffledAr = new int[n*2];
        int i =0,j=0;
        while (i<2*n) {
			shuffledAr[i]=nums[j];
			shuffledAr[i+1]=nums[j+n];
			i+=2;
			j++;
		}
        return shuffledAr;
    }

}

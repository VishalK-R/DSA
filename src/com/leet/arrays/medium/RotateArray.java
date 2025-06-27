package com.leet.arrays.medium;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,6,7};
		int k = 9;
		rotate(nums, k);
		Arrays.stream(nums).forEach(System.out::println);

	}
	
	public static void rotate(int[] nums, int k) {
		int size = nums.length;
        k%=size;
        if(k!=0) {
        	reverseArray(nums,0,size-1);
        	reverseArray(nums,0,k-1);
        	reverseArray(nums,k,size-1);
        }
    }

	private static void reverseArray(int[] nums, int startPos, int endPos) {
		while(startPos<endPos) {
			int temp = nums[startPos];
			nums[startPos]=nums[endPos];
			nums[endPos]=temp;
			startPos++;
			endPos--;
		}
		
	}

}

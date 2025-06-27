package com.leet.arrays.medium;

import java.util.Arrays;

public class SortColors {
	/**Given an array nums with n objects colored red, white, or blue, sort 
	 * them in-place so that objects of the same color are adjacent, with the 
	 * colors in the order red, white, and blue.
	 * 
	 * We will use the integers 0, 1, and 2 to represent the color red, white, 
	 * and blue, respectively.
	 * 
	 * You must solve this problem without using the library's sort function.
	**/
	public static void main(String[] args) {
		int [] nums = {2,0,1};
		sortColors(nums);
		Arrays.stream(nums).forEach(System.out::println);
	}
	
	
	private static void sortColors(int[] nums) {
        int leftPointer = 0;
        int i = 0;
        int rightPointer = nums.length-1;
        
        while(i<=rightPointer) {
        	if(nums[i]==0) {
        		swap(nums, leftPointer, i);
        		i++;
        		leftPointer++;
        	}else if(nums[i]==2) {
        		swap(nums, rightPointer, i);
        		//here we are not incrementing i because we don't want 0 to come
        		// in middle as we are traversing from left to right
        		rightPointer--;
        	}else {
        		i++;
        	}
        }
        
    }


	private static void swap(int[] nums, int pointer, int i) {
		int temp = nums[pointer];
		nums[pointer]=nums[i];
		nums[i]=temp;
	}

}

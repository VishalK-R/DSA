package com.leet.recursion.easy;

public class FindMinimumAndMaximumOfArrayUsingRecursion {

	public static void main(String[] args) {
		int [] nums = {1, 4, 45, 6, -50, 10, 2};
        int n = nums.length;
        
        // Function calling
        System.out.println(findMin(nums, n));
        System.out.println(findMax(nums, n));

	}

	private static int findMin(int[] nums, int length) {
		if(length==1) return nums[0];
		
		return Math.min(nums[length-1], findMin(nums, length-1));
	}
	
	private static int findMax(int[] nums, int length) {
		if(length==1) return nums[0];
		
		return Math.max(nums[length-1], findMax(nums, length-1));
	}

}

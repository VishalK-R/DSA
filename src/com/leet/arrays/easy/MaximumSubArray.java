package com.leet.arrays.easy;

public class MaximumSubArray {

	/**Given an integer array nums, find the subarray with the largest sum, 
	 * and return its sum.
	 * 
	 */
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	sum+=nums[i];
        	if(sum<nums[i]) {
        		sum=nums[i];
        	}
        	if(sum>max) {
        		max=sum;
        	}
        	
		}
        return max;
    }
}

package com.leet.arrays.easy;

import java.util.Arrays;

public class RunningSumOf1dArray {
	/**Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]+…nums[i]).
	Return the running sum of nums.
	
	Constraints:
	1 <= nums.length <= 1000
	-10^6 <= nums[i] <= 10^6
	**/
	public static void main(String[] args) {
		int[]nums = {3,1,2,10,1};
		System.out.println(Arrays.toString(runningSum(nums)));
		
	}
	
	private static int[] runningSum(int[] nums) {
        int index = 0;
        int[] runninSumArray = new int[nums.length];
        runninSumArray[index]=nums[index];
        index++;
        while(index<nums.length) {
        	runninSumArray[index]=runninSumArray[index-1]+nums[index];
        	index++;
        }
		return runninSumArray;
    }

}

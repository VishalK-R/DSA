package com.leet.binarySearch.hard;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		int [] nums = {7,2,5,10,8};
		System.out.println(splitArray(nums,2));

	}

	public static int splitArrayUsingBruteForce(int[] nums, int k) {
		return helper(nums, 0, k, new HashMap<>());
	}

	private static int helper(int[] nums, int index, int k, Map<String, Integer> memo) {
		// Base case: If we've used all k subarrays and covered all elements
	    if (k == 0 && index == nums.length)
	        return 0;

	    // Invalid case: either k subarrays are used up but we still have elements,
	    // or we ran out of elements before forming k subarrays
	    if (k == 0 || index == nums.length)
	        return Integer.MAX_VALUE;

	    // Create a unique key for this subproblem: current index and k
	    String key = index + "," + k;

	    // If we've already solved this subproblem, return the stored result
	    if (memo.containsKey(key))
	        return memo.get(key);

	    // Initialize the minimum possible maximum subarray sum to a large value
	    int minLargestSum = Integer.MAX_VALUE;

	    // This will keep track of the current subarray sum
	    int currentSum = 0;

	    // Try all possible places to split the array starting from 'index'
	    for (int i = index; i < nums.length; i++) {
	        // Add nums[i] to the current subarray sum
	        currentSum += nums[i];

	        // Recursively calculate the minimized largest sum for the remaining array
	        // using k - 1 parts starting from i + 1
	        int next = helper(nums, i + 1, k - 1, memo);

	        // If the recursive call returned a valid result
	        if (next != Integer.MAX_VALUE) {
	            // The current configuration's max sum is the larger of:
	            // - current subarray sum
	            // - the largest sum from the remaining k - 1 subarrays
	            int maxSumForThisSplit = Math.max(currentSum, next);

	            // We want to minimize the largest sum across all valid splits
	            minLargestSum = Math.min(minLargestSum, maxSumForThisSplit);
	        }
	    }

	    // Store the result in memo map to avoid recomputation
	    memo.put(key, minLargestSum);

	    // Return the minimum of the largest subarray sums found
	    return minLargestSum;
	}
	
	
	public static int splitArray(int[] nums, int k) {
		int minRangeValue = Integer.MIN_VALUE; 
		int maxRangeValue = 0;
		for (int i = 0; i < nums.length; i++) {
			minRangeValue =  Math.max(minRangeValue, nums[i]);
			maxRangeValue+=nums[i];
		}
		while(minRangeValue<maxRangeValue) {
			int midValue = minRangeValue+(maxRangeValue-minRangeValue)/2;
			int numberOfPiecesPossible = 1, currentSum = 0;
			for (int i = 0; i < nums.length; i++) {
				if(currentSum+nums[i]<=midValue) {
					currentSum+=nums[i];
				}else {
					currentSum=nums[i];
					numberOfPiecesPossible++;
				}
			}
			if(numberOfPiecesPossible<=k) {
				maxRangeValue = midValue;
			}else {
				minRangeValue = midValue+1;
			}
		}
		return maxRangeValue;
	}

}

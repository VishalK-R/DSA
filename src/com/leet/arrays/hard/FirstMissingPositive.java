package com.leet.arrays.hard;

public class FirstMissingPositive {

	/**Given an unsorted integer array nums. Return the smallest positive integer
	 *  that is not present in nums.
	 *  
	 *  You must implement an algorithm that runs in O(n) time and uses 
	 *  O(1) auxiliary space.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int [] nums = {3,5,1,2};
		System.out.println(firstMissingPositiveUsingBruteForce(nums));
		System.out.println(firstMissingPositive(nums));

	}
	
	/**
	 * Approach brute force
	 * create a new array where we store the value nums[i] at correctIndex 
	 *i.e newNums[nums[i]-1] = nums[i];
	 * 
	 *but here space complexity is O(n) 
	 * 
	 * @param nums
	 * @return
	 */
	private static int firstMissingPositiveUsingBruteForce(int[] nums) {
		int [] newNums = new int[nums.length];
		for(int i = 0; i<nums.length; i++) {
			int correctPos = nums[i]-1;
			if(correctPos>=0&&correctPos<nums.length) {
				newNums[correctPos] = nums[i];
			}
		}
		
		
		for (int i = 0; i < newNums.length; i++) {
			if(newNums[i]!=i+1) {
				return i+1;
			}
		}
		return nums.length+1;
	}
	
	/**
	 * 
	 * here we perform the swapping at same position while swapping we don't increment 
	 * index as the number at the current idex after swapping may be eligible for swap
	 * 
	 * if we arent swapping increase index
	 * 
	 * @param nums
	 * @return
	 */

	public static int firstMissingPositive(int[] nums) {
        int index = 0;
        
         while(index < nums.length) {
			int correctPos = nums[index]-1;
			if(correctPos>=0&&correctPos<nums.length&&nums[index]!=nums[correctPos]) {
				swap(nums, correctPos, index);
			}else {
				index++;
			}
		}
        
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i+1) {
				return i+1;
			}
		}
        return nums.length+1;
    }

	private static void swap(int[] nums, int correctPos, int i) {
		int temp = nums[correctPos];
		nums[correctPos] = nums[i];
		nums[i]=temp;
	}
}

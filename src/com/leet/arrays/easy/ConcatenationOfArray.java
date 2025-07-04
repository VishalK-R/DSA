package com.leet.arrays.easy;

import java.util.Arrays;

public class ConcatenationOfArray {
	/**Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and 
	 * ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

	Specifically, ans is the concatenation of two nums arrays.

	Return the array ans
	**/

	public static void main(String[] args) {
		int [] nums = {1,3,2,1};
		Arrays.stream(getConcatenation(nums)).forEach(System.out::println);

	}
	
	private static int[] getConcatenation(int[] nums) {
		int size = nums.length;
        int [] ans = new int[size*2];
        for (int i = 0; i < size; i++) {
			ans[i] = nums[i];
			ans[i+size] = nums[i];
		}
		return ans;
    }

}

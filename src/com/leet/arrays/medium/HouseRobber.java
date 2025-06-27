package com.leet.arrays.medium;

public class HouseRobber {

	/**
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping you
	 * from robbing each of them is that adjacent houses have security systems
	 * connected and it will automatically contact the police if two adjacent houses
	 * were broken into on the same night.
	 * 
	 * Given an integer array nums representing the amount of money of each house,
	 * return the maximum amount of money you can rob tonight without alerting the
	 * police.
	 * 
	 */
	public static void main(String[] args) {
		int [] nums = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
		System.out.println(rob(nums));
	}

	private static int rob(int[] nums) {
		int maxElementAt3Pos = 0;
		int maxElementAt2Pos = 0;
		int maxElementAt1Pos = 0;
		int maxElement = 0;
		
		for (int i = 0; i < 3; i++) {
			if (i==0&&nums.length>i) {
				maxElementAt3Pos = nums[i];
				maxElement = maxElementAt3Pos;
			} else if (i==1&&nums.length>i) {
				maxElementAt2Pos = nums[i];
				if (maxElement < maxElementAt2Pos) {
					maxElement = maxElementAt2Pos;
				}
			} else if (i==2&&nums.length>i){
				maxElementAt1Pos = nums[i] + maxElementAt3Pos;
				if (maxElement < maxElementAt1Pos) {
					maxElement = maxElementAt1Pos;
				}
			}
		}
		
		for (int i = 3; i < nums.length; i++) {
			int max = Math.max(nums[i] + maxElementAt2Pos, nums[i] + maxElementAt3Pos);
			maxElementAt3Pos = maxElementAt2Pos;
			maxElementAt2Pos = maxElementAt1Pos;
			maxElementAt1Pos = max;
			if (maxElement < max) {
				maxElement = max;
			}
		}

		return maxElement;
	}

}

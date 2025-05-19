package com.dsa.search;

public class LinearSearch {

	public static void main(String[] args) {
		int [] nums = {2,4,1,7,5,9,6};
		int target = 5;
		System.out.println(findIfElementExists(nums, target));
	}
	
	public static boolean findIfElementExists(int [] nums, int target) {
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==target) {
				return true;
			}
		}
		return false;
	}

}

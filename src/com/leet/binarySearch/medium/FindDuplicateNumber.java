package com.leet.binarySearch.medium;

import java.util.HashSet;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		int [] nums = {1,3,2,4,3};
		System.out.println(findDuplicateUsingHareAndTortoiseAlgo(nums));
	}
	
	public static int findDuplicateUsingBruteForce(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]==nums[j]) {
					return nums[i];
				}
			}
		}
		return 0;
	}
	
	
	public static int findDuplicateUsingHashSet(int[]nums) {
		HashSet<Integer> numSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(!numSet.add(nums[i])) {
				return nums[i];
			}
		}
		return 0;
	}
	

	
	public static int findDuplicateUsingHareAndTortoiseAlgo(int[]nums) {
		int tortoise = 0, hare = 0;
		do {
			tortoise = nums[tortoise];
			hare=nums[nums[hare]];
		}while(tortoise!=hare);
		
		tortoise = 0;
		while(tortoise!=hare) {
			tortoise=nums[tortoise];
			hare=nums[hare];
		}
		return tortoise;
	}

}

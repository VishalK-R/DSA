package com.dsa.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[]nums= {1,2,3,4,5,6,7};
		int target = 5;
		System.out.println(findIfElementExists(nums, target));
	}
	
	// when its sorted we can use binary search
	// similar to finding a word in dictionary, by searching in the 
	//half of the array
	public static boolean findIfElementExists(int [] nums, int target) {		
		int start = 0, end = nums.length;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(nums[mid]==target) {
				return true;
			}else if (nums[mid]<target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return false;
	}
}

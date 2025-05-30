package com.leet.binarySearch.medium;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		int [] nums = {1,2,2,3,3};
		System.out.println(singleNonDuplicate(nums));

	}
	
	public static int singleNonDuplicate(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			boolean isMidEven = mid%2==0;
			if(start==end || (nums[mid]<nums[mid+1] && 
					(mid==0||nums[mid]>nums[mid-1]))) {
				return nums[mid];
			}else if((isMidEven && nums[mid]==nums[mid-1])||
					(!isMidEven && nums[mid]==nums[mid+1])){
				end = mid - 1;
			}else if((isMidEven && nums[mid]==nums[mid+1])||
					(!isMidEven && nums[mid]==nums[mid-1])){
				start = mid + 1;
			}
		}
		return -1;
	}

}

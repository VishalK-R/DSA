package com.leet.binarySearch.medium;

public class FindPeakElement {

	public static void main(String[] args) {
		int [] nums = {1,2};
		System.out.println(findPeakElement(nums));
	}
	
	public static int findPeakElement(int[] nums) {
		int start = 0, end = nums.length-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			//case 1: when the mid is at end of the array return mid as 
			//it is peak
			//case 2: when the mid is at start that means peak element 
			//is at mid;
			//case 3: but if length of the array itself is 2 we need to 
			//check the numbers, or by default, since mid is 0 it returns 
			//zero
			if(mid==nums.length-1||mid==0) {
				if(nums.length==2) {
					return nums[0]<nums[1]?1:0;
				}
				return mid;
			}
			
			//if element at mid is greater than its neighbour we have 
			//found peak
			if((nums[mid]>nums[mid+1])&&(nums[mid]>nums[mid-1])) {
				return mid;
			}else if(nums[mid]>nums[mid+1]) {
				//we are in descending part of the array, peak is in left
				end = mid;
			}else if(nums[mid]<nums[mid+1]){
				//we are in descending part of the array, peak is in right
				start = mid+1;
			}
		}
		return start;
	}

}

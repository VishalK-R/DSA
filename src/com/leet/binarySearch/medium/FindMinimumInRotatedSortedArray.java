package com.leet.binarySearch.medium;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int [] nums = {4,5,6,7,0,1,2};
		System.out.println(findMin(nums));

	}
	
	public static int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start<=end) {
        	int mid = start + (end-start)/2;
        	if(mid==nums.length-1){
        		return nums[0];
        	}else if(nums[mid]>nums[mid+1]){
        		return nums[mid+1];
        	}else if(nums[mid]>=nums[start]) {
        		start = mid+1;
        	}else {
        		end = mid-1;
        	}
        }
		return nums[start+1];
    }

}

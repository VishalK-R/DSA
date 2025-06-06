package com.leet.binarySearch.hard;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int [] nums1 = {}, nums2 = {1};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Always binary search on the smaller array
		if(nums1.length>nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		
		// Total number of elements in both arrays
		int totalSize = nums1.length+nums2.length;
		int start = 0, end = nums1.length;
		

		// Perform binary search to find the correct partition
		while(start<=end) {
			
			int leftPartionIndex = start+(end-start)/2;
			int rightPartitionIndex = (totalSize+1)/2-leftPartionIndex;
			
			int maxOfLeftNums1 = leftPartionIndex==0?
					Integer.MIN_VALUE:nums1[leftPartionIndex-1];
			int minOfRightNums1 = leftPartionIndex==nums1.length?
					Integer.MAX_VALUE:nums1[leftPartionIndex];
			
			int maxOfLeftNums2 = rightPartitionIndex==0?
					Integer.MIN_VALUE:nums2[rightPartitionIndex-1];
			int minOfRightNums2 = rightPartitionIndex==nums2.length?
					Integer.MAX_VALUE:nums2[rightPartitionIndex];
			
			if(maxOfLeftNums1>minOfRightNums2) {
				// If maxOfLeftNums1 > minOfRightNums2, move left (partition too far right)
				end=leftPartionIndex-1;
			}else if(maxOfLeftNums2>minOfRightNums1) {
				// If maxOfLeftNums2 > minOfRightNums1, move right (partition too far left)
				start=leftPartionIndex+1;
			}else {
				// All elements in left half are <= all elements in right half
				if(totalSize%2==1) {
					// If total number of elements is odd, median is max of left side
					return Math.max(maxOfLeftNums1, maxOfLeftNums2);
				}else {
					// If even, median is average of max of left and min of right
					return (Math.max(maxOfLeftNums1, maxOfLeftNums2)
							+Math.min(minOfRightNums1, minOfRightNums2))/2.0;
				}
			}
		}
		
		// If code reaches here, input arrays were not valid for median finding
		return -1;
	}

}

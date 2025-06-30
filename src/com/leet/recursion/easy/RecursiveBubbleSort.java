package com.leet.recursion.easy;

import java.util.Arrays;

public class RecursiveBubbleSort {

	public static void main(String[] args) {
		int[]nums = {2, 3, 4, 4, 6, 8, 9, 1};
		bubbleSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));		
	}
	
	public static void bubbleSort(int[]nums, int startPos, int endPos) {
		if (endPos==0) return;
		
		if(startPos == endPos) {
			bubbleSort(nums, 0, --endPos);
			return;
		}
		
		
		if(nums[startPos]>nums[startPos+1]) {
			int temp = nums[startPos];
			nums[startPos] = nums[startPos+1];
			nums[startPos+1] = temp;
		}
		
		bubbleSort(nums, ++startPos, endPos);
	}

}

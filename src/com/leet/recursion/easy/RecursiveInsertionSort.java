package com.leet.recursion.easy;

import java.util.Arrays;

public class RecursiveInsertionSort {

	public static void main(String[] args) {
		int[] nums = {9,7,6,15,-5,5,10,17,-6};
		insertionSort(nums,1);
		Arrays.stream(nums).mapToObj(num->num+" ").forEach(System.out::print);
	}
	
	public static void insertionSort(int[] nums, int end) {
		if(end==nums.length) return;
		insert(nums, end-1, nums[end]);
		insertionSort(nums, ++end);
		
	}
	
	public static void insert(int[] nums, int end, int key) {
		if(end<0||nums[end]<=key) return;
		nums[end+1]=nums[end];
		nums[end]=key;
		insert(nums,--end,key);
	}

}

package com.leet.binarySearch.easy;

import java.util.Arrays;

public class SpecialArray {

	public static void main(String[] args) {
		int [] nums = {1,0,0,6,4,9};
		System.out.println(specialArrayUsingSort(nums));

	}
	
    public static int specialArray(int[] nums) {
        int index = 0, count = 0, num = 1;
    	while(num<=nums.length&&index<nums.length) {
    		if(num<=nums[index]) {
    			count++;
    		}
    		index++;
    		if(count>num) {
    			num++;
    			count=0;
    			index=0;
    		}
    	}
    	
    	if(count==num) {
    		return num;
    	}
    	return -1;
    }
	/**
	 * time complexity O(n*log n)
	 * for sorting arrays - O(n*log n)
	 * for looping through array n
	 * @param nums
	 * @return
	 */
    public static int specialArrayUsingSort(int[] nums) {
    	Arrays.sort(nums);
        int index = 0, num = 1;
        while(index<nums.length && num<=nums.length-index) {
        	if(num<=nums[index] && num==nums.length-index) {
        		return num;
        	}
        	//if num is greater increment index so that its less than nums[index]
        	if(num>nums[index]) {
        		index++;
        	}else {
        		num++;
        	}
        }
    	return -1;
    }

}

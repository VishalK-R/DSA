package com.leet.binarySearch.medium;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

	public static void main(String[] args) {
		int [] nums = {1,2,4} ; 
		int k = 5;
		System.out.println(maxFrequencyUsingPrefixSum(nums, k));
	}
	
	public static int maxFrequencyUsingBruteForce(int[] nums, int k) {
		Arrays.sort(nums);
		int maxCount=1;
		for (int i = nums.length-1; i >= 0; i--) {
			int count = 1;
			int remaining = k;
			for (int j = i-1; j >= 0; j--) {
				int diff = nums[i]-nums[j];
				if(diff<=remaining) {
					remaining-=diff;
					count++;
				}else {
					break;
				}
			}
			maxCount=Math.max(maxCount, count);
		}
		return maxCount;
	}
	
	public static int maxFrequencyUsingPrefixSum(int[] nums, int k) {
		Arrays.sort(nums);
		int [] preFixSum = new int[nums.length];
		preFixSum[0]=nums[0];
		for (int i = 1; i < preFixSum.length; i++) {
			preFixSum[i]=preFixSum[i-1]+nums[i];
		}
		int maxCount=0;
		for (int i = nums.length-1; i > 0; i--) {
			int start = 0, end = i;
			while(start<=end) {
				int mid = start+(end-start)/2;
				int calculatedValue = mid>0?nums[i]*(i-mid)
						-preFixSum[i-1]+preFixSum[mid-1]:nums[i]*(i-mid)
						-preFixSum[i-1];
				if(calculatedValue>k) {
					start=mid+1;
				}else {
					end=mid-1;
				}
			}
			maxCount=Math.max(maxCount, i-start);
		}
		return maxCount+1;
	}
}

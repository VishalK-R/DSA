package com.leet.binarySearch.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSumOfArray {

	public static void main(String[] args) {
		int [] nums = {1000000000,1000000000,1000000000,1000000000};
		fourSum(nums, -294967296).forEach(System.out::println);

	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> resultList = new LinkedList<>();
		for (int i = 0; i < nums.length-3; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
			for (int j = i+1; j < nums.length-2; j++) {
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
				int k = j+1, l = nums.length-1;
				while(k<l) {
                    long sum = (long)nums[i] + nums[j]+ nums[k]+ nums[l];
					if(sum==target) {
						List <Integer> result = new LinkedList<>();
						result.add(nums[i]);
						result.add(nums[j]);
						result.add(nums[k]);
						result.add(nums[l]);
						resultList.add(result);
						k++;
                        while(k<l&&nums[k]==nums[k-1]) {
							k++;
						}
					}else if(sum<target) {
						k++;
					}else {
						l--;
					}
				}
			}
		}
		return resultList;
	}

}

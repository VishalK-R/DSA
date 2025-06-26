package com.leet.binarySearch.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		int [] nums = {5,2,1,6,1};
		System.out.println(countSmallerByBruteForce(nums));
		System.out.println(countSmallerByBinarySearch(nums));

	}
	
	public static List<Integer> countSmallerByBruteForce(int[] nums) {
		List<Integer> countList = new LinkedList<>();
		for (int i = 0; i < nums.length-1; i++) {
			int count = 0;
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]>nums[j]) {
					count++;
				}
			}
			countList.add(count);
		}
		countList.add(0);
		return countList;
	}
	
	public static List<Integer> countSmallerByBinarySearch(int[] nums) {
		List<Integer> countList = new LinkedList<>();
		List<Integer> sortedList = new ArrayList<>();
        for(int i=nums.length-1; i>=0; i--){
            int count = insertAndGetIndex(nums[i],sortedList);
            countList.add(0, count);
        }
		return countList;
	}

	private static int insertAndGetIndex(int num, List<Integer> sortedList) {
		int start = 0;
		int end = sortedList.size()-1;
		if(end+1==0 || num>sortedList.get(end)){
            sortedList.add(num);
            return end+1;
        }
		
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(sortedList.get(mid)<num) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		sortedList.add(start,num);
		return start;
	}

}

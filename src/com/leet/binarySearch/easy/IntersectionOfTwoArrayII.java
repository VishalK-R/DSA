package com.leet.binarySearch.easy;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrayII {

	public static void main(String[] args) {
		int [] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
//		Arrays.stream(intersectionBruteForce(nums1,nums2)).forEach(System.out::println);
//		Arrays.stream(intersectionUsingSort(nums1,nums2)).forEach(System.out::println);
		Arrays.stream(intersection(nums1,nums2)).forEach(System.out::println);
	}
	
	// time complexity O(m*n)
		public static int[] intersectionBruteForce(int[] nums1, int[] nums2) {
				int size = nums1.length>nums2.length?nums1.length:nums2.length;
				int [] resultNums = new int[size];
				int k =0;
		        for (int i = 0; i < nums1.length; i++) {
					for (int j = 0; j < nums2.length; j++) {
						if(nums1[i]==nums2[j]) {
							resultNums[k] = nums2[j];
							nums2[j]=-1;
							k++;
							break;
						}
					}
				}
		        return Arrays.copyOfRange(resultNums, 0, k);
	    }
		
		//Sort O(log m + log n) and use two pointers one each on array O(m+n)
		public static int[] intersectionUsingSort(int[] nums1, int[] nums2) {
			if(nums1.length<nums2.length) {
				return intersectionUsingSort(nums2, nums1);
			}
			int[] resultAr = new int[nums1.length];
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int i=0, j=0, k=0;
			while(i<nums1.length&&j<nums2.length) {
				if(nums1[i]==nums2[j]) {
					resultAr[k]=nums1[i];
					i++;
					j++;
					k++;
				}else if(nums1[i]>nums2[j]) {
					j++;
				}else {
					i++;
				}
			}
			
	        return Arrays.copyOfRange(resultAr,0,k);
    }
		
		
		
		//Using HashSet time complexity - O(m+n)
		public static int[] intersection(int[] nums1, int[] nums2) {
			if(nums1.length<nums2.length) {
				return intersection(nums2, nums1);
			}
			
	        HashMap<Integer, Integer> numMap = new HashMap<>();
	        for (int i = 0; i < nums1.length; i++) {
				if(numMap.containsKey(nums1[i])) {
					int value = numMap.get(nums1[i]);
					numMap.put(nums1[i], ++value);
				}else {
					numMap.put(nums1[i], 1);
				}
			}
	        
	        int [] resultAr = new int[nums1.length];
	        int k = 0;
	        
	        for (int i = 0; i < nums2.length; i++) {
				if(numMap.containsKey(nums2[i])) {
					resultAr[k++] = nums2[i];
					int value = numMap.get(nums2[i]);
					if(value==1) {
						numMap.remove(nums2[i]);
					}else {
						numMap.put(nums2[i], --value);
					}
				}
			}
	        return Arrays.copyOfRange(resultAr, 0, k);
	    }

}

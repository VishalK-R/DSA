package com.leet.binarySearch.easy;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int [] nums1 = {1,2,2,1}, nums2 = {2,2};
//		Arrays.stream(intersectionBruteForce(nums1,nums2)).forEach(
//				System.out::println);
		Arrays.stream(intersection(nums1,nums2)).forEach(
				System.out::println);
	}
	
	// time complexity O(m*n)
	public static int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
        	boolean updateFirstArrayElement = true;
			for (int j = 0; j < nums2.length; j++) {
				if(nums1[i]==nums2[j]) {
					updateFirstArrayElement = false;
					nums2[j] = -1;
				}
			}
			if(updateFirstArrayElement) {
				nums1[i]=-1;
			}
		}
        int [] resultNums = new int[nums1.length];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
			if(nums1[i]>=0) {
				resultNums[k]=nums1[i];
				k++;
			}
		}
        return Arrays.copyOfRange(resultNums, 0, k);
    }
	
	//Sort O(log m + log n) and use two pointers one each on array O(m+n)
	
	//Using HashSet time complexity - O(m+n)
	public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> numset = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
			numset.add(nums1[i]);
		}
        
        HashSet<Integer> resultset = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
			if(numset.contains(nums2[i])) {
				resultset.add(nums2[i]);
			}
		}
        return resultset.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

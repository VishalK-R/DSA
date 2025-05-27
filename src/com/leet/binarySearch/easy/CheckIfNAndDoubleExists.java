package com.leet.binarySearch.easy;

import java.util.Arrays;
import java.util.HashSet;

public class CheckIfNAndDoubleExists {

	public static void main(String[] args) {
		int [] arr = {0,0};
		System.out.println(checkIfExistUsingBinarySearch(arr));

	}
	
	public static boolean checkIfExistUsingBruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i==j) continue;
				if(arr[i]==2*arr[j]) {
					System.out.println(arr[i]+" "+arr[j]);
					return true;
				}
			}
		}
		return false;
    }
	
	public static boolean checkIfExistUsingBinarySearch(int[] arr) {
		Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
			int start = 0;
			int end = arr.length-1;
			while(start<=end) {
				int mid = start + (end-start)/2;
				if(i==mid&&arr[mid]==0) {
					start=mid+1;
					continue;
				}
				if(arr[i]==2*arr[mid]) {
					return true;
				}else if(2*arr[mid]<arr[i]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}
		return false;
    }
	
	public static boolean checkIfExistUsingHashSet(int[] arr) {
		HashSet<Integer> arrSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if(arrSet.contains(2*arr[i])||
					(arrSet.contains(arr[i]/2)&&arr[i]%2==0)) return true;
			arrSet.add(arr[i]);
		}
		return false;
    }

}

package com.leet.binarySearch.easy;

public class KthMissingPositiveInteger {

	public static void main(String[] args) {
		int [] ar = {2,3,4,7,11};
		int target = 5;
		System.out.println(findKthPositiveBruteForce1(ar, target));
		System.out.println(findKthPositiveBruteForce2(ar, target));
		System.out.println(findKthPositiveBinarySearch(ar, target));
	}
	
	public static int findKthPositiveBruteForce1(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
			if(arr[i]<=k) k++;
		}
        return k;
    }
	
	public static int findKthPositiveBruteForce2(int[] arr, int k) {
		int i = 0;
		// arr[i]-(i+1) gives total missing numbers at i
		while(i<arr.length && arr[i]-(i+1)<k) {
			i++;
		}
		//arr[i]+k-(arr[i]-(i+1))=i+1+k
		//i.e, 
		return k+i;
	}
	
	public static int findKthPositiveBinarySearch(int[] arr, int k) {
		int left = 0;
		int right = arr.length;
		while(left<right) {
			int mid = left + (right-left)/2;
			if(arr[mid]-(mid+1)<k) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return left+k;
	}

}

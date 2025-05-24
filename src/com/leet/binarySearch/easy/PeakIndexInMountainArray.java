package com.leet.binarySearch.easy;

public class PeakIndexInMountainArray {
	public static void main(String[] args) {
		int nums[]  = {0,10,15,21,31,0};
		System.out.println(peakIndexInMountainArray(nums));
	}
	
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;
        while(start<=end) {
        	int mid = start + (end-start)/2;
        	if (arr[mid]>arr[mid+1]) {
        		end = mid-1;
        	}else {
        		start = mid+1;
        	}
        }
        return start;
    }
}

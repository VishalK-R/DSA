package com.leet.binarySearch.easy;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(2147483647));
	}
	
	public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start<=end) {
        	int mid = start + (end-start)/2;
        	if(mid==num/mid && num%mid==0) {
        		return true;
        	}else if(mid<num/mid) {
        		start = mid+1;
        	}else {
        		end = mid-1;
        	}
        }
		
		return false;
    }

}

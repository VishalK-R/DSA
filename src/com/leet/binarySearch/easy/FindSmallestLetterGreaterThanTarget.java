package com.leet.binarySearch.easy;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		char [] letters = {'c','f','y','y'};
		char target = 'y';
		System.out.println(nextGreatestLetter(letters, target));

	}
	
	public static char nextGreatestLetter(char[] letters, char target) {
		int start = 0;
		int end = letters.length-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(letters[mid]<=target) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return start==letters.length?letters[0]:letters[start];
	}

}

package com.leet.binarySearch.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumArray {
	/**Given a 1-indexed array of integers numbers that is already sorted in 
	 * non-decreasing order, find two numbers such that they add up to a specific 
	 * target number. Let these two numbers be numbers[index1] and numbers[index2] 
	 * where 1 <= index1 < index2 <= numbers.length.
	 * 
	 * Return the indices of the two numbers, index1 and index2, added by one as an 
	 * integer array [index1, index2] of length 2.
	 * 
	 * The tests are generated such that there is exactly one solution. You may not 
	 * use the same element twice.
	 * Your solution must use only constant extra space.
	**/
	public static void main(String[] args) {
		int [] numbers = {2,3,4,7,11,15};
		int target = 9;
		Arrays.stream(twoSumBruteForce(numbers, target)).forEach(System.out::println);
		Arrays.stream(twoSumUsingBinarySearch(numbers, target)).forEach(System.out::println);
		Arrays.stream(twoSumUsingHashMap(numbers, target)).forEach(System.out::println);
	}
	
	/**
	 * time complexity is O(n^2)
	 * space complexity is O(1)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSumBruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if(numbers[i]+numbers[j]==target) {
					return new int[] {i+1,j+1};
				}
			}
		}
        return new int[] {-1,-1};
    }
	
	/**
	 * time complexity is O(n*log n)
	 * space complexity is O(1)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSumUsingBinarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
			int start = i+1;
			int end = numbers.length-1;
			while(start<=end) {
				int mid = start + (end-start)/2;
				if(numbers[i]+numbers[mid]==target) {
					return new int [] {i+1, mid+1};
				}else if (numbers[i]+numbers[mid]<target){
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}
        return new int[] {-1,-1};
    }
	
	
	public static int[] twoSumUsingHashMap(int[] numbers, int target) {
		HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
			if(numMap.containsKey(target-numbers[i])) {
				return new int[] {numMap.get(target-numbers[i])+1,i+1};
			}else {
				numMap.put(numbers[i], i);
			}
		}
        return new int[] {-1,-1};
    }

}

package com.leet.binarySearch.medium;

import java.util.Arrays;
import java.util.HashMap;

public class FindRightInterval {

	public static void main(String[] args) {
		int[][] intervals = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		System.out.println(Arrays.toString(findRightInterval(intervals)));

	}

	public static int[] findRightIntervalUsingBruteForce(int[][] intervals) {
		int[] resultAr = new int[intervals.length];
		int max = 0;
		for (int i = 0; i < resultAr.length; i++) {
			if (intervals[i][0] > max) {
				max = intervals[i][0];
			}
		}
		for (int i = 0; i < intervals.length; i++) {
			int num = intervals[i][1];

			if (num > max) {
				resultAr[i] = -1;
			} else {
				outer: 
				while (num <= max) {
					for (int j = 0; j < intervals.length; j++) {
						if (num == intervals[j][0]) {
							resultAr[i] = j;
							break outer;
						}
					}
					num++;
					resultAr[i] = -1;
				}
			}

		}
		return resultAr;
	}
	
	public static int[] findRightIntervalUsingHashMap(int[][] intervals) {
		int [] resultAr = new int[intervals.length];
		HashMap<Integer, Integer> xIntervalIndexMap = new HashMap<>();
		int max = 0;
		for (int i = 0; i < resultAr.length; i++) {
			if (intervals[i][0] > max) {
				max = intervals[i][0];
			}
			xIntervalIndexMap.put(intervals[i][0], i);
		}
		
		for (int i = 0; i < intervals.length; i++) {
			int num = intervals[i][1];

			if (num > max) {
				resultAr[i] = -1;
			} else {
				while (num <= max) {
					if (xIntervalIndexMap.containsKey(num)) {
						resultAr[i] = xIntervalIndexMap.get(num);
						break;
					}
					num++;
					resultAr[i] = -1;
				}
			}

		}
		return resultAr;
	}
	
	public static int[] findRightInterval(int[][] intervals) {
		int size = intervals.length;
		int [] resultAr = new int[size];
		int [] newAr = new int[size];
		HashMap<Integer, Integer> xIntervalIndexMap = new HashMap<>();
		for (int i = 0; i < size; i++) {
			newAr[i]=intervals[i][0];
			xIntervalIndexMap.put(intervals[i][0], i);
		}
		Arrays.sort(newAr);
		for (int i = 0; i < size; i++) {
			int target = intervals[i][1];
			int start = 0, end = size-1;
			resultAr[i]=-1;
			while(start<=end) {
				int mid = start + (end-start)/2;
				if(newAr[mid]<target) {
					start = mid+1;
				}else {
					if(xIntervalIndexMap.containsKey(newAr[mid])) {
						resultAr[i]=xIntervalIndexMap.get(newAr[mid]);
					}
					end=mid-1;
				}
			}
		}
		return resultAr;
	}

}

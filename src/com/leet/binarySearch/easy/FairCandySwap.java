package com.leet.binarySearch.easy;

import java.util.Arrays;

public class FairCandySwap {

	public static void main(String[] args) {
		int [] aliceSizes = {2};
		int [] bobSizes = {1,3};
		System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
	}

	/**
	 * time complexity = O(n*m)
	 * 
	 * @param aliceSizes
	 * @param bobSizes
	 * @return
	 */
	public static int[] fairCandySwapUsingBruteForce(int[] aliceSizes, int[] bobSizes) {
		int totalCandicesOfAlice = getTotalCandies(aliceSizes);
		int totalCandicesOfBob = getTotalCandies(bobSizes);
		for (int i = 0; i < aliceSizes.length; i++) {
			for (int j = 0; j < bobSizes.length; j++) {
				if (totalCandicesOfAlice - aliceSizes[i] + bobSizes[j] == totalCandicesOfBob - bobSizes[j]
						+ aliceSizes[i]) {
					return new int[] { aliceSizes[i], bobSizes[j] };
				}
			}
		}
		return new int[] { -1, -1 };
	}
	
	/**
	 * time complexity = O(n*log m)
	 * 
	 * @param aliceSizes
	 * @param bobSizes
	 * @return
	 */
	public static int[] fairCandySwapUsingBinarySearch(int[] aliceSizes, int[] bobSizes) {
		Arrays.sort(aliceSizes);
		Arrays.sort(bobSizes);
		int totalCandicesOfAlice = getTotalCandies(aliceSizes);
		int totalCandicesOfBob = getTotalCandies(bobSizes);
		for (int i = 0; i < aliceSizes.length; i++) {
			int requiredBobCandies = (totalCandicesOfBob-totalCandicesOfAlice) / 2 + aliceSizes[i];
			int start = 0;
			int end = bobSizes.length-1;
			while(start<=end) {
				int mid = start + (end-start)/2;
				if(bobSizes[mid]==requiredBobCandies) {
					return new int[] {aliceSizes[i], requiredBobCandies};
				}else if(bobSizes[mid]<requiredBobCandies) {
					start = mid+1;
				}else {
					end = mid - 1;
				}
			}
		}
		return new int[] { -1, -1 };
	}
	
	/**
	 * time complexity = O(n+m)
	 * use two pointers on both the sorted arrays
	 * 
	 * @param aliceSizes
	 * @param bobSizes
	 * @return
	 */
	public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
		Arrays.sort(aliceSizes);
		Arrays.sort(bobSizes);
		int totalCandicesOfAlice = getTotalCandies(aliceSizes);
		int totalCandicesOfBob = getTotalCandies(bobSizes);
		int diffCandies = totalCandicesOfAlice - totalCandicesOfBob;
		return getSwappedArray(aliceSizes, bobSizes, diffCandies);
		
	}

	private static int[] getSwappedArray(int[] aliceSizes, int[] bobSizes, int diffCandies) {
		int i = 0, j = 0;
		while(i<aliceSizes.length&&j<bobSizes.length) {
			if(aliceSizes[i]-bobSizes[j]==(diffCandies)/2) {
				return new int[] {aliceSizes[i],bobSizes[j]};
			}else if(aliceSizes[i]-bobSizes[j]<(diffCandies)/2) {
				i++;
			}else {
				j++;
			}
		}
		return new int[] { -1, -1 };
	}

	private static int getTotalCandies(int[] candies) {
		int totalSum = 0;
		for (int i = 0; i < candies.length; i++) {
			totalSum += candies[i];
		}
		return totalSum;
	}
	
	//Alternatively we can use hashset for easy lookup

}

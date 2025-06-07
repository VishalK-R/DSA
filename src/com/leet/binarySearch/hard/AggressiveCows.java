package com.leet.binarySearch.hard;

import java.util.Arrays;

public class AggressiveCows {
	
	/**
	 * N stalls located at different positions along a line.
	 * 
	 * C cows to place into stalls.
	 * 
	 * Place the cows in stalls so that the minimum distance between any two cows 
	 * is as large as possible.
	 * 
	 * 2 ≤ N ≤ 100,000 (size of the array)
	 * 0 ≤ xi ≤ 1,000,000,000 where xi is the position of the stall in the array
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int [] stalls = {1,3,2,4,5,6,7,8,9};
		int cows = 3;
		System.out.println(getMinimumDistance(stalls, cows));
	}


	public static int getMinimumDistanceUsingBruteForce(int [] stalls, int cows) {
		Arrays.sort(stalls);
		int maxDistance = stalls[stalls.length - 1] - stalls[0];
		int minDistance = 1;
		int distance=0;
		while (minDistance <= maxDistance) {
			if (ifCowsCanBePlaced(stalls, cows, minDistance)) {
				distance = minDistance;
			}else {
				break;
			}
			minDistance++;
		}
		return distance;
	}

	public static int getMinimumDistance(int[] stalls, int cows) {
		Arrays.sort(stalls);
		int distance = 0;
		int minDistance = stalls[0], maxDistance = stalls[stalls.length-1];
		while(minDistance<=maxDistance) {
			int mid = minDistance+(maxDistance-minDistance)/2;
			if(ifCowsCanBePlaced(stalls, cows, mid)) {
				distance = mid;
				minDistance = mid+1;
			}else {
				maxDistance = mid-1;
			}
		}
		return distance;
	}

	private static boolean ifCowsCanBePlaced(int[] stalls, int cows, int distance) {
		int previousPos = stalls[0], cowsLeftToBePlaced = cows - 1;
		for (int i = 1; i < stalls.length; i++) {
			if (previousPos + distance <= stalls[i]) {
				previousPos = stalls[i];
				cowsLeftToBePlaced--;
				if (cowsLeftToBePlaced == 0) {
					return true;
				}
			}
		}
		return false;
	}

}

package com.leet.binarySearch.medium;

public class KokoEatingBanannas {

	public static void main(String[] args) {
		int [] piles = {805306368,805306368,805306368};
		int h = 1000000000;
		System.out.println(minEatingSpeed(piles,h));

	}
	
	public static int minEatingSpeed(int[] piles, int h) {
		int minspeed = 1, maxspeed = getMax(piles);
		int result = 1;
		while(minspeed<=maxspeed) {
			int mid = minspeed + (maxspeed-minspeed)/2;
			long totalHours = getTotalHours(piles,mid);
			if(totalHours>h) {
				minspeed=mid+1;
			}else {
				result =mid;
				maxspeed=mid-1;
			}
			
		}
		return result;
	}

	private static int getMax(int[] piles) {
		int max = 0;
		for (int i = 0; i < piles.length; i++) {
			max=Math.max(max, piles[i]);
		}
		return max;
	}

	private static long getTotalHours(int[] piles, int speed) {
		long sum = 0;
		for (int i = 0; i < piles.length; i++) {
			sum+=(piles[i]+speed-1l)/speed;
		}
		return sum;
	}

}

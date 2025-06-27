package com.leet.arrays.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

	/**There are n kids with candies. You are given an integer array candies, where each candies[i] represents 
	 * the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies 
	 * that you have.
	 * 
	 * 
	 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all 
	 * the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
	 * 
	 * Constraints:
	 * n == candies.length
	 * 2 <= n <= 100
	 * 1 <= candies[i] <= 100
	 * 1 <= extraCandies <= 50
	 */
	public static void main(String[] args) {
		int [] candies = {2,3,5,1,3};
		int extraCandies = 3;
		System.out.println(kidsWithCandies(candies, extraCandies));
	}
	
	private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		
		List<Boolean> kidsWithMaxCandies = new LinkedList<>();
//		int max = Arrays.stream(candies).max()
//				.orElseThrow(() -> new IllegalArgumentException("Array is empty"));
		int max = Arrays.stream(candies).reduce(1, (a, b) -> a > b ? a : b);
		for(int i = 0; i<candies.length; i++) {
			if((candies[i]+extraCandies)<max) {
				kidsWithMaxCandies.add(false);
			}else {
				kidsWithMaxCandies.add(true);
			}
		}
		
		return kidsWithMaxCandies;
        
    }

}

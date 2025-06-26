package com.leet.binarySearch.hard;

public class DivideChocolates {
	/**You have one chocolate bar that consists of some chunks. Each chunk 
	 * has its own sweetness given by the array sweetness.
	 * 
	 * You want to share the chocolate with your K friends so you start 
	 * cutting the chocolate bar into K+1 pieces using K cuts, each piece 
	 * consists of some consecutive chunks.
	 * 
	 * Being generous, you will eat the piece with the minimum total 
	 * sweetness and give the other pieces to your friends. 
	 * 
	 * Find the maximum total sweetness of the piece you can get by 
	 * cutting the chocolate bar optimally.
	 * 
	 * Constraints:
	 *  0 <= K < sweetness.length <= 10^4
	 *  1 <= sweetness[i] <= 10^5
	 *  
	 **/
	public static void main(String[] args) {
		int [] nums = {3,2,2,1,2,2,2,2,2};
		int k = 2;
		System.out.println(new DivideChocolates().maximizeSweetness(nums, k));
	}
	
	public int maximizeSweetness(int[] nums, int k) {
		int minValue = Integer.MAX_VALUE;
		int maxValue = 0;
		for (int i = 0; i < nums.length; i++) {
			minValue = Math.min(minValue, nums[i]);
			maxValue+=nums[i];
		}
		
		if(k==0) {
			return maxValue;
		}else if(k==nums.length-1) {
			return minValue;
		}
		
		int minSweetness = 0;
		while(minValue<=maxValue) {
			int mid = (minValue + (maxValue-minValue)/2);
			if(canDivideIntoMinSweetness(mid,nums,k)) {
				minSweetness = mid;
				minValue=mid+1;
			}else {
				maxValue=mid-1;
			}
		}
		return minSweetness;
	}

	private static boolean canDivideIntoMinSweetness(int targetSweetness, int[] nums, int k) {
		int currentSweetness = 0;
		int divisionsOfSweet = 0;
		for (int i = 0; i < nums.length; i++) {
			currentSweetness+=nums[i];
			if(currentSweetness>=targetSweetness) {
				divisionsOfSweet++;
				currentSweetness=0;
			}
		}
		return divisionsOfSweet>=k+1;
	}

}

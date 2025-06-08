package leet.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;

public class FindCountOfNumbersSmallerThanCurrentNumber {

	/**Given the array nums, for each nums[i] find out how many numbers in the 
	 * array are smaller than it. That is, for each nums[i] you have to count 
	 * the number of valid j's such that j != i and nums[j] < nums[i].
	 * 
	 * Return the answer in an array.
	 * 
	 * Constraints
	 * 0 <= nums[i] <= 100
	 * 2 <= nums.length <= 500
	 * 
	 */
	
	public static void main(String[] args) {
		int[] nums = {5,0,10,0,10,6};
		System.out.println(smallerNumbersThanCurrentBruteForceApproach(nums));
		System.out.println(Arrays.toString(smallerNumbersThanCurrentUsingSortAndMap(nums)));
		System.out.println(Arrays.toString(smallerNumbersThanCurrentUsingProgressiveSumArray(nums)));
	}
	
	/**
	 * Time complexity O(n*n)
	 * @param nums
	 * @return
	 */
	private static int[] smallerNumbersThanCurrentBruteForceApproach(int[] nums) {
        int[] ar = new int[nums.length];
		for(int i = 0; i<nums.length; i++) {
			int count = 0;
			for(int j =0; j<nums.length; j++) {
				//check how many numbers are greater than current number
				if(nums[i]>nums[j]) {
					count++;
				}
			}
			ar[i]=count;
		}
		return ar;
    }
	
	private static int[] smallerNumbersThanCurrentUsingSortAndMap(int[] nums) {
        int[] ar = new int[nums.length];
        int[] numsCopySorted = Arrays.copyOf(nums, nums.length);
        
        Arrays.sort(numsCopySorted);
        HashMap<Integer, Integer> numsCount = new HashMap<>();
        for(int index = 0; index<numsCopySorted.length; index++) {
        	if(!numsCount.containsKey(numsCopySorted[index]))
        		numsCount.put(numsCopySorted[index], index);
        }
        
        for(int index = 0; index<nums.length; index++) {
        	ar[index] = numsCount.get(nums[index]);
        }
        
		
		return ar;
    }

	private static int[] smallerNumbersThanCurrentUsingProgressiveSumArray(int[] nums) {
        int[] ar = new int[nums.length];
		int[] countAr = new int[101];
		for(int i = 0; i<nums.length;i++) {
			int count = countAr[nums[i]];
			countAr[nums[i]] = count+1;
		}
		
		for(int i=1;i<countAr.length;i++) {
			countAr[i]+=countAr[i-1];
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				ar[i]=0;
			}else {
				ar[i]=countAr[nums[i]-1];
			}
		}
		return ar;
    }

}

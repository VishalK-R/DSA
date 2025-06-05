package com.leet.binarySearch.medium;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference {

	public static void main(String[] args) {
		int [] nums1 = {1,28,21}, 
				nums2 = {9,21,20};
	//	int [] nums1 = {2,4,6,8,10}, nums2= {2,4,6,8,10};
		System.out.println(minAbsoluteSumDiff(nums1, nums2));
	}
	
	public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		long absDiffSum = 0l;
		// Define the modulo constant as per the problem statement
        final int MOD = 1_000_000_000 + 7;
        //Step 1: Calculate initial absolute sum difference
		for (int i = 0; i < nums2.length; i++) {
			int absDiff = Math.abs(nums1[i]-nums2[i]);
			absDiffSum+=absDiff;
		}
		//Step 2: If the initial sum is 0, no change can make it smaller.
		if(absDiffSum==0l) return 0;
		
		// Step 3: Sort nums1 to efficiently find the closest element 
		//using binary search
		int[] sortedNums1 = nums1.clone();
		Arrays.sort(sortedNums1);
		
		// We will try to reduce this by replacing one element.
        long minOverallAbsSumDiff = absDiffSum;
		// Step 4: Iterate through each element in nums2 (and 
		//corresponding sortedNums1)
        // and consider replacing nums1[i] with an element from nums1
        // to minimize the difference at that specific index 'i'.
        for (int i = 0; i < nums1.length; i++) {
            int target = nums2[i];
            
            // Find the index of an element in sortedNums1 that is equal 
            //to or just greater than target
            // If target is not found, Arrays.binarySearch returns 
            //(-(insertion point) - 1)
            int searchResultIndex = Arrays.binarySearch(sortedNums1, target);

            long bestNewDiffForCurrentIndex;

            if (searchResultIndex >= 0) {
                // Case A: Exact match found in sortedNums1. The best 
            	//possible new difference is 0.
                bestNewDiffForCurrentIndex = 0;
            } else {
                // Case B: No exact match. 'searchResultIndex' is 
            	//(-(insertion point) - 1).
                // The insertion point is the index where the target 
            	//would be inserted,maintaining sorted order. This means 
            	//elements at 'insertionPoint' and 'insertionPoint - 1'
                // are the candidates for the closest value.
                int insertionPoint = -searchResultIndex - 1;
                
                // Difference with element at insertionPoint
                long diff1 = Long.MAX_VALUE; 
                // Difference with element at insertionPoint - 1
                long diff2 = Long.MAX_VALUE;
                
                // Check the element at 'insertionPoint' (if it's a 
                //valid index)
                if (insertionPoint < sortedNums1.length) {
                    diff1 = Math.abs(sortedNums1[insertionPoint] - target);
                }

                // Check the element at 'insertionPoint - 1' (if it's a 
                //valid index)
                if (insertionPoint > 0) {
                    diff2 = Math.abs(sortedNums1[insertionPoint - 1] - target);
                }
                
                // The best new difference for this index 'i' is the 
                //minimum of these two.
                bestNewDiffForCurrentIndex = Math.min(diff1, diff2);
            }

            // Calculate the current difference at index 'i' before 
            //replacement
            long currentDiffAtIndex = Math.abs(nums1[i] - nums2[i]);

            // Calculate the potential new total sum if nums1[i] was 
            //replaced
            // This is: (initial total sum) - (current difference at i) 
            //+ (new best difference at i)
            long potentialNewTotalSum = absDiffSum - currentDiffAtIndex 
            		+ bestNewDiffForCurrentIndex;

            // Update the overall minimum total sum found so far
            minOverallAbsSumDiff = Math.min(minOverallAbsSumDiff, 
            		potentialNewTotalSum);
        }

        // Step 5: Apply the modulo operation to the final minimum sum.
        // Adding MOD before taking modulo ensures the result is always 
        //positive.
        return (int) ((minOverallAbsSumDiff % MOD + MOD) % MOD);
	}
}

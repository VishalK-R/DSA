package leet.arrays.easy;

import java.util.HashMap;
import java.util.Map.Entry;

public class NumberOfGoodPairs {

	/**Given an array of integers nums, return the number of good pairs.
		A pair (i, j) is called good if nums[i] == nums[j] and i < j.
		
		1 <= nums.length <= 100
		1 <= nums[i] <= 100
	**/
	public static void main(String[] args) {
		int [] nums = {1,1,1,1};
		System.out.println(numIdenticalPairs(nums));
		System.out.println(numIdenticalPairsUsingCount(nums));
	}
	
	private static int numIdenticalPairs(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length-1;i++) {
        	for(int j = i+1; j<nums.length; j++) {
        		if(nums[i]==nums[j]) {
        			sum++;
        		}
        	}
        }
        return sum;
    }

	//get count of all numbers the ones, the number of pairs will be equal to
	// (count * (count-1)) / 2
	private static int numIdenticalPairsUsingCount(int[] nums) {
		HashMap<Integer, Integer> numCount = new HashMap<>();
		for(int key: nums) {
			int count = numCount.getOrDefault(key, 0);
			numCount.put(key, count+1);
		}
		
		int sum = 0;
		for(Entry<Integer, Integer> entrySet : numCount.entrySet()) {
			int count = entrySet.getValue();
			sum+=((count*(count-1))/2);
		}
		
		return sum;
	}
}

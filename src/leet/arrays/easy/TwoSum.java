package leet.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	/**Given an array of integers nums and an integer target, return 
	 * indices of the two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution,
	 *  and you may not use the same element twice.
	 *  
	 *  You can return the answer in any order.
	**/
	public static void main(String[] args) {
		int [] nums = {3,3};
		int target = 6;
		Arrays.stream(twoSum(nums,target)).forEach(System.out::println);

	}
	
	public static int[] twoSum(int[] nums, int target) {
        int [] indices = new int[2];
        HashMap<Integer,Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	int requiredNum = target-nums[i];
        	if(numsMap.containsKey(requiredNum)) {
        		indices[0]=numsMap.get(requiredNum);
				indices[1]=i;
				return indices;
        	}else {
        		numsMap.put(nums[i],i);
        	}
		}
        return indices;
    }

}

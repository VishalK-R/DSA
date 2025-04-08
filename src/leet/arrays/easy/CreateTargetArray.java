package leet.arrays.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CreateTargetArray {

	/**Given two arrays of integers nums and index. Your task is to create target array under the following rules:

		Initially target array is empty.
		From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
		Repeat the previous step until there are no elements to read in nums and index.
		Return the target array.

		It is guaranteed that the insertion operations will be valid.
		
		Constraints:
		1 <= nums.length, index.length <= 100
		nums.length == index.length
		0 <= nums[i] <= 100
		0 <= index[i] <= i
	**/
	public static void main(String[] args) {
		int [] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
		
		Arrays.stream(createTargetArray(nums, index)).forEach(System.out::println);
	}
	
	public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetArrayList = new LinkedList<>();
        for(int i = 0; i<nums.length; i++) {
        	targetArrayList.add(index[i], nums[i]);
        }
        
        int[] targetArray = targetArrayList.stream().mapToInt(Integer::intValue).toArray();
        return targetArray;
    }

}

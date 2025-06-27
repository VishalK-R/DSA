package com.leet.arrays.medium;

public class JumpArray {

	public static void main(String[] args) {
		int [] nums = {3,2,1,0,4};
		System.out.println(canJump(nums));

	}
	/**
	 * the idea here is we go backwards tracking if we can reach particular position
	 * then we check if we can reach the new position from where we could reach the 
	 * previous position
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		int targetPos = nums.length-1;
        for (int i = nums.length-2; i >= 0; i--) {
			if(nums[i]+i>=targetPos) {
				targetPos = i;
			}
		}
        if(targetPos==0)return true;
        return false;
    }

}
